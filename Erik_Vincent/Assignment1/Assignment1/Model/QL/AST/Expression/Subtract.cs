namespace Assignment1.Model.QL.AST.Expression
{
    public class Subtract : Binary
    {
        public Subtract(int lineNumber, IExpression left, IExpression right) : base(left, right)
        {
            _lineNumber = lineNumber;
        }

        public override void Accept(IExpressionVisitor visitor) => visitor.Visit(this);
    }
}