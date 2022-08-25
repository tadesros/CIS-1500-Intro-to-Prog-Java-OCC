package com.example.adventure_game;

public class Monster {
    //**Class Attributes**
    //Hit Points
    private int hitPoints;
    //Strength
    private int strength;
    //Dexterity
    private int dexterity;
    //Intelligence
    private int intelligence;
    //Random Value for stats
    private int minRandom = 1;
    private int maxRandom = 6;
    //Monster Constructor
    public Monster() {
        //Value of hit points at start
         int randomStatValue = getRandomNumber(1,6);
         //Calc. Strength, Dexterity and Intelligence
         int calculatedStates = randomStatValue * 2;
        //Set hit points
        setHitPoints(randomStatValue);
        //Calculate and set Strength
        setStrength(calculatedStates);
        //Calculate and set Dexterity
        setDexterity(calculatedStates);
        //Calculate and set Intelligence
        setIntelligence(calculatedStates);
    } //end constructor
    //Setters
    //This value will change
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    //These values will not change once set
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
    //Get Random Number
    public int getRandomNumber(int min, int max) {
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
}
