﻿using QLParser.AST;
using QLParser.AST.QL;
using QLParser.AST.QLS;
using QLParser.AST.QLS.Enums;
using System;
using System.Collections.Generic;
using static QLSGrammar.QLSGrammarParser;

namespace QLParser.ParserVisitors.QLS
{
    public class StylesheetVisitor : QLSGrammar.QLSGrammarBaseVisitor<QLSNode>
    {
        public override QLSNode VisitStylesheet(StylesheetContext context)
        {
            if (context == null)
                throw new ArgumentNullException("Context can't be null.");

            string id = context.ID().GetText();
            var styles = VisitDefaults(context.defaults());
            var qlsNode = new QLSStructuralNode(Location.FromContext(context), QLSNodeType.Stylesheet, id, styles);

            foreach (PageContext pageContext in context.page())
                qlsNode.AddNode(VisitPage(pageContext));

            return qlsNode;
        }

        public override QLSNode VisitPage(PageContext context)
        {
            if (context == null)
                throw new ArgumentNullException("Context can't be null.");

            string id = Util.RemoveQuotes(context.TEXT().GetText());
            var styles = VisitDefaults(context.defaults());
            var qlsNode = new QLSStructuralNode(Location.FromContext(context), QLSNodeType.Page, id, styles);

            foreach (SectionContext sectionContext in context.section())
                qlsNode.AddNode(VisitSection(sectionContext));

            return qlsNode;
        }

        public override QLSNode VisitSection(SectionContext context)
        {
            if (context == null)
                throw new ArgumentNullException("Context can't be null.");

            string id = Util.RemoveQuotes(context.TEXT().GetText());
            var styles = VisitDefaults(context.defaults());
            var qlsNode = new QLSStructuralNode(Location.FromContext(context), QLSNodeType.Section, id, styles);

            foreach (SectionContext sectionContext in context.section())
                qlsNode.AddNode(VisitSection(sectionContext));

            foreach (QuestionContext questionContext in context.question())
                qlsNode.AddNode(VisitQuestion(questionContext));

            return qlsNode;
        }

        public override QLSNode VisitQuestion(QuestionContext context)
        {
            if (context == null)
                throw new ArgumentNullException("Context can't be null.");

            string id = context.ID().GetText();

            if (context.widgetspecification() != null)
            {
                var widgetSpecificaitonVisitor = new WidgetSpecificationVisitor();
                var specification = widgetSpecificaitonVisitor.VisitWidgetspecification(context.widgetspecification());

                var qlsNode = new QLSQuestionNode(Location.FromContext(context), id, new List<QLSStyle>() { new QLSStyle(QValueType.Unknown, specification) });
                return qlsNode;
            }
            else
            {
                var qlsNode = new QLSQuestionNode(Location.FromContext(context), id);
                return qlsNode;
            }
        }

        private new QLSStyle VisitDefaults(DefaultsContext context)
        {
            if (context == null)
                return new QLSStyle();

            var visitor = new DefaultsVisitor();
            return visitor.VisitDefaults(context);
        }

        private IList<QLSStyle> VisitDefaults(DefaultsContext[] contexts)
        {
            IList<QLSStyle> styles = new List<QLSStyle>();
            foreach (var defaultContext in contexts)
                styles.Add(VisitDefaults(defaultContext));

            return styles;
        }
    }
}