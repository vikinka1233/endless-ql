﻿using System;
using System.Collections.Generic;

namespace QuestionnaireDomain.Entities.Domain.Interfaces
{
    public interface IDomainItemRegistry
    {
        void Add(IDomainItem item);
        T Find<T>(Guid id) where T : IDomainItem;
        IEnumerable<T> GetAll<T>() where T : IDomainItem;
        void Nuke();
        void Delete<T>(DomainId<T> domainItem) where T : IDomainItem;
    }
}