﻿using Antlr4.Runtime;
using QL.Core.Types;

namespace QL.Core.Ast
{
    public class QuestionNode : Node
    {
        public QuestionNode(IToken token, string description, string label, QLType type) : base(token)
        {
            Description = description;
            Label = label;
            Type = type;
        }

        public string Description { get; }
        public QLType Type { get; }
        public string Label { get; }

        protected override void VisitNode(IVisitor visitor)
        {
            visitor.VisitEnter(this);
            VisitChildren(visitor);
            visitor.VisitExit(this);
        }
    }
}
