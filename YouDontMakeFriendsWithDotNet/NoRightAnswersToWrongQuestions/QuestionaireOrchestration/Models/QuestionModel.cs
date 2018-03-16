﻿using System;

namespace QuestionaireOrchestration.Models
{
    public class QuestionModel
    {
        public QuestionModel(
            Guid questionOutputId, 
            Guid questionVariableId,
            string questionText, 
            bool visible, 
            bool readOnly, 
            Type questionType)
        {
            QuestionVariableId = questionVariableId;
            QuestionOutputId = questionOutputId;
            QuestionText = questionText;
            Visible = visible;
            ReadOnly = readOnly;
            QuestionType = questionType;
        }

        public Guid QuestionOutputId { get; }
        public Guid QuestionVariableId { get; }
        public string QuestionText { get; }
        public bool Visible { get; }
        public bool ReadOnly { get; }
        public string Value { get; set; }
        public Type QuestionType { get; }
    }
}