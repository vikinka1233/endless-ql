﻿using QLParser.Analysis.QL.Semantic;
using QLParser.Analysis.QL.Syntactic;
using QLParser.Analysis.QLS;
using QLParser.AST.QL;
using QLParser.AST.QLS;
using System.Collections.Generic;
using System.Linq;

namespace QLParser.Analysis
{
    public class Analyser
    {
        #region Singleton
        private static Analyser _instance;
        public static Analyser Instance
        {
            get
            {
                if (_instance == null)
                    _instance = new Analyser();

                return _instance;
            }
        }
        #endregion

        private IList<IQLAnalyser> _qlAnalysers;
        private IList<IQLSAnalyser> _qlsAnalysers;
        private IList<AnalyserMessage> _messages;

        private Analyser()
        {
            this._messages = new List<AnalyserMessage>();
            this._qlAnalysers = new List<IQLAnalyser>()
            {
                // Syntactic
                new SingleFormValidator(),

                // Semantic
                new DuplicateVariableAnalyser(),
                new OnlyInitialisedVarsAnalyser(),
                new StatementTypeAnalyser()
            };
            this._qlsAnalysers = new List<IQLSAnalyser>() {
                new AllIdentifiersAreUsedAnalyser(),
                new DuplicateIdentifiersAnalyser(),
                new UnknownIdentifiersAnalyser()
            };

        }

        public static bool Analyse(QLNode node)
        {
            Reset();

            if (node == null)
                return false;

            var result = true;
            foreach (IQLAnalyser analyser in Instance._qlAnalysers)
                if (!analyser.Analyse(node) && result)
                    result = false;

            return result;
        }

        private static bool Analyse(QLSNode node)
        {
            if (node == null)
                return false;

            var result = true;
            foreach (IQLSAnalyser analyser in Instance._qlsAnalysers)
                if (!analyser.Analyse(node) && result)
                    result = false;

            return result;
        }

        public static bool Analyse(QLNode qlNode, QLSNode qlsNode)
        {
            Reset();

            if (qlNode == null || qlsNode == null)
                return false;

            // Analyse QL and QLS.
            var result = true;
            result = Analyse(qlNode) && result;
            result = Analyse(qlsNode) && result;

            return result;
        }

        public static void AddMessage(string message, Language languageType, MessageType messageType)
        {
            Instance._messages.Add(new AnalyserMessage(message, languageType, messageType));
        }

        public static List<string> GetErrors()
        {
            return Instance._messages
                .Select(x => x.ToString())
                .ToList();
        }

        public static void Reset()
        {
            Instance._messages.Clear();
        }
    }
}