form taxOfficeExample {
  "Did you sell a house in 2010?"
    soldFirstHouse: boolean
  "Did you sell a house in 2011?"
    soldSecondHouse: money

  if (soldFirstHouse && (soldFirstHouse && soldSecondHouse)) {
    "What was the selling price?"
      sellingPrice: money
  }
}
