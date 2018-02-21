﻿using System;
using QuestionaireOrchestration.API;
using QuestionnaireDomain.Logic.API;
using QuestionnaireInfrastructure.API;

namespace QuestionaireOrchestration.CommandHandlers
{
    internal class ParseTextCommandHandler : ICommandHandler<CreateQuestionnaireCommandMessage>
    {
        private readonly IQuestionnaireCreator m_questionnaireCreator;
        private readonly ICommandObjectRegistry m_commandObjectRegistry;

        public ParseTextCommandHandler(
            IQuestionnaireCreator questionnaireCreator,
            ICommandObjectRegistry commandObjectRegistry)
        {
            m_questionnaireCreator = questionnaireCreator;
            m_commandObjectRegistry = commandObjectRegistry;
        }
        
        public void Execute(CreateQuestionnaireCommandMessage command)
        {
            var createdId = m_questionnaireCreator.Create(command.Text);
            if (createdId != Guid.Empty) 
            {
                m_commandObjectRegistry.Add(command, createdId);
            }
        }
    }
}