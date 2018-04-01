﻿using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using QLGrammar;
using QLParser.AST;
using QLParser.AST.QL;
using System.Linq;
using static QLGrammar.QLGrammarParser;

namespace QLParser.ParserVisitors.QL
{
    public class FormVisitor : QLGrammarBaseVisitor<FormNode>
    {
        public override FormNode VisitForm([NotNull] FormContext context)
        {
            if (context.children.Any(x => x.GetType() == typeof(ErrorNodeImpl)))
                return null;

            // Construct FormNode object to store the results in.
            var name = context.formName().GetText();
            FormNode node = new FormNode(Location.FromContext(context), name);

            // Get the sections
            SectionContext[] sectionContext = context.section();
            SectionVisitor visitor = new SectionVisitor();
            foreach (SectionContext ctx in sectionContext)
                node.AddNode(visitor.VisitSection(ctx));

            return node;
        }
    }
}