import Field from "./FieldNode";
import FieldType from "../../FieldType";
import NodeVisitor from "../visitors/NodeVisitor";
import FormState from "../../state/FormState";

/**
 * Decorator for Fields that makes the Field "decoratable" for future usage.
 */
export default class FieldDecorator implements Field {
  private fieldToBeDecorated: Field;

  get identifier(): string {
    return this.fieldToBeDecorated.identifier;
  }

  get label(): string {
    return this.fieldToBeDecorated.label;
  }

  get type(): FieldType {
    return this.fieldToBeDecorated.type;
  }

  constructor(fieldToBeDecorated: Field) {
    this.fieldToBeDecorated = fieldToBeDecorated;
  }

  accept(visitor: NodeVisitor) {
    return this.fieldToBeDecorated.accept(visitor);
  }

  isReadOnly(): boolean {
    return this.fieldToBeDecorated.isReadOnly();
  }

  getAnswer(state: FormState) {
    return this.fieldToBeDecorated.getAnswer(state);
  }
}