﻿using System;
using System.Collections.Generic;
using QuestionnaireDomain.Entities.Ast.Nodes.Boolean;
using QuestionnaireDomain.Entities.Ast.Nodes.Boolean.Interfaces;
using QuestionnaireDomain.Entities.Ast.Nodes.Calculation;
using QuestionnaireDomain.Entities.Ast.Nodes.Calculation.Interfaces;
using QuestionnaireDomain.Entities.Ast.Nodes.Common;
using QuestionnaireDomain.Entities.Ast.Nodes.Common.Interfaces;
using QuestionnaireDomain.Entities.Ast.Nodes.Questionnaire;
using QuestionnaireDomain.Entities.Ast.Nodes.Questionnaire.Interfaces;
using QuestionnaireDomain.Entities.Ast.Nodes.Relational;
using QuestionnaireDomain.Entities.Ast.Nodes.Relational.Interfaces;
using QuestionnaireDomain.Entities.Ast.Tools.Interfaces;
using QuestionnaireDomain.Entities.Domain;
using QuestionnaireDomain.Entities.Domain.Interfaces;
using QuestionnaireInfrastructure.API;

namespace QuestionnaireDomain.Entities.Ast.Tools
{
    internal class AstFactory : IAstFactory
    {
        private readonly IIdMaker m_ids;
        private readonly IDomainItemRegistry m_registry;
        private readonly ISymbolTable m_symbolTable;

        public AstFactory(
            IIdMaker ids, 
            IDomainItemRegistry registry,
            ISymbolTable symbolTable)
        {
            m_ids = ids;
            m_registry = registry;
            m_symbolTable = symbolTable;
        }

        public Reference<IQuestionnaireRootNode> CreateQuestionnaire(
            string definition,
            string questionaireName,
            IEnumerable<Reference<IStatementNode>> statements)
        {
            var questionnaire = new QuestionnaireRootNode(
                m_ids.Next,
                definition,
                questionaireName,
                statements);

            return DomainItemRegistration<IQuestionnaireRootNode>(questionnaire);
        }
        
        public Reference<IConditionalStatementNode> CreateConditional(
            string definition, 
            Reference<IBooleanLogicNode> predicate, 
            IEnumerable<Reference<IStatementNode>> consequent,
            IEnumerable<Reference<IStatementNode>> alternative)
        {
            var condition = new ConditionalNode(
                m_ids.Next, 
                definition,
                predicate,
                consequent,
                alternative);

            return DomainItemRegistration<IConditionalStatementNode>(condition);
        }

        public Reference<IUserInputQuestionNode> CreateUserInputQuestion(
            string definition,
            string questionName,
            string questionText,
            Type questionType)
        {
            var question = new UserInputQuestionNode(
                m_ids.Next,
                definition,
                questionName,
                questionText,
                questionType);

            InitializeVariable(question.Id, questionType);
            return DomainItemRegistration<IUserInputQuestionNode>(question);
        }

        private void InitializeVariable(Guid questionId, Type questionType)
        {
            if (questionType == typeof(bool))
            {
                m_symbolTable.Add(questionId, default(bool));
            }

            if (questionType == typeof(decimal))
            {
                m_symbolTable.Add(questionId, default(decimal));
            }

            if (questionType == typeof(int))
            {
                m_symbolTable.Add(questionId, default(int));
            }

            if (questionType == typeof(DateTime))
            {
                m_symbolTable.Add(questionId, default(DateTime));
            }
            
            if (questionType == typeof(string))
            {
                m_symbolTable.Add(questionId, default(string));
            }
        }

        public Reference<ICalculatedQuestionNode> CreateCalculatedQuestion(
            string definition, 
            string questionName, 
            string questionText, 
            Type questionType,
            Reference<ICalculationNode> calculation)
        {
            var question = new CalculatedQuestionNode(
                m_ids.Next,
                definition,
                questionName,
                questionText,
                questionType,
                calculation);

            return DomainItemRegistration<ICalculatedQuestionNode>(question);
        }

        public Reference<INumberNode> CreateNumber(string numberText)
        {
            var number = new NumberNode(m_ids.Next, numberText);
            return DomainItemRegistration<INumberNode>(number);
        }

        public Reference<ICalculationVariableNode> CreateNumberVariableName(string variableName)
        {
            var variable = new CalculationVariableNode(m_ids.Next, variableName);
            return DomainItemRegistration<ICalculationVariableNode>(variable);
        }

        public Reference<IBooleanVariableNode> CreateBooleanVariableName(string variableName)
        {
            var variable = new BooleanVariableNode(m_ids.Next, variableName);
            return DomainItemRegistration<IBooleanVariableNode>(variable);
        }

        public Reference<IBooleanLiteralNode> CreateBooleanLiteral(string booleanString)
        {
            var literal = new BooleanLiteralNode(m_ids.Next,booleanString);
            return DomainItemRegistration<IBooleanLiteralNode>(literal);
        }

        public Reference<IAndNode> CreateAndOperation(
            string definition,
            Reference<IBooleanLogicNode> leftExpression,
            Reference<IBooleanLogicNode> rightExpression)
        {
            var andNode = new AndNode(
                m_ids.Next, 
                definition,
                leftExpression, 
                rightExpression);

            return DomainItemRegistration<IAndNode>(andNode);
        }

        public Reference<IOrNode> CreateOrOperation(
            string definition,
            Reference<IBooleanLogicNode> leftExpression,
            Reference<IBooleanLogicNode> rightExpression)
        {
            var orNode = new OrNode(
                m_ids.Next, 
                definition,
                leftExpression, 
                rightExpression);

            return DomainItemRegistration<IOrNode>(orNode);
        }

        public Reference<INegateNode> CreateNegationOperation(
            string definition,
            Reference<IBooleanLogicNode> childExpression)
        {
            var negateNode = new NegateNode(
                m_ids.Next, 
                definition,
                childExpression);

            return DomainItemRegistration<INegateNode>(negateNode);
        }

        public Reference<IEqualityNode> CreateEqualityOperation(
            string definition,
            Reference<IAstNode> leftExpression, 
            Reference<IAstNode> rightExpression)
        {
            var equalityNode = new EqualityNode(
                m_ids.Next, 
                definition,
                leftExpression, 
                rightExpression);

            return DomainItemRegistration<IEqualityNode>(equalityNode);
        }

        public Reference<IAstNode> CreateMultiplicationOperation(
            string definition,
            Reference<ICalculationNode> leftExpression, 
            Reference<ICalculationNode> rightExpression)
        {
            var multiplicationNode = new MultiplyNode(
                m_ids.Next,
                definition,
                leftExpression,
                rightExpression);

            return DomainItemRegistration<IMultiplyNode>(multiplicationNode);
        }

        public Reference<IAstNode> CreateDivisionOperation(
            string definition,
            Reference<ICalculationNode> leftExpression, 
            Reference<ICalculationNode> rightExpression)
        {
            var divisionNode = new DivideNode(
                m_ids.Next,
                definition,
                leftExpression,
                rightExpression);

            return DomainItemRegistration<IDivideNode>(divisionNode);
        }

        public Reference<IAstNode> CreateAdditionOperation(
            string definition, 
            Reference<ICalculationNode> leftExpression, 
            Reference<ICalculationNode> rightExpression)
        {
            var addNode = new AddNode(
                m_ids.Next,
                definition,
                leftExpression,
                rightExpression);

            return DomainItemRegistration<IAddNode>(addNode);
        }

        public Reference<IAstNode> CreateSubtractionOperation(
            string definition, 
            Reference<ICalculationNode> leftExpression, 
            Reference<ICalculationNode> rightExpression)
        {
            var subtractNode = new SubtractNode(
                m_ids.Next,
                definition,
                leftExpression,
                rightExpression);

            return DomainItemRegistration<ISubtractNode>(subtractNode);
        }

        public Reference<IAstNode> CreateInequalityOperation(
            string definition, Reference<IAstNode> leftExpression, 
            Reference<IAstNode> rightExpression)
        {
            var inequalityNode = new InequalityNode(
                m_ids.Next,
                definition,
                leftExpression,
                rightExpression);

            return DomainItemRegistration<IInequalityNode>(inequalityNode);
        }

        public Reference<IAstNode> CreateDate(string dateText)
        {
            var dateNode = new DateNode(
                m_ids.Next,
                dateText);

            return DomainItemRegistration<IDateNode>(dateNode);
        }

        public Reference<IAstNode> CreateDateVariableName(string variableName)
        {
            var dateNode = new DateVariableNode(
                m_ids.Next,
                variableName);

            return DomainItemRegistration<IDateVariableNode>(dateNode);
        }

        public Reference<IAstNode> CreateText(string text)
        {
            var dateNode = new TextNode(
                m_ids.Next,
                text);

            return DomainItemRegistration<ITextNode>(dateNode);
        }

        public Reference<IAstNode> CreateTextVariableName(string variableName)
        {
            var textNode = new TextVariableNode(
                m_ids.Next,
                variableName);

            return DomainItemRegistration<ITextVariableNode>(textNode);
        }

        public Reference<IAstNode> CreateGreaterThanOperation(
            string definition, 
            Reference<IAstNode> leftExpression, 
            Reference<IAstNode> rightExpression)
        {
            var greaterThanNode = new GreaterThanNode(
                m_ids.Next,
                definition,
                leftExpression,
                rightExpression);

            return DomainItemRegistration<IGreaterThanNode>(greaterThanNode);
        }

        public Reference<IAstNode> CreateGreaterOrEqualOperation(
            string definition, 
            Reference<IAstNode> leftExpression, 
            Reference<IAstNode> rightExpression)
        {
            var greaterOrEqualNode = new GreaterOrEqualNode(
                m_ids.Next,
                definition,
                leftExpression,
                rightExpression);

            return DomainItemRegistration<IGreaterOrEqualNode>(greaterOrEqualNode);
        }

        public Reference<IAstNode> CreateLessThanOperation(string definition, Reference<IAstNode> leftExpression, Reference<IAstNode> rightExpression)
        {
            var lessThanNode = new LessThanNode(
                m_ids.Next,
                definition,
                leftExpression,
                rightExpression);

            return DomainItemRegistration<ILessThanNode>(lessThanNode);
        }

        public Reference<IAstNode> CreateLessOrEqualOperation(string definition, Reference<IAstNode> leftExpression, Reference<IAstNode> rightExpression)
        {
            var lessOrEqualNode = new LessOrEqualNode(
                m_ids.Next,
                definition,
                leftExpression,
                rightExpression);

            return DomainItemRegistration<ILessOrEqualNode>(lessOrEqualNode);
        }

        public Reference<IUntypedVariableNode> CreateUntypedVariableName(string variableName)
        {
            var untypedVariableNode = new UntypedVariableNode(
                m_ids.Next,
                variableName);

            return DomainItemRegistration<IUntypedVariableNode>(untypedVariableNode);
        }

        private Reference<T> DomainItemRegistration<T>(T node) where T : IDomainItem
        {
            m_registry.Add(node);
            return new Reference<T>(node.Id);
        }
    }
}
