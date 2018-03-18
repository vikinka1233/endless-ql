﻿using System.Collections.Generic;
using QuestionnaireDomain.Entities.Ast.Nodes.Questionnaire.Interfaces;
using QuestionnaireDomain.Entities.Domain;

namespace QuestionnaireDomain.Entities.Validators
{
    public interface IValidator
    {
        IEnumerable<ValidationMetaData> Validate(Reference<IQuestionnaireRootNode> questionnaireRootNode);
    }
}