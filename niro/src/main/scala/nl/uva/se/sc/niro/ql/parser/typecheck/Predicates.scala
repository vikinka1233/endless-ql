package nl.uva.se.sc.niro.ql.parser.typecheck

import cats.implicits._
import nl.uva.se.sc.niro.errors.Errors.TypeCheckError
import nl.uva.se.sc.niro.ql.model.ast._
import nl.uva.se.sc.niro.ql.parser.typecheck.StaticTypes._
import nl.uva.se.sc.niro.util.PrettyPrinter.ExpressionCanPrettyPrint
import org.apache.logging.log4j.scala.Logging

object Predicates extends Logging {
  def check(qlForm: QLForm): Either[Seq[TypeCheckError], QLForm] = {
    logger.info("Phase 3 - Checking predicates that are not of the type boolean ...")

    val conditionals: Seq[Conditional] = Statement.collectAllConditionals(qlForm.statements)
    val conditionalsWithNonBooleanPredicates: Seq[Conditional] = conditionals filterNot { conditional =>
      conditional.predicate.typeOf(qlForm.symbolTable).contains(BooleanType)
    }

    if (conditionalsWithNonBooleanPredicates.nonEmpty) {
      conditionalsWithNonBooleanPredicates
        .map(nonBooleanPredicate =>
          TypeCheckError(message = s"Non boolean predicate: ${nonBooleanPredicate.predicate.prettyPrint}"))
        .asLeft
    } else {
      qlForm.asRight
    }
  }
}
