﻿using QuestionnaireDomain.Entities.API;

namespace QuestionnaireDomain.Entities.Ast.Nodes.Common.Interfaces
{
    public interface IAstNode : IDomainItem
    {
        string Definition { get; }
    }
}