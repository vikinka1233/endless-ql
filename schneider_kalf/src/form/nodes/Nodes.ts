import FormNode from './FormNode';
import Question from './fields/Question';
import IfCondition from './conditions/IfCondition';
import Addition from './expressions/arithmetic/Addition';
import Division from './expressions/arithmetic/Division';
import Multiplication from './expressions/arithmetic/Multiplication';
import NumberLiteral from './expressions/arithmetic/NumberLiteral';
import Subtraction from './expressions/arithmetic/Subtraction';
import And from './expressions/boolean_expressions/And';
import BooleanLiteral from './expressions/boolean_expressions/BooleanLiteral';
import Negation from './expressions/boolean_expressions/Negation';
import Or from './expressions/boolean_expressions/Or';
import Equals from './expressions/comparisons/Equals';
import LargerThan from './expressions/comparisons/LargerThan';
import LargerThanOrEqual from './expressions/comparisons/LargerThanOrEqual';
import SmallerThan from './expressions/comparisons/SmallerThan';
import NotEqual from './expressions/comparisons/NotEqual';
import SmallerThanOrEqual from './expressions/comparisons/SmallerThanOrEqual';
import VariableIdentifier from './expressions/VariableIdentifier';
import ComputedField from "./fields/ComputedField";

/**
 * List all available node types for easy access in the grammar.
 */
export default {
  IfCondition,
  Addition,
  Division,
  Multiplication,
  NumberLiteral,
  Subtraction,
  And,
  BooleanLiteral,
  Negation,
  Or,
  Equals,
  LargerThan,
  LargerThanOrEqual,
  NotEqual,
  SmallerThan,
  SmallerThanOrEqual,
  VariableIdentifier,
  ComputedField,
  Question,
  FormNode
};