﻿using QL_Vizualizer.Controllers;
using QL_Vizualizer.Expression;
using QL_Vizualizer.Expression.Types;
using System.Collections.Generic;
using System.Linq;

namespace QL_Vizualizer.ElementManagers
{
    public abstract class ElementManager
    {
        /// <summary>
        /// Unique identifyer of the Element & ElementManager
        /// </summary>
        public string Identifyer { get; private set; }

        /// <summary>
        /// Text of the ElementManager
        /// </summary>
        public string Text { get; private set; }

        /// <summary>
        /// Indication if the Element should be shown
        /// </summary>
        public bool Active { get; protected set; }

        /// <summary>
        /// Expression for activation evaluation
        /// </summary>
        protected ExpressionBool _activationExpression;

        /// <summary>
        /// ElementManager controller that this ElementManager receives updates from
        /// </summary>
        protected ElementManagerController _widgetController;

        /// <summary>
        /// Parent of this ElementManager
        /// </summary>
        protected ElementManager _parent { get; private set; }

        public ElementManager(string identifyer, string text, ExpressionBool activationExpression = null)
        {
            Text = text;
            Identifyer = identifyer;

            _activationExpression = activationExpression;
            Active = activationExpression == null;
        }

        public virtual IEnumerable<string> GetNotifyWidgetIDs()
        {
            return _activationExpression.UsedWidgetIDs;
        }

        /// <summary>
        /// Sets widgetcontroller and subscribes to value changes
        /// </summary>
        /// <param name="controller">Controller to use</param>
        public virtual void SetController(ElementManagerController controller)
        {
            _widgetController = controller;

            // Subscribe to items from the controller
            if (_activationExpression != null)
            {
                foreach (string id in GetNotifyWidgetIDs())
                    _widgetController.ReceiveUpdates(id, this);
                Active = _activationExpression.Result;
            }
        }

        /// <summary>
        /// Handles incoming update notifactions
        /// </summary>
        /// <param name="updatedIdentifyer">Updated widgetID</param>
        public virtual void ReceiveUpdate(string updatedIdentifyer)
        {
            bool _oldActive = Active;
            if (_activationExpression != null && _activationExpression.UsedWidgetIDs.Contains(updatedIdentifyer))
                Active = _activationExpression.Result;
            _widgetController.UpdateView(this);

            // Value is changed
            if (_oldActive != Active)
                _widgetController.ActiveChanged();
        }

        public abstract string ToXML();

        public void SetParent(ElementManager parent)
        {
            _parent = parent;
        }
    }
}