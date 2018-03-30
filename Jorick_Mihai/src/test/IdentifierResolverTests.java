package test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.uva.jomi.ql.ast.analysis.IdentifierResolver;
import org.uva.jomi.ql.ast.statements.Statement;
import org.uva.jomi.ql.tests.utilities.TestUtilities;

public class IdentifierResolverTests {

	IdentifierResolver identifierResolver = new IdentifierResolver(true);

//	String undeclaredQuestionName1 =
//			"form Form1 {\n"
//			+ "\"question1\" q1: boolean q2\n"
//			+ "}";
//
//	@Test
//	public void undeclaredQuestionName1() throws Exception {
//		List<Stmt> ast = TestUtilities.buildAst(undeclaredQuestionName1);
//		identifierResolver.resolve(ast);
//		assertTrue(identifierResolver.getNumberOfErrors() == 1);
//		assertTrue(identifierResolver.
//				getErrorAtIndex(0).equals("[IdentifierResolver] line: 2, column: 24: Undeclared identifier: q2"));
//	}
//
//	String undefinedQuestionName2 =
//			"form Form1 {\n"
//			+ "\"question1\" q1: boolean\n"
//			+ "if (q2) {}\n"
//			+ "}";
//
//	@Test
//	public void undeclaredQuestionName2() throws Exception {
//		List<Stmt> ast = TestUtilities.buildAst(undefinedQuestionName2);
//		identifierResolver.resolve(ast);
//		assertTrue(identifierResolver.getNumberOfErrors() == 1);
//		assertTrue(identifierResolver.
//				getErrorAtIndex(0).equals("[IdentifierResolver] line: 3, column: 4: Undeclared identifier: q2"));
//	}
//
//	String readOnlyQuestionName1 =
//			"form Form1 {\n"
//			+ "\"question1\" q1: boolean\n"
//			+ "if (q1) {\n"
//			+ "\"question2\" q1: boolean q1\n"
//			+ "}\n"
//			+ "}";
//
//	@Test
//	public void readOnlyQuestionName1() throws Exception {
//		List<Stmt> ast = TestUtilities.buildAst(readOnlyQuestionName1);
//		identifierResolver.resolve(ast);
//		assertTrue(identifierResolver.getNumberOfErrors() == 0);
//	}
//
//	String readOnlyQuestionName2 =
//			"form Form1 {\n"
//			+ "\"question1\" q1: boolean\n"
//			+ "\"question1\" q1: boolean\n"
//			+ "}";
//
//	@Test
//	public void readOnlyQuestionName2() throws Exception {
//		List<Stmt> ast = TestUtilities.buildAst(readOnlyQuestionName2);
//		identifierResolver.resolve(ast);
//		assertTrue(identifierResolver.getNumberOfErrors() == 1);
//		assertTrue(identifierResolver.
//				getErrorAtIndex(0).equals("[IdentifierResolver] line: 3, column: 12: Read-only identifier already declared the current scope: q1"));
//	}
//
//	String readOnlyQuestionName3 =
//			"form Form1 {\n"
//			+ "if (true) {\n"
//			+ "\"question1\" q1: boolean\n"
//			+ "\"question1\" q1: boolean\n"
//			+ "}\n"
//			+ "}";
//
//	@Test
//	public void readOnlyQuestionName3() throws Exception {
//		List<Stmt> ast = TestUtilities.buildAst(readOnlyQuestionName3);
//		identifierResolver.resolve(ast);
//		assertTrue(identifierResolver.getNumberOfErrors() == 1);
//		assertTrue(identifierResolver.
//				getErrorAtIndex(0).equals("[IdentifierResolver] line: 4, column: 12: Read-only identifier already declared the current scope: q1"));
//	}
//
//	String readOnlyQuestionName4 =
//			"form Form1 {\n"
//			+ "if (true) {\n"
//			+ "} else {"
//			+ "\"question1\" q1: boolean\n"
//			+ "\"question1\" q1: boolean\n"
//			+ "}\n"
//			+ "}";
//
//	@Test
//	public void readOnlyQuestionName4() throws Exception {
//		List<Stmt> ast = TestUtilities.buildAst(readOnlyQuestionName4);
//		identifierResolver.resolve(ast);
//		assertTrue(identifierResolver.getNumberOfErrors() == 1);
//		assertTrue(identifierResolver.
//				getErrorAtIndex(0).equals("[IdentifierResolver] line: 4, column: 12: Read-only identifier already declared the current scope: q1"));
//	}
//
//	String cyclicDependencyTest	 =
//			"form Form1 {\n"
//			+ "if (x) {\n"
//			+ "\"y?\" x: boolean\n"
//			+ "}\n"
//
//			+ "if (y) {\n"
//			+ "\"x?\" y: boolean\n"
//			+ "}\n"
//			+ "}";
//
//	@Test
//	public void cyclicDependencyTest() throws Exception {
//		List<Stmt> ast = TestUtilities.buildAst(cyclicDependencyTest);
//		identifierResolver.resolve(ast);
//		assertTrue(identifierResolver.getNumberOfErrors() == 2);
//		assertTrue(identifierResolver.
//				getErrorAtIndex(0).equals("[IdentifierResolver] line: 2, column: 4: Undeclared identifier: x"));
//		assertTrue(identifierResolver.
//				getErrorAtIndex(1).equals("[IdentifierResolver] line: 5, column: 4: Undeclared identifier: y"));
//	}

//	String sameNameDifferentTypeTest1 =
//			"form Form1 {\n"
//			+ "\"question1\" q1: boolean\n"
//			+ "\"question1\" q1: integer\n"
//			+ "}";
//
//	@Test
//	public void sameNameDifferentTypeTest1() throws Exception {
//		List<Stmt> ast = TestUtilities.buildAst(sameNameDifferentTypeTest1);
//		identifierResolver.resolve(ast);
//		assertTrue(identifierResolver.getNumberOfErrors() == 1);
//		assertTrue(identifierResolver.
//				getErrorAtIndex(0).equals("[IdentifierResolver] line: 3, column: 12: Read-only identifier already declared the current scope: q1"));
//	}

//	String sameNameDifferentTypeTest2 =
//			"form Form1 {\n"
//			+ "\"question1\" q1: boolean\n"
//			+ "if (q1) {\n"
//			+ "\"question1\" q1: string\n"
//			+ "}\n"
//			+ "}";
//
//	@Test
//	public void sameNameDifferentTypeTest2() throws Exception {
//		List<Stmt> ast = TestUtilities.buildAst(sameNameDifferentTypeTest2);
//		identifierResolver.resolve(ast);
//		assertTrue(identifierResolver.getNumberOfErrors() == 1);
//		assertTrue(identifierResolver.
//				getErrorAtIndex(0).equals("[IdentifierResolver] line: 4, column: 12: Read-only identifier (line: 2, column: 12) with a different type is declared in an outside scope: q1"));
//	}


//	String positiveTest1 =
//			"form Form1 {\n"
//			+ "\"question 1\" q1: integer 1"
//			+ "\"question 2\" q2: integer q1 + 1"
//			+ "if (true) {\n"
//			+ "\"question 3\" q3: integer q1 + q2"
//			+ "} else {\n"
//			+ "\"question 4\" q4: integer q1 - q2"
//			+ "}\n"
//			+ "}";
//
//	@Test
//	public void positiveTest1() throws Exception {
//		List<Stmt> ast = TestUtilities.buildAst(positiveTest1);
//		identifierResolver.resolve(ast);
//		assertTrue(identifierResolver.getNumberOfErrors() == 0);
//	}

	String positiveTest2 =
			"form Form1 {\n"
			+ "\"question1\" q1: boolean\n"
			+ "if (q1) {\n"
			+ "\"question1\" q1: boolean\n"
			+ "}\n"
			+ "}";

	@Test
	public void positiveTest2() throws Exception {
		List<Statement> ast = TestUtilities.buildAst(positiveTest2);
		identifierResolver.resolve(ast);
		assertTrue(identifierResolver.getNumberOfErrors() == 0);
	}

	String positiveTest3 =
			"form Form1 {\n"
			+ "\"question2\" q2: boolean = q1\n"
			+ "if (q1) {\n"
			+ "\"question3\" q3: boolean = q1\n"
			+ "}\n"
			+ "\"question1\" q1: boolean\n"
			+ "}";

	@Test
	public void positiveTest3() throws Exception {
		List<Statement> ast = TestUtilities.buildAst(positiveTest3);
		identifierResolver.resolve(ast);
		assertTrue(identifierResolver.getNumberOfErrors() == 0);
	}
}
