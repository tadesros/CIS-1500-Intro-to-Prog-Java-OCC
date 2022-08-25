# JavaTemplate

/* GUI Layout inspired by the example given by professor Eric Charnesky in class */



Hide Assignment Information
Instructions
https://classroom.github.com/a/ZaTVenPd

Please see https://youtu.be/JtNxpBJ6DRs?t=4686 from last semester for the final project description - starting at 1:18:12 or so into the video.

Please schedule a time to present with Eric AND submit the URL to your repository AND a self assessment using the rubric.  Projects that are not presented will not receive credit.

If you want to work in pairs on the project you may, please let me know who you are working with, and each person needs to submit individually.

 

Build a pretend adventure game with JavaFX

 

Create a 2d Array/ArrayList of Rooms, about 10x10 or large, at the edges, or if a room is blocked, don't let them travel to it with the navigation buttons.

Create a class from Room that stores it's location, whether it is blocked or not, and the NPC for that room, how much gold there is to find.

 

Player Character ( class )

-Hit Points - start with 20

- Strength - 3 rolls of a 6 sided die

- Dexterity - 3 rolls of a 6 sided die 

- Intelligence - 3 rolls of a 6 sided die

- total gold

 

In a room, there is a 1 in 2 chance of encountering a NPC to fight/run away from.  Or if there is no NPC, or after you kill it, you can search the room for gold or sleep.

 

Non Player Characters ( monsters )

- Hit Points - randomly 1-6 ( use the same number for the stats below )

- Strength ( 1-6 ) x 2

- Dexterity ( 1-6 ) x 2 

- Intelligence ( 1-6 ) x 2 

 

 

- Searching the room, 'roll' a 20 sided die, and if we roll a value < our intelligence, we find a the gold in the room  ( you pick some random amount in the code ).

- Fight - 'roll' a 20 sided die, if we roll >= monster dexterity, we hit.  They take our strength / 3 damage if hit ( reduces NPC hit points by that value ).

  after we attack, if the monster is alive ( has > 0 hit points ) it can attack us, same rules, but in reverse ( minimum 1 damage )

- Run away - the monster gets to make 1 attack as we run away if it "sees" us, roll a 20 sided die, if it rolls < it's intelligence it saw us. ( go to the previous room, or random direction, or let them pick )

- Sleep, if we sleep, we regain all of our hit points, but there is a 1/6 chance a NPC finds us while sleeping and gets to attack us ( add a new NPC to the room )

 

Game runs forever, or until the player dies.

Due Date
Aug 22, 2022 11:59 PM
Hide Rubrics
Rubric Name: Final Project
Criteria	
Complete
5 points
Missing
0 points
Criterion Score
Maze is a 2d array or arraylist of type Room
Score of Maze is a 2d array or arraylist of type Room,/ 5
Room class
Score of Room class,/ 5
Player class
Score of Player class,/ 5
NPC class
Score of NPC class,/ 5
Searching a room
Score of Searching a room,/ 5
Sleeping in a room
Score of Sleeping in a room,/ 5
running away from an NPC
Score of running away from an NPC,/ 5
Fight between player and NPC
Score of Fight between player and NPC,/ 5
Total
