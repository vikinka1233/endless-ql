form ConditionQuestions {
	firstName: "What is your first name?" string
	age: "How old are you?" integer
	if (age > 10) {
		lastName: "What is your last name?" string
		canRead: "Can you read?" boolean
		salary: "What is your monthly salary?" money
	} else {
		lastName: "What is your last name of your parents?" string
	}
	dateOfBirth: "What is your date of birth?" date
}