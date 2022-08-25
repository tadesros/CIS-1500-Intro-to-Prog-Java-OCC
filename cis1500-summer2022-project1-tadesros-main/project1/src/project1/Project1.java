package project1;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        //Declare a scanner object for getting user input
        Scanner keyboard = new Scanner(System.in);
        //Daily ml of kitten formula
        Double dailyFormula;
        //Daily wet food in grams
        Double dailyWetFood;
        //Welcome prompt
        System.out.println("** Welcome to the Kitten Food Calculator **");
        //Get user's name
        System.out.println("Please enter your name: ");
        String userName = keyboard.nextLine();
        //Get number of kitten's to feed (integer)
        System.out.println(userName + " how many kittens do you have?");
        Integer numKittens = Integer.parseInt(keyboard.nextLine());
        //Get kittens average age in weeks (integer)
        System.out.println(userName + " what is the average age of your kittens (weeks)?");
        Integer avgAge = Integer.parseInt(keyboard.nextLine());
        //Get average weight of kittens in grams (double)
        System.out.println(userName + " what is the average weight of your kittens (grams)?");
        Double avgWeight = Double.parseDouble(keyboard.nextLine());

        //*Calculate daily food Requirement based on average age*

        //From 1 to 4 weeks old
        if (avgAge < 5) {
            //Daily formula 5ml for every 100 grams
            dailyFormula = (avgWeight / 100) * 5;
            //No wet food
            dailyWetFood = 0.0;
        }
        //From 5 to 8 weeks old
        else if (avgAge <= 8) {
            //Daily formula fixed at 20ml
            dailyFormula = 20.0;
            //Wet food 10 grams of wet food for every 100 grams
            dailyWetFood = (avgWeight / 100.0) * 10;
        }
        //For 9 or more weeks old
        else {
            //No formula at this age.
            dailyFormula = 0.0;
            //Daily wet food set at 100 grams
            dailyWetFood = 100.0;
        }
        //Convert daily values to weekly times the number of kittens
        double weeklyFormula = dailyFormula * 7 * numKittens;
        double weeklyWetFood = dailyWetFood * 7 * numKittens;
        //Round the result to 2 decimal places
        double weeklyFormulaRound = Math.round(weeklyFormula*100)/100;
        double weeklyWetFoodRound = Math.round(weeklyWetFood*100)/100;
        //Display the results to the user
        System.out.println(userName + " your "+numKittens+" kittens require "+weeklyFormulaRound+" milliliters of formula for 1 week.");
        System.out.println(userName + " your "+numKittens+" kittens require "+weeklyWetFoodRound+" grams of wet food for 1 week.");
    }
}
