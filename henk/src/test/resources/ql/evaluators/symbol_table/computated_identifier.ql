form taxOfficeExample {
  "Did you sell a house in 2010?"
    hasSoldHouse: boolean


    if(!hasSoldHouse) {
      "Did you sell a house in 2010?"
        hasSoldSecondHouse: boolean
    }
}
