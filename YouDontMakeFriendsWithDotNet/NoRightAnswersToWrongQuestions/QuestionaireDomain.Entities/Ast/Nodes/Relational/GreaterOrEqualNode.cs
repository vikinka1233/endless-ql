﻿using System;
using QuestionnaireDomain.Entities.Ast.Nodes.Common.Interfaces;
using QuestionnaireDomain.Entities.Ast.Nodes.Relational.Interfaces;
using QuestionnaireDomain.Entities.DomainObjects;

namespace QuestionnaireDomain.Entities.Ast.Nodes.Relational
{
    internal class GreaterOrEqualNode : 
        RelationalOperationNode, 
        IGreaterOrEqualNode
    {
        public GreaterOrEqualNode(
            Guid id,
            string definition,
            Reference<IAstNode> leftExpression,
            Reference<IAstNode> rightExpression)
            : base(id, definition, leftExpression, rightExpression)
        {
        }
    }
}