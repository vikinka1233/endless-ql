/*
 * generated by Xtext 2.12.0
 */
package org.uva.sc.pc.ql.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.uva.sc.pc.ql.qLang.Form
import org.uva.sc.pc.ql.qLang.QLangPackage
import org.uva.sc.pc.ql.qLang.util.TypeUtil
import org.uva.sc.pc.ql.validation.QLangExpressionValidator

@RunWith(XtextRunner)
@InjectWith(QLangInjectorProvider)
class QLangExpressionValidatorTests {

	@Inject
	ParseHelper<Form> parseHelper

	@Inject
	ValidationTestHelper validationTestHelper;

	@Test
	def void testBooleanVariableValidityInExpression() {
		assertVariableInExpressionHelper(TypeUtil.OP_EQUALS, TypeUtil.TYPE_BOOLEAN)
		assertVariableInExpressionHelper(TypeUtil.OP_NOT_EQUALS, TypeUtil.TYPE_BOOLEAN)
		assertVariableInExpressionHelper(TypeUtil.OP_SMALLER_THAN, TypeUtil.TYPE_BOOLEAN)
		assertVariableInExpressionHelper(TypeUtil.OP_SMALLER_THAN_EQUALS, TypeUtil.TYPE_BOOLEAN)
		assertVariableInExpressionHelper(TypeUtil.OP_GREATER_THAN, TypeUtil.TYPE_BOOLEAN)
		assertVariableInExpressionHelper(TypeUtil.OP_GREATER_THAN_EUQALS, TypeUtil.TYPE_BOOLEAN)
		assertVariableInExpressionHelper(TypeUtil.OP_PLUS, TypeUtil.TYPE_BOOLEAN)
		assertVariableInExpressionHelper(TypeUtil.OP_MINUS, TypeUtil.TYPE_BOOLEAN)
		assertVariableInExpressionHelper(TypeUtil.OP_MUL, TypeUtil.TYPE_BOOLEAN)
		assertVariableInExpressionHelper(TypeUtil.OP_DIV, TypeUtil.TYPE_BOOLEAN)
	}

	@Test
	def void testStringVariableValidityInExpression() {
		assertVariableInExpressionHelper(TypeUtil.OP_OR, TypeUtil.TYPE_STRING)
		assertVariableInExpressionHelper(TypeUtil.OP_AND, TypeUtil.TYPE_STRING)
		assertVariableInExpressionHelper(TypeUtil.OP_SMALLER_THAN, TypeUtil.TYPE_STRING)
		assertVariableInExpressionHelper(TypeUtil.OP_SMALLER_THAN_EQUALS, TypeUtil.TYPE_STRING)
		assertVariableInExpressionHelper(TypeUtil.OP_GREATER_THAN, TypeUtil.TYPE_STRING)
		assertVariableInExpressionHelper(TypeUtil.OP_GREATER_THAN_EUQALS, TypeUtil.TYPE_STRING)
		assertVariableInExpressionHelper(TypeUtil.OP_MINUS, TypeUtil.TYPE_STRING)
		assertVariableInExpressionHelper(TypeUtil.OP_MUL, TypeUtil.TYPE_STRING)
		assertVariableInExpressionHelper(TypeUtil.OP_DIV, TypeUtil.TYPE_STRING)
		assertVariableInExpressionHelper(TypeUtil.OP_NOT, TypeUtil.TYPE_STRING)
	}
	
	@Test
	def void testIntegerVariableValidityInExpression() {
		assertVariableInExpressionHelper(TypeUtil.OP_OR, TypeUtil.TYPE_INTEGER)
		assertVariableInExpressionHelper(TypeUtil.OP_AND, TypeUtil.TYPE_INTEGER)
		assertVariableInExpressionHelper(TypeUtil.OP_EQUALS, TypeUtil.TYPE_INTEGER)
		assertVariableInExpressionHelper(TypeUtil.OP_NOT_EQUALS, TypeUtil.TYPE_INTEGER)
		assertVariableInExpressionHelper(TypeUtil.OP_NOT, TypeUtil.TYPE_INTEGER)
	}
	
	@Test
	def void testDecimalVariableValidityInExpression() {
		assertVariableInExpressionHelper(TypeUtil.OP_OR, TypeUtil.TYPE_DECIMAL)
		assertVariableInExpressionHelper(TypeUtil.OP_AND, TypeUtil.TYPE_DECIMAL)
		assertVariableInExpressionHelper(TypeUtil.OP_EQUALS, TypeUtil.TYPE_DECIMAL)
		assertVariableInExpressionHelper(TypeUtil.OP_NOT_EQUALS, TypeUtil.TYPE_DECIMAL)
		assertVariableInExpressionHelper(TypeUtil.OP_NOT, TypeUtil.TYPE_DECIMAL)
	}
	
	@Test
	def void testMoneyVariableValidityInExpression() {
		assertVariableInExpressionHelper(TypeUtil.OP_OR, TypeUtil.TYPE_MONEY)
		assertVariableInExpressionHelper(TypeUtil.OP_AND, TypeUtil.TYPE_MONEY)
		assertVariableInExpressionHelper(TypeUtil.OP_EQUALS, TypeUtil.TYPE_MONEY)
		assertVariableInExpressionHelper(TypeUtil.OP_NOT_EQUALS, TypeUtil.TYPE_MONEY)
		assertVariableInExpressionHelper(TypeUtil.OP_NOT, TypeUtil.TYPE_MONEY)
	}
	
	@Test
	def void testDateVariableValidityInExpression() {
		assertVariableInExpressionHelper(TypeUtil.OP_OR, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_AND, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_EQUALS, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_NOT_EQUALS, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_SMALLER_THAN, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_SMALLER_THAN_EQUALS, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_GREATER_THAN, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_GREATER_THAN_EUQALS, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_PLUS, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_MINUS, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_MUL, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_DIV, TypeUtil.TYPE_DATE)
		assertVariableInExpressionHelper(TypeUtil.OP_NOT, TypeUtil.TYPE_DATE)
	}

	def assertVariableInExpressionHelper(String op, String type) {
		val result = parseHelper.parse('''
			form TestForm{
							q1: "Do you have a pet?" «type»
							q2: "Do you have a house?" «type»
							q3: "Computed" «type» = («IF op != "!"»q1«ENDIF» «op» q2)
						}
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		switch op {
			case TypeUtil.OP_OR:
				validationTestHelper.assertError(result, QLangPackage.eINSTANCE.expressionOr,
					QLangExpressionValidator.TYPE_NOT_ALLOWED)
			case TypeUtil.OP_AND:
				validationTestHelper.assertError(result, QLangPackage.eINSTANCE.expressionAnd,
					QLangExpressionValidator.TYPE_NOT_ALLOWED)
			case TypeUtil.OP_EQUALS,
			case TypeUtil.OP_NOT_EQUALS:
				validationTestHelper.assertError(result, QLangPackage.eINSTANCE.expressionEquality,
					QLangExpressionValidator.TYPE_NOT_ALLOWED)
			case TypeUtil.OP_SMALLER_THAN,
			case TypeUtil.OP_SMALLER_THAN_EQUALS,
			case TypeUtil.OP_GREATER_THAN,
			case TypeUtil.OP_GREATER_THAN_EUQALS:
				validationTestHelper.assertError(result, QLangPackage.eINSTANCE.expressionComparison,
					QLangExpressionValidator.TYPE_NOT_ALLOWED)
			case TypeUtil.OP_PLUS,
			case TypeUtil.OP_MINUS:
				validationTestHelper.assertError(result, QLangPackage.eINSTANCE.expressionPlusOrMinus,
					QLangExpressionValidator.TYPE_NOT_ALLOWED)
			case TypeUtil.OP_MUL,
			case TypeUtil.OP_DIV:
				validationTestHelper.assertError(result, QLangPackage.eINSTANCE.expressionMulOrDiv,
					QLangExpressionValidator.TYPE_NOT_ALLOWED)
			case TypeUtil.OP_NOT:
				validationTestHelper.assertError(result, QLangPackage.eINSTANCE.expressionNot,
					QLangExpressionValidator.TYPE_NOT_ALLOWED)
		}
	}

}
