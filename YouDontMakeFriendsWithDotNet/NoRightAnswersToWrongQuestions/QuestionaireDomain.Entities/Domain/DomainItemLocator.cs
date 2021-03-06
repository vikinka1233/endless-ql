﻿using System;
using System.Collections.Generic;
using System.Linq;
using QuestionnaireDomain.Entities.Ast.Nodes.Questionnaire.Interfaces;
using QuestionnaireDomain.Entities.Domain.Interfaces;

namespace QuestionnaireDomain.Entities.Domain
{
    public class DomainItemLocator : IDomainItemLocator
    {
        private readonly IDomainItemRegistry m_registry;

        public DomainItemLocator(IDomainItemRegistry registry)
        {
            m_registry = registry;
        }

        public TDomainItem Get<TDomainItem>(Guid id) where TDomainItem : IDomainItem
        {
            return m_registry.Find<TDomainItem>(id);
        }

        public DomainId<TDomainItem> GetRef<TDomainItem>(Guid id) where TDomainItem : IDomainItem
        {
            var domainItem = m_registry.Find<TDomainItem>(id);
            return new DomainId<TDomainItem>(domainItem.Id);
        }

        public IEnumerable<TDomainItem> GetAll<TDomainItem>() where TDomainItem : IDomainItem
        {
            return m_registry.GetAll<TDomainItem>();
        }

        public IEnumerable<DomainId<TDomainItem>> GetAllRefs<TDomainItem>() where TDomainItem : IDomainItem
        {
            return m_registry
                .GetAll<TDomainItem>()
                .Select(x => new DomainId<TDomainItem>(x.Id));
        }

        public bool Exists<TDomainItem>(Guid id) where TDomainItem : IDomainItem
        {
            try
            {
                return m_registry.Find<TDomainItem>(id) != null;
            }
            catch (Exception)
            {
                return false;
            }
        }

        public DomainId<IQuestionnaireRootNode> GetRoot(DomainId<IQuestionNode> node)
        {
            return GetAllRefs<IQuestionnaireRootNode>().FirstOrDefault();
        }
    }
}