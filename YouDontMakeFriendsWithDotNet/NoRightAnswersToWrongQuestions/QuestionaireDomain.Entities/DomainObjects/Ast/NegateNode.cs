﻿using System;
using QuestionaireDomain.Entities.API.AstNodes.Boolean;

namespace QuestionaireDomain.Entities.DomainObjects.Ast
{
    internal class NegateNode : AstNodeBase, INegateNode
    {
        public NegateNode(
            Guid id,
            string definition,
            Reference<IBooleanLogicNode> childExpression) 
            : base(id, definition)
        {
            Expression = childExpression;
        }

        public Reference<IBooleanLogicNode> Expression { get; set; }
    }
}