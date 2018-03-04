package org.uva.jomi.ql.interpreter;

public interface GenericValue {
	// Addition.
	GenericValue add(GenericValue rightHandSideValue);
	GenericValue add(IntegerValue leftHandSideValue);
	GenericValue add(StringValue leftHandSideValue);
	GenericValue add(BooleanValue leftHandSideValue);
	
	// Subtraction.
	GenericValue subtract(GenericValue rightHandSideValue);
	GenericValue subtract(IntegerValue leftHandSideValue);
	GenericValue subtract(StringValue leftHandSideValue);
	GenericValue subtract(BooleanValue leftHandSideValue);
	
	// Multiplication.
	GenericValue multiply(GenericValue rightHandSideValue);
	GenericValue multiply(IntegerValue leftHandSideValue);
	GenericValue multiply(StringValue leftHandSideValue);
	GenericValue multiply(BooleanValue leftHandSideValue);
	
	// Division.
	GenericValue divide(GenericValue rightHandSideValue);
	GenericValue divide(IntegerValue leftHandSideValue);
	GenericValue divide(StringValue leftHandSideValue);
	GenericValue divide(BooleanValue leftHandSideValue);
	
	// And operation.
	GenericValue and(GenericValue rightHandSideValue);
	GenericValue and(IntegerValue leftHandSideValue);
	GenericValue and(StringValue leftHandSideValue);
	GenericValue and(BooleanValue leftHandSideValue);
	
	default public void additionError(Class<?> left, Class<?> right) {
		error(left, right, "add");
	}
	
	default public void subtractionError(Class<?> left, Class<?> right) {
		error(left, right, "subtract");
	}
	
	default public void multiplicationError(Class<?> left, Class<?> right) {
		error(left, right, "multiply");
	}
	
	default public void  divisionError(Class<?> left, Class<?> right) {
		error(left, right, "divide");
	}
	
	default public void  andOperationError(Class<?> left, Class<?> right) {
		error(left, right, "peform an And operation using");
	}
	
	default public void error(Class<?> left, Class<?> right, String type) {
		String error = String.format("RuntimeError: Cannot %s a %s and a %s", type, left.getSimpleName(), right.getSimpleName());
		System.err.println(error);
		throw new RuntimeException(error);
	}
}
