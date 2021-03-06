﻿using System;
using AntlrInterpretor;
using Microsoft.Extensions.DependencyInjection;
using QuestionnaireDomain.Entities.Ast.Tools.Interfaces;
using QuestionaireOrchestration;
using QuestionaireOrchestration.Visitors;
using QuestionnaireDomain.Entities.Domain.Interfaces;
using QuestionnaireInfrastructure;
using QuestionnaireInfrastructure.API;

namespace QuestionaireConsoleApp
{
    class Program
    {
        private static IServiceCollection QlServiceCollection { get; set; }
        private static IServiceProvider m_serviceProvider;
        private static IDomainItemLocator m_domainItemLocator;
        private static IQuestionnairePrinter m_qprint;
        private static IBooleanLogicPrinter m_bprint;

        static void Main(string[] args)
        {
            InitializeModules();

            while (true)
            {
                Console.WriteLine("Choose:");
                Console.WriteLine("  1: form definition");
                Console.WriteLine("  2: logical statement");
                Console.WriteLine("  3: calculation");
                Console.WriteLine("  q: quit");
                var choice = Console.ReadLine();

                //ToDo, remove the Nuke Hack - dont expose registry!
                var registry = m_serviceProvider.GetService<IDomainItemRegistry>();
                registry.Nuke();

                switch (choice)
                {
                    case "q":
                        break;
                    case "1":
                        WriteQuestionnaire();
                        continue;
                    case "2":
                        WriteCondition();
                        continue;
                    case "3":
                        continue;
                    default:
                        Console.WriteLine($"'{choice}' is not a valid option");
                        continue;
                }

                break;
            }
        }

        private static void WriteCondition()
        {
            Console.WriteLine("Enter statement:");
            var formDefinition = Console.ReadLine();
            //ToDo: move creation of predicate into console app
  
           // m_bprint.Print(predicate.ToDomainItem(m_domainItemLocator));
        }

        private static void WriteQuestionnaire()
        {
            Console.WriteLine("Enter form:");
            var formDefinition = Console.ReadLine();
            var creator = m_serviceProvider.GetService<IQuestionnaireAstCreator>();
            var questionaire = creator.Create(formDefinition);

            m_qprint.Print(questionaire.ToDomainItem(m_domainItemLocator));
        }


        private static void InitializeModules()
        {
            var ioc = new DependencyInjectionContainer();
            QlServiceCollection = ioc.Create();

            QlServiceCollection.AddModule(new InfrastructureModule());
            QlServiceCollection.AddModule(new AntlrModule());
            QlServiceCollection.AddModule(new OrchestrationModule());
            m_serviceProvider = QlServiceCollection.BuildServiceProvider(true);
            m_domainItemLocator = m_serviceProvider.GetService<IDomainItemLocator>();
            m_qprint = m_serviceProvider.GetService<IQuestionnairePrinter>();
            m_qprint.Writer = Console.Out;
            m_bprint = m_serviceProvider.GetService<IBooleanLogicPrinter>();
            m_bprint.Writer = Console.Out;
        }
    }
}
