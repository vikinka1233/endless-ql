﻿namespace QuestionnaireDomain.Entities.Ast.Nodes.Boolean.Interfaces
{
    public interface IBooleanLiteralNode : ITerminalNode
    {
        bool Value { get; }
    }
}