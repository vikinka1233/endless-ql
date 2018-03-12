﻿using System;
using Microsoft.Extensions.DependencyInjection;
using QuestionnaireDomain.Entities.API;
using QuestionnaireInfrastructure.API;

namespace QuestionnaireDomain.Entities
{
    public class EntitiesModule : IHasRegistrations
    {
        public void RegisterDependencies(IServiceCollection appRegistration)
        {
            appRegistration.AddSingleton(typeof(IAstFactory), typeof(AstFactory));
            appRegistration.AddSingleton(typeof(IOutputItemFactory), typeof(OutputItemFactory));
            appRegistration.AddSingleton(typeof(IDomainItemRegistry), typeof(DomainItemRegistry));
            appRegistration.AddSingleton(typeof(ISymbolTable<bool>), typeof(SymbolTable<bool>));
            appRegistration.AddSingleton(typeof(ISymbolTable<decimal>), typeof(SymbolTable<decimal>));
            appRegistration.AddSingleton(typeof(ISymbolTable<DateTime>), typeof(SymbolTable<DateTime>));
            appRegistration.AddSingleton(typeof(ISymbolTable<string>), typeof(SymbolTable<string>));
        }
    }
}
