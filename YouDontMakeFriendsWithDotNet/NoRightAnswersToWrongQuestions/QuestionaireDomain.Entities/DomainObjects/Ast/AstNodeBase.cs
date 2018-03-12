﻿using System;
using QuestionaireDomain.Entities.API.AstNodes;

namespace QuestionaireDomain.Entities.DomainObjects.Ast
{
    internal abstract class AstNodeBase : IAstNode
    {
        protected AstNodeBase(
            Guid id,
            string definition)
        {
            Id = id;
            Definition = definition;
            DisplayName = definition;
        }

        public Guid Id { get; }
        public string DisplayName { get; }
        public string Definition { get; }
    }
}