package Lotto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Input Scanner
        Scanner keyboard = new Scanner(System.in);
        int maxValue;
        int numberValues;
        boolean ticketMatch = false;
        int ticketCount = 0;

        //Prompt for the maximum value of a lottery number
        String promptMaxNumber = "Enter the max value of a lottery number between 1 and 100: ";
        String errorPromptMaxNumber = "Error! Out of range. Please enter an integer between 1 and 100: ";
        //Prompt for the number of lottery values
        String promptNumberLotteryValues = "Enter the number of values for the lotto between 3 and 10: ";
        String errorPromptNumberLotteryValues = "Error! Out of range. Please enter values between 3 and 10: ";

        //Get max value from user
        maxValue = getValidMaxNumber(keyboard, promptMaxNumber,errorPromptMaxNumber);
        //Get number of lottery values from user
        numberValues = getNumberLotteryValues(keyboard,promptNumberLotteryValues,errorPromptNumberLotteryValues);
        //Create a lotto ticket object
        LottoTicket myTicket = new LottoTicket(numberValues,maxValue);

        LottoTicket testTicket;
        //Print - for testing
    //    myTicket.printLottoArray();

        //While ticketMatch is false
        while(!ticketMatch)
        {
            //Increment ticket try
            ticketCount = ticketCount + 1;
            //Create a new ticket
            testTicket = new LottoTicket(numberValues,maxValue);
            //Check if equal
            ticketMatch = myTicket.isWinner(testTicket);
        }
        System.out.println("You need to purchase approximately: "+ticketCount+" tickets to get a winner.");


    }//End Main Method

    //METHODS
    public static int getValidMaxNumber(Scanner sc, String prompt,String errorPrompt) {
        int value = 0;
        boolean isValid = false;

        while (!isValid) {
            //Print out the prompt
            System.out.print(prompt);
            //If it is an integer?
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                //Make sure max value is in range
                if(value >= 1 && value <= 100){
                    isValid = true;
                }
                else{
                    System.out.println(errorPrompt);
                }
            } else {
                System.out.println("Error! That is not an integer. Try again.");
                isValid = false;
            }
            sc.nextLine();
        }
        return value;
    }

    public static int getNumberLotteryValues(Scanner sc, String prompt,String errorPrompt) {
        int value = 0;
        boolean isValid = false;

        while (!isValid) {
            //Print out the prompt
            System.out.print(prompt);
            //If it is an integer?
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                //Make sure max value is in range
                if(value >= 3 && value <= 10){
                    isValid = true;
                }
                else{
                    System.out.println(errorPrompt);
                    isValid = false;
                }
            } else {
                System.out.println("Error! That is not an integer. Try again.");
            }
            sc.nextLine();
        }
        return value;
    }

}//End Main Class


