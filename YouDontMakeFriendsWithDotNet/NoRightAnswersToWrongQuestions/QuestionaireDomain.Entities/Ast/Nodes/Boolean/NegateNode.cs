﻿using System;
using QuestionnaireDomain.Entities.Ast.Nodes.Boolean.Interfaces;
using QuestionnaireDomain.Entities.Ast.Nodes.Common;
using QuestionnaireDomain.Entities.Domain;

namespace QuestionnaireDomain.Entities.Ast.Nodes.Boolean
{
    internal class NegateNode : AstNodeBase, INegateNode
    {
        public NegateNode(
            Guid id,
            string definition,
            DomainId<IBooleanLogicNode> childExpression)
            : base(id, definition)
        {
            Expression = childExpression;
        }

        public DomainId<IBooleanLogicNode> Expression { get; set; }
    }
}