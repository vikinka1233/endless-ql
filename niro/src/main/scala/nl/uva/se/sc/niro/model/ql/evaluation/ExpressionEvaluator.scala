package nl.uva.se.sc.niro.model.ql.evaluation

import nl.uva.se.sc.niro.model.ql.SymbolTable.SymbolTable
import nl.uva.se.sc.niro.model.ql.evaluation.QLFormEvaluator.Dictionary
import nl.uva.se.sc.niro.model.ql.expressions.Conversions._
import nl.uva.se.sc.niro.model.ql.expressions._
import nl.uva.se.sc.niro.model.ql.expressions.answers.{ Answer, DecimalAnswer, IntegerAnswer }

object ExpressionEvaluator {
  implicit class ExpressionOps(e: Expression) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = e match {
      case a: Answer           => Some(a)
      case r: Reference        => r.evaluate(symbolTable, dictionary)
      case a: Addition         => a.evaluate(symbolTable, dictionary)
      case s: Subtract         => s.evaluate(symbolTable, dictionary)
      case m: Multiply         => m.evaluate(symbolTable, dictionary)
      case d: Divide           => d.evaluate(symbolTable, dictionary)
      case m: Minus            => m.evaluate(symbolTable, dictionary)
      case l: LessThan         => l.evaluate(symbolTable, dictionary)
      case l: LessThanEqual    => l.evaluate(symbolTable, dictionary)
      case g: GreaterThenEqual => g.evaluate(symbolTable, dictionary)
      case g: GreaterThen      => g.evaluate(symbolTable, dictionary)
      case n: NotEqual         => n.evaluate(symbolTable, dictionary)
      case e: Equal            => e.evaluate(symbolTable, dictionary)
      case o: Or               => o.evaluate(symbolTable, dictionary)
      case a: And              => a.evaluate(symbolTable, dictionary)
      case n: Negate           => n.evaluate(symbolTable, dictionary)
    }
  }
  private def widen(left: Answer, right: Answer): (Answer, Answer) = (left, right) match {
    case (i: IntegerAnswer, _: DecimalAnswer) => (i.toDecimal, right)
    case (_: DecimalAnswer, i: IntegerAnswer) => (left, i.toDecimal)
    case _                                    => (left, right)
  }

  implicit class AdditionOps(expression: Addition) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
        widened = widen(leftAnswer, rightAnswer)
      } yield widened._1.plus(widened._2)
    }
  }

  implicit class SubtractOps(expression: Subtract) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
        widened = widen(leftAnswer, rightAnswer)
      } yield widened._1.subtract(widened._2)
    }
  }

  implicit class MultiplyOps(expression: Multiply) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
        widened = widen(leftAnswer, rightAnswer)
      } yield widened._1.multiply(widened._2)
    }
  }

  implicit class DivideOps(expression: Divide) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
        widened = widen(leftAnswer, rightAnswer)
      } yield widened._1.divide(widened._2)
    }
  }

  implicit class MinusOps(expression: Minus) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
      } yield rightAnswer.minus
    }
  }

  implicit class LessThanOps(expression: LessThan) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
        widened = widen(leftAnswer, rightAnswer)
      } yield widened._1.lessThan(widened._2)
    }
  }

  implicit class LessThanEqualOps(expression: LessThanEqual) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
        widened = widen(leftAnswer, rightAnswer)
      } yield widened._1.lessThanEquals(widened._2)
    }
  }

  implicit class GreaterThenEqualOps(expression: GreaterThenEqual) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
        widened = widen(leftAnswer, rightAnswer)
      } yield widened._1.greaterThenEquals(widened._2)
    }
  }

  implicit class GreaterThenOps(expression: GreaterThen) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
        widened = widen(leftAnswer, rightAnswer)
      } yield widened._1.greaterThen(widened._2)
    }
  }

  implicit class NotEqualOps(expression: NotEqual) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
        widened = widen(leftAnswer, rightAnswer)
      } yield widened._1.notEquals(widened._2)
    }
  }

  implicit class EqualOps(expression: Equal) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
        widened = widen(leftAnswer, rightAnswer)
      } yield widened._1.equals(widened._2)
    }
  }

  implicit class OrOps(expression: Or) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
      } yield leftAnswer.or(rightAnswer)
    }
  }

  implicit class AndOps(expression: And) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        leftAnswer <- expression.left.evaluate(symbolTable, dictionary)
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
      } yield leftAnswer.and(rightAnswer)
    }
  }

  implicit class NegateOps(expression: Negate) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      for {
        rightAnswer <- expression.right.evaluate(symbolTable, dictionary)
      } yield rightAnswer.negate
    }
  }

  implicit class ReferenceOps(expression: Reference) {
    def evaluate(symbolTable: SymbolTable, dictionary: Dictionary): Option[Answer] = {
      symbolTable
        .get(expression.questionId)
        .flatMap(_.expression)
        .orElse(dictionary.get(expression.questionId))
        .flatMap(_.evaluate(symbolTable, dictionary))
    }
  }

  /**
    * Only expressions that are defined to be a variable (answer) will be retrieved from the dictionary if exist.
    * This is done so values of calculated fields won't be retrieved from the dictionary
    */
  private def memoryLookup(questionId: String, expression: Expression, dictionary: Dictionary) = expression match {
    case _: Answer => dictionary.getOrElse(questionId, expression)
    case _         => expression
  }
}