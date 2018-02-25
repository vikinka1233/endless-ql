﻿using Antlr4.Runtime.Misc;
using QL_Parser.AST.Nodes;
using QLanguage;

namespace QL_Parser.Visitors
{
    public class ValueVisitor : QLanguage.QLanguageBaseVisitor<IExpressionNode>
    {
        public override IExpressionNode VisitValue([NotNull] QLanguageParser.ValueContext context)
        {
            var statement = context.statement();
            if (statement != null)
            {
                var visitor = new StatementVisitor();
                return visitor.VisitStatement(statement);
            }
            else
            {
                var id = context.ID().GetText();
                return new ValueNode(id);
            }
        }
    }
}
