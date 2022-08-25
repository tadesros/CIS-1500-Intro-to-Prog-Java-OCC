package com.example.adventure_game;

public class Player {
    //**Class Attributes**
    //Hit Points
    private int hitPoints;
    //Strength
    private int strength;
    //Dexterity
    private int dexterity;
    //Intelligence
    private int intelligence;
    //Total Gold
    private int totalGold;
    //Player Constructor
    public Player() {
        //Value of hit points at start
        setHitPoints(20);
        //Set gold to zero
        setTotalGold(0);
        //Calculate and set Strength
        setStrength(rollSixSidedDieThreeTimes());
        //Calculate and set Dexterity
        setDexterity(rollSixSidedDieThreeTimes());
        //Calculate and set Intelligence
        setIntelligence(rollSixSidedDieThreeTimes());
    }//end Constructor
    /* Setters */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public void setTotalGold(int totalGold) {
        this.totalGold = totalGold;
    }
    public void addToTotalGold(int goldToAdd){
        this.totalGold += goldToAdd;
    }
    //This value set only once
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    //Getters
    public int getHitPoints() {
        return hitPoints;
    }
    public int getStrength() {
        return strength;
    }
    public int getDexterity() {
        return dexterity;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public int getTotalGold() {
        return totalGold;
    }
    /*Supporting Functions*/
    //Roll a six sided die three times add all three
    public int rollSixSidedDieThreeTimes()
    {
        //Total for turn
        int totalForTurn = 0;

        // Get random number three times
        for(int i = 0; i < 3; i++) {
            totalForTurn =  totalForTurn + rollSixSidedDie();
        }
        return totalForTurn;
    }
    //Roll a six sided die
    public int rollSixSidedDie()
    {
        return getRandomNumber(1,6);
    }
    //Get Random Number
    public int getRandomNumber(int min, int max) {
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
} //end player class
