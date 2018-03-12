﻿using System;
using QuestionaireDomain.Entities.API.AstNodes.Calculation;

namespace QuestionaireDomain.Entities.DomainObjects.Ast
{
    internal class MultiplyNode : 
        CalculationBinaryExpressionNodeBase, 
        IMultiplyNode
    {
        public MultiplyNode(
            Guid id,
            string definition,
            Reference<ICalculationNode> leftCalculation,
            Reference<ICalculationNode> rightCalculation) 
            : base(id, definition, leftCalculation, rightCalculation)
        {
        }
    }
}