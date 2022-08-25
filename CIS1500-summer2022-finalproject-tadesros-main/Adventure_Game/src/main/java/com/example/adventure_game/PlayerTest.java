package com.example.adventure_game;


import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @org.junit.jupiter.api.Test
    void testConstructorAndGets() {
        //AAA
        //Arrange - set up the variables we need to test
        int expectedHitPoints = 20;
        int expectedTotalGold = 0;

        //Act
        Player player = new Player();

        int actualHitPoints = player.getHitPoints();
        int actualGold = player.getTotalGold();
        int actualDext = player.getDexterity();
        int actualIntel = player.getIntelligence();
        int actualStrength = player.getStrength();

        //Assert
        assertEquals(expectedHitPoints,actualHitPoints);
        assertEquals(expectedTotalGold,actualGold);
    }


    @org.junit.jupiter.api.Test
    void setHitPoints() {
    }

    @org.junit.jupiter.api.Test
    void setTotalGold() {
    }

    @org.junit.jupiter.api.Test
    void setStrength() {
    }

    @org.junit.jupiter.api.Test
    void setDexterity() {
    }

    @org.junit.jupiter.api.Test
    void setIntelligence() {
    }
}