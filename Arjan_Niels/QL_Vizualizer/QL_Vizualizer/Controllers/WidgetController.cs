﻿using QL_Parser;
using QL_Parser.Analysis;
using QL_Parser.AST.Nodes;
using QL_Vizualizer.Controllers.Display;
using QL_Vizualizer.Widgets;
using System.Collections.Generic;
using System.Linq;


namespace QL_Vizualizer.Controllers
{
    /// <summary>
    /// Stores used Widgets
    /// Handles Widget answer/value updates
    /// Abstracts Widget View
    /// </summary>
    public abstract class WidgetController
    {
        /// <summary>
        /// Collection of widgets, dictionary on widget identifyer
        /// </summary>
        protected Dictionary<string, QLWidget> _widgets;

        /// <summary>
        /// Collection of widgets, subscribed to a widget (subscribed to widgetID is stored in the key)
        /// </summary>
        private Dictionary<string, List<QLWidget>> _notifyOnChange;

        public WidgetController()
        {
            _widgets = new Dictionary<string, QLWidget>();
            _notifyOnChange = new Dictionary<string, List<QLWidget>>();
        }

        /// <summary>
        /// Set display controller
        /// </summary>
        /// <typeparam name="T">Element type of display controller</typeparam>
        /// <param name="displayController">Display controller to use</param>
        public abstract void SetDisplayController<T,Y>(WidgetDisplayController<T,Y> displayController);

        /// <summary>
        /// Updates the view of a widget
        /// </summary>
        /// <param name="widget">Widget to update</param>
        public abstract void UpdateView(QLWidget widget);

        /// <summary>
        /// Shows all widgets
        /// </summary>
        public abstract void ShowWidgets();

        /// <summary>
        /// Shows view to user
        /// </summary>
        public abstract void ShowView();

        /// <summary>
        /// Handles error display
        /// </summary>
        /// <param name="errors">Errors to show</param>
        public abstract void ShowError(params string[] errors);

        /// <summary>
        /// Sets all widgets, overrides existing values
        /// </summary>
        /// <param name="widgets">Widgets to assign</param>
        public virtual void SetWidgets(List<QLWidget> widgets)
        {
            // Convert list input to dictionary
            _widgets = widgets.ToDictionary(o => o.Identifyer, o => o);

            // Set controller for each assigned widget
            foreach (QLWidget w in _widgets.Values)
                w.SetController(this);
        }

        /// <summary>
        /// Handles QL-language input
        /// </summary>
        /// <param name="rawQL">Raw QL-language string</param>
        public virtual void HandleQL(string rawQL)
        {
            FormNode node = QLParserHelper.Parse(rawQL);
            if (Analyser.Analyse(node))
            {
                ShowError(Analyser.GetErrors().ToArray());
                return;
            }
        }

        /// <summary>
        /// Subscribe Widget to updates of the (targetID) Widget
        /// </summary>
        /// <param name="targetID">Widgets' id that initiates updates</param>
        /// <param name="widget">Widget to receive updates</param>
        public void ReceiveUpdates(string targetID, QLWidget widget)
        {
            // Create value in dictonary if it does not exist
            if (!_notifyOnChange.ContainsKey(targetID))
                _notifyOnChange.Add(targetID, new List<QLWidget>());

            // Add value to targetID
            if (!_notifyOnChange[targetID].Contains(widget))
                _notifyOnChange[targetID].Add(widget);
        }

        /// <summary>
        /// Start notifying subscribed that the value of the widget has changed
        /// </summary>
        /// <param name="widgetID">ID of the changed widgets' value</param>
        public void ValueUpdate(string widgetID)
        {
            if (_notifyOnChange.ContainsKey(widgetID))
                foreach (QLWidget w in _notifyOnChange[widgetID])
                    w.ReceiveUpdate(widgetID);
        }

        /// <summary>
        /// Get Widget by ID
        /// </summary>
        /// <param name="widgetID">ID of the widget</param>
        /// <returns>Widget associated with the given ID</returns>
        public QLWidget GetWidget(string widgetID)
        {
            return _widgets[widgetID];
        }
    }
}
