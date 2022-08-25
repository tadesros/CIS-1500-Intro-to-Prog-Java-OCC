package project2;
import java.util.Scanner;
public class Project2 {
    public static void main(String[] args) {
        //Turn count
        int turnCount =0;
        //Player health
        int playerHealth = 2;
        //Move stored as a code
        int moveCode = 0;
        //Current player move
        String currentPlayerMove = "";
        //Hold whether the players move is valid
        boolean isPlayerMoveValid = false;
        //Display intro to the game
        displayGameMainMenu();
        //Show instructions
        displayGameInstructions();
        //Outside loop continues until the escape phrase is entered "SEE YOU LATER" = code is 3
        while(moveCode != 3) {
            //This loop will continue until user enters a valid game move other than help
                //Prompt for user move
                askForPlayerMove();
                //Get Player Move
                currentPlayerMove = getPlayerMove();
                //Validate Player Move or Help entered
                isPlayerMoveValid = checkForInvalidMoveOrHelp(currentPlayerMove);

                while(!isPlayerMoveValid){
                    //Show instructions
                    displayGameInstructions();
                    //Prompt for user move
                    askForPlayerMove();
                    //Get Player Move
                    currentPlayerMove = getPlayerMove();
                    //Validate Player Move or Help entered
                    isPlayerMoveValid = checkForInvalidMoveOrHelp(currentPlayerMove);
                }
            //Increment turn count
            turnCount = turnCount + 1;
            //Display Move Results return three codes
            // 1 - normal move
            // 2 - wounded
            // 3 - Game is over
            moveCode = displayMoveResults(currentPlayerMove, turnCount);
            //Check move code for wounded
            if (moveCode == 2) {
                //Reduce player health by one
                playerHealth = playerHealth - 1;
                //Check player health if forced to sleep
                if (playerHealth == 0) {
                    System.out.println("You have " + playerHealth + " health left. You need to sleep to recover.");
                    //Wait until user sleeps
                    waitForSleep();
                    //Reset playerHealth
                    playerHealth = 2;
                    //Your health is now recovered
                    System.out.println("You have recovered! You can now continue your quest with " + playerHealth + " full health.");
                } else {
                    //Display current health.
                    System.out.print("\nBe careful you only have " + playerHealth + " health left.\n");
                }
            }
        }
    }//end main method

    /*Method Declarations*/

    //Display to the user the introduction to the game.
    public static void displayGameMainMenu(){
        System.out.print(" *** WELCOME TO WORK ESCAPE ***\n" +
                "You are at your desk and it's 5 o'clock you need to escape work\n");
    }
    //Display game help
    public static void displayGameInstructions(){
        System.out.print("\nYour valid moves are (not case sensitive):\n" +
                "*  Movement  *                 *  ACTIONS  *      \n" +
                "1) GO OUT FRONT               1)  DRINK COFFEE \n" +
                "2) GO OUT BACK                2)  CHECK EMAIL\n" +
                "3) GO OUT FIRE ESCAPE         3)  LOOK OUTSIDE\n" +
                "4) GO OUT MYSTERY DOOR        4)  SHUT OFF LAPTOP\n");
    }
    //Prompt user for next move
    public static void askForPlayerMove(){
        System.out.println
                ("\nEnter a move (enter help to view choices): ");
    }
    //Get input from user for next move force it to uppercase
    public static String getPlayerMove(){
        //Declare scanner object for input
        Scanner keyboardInput = new Scanner(System.in);
        //Get user move and force to uppercase
        return  keyboardInput.nextLine().toUpperCase();
    }
    //RETURN TRUE IF THE MOVE IS VALID AND NOT HELP - FALSE OTHERWISE
    public static Boolean checkForInvalidMoveOrHelp(String playerMove)
    {
        if(playerMove.equalsIgnoreCase("SEE YOU LATER") || playerMove.equalsIgnoreCase("GO OUT FRONT")  ||  playerMove.equalsIgnoreCase("GO OUT BACK")  ||
                playerMove.equalsIgnoreCase("GO OUT FIRE ESCAPE")  || playerMove.equalsIgnoreCase("GO OUT MYSTERY DOOR")  || playerMove.equalsIgnoreCase("DRINK COFFEE")
                || playerMove.equalsIgnoreCase("CHECK EMAIL")  || playerMove.equalsIgnoreCase("LOOK OUTSIDE")  ||  playerMove.equalsIgnoreCase("SHUT OFF LAPTOP")  )
        {
            return true;
        }
        else {
            return false;
        }
    }
    //Display the Results of the Players Move
    public static Integer displayMoveResults(String currentMove, Integer turnCount)
    {
        System.out.print("\nTURN # "+turnCount);

        if (currentMove.equalsIgnoreCase("GO OUT FRONT"))
        {
            System.out.print("\nYIKES you run into your boss who tells you to finish some TPS reports before you go home. You are back at your desk.\n");
            return 1;
        }
        else if (currentMove.equalsIgnoreCase("GO OUT BACK"))
        {
            System.out.print("\nOh no! You forgot your badge to get out the door. You are back at your desk.\n");
            return 1;
        }
        else if (currentMove.equalsIgnoreCase("GO OUT FIRE ESCAPE"))
        {
            System.out.print("\nOh man! You set off the fire alarm. You return to your desk and pretend you didn't do it.\n");
            return 1;
        }
        else if (currentMove.equalsIgnoreCase("GO OUT MYSTERY DOOR"))
        {
            System.out.print("\nYou open a door you have never been in. Supply Closet. You grab some sticky notes and return to your desk.\n");
            return 1;
        }
        else if (currentMove.equalsIgnoreCase("DRINK COFFEE"))
        {
            System.out.print("\nArgg! Stale coffee you are wounded.\n");
            return 2;
        }
        else if (currentMove.equalsIgnoreCase("CHECK EMAIL"))
        {
            System.out.print("\nYou check your e-mail. Bad Move now you have to stay longer to respond.\n");
            return 1;
        }
        else if (currentMove.equalsIgnoreCase("LOOK OUTSIDE"))
        {
            System.out.print("\nYou look outside at the beautiful weather and realize how much you need to get outta here.\n");
            return 1;
        }
        else if (currentMove.equalsIgnoreCase("SHUT OFF LAPTOP"))
        {
            System.out.print("\nYou select shut down. Oh no! Windows Updates starting. You may have to spend the night.\n");
            return 1;
        }
        //ESCAPE WORD - See you later
        else{
            System.out.print("\nCongratulations your are free! You did it in # "+turnCount +" turns.");
            return 3;
        }

    }
    //Increment move count
    public static int incrementMoveCount(int currentCount, String currentMove)
    {
      int updatedMoveCount = currentCount;
      return updatedMoveCount;
    }
    //Wait for sleep
    public static void waitForSleep(){
        String userInput = "";

        do {
            //Enter sleep to continue
            System.out.print("\nYou are wounded. You need to sleep.\n");
            //Declare scanner object for input
            Scanner keyboardInput = new Scanner(System.in);
            //Get user move and force to uppercase
            userInput = keyboardInput.nextLine().toUpperCase();
        }while(!userInput.equalsIgnoreCase("SLEEP"));


    }
} //End Project2 class
