package com.example.adventure_game;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    //Maze Size - dimensions of grid
    private int mazeSize = 12;
    //Declare a 2 dimensional array of Rooms
    Room[][] maze;
    //Maze Constructor
    public Maze() {
        //Initialize maze object
        maze = new Room[getMazeSize()][getMazeSize()];
        //Initialize 1st Row
        maze[0][0] = new Room(1,0,0);
        maze[0][1] = new Room(1,0,1);
        maze[0][2] = new Room(1,0,2);
        maze[0][3] = new Room(1,0,3);
        maze[0][4] = new Room(1,0,4);
        maze[0][5] = new Room(1,0,5);
        maze[0][6] = new Room(1,0,6);
        maze[0][7] = new Room(1,0,7);
        maze[0][8] = new Room(1,0,8);
        maze[0][9] = new Room(1,0,9);
        maze[0][10] = new Room(1,0,10);
        maze[0][11] = new Room(1,0,11);
        //Initialize 2nd Row
        maze[1][0] = new Room(1,1,0);
        maze[1][1] = new Room(0,1,1);
        maze[1][2] = new Room(1,1,2);
        maze[1][3] = new Room(0,1,3);
        maze[1][4] = new Room(0,1,4);
        maze[1][5] = new Room(0,1,5);
        maze[1][6] = new Room(0,1,6);
        maze[1][7] = new Room(0,1,7);
        maze[1][8] = new Room(0,1,8);
        maze[1][9] = new Room(0,1,9);
        maze[1][10] = new Room(0,1,10);
        maze[1][11] = new Room(1,1,11);
        //Initialize 3rd Row
        maze[2][0] = new Room(1,2,0);
        maze[2][1] = new Room(0,2,1);
        maze[2][2] = new Room(1,2,2);
        maze[2][3] = new Room(0,2,3);
        maze[2][4] = new Room(0,2,4);
        maze[2][5] = new Room(0,2,5);
        maze[2][6] = new Room(0,2,6);
        maze[2][7] = new Room(0,2,7);
        maze[2][8] = new Room(0,2,8);
        maze[2][9] = new Room(0,2,9);
        maze[2][10] = new Room(0,2,10);
        maze[2][11] = new Room(1,2,11);
        //Initialize  4th
        maze[3][0] = new Room(1,3,0);
        maze[3][1] = new Room(0,3,1);
        maze[3][2] = new Room(1,3,2);
        maze[3][3] = new Room(0,3,3);
        maze[3][4] = new Room(0,3,4);
        maze[3][5] = new Room(0,3,5);
        maze[3][6] = new Room(0,3,6);
        maze[3][7] = new Room(0,3,7);
        maze[3][8] = new Room(0,3,8);
        maze[3][9] = new Room(0,3,9);
        maze[3][10] = new Room(0,3,10);
        maze[3][11] = new Room(1,3,11);
        //Initialize 5th Row
        maze[4][0] = new Room(1,4,0);
        maze[4][1] = new Room(0,4,1);
        maze[4][2] = new Room(0,4,2);
        maze[4][3] = new Room(0,4,3);
        maze[4][4] = new Room(0,4,4);
        maze[4][5] = new Room(1,4,5);
        maze[4][6] = new Room(0,4,6);
        maze[4][7] = new Room(0,4,7);
        maze[4][8] = new Room(0,4,8);
        maze[4][9] = new Room(0,4,9);
        maze[4][10] = new Room(0,4,10);
        maze[4][11] = new Room(1,4,11);
        //Initialize 6th Row
        maze[5][0] = new Room(1,5,0);
        maze[5][1] = new Room(0,5,1);
        maze[5][2] = new Room(0,5,2);
        maze[5][3] = new Room(0,5,3);
        maze[5][4] = new Room(0,5,4);
        maze[5][5] = new Room(0,5,5);
        maze[5][6] = new Room(0,5,6);
        maze[5][7] = new Room(1,5,7);
        maze[5][8] = new Room(0,5,8);
        maze[5][9] = new Room(0,5,9);
        maze[5][10] = new Room(0,5,10);
        maze[5][11] = new Room(1,5,11);
        //Initialize 7th Row
        maze[6][0] = new Room(1,6,0);
        maze[6][1] = new Room(0,6,1);
        maze[6][2] = new Room(0,6,2);
        maze[6][3] = new Room(0,6,3);
        maze[6][4] = new Room(0,6,4);
        maze[6][5] = new Room(0,6,5);
        maze[6][6] = new Room(0,6,6);
        maze[6][7] = new Room(1,6,7);
        maze[6][8] = new Room(0,6,8);
        maze[6][9] = new Room(0,6,9);
        maze[6][10] = new Room(0,6,10);
        maze[6][11] = new Room(1,6,11);
        //Initialize 8th Row
        maze[7][0] = new Room(1,7,0);
        maze[7][1] = new Room(0,7,1);
        maze[7][2] = new Room(0,7,2);
        maze[7][3] = new Room(0,7,3);
        maze[7][4] = new Room(0,7,4);
        maze[7][5] = new Room(1,7,5);
        maze[7][6] = new Room(0,7,6);
        maze[7][7] = new Room(0,7,7);
        maze[7][8] = new Room(0,7,8);
        maze[7][9] = new Room(0,7,9);
        maze[7][10] = new Room(0,7,10);
        maze[7][11] = new Room(1,7,11);
        //Initialize 9th Row
        maze[8][0] = new Room(1,8,0);
        maze[8][1] = new Room(0,8,1);
        maze[8][2] = new Room(0,8,2);
        maze[8][3] = new Room(0,8,3);
        maze[8][4] = new Room(0,8,4);
        maze[8][5] = new Room(1,8,5);
        maze[8][6] = new Room(0,8,6);
        maze[8][7] = new Room(0,8,7);
        maze[8][8] = new Room(0,8,8);
        maze[8][9] = new Room(0,8,9);
        maze[8][10] = new Room(0,8,10);
        maze[8][11] = new Room(1,8,11);
        //Initialize 10th Row
        maze[9][0] = new Room(1,9,0);
        maze[9][1] = new Room(0,9,1);
        maze[9][2] = new Room(0,9,2);
        maze[9][3] = new Room(0,9,3);
        maze[9][4] = new Room(0,9,4);
        maze[9][5] = new Room(0,9,5);
        maze[9][6] = new Room(0,9,6);
        maze[9][7] = new Room(0,9,7);
        maze[9][8] = new Room(0,9,8);
        maze[9][9] = new Room(0,9,9);
        maze[9][10] = new Room(0,9,10);
        maze[9][11] = new Room(1,9,11);
        //Initialize 11th Row
        maze[10][0] = new Room(1,10,0);
        maze[10][1] = new Room(0,10,1);
        maze[10][2] = new Room(0,10,2);
        maze[10][3] = new Room(0,10,3);
        maze[10][4] = new Room(0,10,4);
        maze[10][5] = new Room(0,10,5);
        maze[10][6] = new Room(0,10,6);
        maze[10][7] = new Room(0,10,7);
        maze[10][8] = new Room(0,10,8);
        maze[10][9] = new Room(0,10,9);
        maze[10][10] = new Room(0,10,10);
        maze[10][11] = new Room(1,10,11);
        //Initialize 11th Row
        maze[11][0] = new Room(1,10,0);
        maze[11][1] = new Room(1,10,1);
        maze[11][2] = new Room(1,10,2);
        maze[11][3] = new Room(1,10,3);
        maze[11][4] = new Room(1,10,4);
        maze[11][5] = new Room(1,10,5);
        maze[11][6] = new Room(1,10,6);
        maze[11][7] = new Room(1,10,7);
        maze[11][8] = new Room(1,10,8);
        maze[11][9] = new Room(1,10,9);
        maze[11][10] = new Room(1,10,10);
        maze[11][11] = new Room(1,10,11);
    }


    public int getMazeSize() {
        return mazeSize;
    }


      public void setMazeSize(int mazeSize) {
        this.mazeSize = mazeSize;
    }

}
