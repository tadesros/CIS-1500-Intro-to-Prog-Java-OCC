package com.example.adventure_game;
public class Game {
    //**Attributes**
    private int startingRow;
    private int startingCol;
    private int currentRow;
    private int currentCol;
    //Player object
    Player player;
    Monster currentMonster;
    //Maze object
    Maze gameMap;
    //State Variables possible actions
    private boolean canFight;
    private boolean canSearch;
    private boolean canSleep;
    private boolean canRun;
    //*Current Monster Attributes*
    private int curMonsterHitPoints;
    private int curMonsterStrength;
    private int curMonsterDexterity;
    private int curMonsterIntelligence;
    private boolean monsterInRoom;
    //*State Variable possible directions*
    private boolean canGoNorth;
    private boolean canGoSouth;
    private boolean canGoEast;
    private boolean canGoWest;

    String monsterEncounter = "\nYikes, a large unfriendly looking monster is lurking in the room!" +
            "\nI don't think he has seen you yet." +
            "\nYou can FIGHT the monster for a chance to search for loot" +
            " or RUNAWAY. If you runaway go quietly or else the monster may hear you.";
    String noMonsterEncounter = "\nPhew, no monster in this room. Looks like their may be something valuable in here! " +
            "\nChoose to SEARCH this room or you can" +
            " SLEEP to regain your health." +
            "\nWarning! If you SLEEP their is a chance a monster may find you.";

    String gameIntro = "      BAD ADVENTURE GAME\n" +
            "\nYou are at the entrance of what looks like a dark labyrinth." +
            "\nI have a feeling great adventures, gold and danger await you" +
            "\nChoose your path wisely.";

    String currentMessage;
    //Game Object Constructor
    public Game() {
        //Player
        player = new Player();
        //Maze
        gameMap = new Maze();
        //Monster
        currentMonster = new Monster();
        currentMonster = null;
        //Set starting location
        setStartingCol(1);
        setStartingRow(1);
        //Set current location
        setCurrentCol(getStartingCol());
        setCurrentRow(getStartingRow());
        //Set welcome info
        setCurrentMessage(gameIntro);
        //Set Possible moves
        setPossibleMoves();
        //Set monster in room to false
        setMonsterInRoom(false);
        //Set current monster values
        initializeCurrMonsterValues();
        //Initialize Action Stat
        initializeCurrActionValues();
    }//end constructor
    public void initializeCurrActionValues(){
        setCanSleep(false);
        setCanSearch(false);
        setCanRun(false);
        setCanFight(false);
    }
    //Methods/Functions
    public void initializeCurrMonsterValues()
    {
        setCurMonsterStrength(0);
        setCurMonsterDexterity(0);
        setCurMonsterHitPoints(0);
        setCurMonsterIntelligence(0);
    }
    //*Direction Functions*
    //Player Move North
    public boolean moveNorth()
    {
        //Message
        String gameMessage ="";
        gameMessage +="\n\nWalking North..";
        //Subtract a column to go North
        int newRow = getCurrentRow() - 1;
        //Is new location valid?
        //Yes
        if(checkUnblocked(newRow,getCurrentCol()))
        {
            //Update current location
            setCurrentRow(newRow);
            //Monster in room
            int monsterInRoom = gameMap.maze[newRow][getCurrentCol()].getMonsterInRoom();
            //Yes there is a monster in the room.
            if(monsterInRoom == 1)
            {
                gameMessage+= monsterEncounter;
                //Handle details of finding a monster in the room
                currentMonster =  gameMap.maze[getCurrentRow()][getCurrentCol()].getMonster();
                foundMonster();
            }
            //No Monster
            else{
                gameMessage = noMonsterEncounter;
                noMonster();
            }
            setCurrentMessage(gameMessage);
            return true;
        }
        //Blocked
        //No
        else
        {
            System.out.println("Blocked");
            return false;
        }
    }
    //Player Move South
    public boolean moveSouth()
    {
        //Message
        String gameMessage ="";
        gameMessage +="\n\nWalking South..";
        //Add a column to go South
        int newRow = getCurrentRow() + 1;
        //Is new location valid?
        //Yes
        if(checkUnblocked(newRow,getCurrentCol()))
        {
            //Update current location
            setCurrentRow(newRow);
            //Monster in room
            int monsterInRoom = gameMap.maze[newRow][getCurrentCol()].getMonsterInRoom();
            //Yes there is a monster in the room.
            if(monsterInRoom == 1)
            {
                gameMessage+= monsterEncounter;
                //Handle details of finding a monster in the room
                currentMonster =  gameMap.maze[getCurrentRow()][getCurrentCol()].getMonster();
                foundMonster();
            }
            //No Monster
            else{
               gameMessage+= noMonsterEncounter;
               //System.out.println(getCurrentMessage());
                noMonster();
            }
            setCurrentMessage(gameMessage);
            return true;
        }
        //Blocked
        //No
        else
        {
            System.out.println("Blocked");
            return false;
        }
    }
    //Player Move East
    public boolean moveEast()
    {
        //Message
        String gameMessage ="";
        gameMessage +="\n\nGoing East..";
        //Add a column to go east
        int newCol = getCurrentCol() + 1;
        //Is new location valid?
        //Yes
        if(checkUnblocked(getCurrentRow(),newCol))
        {
            //Update current location
            setCurrentCol(newCol);
            //Monster in room
            int monsterInRoom = gameMap.maze[getCurrentRow()][getCurrentCol()].getMonsterInRoom();
            //Yes there is a monster in the room.
            if(monsterInRoom == 1)
            {
                gameMessage+= monsterEncounter;
                //Handle details of finding a monster in the room
                currentMonster =  gameMap.maze[getCurrentRow()][getCurrentCol()].getMonster();
                foundMonster();
            }
            //No Monster
            else{
                gameMessage+= noMonsterEncounter;
                //System.out.println(getCurrentMessage());
                noMonster();
            }
            setCurrentMessage(gameMessage);
            return true;
        }
        //Blocked
        //No
        else
        {
            System.out.println("Blocked");
            return false;
        }
    }
    //Player Move West
    public boolean moveWest()
    {
        //Message
        String gameMessage ="";
        gameMessage +="\n\nWalking West..";
        //Add a column to go east
        int newCol = getCurrentCol() - 1;
        //Is new location valid?
        //Yes
        if(checkUnblocked(getCurrentRow(),newCol))
        {
            //Update current location
            setCurrentCol(newCol);
            //Monster in room
            int monsterInRoom = gameMap.maze[getCurrentRow()][getCurrentCol()].getMonsterInRoom();
            //Yes there is a monster in the room.
            if(monsterInRoom == 1)
            {
                gameMessage+= monsterEncounter;
                //Handle details of finding a monster in the room
                currentMonster =  gameMap.maze[getCurrentRow()][getCurrentCol()].getMonster();
                foundMonster();
            }
            //No Monster
            else{
                gameMessage+= noMonsterEncounter;
                //System.out.println(getCurrentMessage());
                noMonster();
            }
            setCurrentMessage(gameMessage);
            return true;
        }
        //Blocked
        //No
        else
        {
            System.out.println("Blocked");
            return false;
        }
    }
    //*Actions*
    //Search Room
    public void searchRoom(){
        //Message
        String searchMessage = "\n\nSearching..";
        //Roll a 20 sided die
        int searchResult = getRandomNumber(1, 20);

        searchMessage += "\nYou rolled "+searchResult+ " your intelligence is " + player.getIntelligence()+".";

        //Roll a 20 sided die less than out intelligence you found it
        if(player.getIntelligence() > searchResult){
            int goldInRoom = gameMap.maze[getCurrentRow()][getCurrentCol()].getGoldInRoom();
            player.addToTotalGold(goldInRoom);
            searchMessage += "\nAn old chest is in the corner. You open it slowly and find.. "+goldInRoom+" :) pieces of gold!\n" +
                    "You now have a total of "+player.getTotalGold()+" pieces of gold.";
        }
        //You did not find it
        else{
            searchMessage += "\nAn old chest is in the corner. You open it and find.. lot's of dust. :( better luck next time.\n";
        }
        //Turn off Search button
        setCanSearch(false);
        setCanSleep(false);
        //Get possible moves again
        setPossibleMoves();
        setCurrentMessage(searchMessage);
    }
    //Fight Monster
    public void fight(){
        //String to hold message
        String fightMessage = "\n\nSwinging your sword at the monster!";
        //Roll a 20 sided die
        int fightResult = getRandomNumber(1,20);
        //Int damage
        int hitDamage = player.getStrength() / 3;
        //Who gets a hit?
        if(fightResult >= currentMonster.getDexterity()){
            //New Monster hit points
            int updatedMonsterHitPoints = currentMonster.getHitPoints() - hitDamage;
            //Make sure monster hit points are not zero
            if(updatedMonsterHitPoints <= 0)
            {
                updatedMonsterHitPoints = 0;
            }
            setCurMonsterHitPoints(updatedMonsterHitPoints);
            currentMonster.setHitPoints(updatedMonsterHitPoints);
            //If Monster is alive?
            fightMessage += "\nYou rolled "+fightResult+
                    " the monster has "+currentMonster.getDexterity()+
                    " dexterity." +
                    "\nYou hit the monster, knocking him back." +
                    "The monster suffered "
                    + hitDamage+" damage it has "+currentMonster.getHitPoints() +" hit-point(s) left.";



            if(currentMonster.getHitPoints()==0){
                //Monster is dead
                //We hit
                fightMessage +="\nThe monster stumbles and falls to it's death."
                        +"\nYou can now SEARCH the room for valuables.";
                setCanSleep(false);
                setCanFight(false);
                setCanSearch(true);
                setCanRun(false);
                setNoMovement();
            }
            //Monster is not alive.
            else{
                fightMessage += "\nThe monster stumbled and got back up. Keep fighting!";

                setCanSleep(false);
                setCanFight(true);
                setCanSearch(false);
                setCanRun(false);
                //Set no movement
                setNoMovement();
            }
        }
        //Monster Hit
        else{
            //We miss
            fightMessage +="You rolled a "+fightResult+" and the monster has " + currentMonster.getDexterity() + " dexterity.\nYou missed and did no damage to the monster.";
        }
        setCurrentMessage(fightMessage);
    }
    //Monster Attack
    public void monsterAttack(){
        String monsterAttackMessage = "\n\nMonster Attacking!";
        //Roll a 20 sided die
        int fightResult = getRandomNumber(1,20);
        //Hit damage
        int hitDamage = currentMonster.getStrength() / 3;

        if (hitDamage <= 0)
        {
            hitDamage = 1;
        }
        //Check if Monster hits
        if(fightResult >= player.getDexterity()){
            //New Monster hit points
            int updatedPlayerHitPoints = player.getHitPoints() - hitDamage;

            if(updatedPlayerHitPoints <= 0)
            {
                updatedPlayerHitPoints = 0;
            }
            player.setHitPoints(updatedPlayerHitPoints);


            monsterAttackMessage += "\nThe monster rolled a "+fightResult+" and you have " + player.getDexterity() + " dexterity." +
                    "\nThe monster swung his large axe.";


            //If Monster is alive?
            if(player.getHitPoints()==0){
                //Player is dead
                //We hit
                monsterAttackMessage += "\nArrg! The axe hit you in the chest. Looks like this is it. Better luck next time." +
                        "\n     GAME OVER\n";
                setCanFight(false);
            }
            //Else Alive
            else{
                monsterAttackMessage += "You dodged and the axe hit you, however, it looks like it's just a flesh wound." +
                        "\nNow you want some revenge. Keep Fighting";

                setCanFight(true);
            }
            setNoMovement();
            setCanSleep(false);
            setCanSearch(false);
            setCanRun(false);
        }
        //Monster Missed
        else{
            //We miss
            monsterAttackMessage += "\nThe monster rolled a "+fightResult+" and you have " + player.getDexterity() + " dexterity." +
                    "\nThe monster swung his large axe, you ducked and he missed. You have no injuries.\n";
        }

        setCurrentMessage(monsterAttackMessage);
    }
    //Sleep
    //Return true if a monster attacks
    //Return false if no monster
    public boolean sleep()
    {
        String sleepMessage = "\n\nSleeping..";
        boolean monsterPresent;
        //Roll a 6 sided die
        int sleepResult = getRandomNumber(1,6);
       // System.out.println(sleepResult);
        //If you roll a 1 then monster finds you
        if(sleepResult == 1){
            //Show message
            sleepMessage += "\nOh no a Monster has found us sleeping!";
            //Create a new monster in the room
            gameMap.maze[getCurrentRow()][getCurrentCol()].createNewMonsterInRoom();
            //Set up monster
            currentMonster =  gameMap.maze[getCurrentRow()][getCurrentCol()].getMonster();
            // System.out.println(getCurrentMessage()+ " " + currentMonster.getIntelligence());
            //Set current Monster Stats
            setCurMonsterDexterity(currentMonster.getDexterity());
            setCurMonsterHitPoints(currentMonster.getHitPoints());
            setCurMonsterIntelligence(currentMonster.getIntelligence());
            setCurMonsterStrength(currentMonster.getStrength());
            //Set monster in room flag
            setMonsterInRoom(true);
            //Set actions can search can sleet
            setCanFight(true);
            setCanRun(true);
            setCanSearch(false);
            setCanSleep(false);
            //Set no movements
            setNoMovement();
            monsterPresent = true;
        }
        else //Didn't find you
        {   //Your hit points are restored
            player.setHitPoints(20);
            //Show message
            sleepMessage +="\nYou wake up feeling refreshed." +
                    "\nHit-points have been restored!";
            //Turn off Search button
            setCanSearch(false);
            setCanSleep(false);
            setCanRun(false);
            setCanFight(false);
            //Get possible moves again
            setPossibleMoves();

            monsterPresent = false;

        }
        setCurrentMessage(sleepMessage);

        return monsterPresent;
    }
    //Run Away
    //return true if monster sees you
    //else return false

    public boolean runAway(){
       /* - the monster gets to make 1 attack as we run away if it "sees" us,
           roll a 20 sided die, if it rolls < it's intelligence it saw us. ( go to the previous
        room, or random direction, or let them pick )*/
        String runAwayMessage = "\n\nRunning Away..";

        boolean monsterAlerted;
        //Roll a 20 sided die
        int rollResult = getRandomNumber(1,20);
        runAwayMessage +=  "\nYou rolled "+rollResult+" and the monster has "+currentMonster.getIntelligence()+" intelligence.";

        //Check if roll < monster intelligence
        if(rollResult < currentMonster.getIntelligence())
        {
            //The monster saw you running away.
            runAwayMessage += "\nOuch! You tripped as you started to run. The monster is alerted to your presence";
            monsterAlerted = true;
        }
        else/*Monster doesn't see us*/ {
            //The monster did not see you.
            runAwayMessage+="\nYou sneak away like a ninja. Now which way to go?";

            //Set directions
            setPossibleMoves();

            monsterAlerted = false;
        }

        //Set directions
        setPossibleMoves();

        setCanSleep(false);
        setCanRun(false);
        setCanFight(false);
        setCanSearch(false);
        setCurrentMessage(runAwayMessage);

        return monsterAlerted;
    }
    //**Getters**
    public int getCurrentRow() {
        return currentRow;
    }
    public int getCurrentCol() {
        return currentCol;
    }
    public int getStartingCol() {
        return startingCol;
    }
    public int getStartingRow() {
        return startingRow;
    }
    public boolean getCanGoNorth(){return canGoNorth;}
    public boolean getCanGoSouth(){return canGoSouth;}
    public boolean getCanGoWest(){return canGoWest;}
    public boolean getCanGoEast(){return canGoEast;}
    public String getCurrentMessage() {
        return currentMessage;
    }
    public int getCurMonsterStrength() {
        return curMonsterStrength;
    }
    public int getCurMonsterDexterity() {
        return curMonsterDexterity;
    }
    public int getCurMonsterIntelligence() {
        return curMonsterIntelligence;
    }
    public int getCurMonsterHitPoints() {
        return curMonsterHitPoints;
    }
    public boolean isCanGoNorth() {
        return canGoNorth;
    }
    public boolean isMonsterInRoom() {
        return monsterInRoom;
    }
    public boolean isCanGoWest() {
        return canGoWest;
    }
    public boolean isCanFight() {
        return canFight;
    }
    public boolean isCanSleep() {
        return canSleep;
    }
    public boolean isCanRun() {
        return canRun;
    }
    public boolean isCanSearch() {
        return canSearch;
    }
    public boolean isCanGoSouth() {
        return canGoSouth;
    }
    public boolean isCanGoEast() {
        return canGoEast;
    }
    //**Setters**/
    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }
    public void setStartingRow(int startingRow) {
        this.startingRow = startingRow;
    }
    public void setStartingCol(int startingCol) {
        this.startingCol = startingCol;
    }
    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }
    public void setCurrentMessage(String currentMessage) {
        this.currentMessage = currentMessage;
    }
    public void setPossibleMoves()
    {
          //Go North - subtract one from current row
          int northRow =  getCurrentRow() - 1;
          //Go South - add one to current row
          int southRow = getCurrentRow() + 1;
          //Go West - subtract one to current column
          int westCol = getCurrentCol() - 1;
          //Go East - add one to current column
          int eastCol = getCurrentCol() + 1;
        //Check north if blocked
        //not blocked
        setCanGoNorth(gameMap.maze[northRow][getCurrentCol()].getIsBlocked() != 1);
        //Check if South is blocked
        //not blocked
        setCanGoSouth(gameMap.maze[southRow][getCurrentCol()].getIsBlocked() != 1);
        //Check if East is blocked
        //not blocked
        setCanGoEast(gameMap.maze[getCurrentRow()][eastCol].getIsBlocked() != 1);
        //Check if West is blocked
        //not blocked
        setCanGoWest(gameMap.maze[getCurrentRow()][westCol].getIsBlocked() != 1);

        System.out.println("cur row:"+getCurrentRow());
        System.out.println("cur col:"+getCurrentCol());
        System.out.println("Can you go South: " + getCanGoSouth());
        System.out.println("Can you go North: " + getCanGoNorth());
        System.out.println("Can you go East: " + getCanGoEast());
        System.out.println("Can you go West: " + getCanGoWest());
    }
    public void setCanGoWest(boolean canGoWest) {
        this.canGoWest = canGoWest;
    }
    public void setCanGoNorth(boolean canGoNorth) {
        this.canGoNorth = canGoNorth;
    }
    public void setCanGoSouth(boolean canGoSouth) {
        this.canGoSouth = canGoSouth;
    }
    public void setCanGoEast(boolean canGoEast) {
        this.canGoEast = canGoEast;
    }
    public void setCurMonsterHitPoints(int curMonsterHitPoints) {
        this.curMonsterHitPoints = curMonsterHitPoints;
    }
    public void setCurMonsterStrength(int curMonsterStrength) {
        this.curMonsterStrength = curMonsterStrength;
    }
    public void setCurMonsterDexterity(int curMonsterDexterity) {
        this.curMonsterDexterity = curMonsterDexterity;
    }
    public void setCurMonsterIntelligence(int curMonsterIntelligence) {
        this.curMonsterIntelligence = curMonsterIntelligence;
    }
    public void setMonsterInRoom(boolean monsterInRoom) {
        this.monsterInRoom = monsterInRoom;
    }
    public void setCanFight(boolean canFight) {
        this.canFight = canFight;
    }
    public void setCanSearch(boolean canSearch) {
        this.canSearch = canSearch;
    }
    public void setCanSleep(boolean canSleep) {
        this.canSleep = canSleep;
    }
    public void setCanRun(boolean canRun) {
        this.canRun = canRun;
    }
    //**Supporting Functions**
    public int getRandomNumber(int min, int max) {
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
    public void setNoMovement()
    {
    setCanGoSouth(false);
    setCanGoNorth(false);
    setCanGoEast(false);
    setCanGoWest(false);
}
    public boolean checkUnblocked(int row, int column)
    {
        //not blocked
        return gameMap.maze[row][column].getIsBlocked() != 1;
    }
    public void updateCurrentMonsterStats()
    {
        //Set current Monster Stats
        setCurMonsterDexterity(currentMonster.getDexterity());
        setCurMonsterHitPoints(currentMonster.getHitPoints());
        setCurMonsterIntelligence(currentMonster.getIntelligence());
        setCurMonsterStrength(currentMonster.getStrength());
        //Set monster in room flag
        setMonsterInRoom(true);
        //Set actions can search can sleet
        setCanFight(true);
        setCanRun(true);
        setCanSearch(false);
        setCanSleep(false);
    }
    public void zeroMonsterStats()
    {
        //Set attributes of monster to zero
        setCurMonsterDexterity(0);
        setCurMonsterHitPoints(0);
        setCurMonsterIntelligence(0);
        setCurMonsterStrength(0);
    }
    public void foundMonster(){

        // System.out.println(getCurrentMessage()+ " " + currentMonster.getIntelligence());
        //Set current Monster Stats
        updateCurrentMonsterStats();
        //Set no movements
        setNoMovement();
    }
    public void noMonster(){
        //System.out.println(getCurrentMessage());
        //Set current monster to null
        setMonsterInRoom(false);
        //Set attributes of monster to zero
        setCurMonsterDexterity(0);
        setCurMonsterHitPoints(0);
        setCurMonsterIntelligence(0);
        setCurMonsterStrength(0);
        //Set actions can search can sleep
        setCanFight(false);
        setCanRun(false);
        setCanSearch(true);
        setCanSleep(true);
        //Reset possible moves
        setNoMovement();
    }
}
