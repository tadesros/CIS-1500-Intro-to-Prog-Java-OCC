# JavaTemplate

Please submit the URL to your repository AND a self assessment using the rubric

Please create a java program that allows the user to create a fake lottery game and see how many tickets they need to buy to get a jackpot.

Ask the user to enter the total # of numbers that will be used in the ticket, ensure the value is between 3 and 10

Ask the user to enter the max value for the numbers in the ticket, ensure it is less than 100

Create a class for LottoTicket that has an arrayList of integers for the numbers.

Add a constructor that accepts values for numberOfValues and maxValue

Add the numberOfValues of random numbers 1 to maxValue ( including max value ) to the arraylist of integers

add a method isWinner that accepts an instance of LottoTicket ( not the values themselves, but another instance of the LottoTicket class ), and return true if all of the values in the ticket match all of the numbers in the array list of values ( remember, don't just compare the two arrays with == to see if they match, that won't work ).
