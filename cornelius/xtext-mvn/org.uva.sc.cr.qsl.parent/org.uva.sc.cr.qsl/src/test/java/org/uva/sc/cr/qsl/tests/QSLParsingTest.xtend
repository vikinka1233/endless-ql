package org.uva.sc.cr.qsl.tests

import com.google.inject.Inject
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.uva.sc.cr.qsl.qSL.Model
import org.uva.sc.cr.qsl.qSL.QSLPackage

@RunWith(XtextRunner)
@InjectWith(QSLInjectorProvider)
class QSLParsingTest {

	@Inject
	ParseHelper<Model> parseHelper

	@Inject
	ValidationTestHelper validationTestHelper;

	@Test
	def void positiveTest() {
		val result = parseHelper.parse('''
			form taxOfficeExample { 
			  "Did you sell a house in 2010?" 
			    hasSoldHouse: boolean
			  "Did you buy a house in 2010?"
			    hasBoughtHouse: boolean
			  "Did you enter a loan?"
			    hasMaintLoan: boolean
			    
			  if (hasSoldHouse) {
			    "What was the selling price?"
			      sellingPrice: money
			    "Private debts for the sold house:"
			      privateDebt: money
			    "Value residue:"
			      valueResidue: money = 
			        (sellingPrice - privateDebt)
			  }
			  
			}
			
			stylesheet taxOfficeExample 
			  page Housing {
			    section "Buying"
			      question hasBoughtHouse  
			        widget checkbox 
			    section "Loaning"  
			      question hasMaintLoan
			  }
			
			  page Selling { 
			    section "Selling" {
			      question hasSoldHouse
			        widget radio("Yes", "No") 
			      section "You sold a house" {
			        question sellingPrice
			          widget spinbox
			        question privateDebt
			          widget spinbox 
			        question valueResidue
			        default money {
			          width: 400
			          font: "SansSerif" 
			          fontsize: 14
			          color: #A9f999
			          widget spinbox
			        }        
			      }
			    }
			    default boolean widget radio("Yes", "No")
			  }  
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource().errors.isEmpty())

		validationTestHelper.assertNoErrors(result)
	}

	@Test
	def void testErrorOnQuestionNotDefinedInForm() {
		val result = parseHelper.parse('''
			form taxOfficeExample { 
			  "Did you sell a house in 2010?" 
			    hasSoldHouse: boolean
			  "Did you buy a house in 2010?"
			    hasBoughtHouse: boolean
			  "Did you enter a loan?"
			    hasMaintLoan: boolean
			  
			}
			
			stylesheet taxOfficeExample 
			  page Housing {
			    section "Buying"
			      question hasBoughtHouse  
			        widget checkbox 
			    section "Loaning"  
			      question hasMaintLoan2
			  } 
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource().errors.isEmpty())

		validationTestHelper.assertError(result, QSLPackage.eINSTANCE.questionReference, Diagnostic.LINKING_DIAGNOSTIC)
	}

}
