﻿using System.Collections.Generic;
using System.Linq;
using Type = Assignment1.Model.QL.AST.Type;
using Assignment1.Model.QLS.AST.Style;

namespace Assignment1.Model.QLS.AST
{
    public class DefaultStyle : Statement
    {
        public Type Type { get; }
        public IReadOnlyCollection<IStyle> Styles => _styles.AsReadOnly();

        private readonly List<IStyle> _styles;

        public DefaultStyle(int lineNumber, Type type, IEnumerable<IStyle> styles)
        {
            _lineNumber = lineNumber;
            Type = type;
            _styles = styles.ToList();
        }

        public override void Accept(IQLSASTVisitor visitor) => visitor.Visit(this);
    }
}
