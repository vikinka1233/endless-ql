import Condition from "./Condition";
import FormState from "../../state/FormState";
import { evaluate } from "../../evaluation/evaluation_functions";
import FieldVisitor from "../visitors/FieldVisitor";
import { assertBoolean } from "../../typechecking/typeAssertions";

export default class IfCondition extends Condition {
  accept(visitor: FieldVisitor): any {
    return visitor.visitIfCondition(this);
  }

  passes(formState: FormState): boolean {
    try {
      return assertBoolean(evaluate(this.predicate, formState));
    } catch (error) {
      console.error(error);
      return false;
    }
  }

  fails(formState: FormState): boolean {
    return !this.passes(formState);
  }
}