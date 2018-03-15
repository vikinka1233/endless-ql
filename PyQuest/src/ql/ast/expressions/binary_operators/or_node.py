from ql.ast.expressions.binary_operators.binary_operator_node import BinaryOperatorNode
from ql.types.type_boolean import TypeBoolean
from ql.types.type_undefined import TypeUndefined


class OrOperatorNode(BinaryOperatorNode):
    def __init__(self, position, expression_type, left_expression, right_expression, value):
        super(OrOperatorNode, self).__init__(position, expression_type, left_expression, right_expression, value)
        self.__valid_types = {(TypeBoolean, TypeBoolean): TypeBoolean}

    def get_result_type(self, type1, type2):
        if self.__valid_types.get((type1, type2)):
            return self.__valid_types.get((type1, type2))
        return TypeUndefined

    def evaluate(self):
        if self.left_expression.value is not None or self.right_expression.value is not None:
            self.value = self.left_expression.value or self.right_expression.value