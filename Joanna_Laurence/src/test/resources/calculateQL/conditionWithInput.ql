//AssertDisplayedQuestions=2
form taxOfficeExample {
  "What was the selling price?"
    sellingPrice: decimal = 1.5

  "How many days did you wait?"
    waitDays: integer //THIS IS NOT SEEN

    if (sellingPrice * waitDays > 50) {
      "Did you wait to long?"
        waitedToLong1: boolean = true
    }

    if ((sellingPrice * waitDays) <= 50) {
      "Did you wait to long2?"
        waitedToLong2: boolean = false
    }
}