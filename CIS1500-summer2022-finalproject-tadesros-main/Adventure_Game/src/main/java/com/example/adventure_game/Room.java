package com.example.adventure_game;

public class Room {
    private int col;
    private int row;
    //Min amount of gold
    private int minRandomRange;
    //Max random of gold
    private int maxRandomRange;
    //Monster present? 1=true or 0=false
    private int monsterInRoom;
    //Is the room blocked? 1=true or 0=false
    private int isBlocked;
    //Gold amount
    private int goldInRoom;
    //Monster
    private Monster monster;
    //Room: Constructor
    //Need to supply is blocked 1 = true or 0 = false
    public Room(int isBlocked, int row, int col) {
        //Value of hit points at start
         minRandomRange = 1;
         maxRandomRange = 50;
        //Set hit points
        setMonsterInRoom(getRandomNumber(0,1));
        //Set gold in Room
        setGoldInRoom(getRandomNumber(minRandomRange,maxRandomRange));
        this.isBlocked = isBlocked;
        setCol(col);
        setRow(row);
        //Create value of Monster
        //If Monster is in the room = 1 and not blocked = 0
        //Then create a monster
        if((this.monsterInRoom == 1) && (this.isBlocked == 0)){
            monster = new Monster();
        }
        else {
            monster = null;
        }
    }//end constructor
    //Setters
    public void setGoldInRoom(int goldInRoom) {
        this.goldInRoom = goldInRoom;
    }
    public void setMinRandomRange(int minRandomRange) {
        this.minRandomRange = minRandomRange;
    }
    public void setMaxRandomRange(int maxRandomRange) {
        this.maxRandomRange = maxRandomRange;
    }
    public void setMonsterInRoom(int monsterInRoom) {
        this.monsterInRoom = monsterInRoom;
    }
    public void setIsBlocked(int isBlocked) {
        this.isBlocked = isBlocked;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }
    //Getters
    public int getMonsterInRoom() {
        return monsterInRoom;
    }
    public int getIsBlocked() {
        return isBlocked;
    }
    public int getGoldInRoom() {
        return goldInRoom;
    }
    public Monster getMonster() {
        return monster;
    }
    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    //Supporting Functions
    public int getRandomNumber(int min, int max) {
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
    //Create a new monster in the room - replace current
    public void createNewMonsterInRoom()
    {
        monster = new Monster();
    }
}
