form Box1HouseOwning {
       a: "Did you sell a  house in 2010?" boolean
       b: "Did you buy a house in 2010?" boolean
       c: "Did you enter a loan for maintenance/reconstruction?" boolean
       if (true && true) {
           d: "Price the house was sold for:" money
           e: "Private debts for the sold house:" money
           f: "Value residue:" money (d - 50.0)
       }
   }