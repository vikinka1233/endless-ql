/*
 * generated by Xtext 2.12.0
 */
package org.uva.sc.pc.qls


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class QSLangStandaloneSetup extends QSLangStandaloneSetupGenerated {

	def static void doSetup() {
		new QSLangStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
