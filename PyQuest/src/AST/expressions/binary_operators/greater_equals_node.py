from AST.expressions.binary_operators.binary_operator_node import BinaryOperatorNode


class GreaterEqualsOperatorNode(BinaryOperatorNode):
    def __init__(self, position, expression_type, left_expression, right_expression, value):
        super(GreaterEqualsOperatorNode, self).__init__(position, expression_type, left_expression, right_expression, value)

    def evaluate(self):
        if self.left_expression.value is not None and self.right_expression.value is not None:
            self.value = self.left_expression.value >= self.right_expression.value
