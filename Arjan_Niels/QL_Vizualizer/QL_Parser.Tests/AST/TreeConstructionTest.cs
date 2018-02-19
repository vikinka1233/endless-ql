﻿using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL_Parser.AST.Nodes;
using System;

namespace QL_Parser.Tests.AST
{
    [TestClass]
    public class TreeConstructionTest
    {
        public Node AST { get; set; }

        [TestInitialize]
        public void Initialize()
        {
            AST = new FormNode("TestForm");
            var firstQuestion = new QuestionNode("Q1", "Do you like puppies?", QuestionType.BOOLEAN);
            var secondQuestion = new QuestionNode("Q2", "Do you like kittens?", QuestionType.BOOLEAN);

            AST.AddNode(firstQuestion);
            AST.AddNode(secondQuestion);
        }

        [TestMethod]
        public void RootIsFormTest()
        {
            Assert.AreEqual(NodeType.FORM, AST.Type);
        }

        [TestMethod]
        public void FormNameTest()
        {
            var formNode = AST as FormNode;
            Assert.AreEqual("TestForm", formNode.FormName);
        }

        [TestMethod]
        public void AddNodeTest()
        {
            Assert.AreEqual(2, AST.Children.Count);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentNullException))]
        public void AddNullNodeTest()
        {
            AST.AddNode(null);
        }
    }
}