package com.example.adventure_game;

/*GUI Layout inspired by the example given by professor Eric Charnesky in class */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class HelloController {
    //Player class
     private Game game;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Label lblStrength;
    @FXML
    private Label lblHitPoints;
    @FXML
    private Label lblDexterity;
    @FXML
    private Label lblIntelligence;
    @FXML
    private Label lblGold;
    @FXML
    private Button moveRight;
    @FXML
    private Button moveLeft;
    @FXML
    private Button moveDown;
    @FXML
    private Button moveUp;
    @FXML
    private TextArea textArea;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnSleep;
    @FXML
    private Button btnFight;
    @FXML
    private Button btnRun;
    @FXML
    private Label lblMonsterDexterity;
    @FXML
    private Label lblMonsterIntelligence;
    @FXML
    private Label lblMonsterHitPoints;
    @FXML
    private Label lblMonsterStrength;
    @FXML
    private Label lblRow;
    @FXML
    private Label lblCol;

    //* Methods *
    //Initialize Run on Load
    public void initialize(){
        //Make text area uneditable
        textArea.setEditable(false);
        //Create a game object
        game = new Game();
        //Set initial game state
          //Show message, buttons, etc
           initializeGameState();
    }
    //Click Event Methods
    @FXML
    public void clickSouth(ActionEvent actionEvent) {
            game.moveSouth();
            //Set Monster In room variables
             updateGameState();
    }
    @FXML
    public void clickNorth(ActionEvent actionEvent) {
         game.moveNorth();
        //Set Monster In room variables
         updateGameState();
    }
    @FXML
    public void clickEast(ActionEvent actionEvent) {
        game.moveEast();
        //Set Monster In room variables
        updateGameState();
    }
    @FXML
    public void clickWest(ActionEvent actionEvent) {
        game.moveWest();
        //Set Monster In room variables
        updateGameState();
    }
    @FXML
    public void clickSearch(ActionEvent actionEvent) {
        //Call search Room
        game.searchRoom();
        //Show message
        showGameMessage();
        //Update Buttons
        updateGameActions();
        updateNavButtons();
        //Update gold total
        lblGold.setText(String.valueOf(game.player.getTotalGold()));
    }
    @FXML
    public void clickFight(ActionEvent actionEvent) {
        //Call Fight
        game.fight();
        //Show Message
        showGameMessage();
        //Update Game Actions
         updateGameActions();
         updateNavButtons();
        lblMonsterHitPoints.setText(String.valueOf(game.getCurMonsterHitPoints()));
        //If monster is alive then run monster attack
        if(game.getCurMonsterHitPoints() != 0)
        {
            //The monster hits
            game.monsterAttack();
            //Show message
            showGameMessage();
            //Update game actions
            updateGameActions();
            updateNavButtons();
            //Update Your hit points
            lblHitPoints.setText(String.valueOf(game.player.getHitPoints()));
        }

    }
    @FXML
    public void clickSleep(ActionEvent actionEvent) {
        //boolean to track if monster sees us
        boolean monsterPresent = game.sleep();

        if(monsterPresent)
        {
            //Populate new monster stat's
            updateMonsterStats();
            showGameMessage();
            //Update Buttons
            updateGameActions();
            updateNavButtons();
            //The monster hits
            game.monsterAttack();
            //Update Your hit points
            lblHitPoints.setText(String.valueOf(game.player.getHitPoints()));
        }
        //Show Message
        showGameMessage();
        //Update Buttons
        updateGameActions();
        updateNavButtons();

        //Update hit points
        lblHitPoints.setText(String.valueOf(game.player.getHitPoints()));
    }
    @FXML
    public void clickRunaway(ActionEvent actionEvent) {
        //Run away
        boolean monsterSawYou = game.runAway();

        if(monsterSawYou)
        {
            showGameMessage();
            //Update Buttons
            updateGameActions();
            updateNavButtons();
            //The monster hits
            game.monsterAttack();
            //Update Your hit points
            lblHitPoints.setText(String.valueOf(game.player.getHitPoints()));
        }
        //Show message
        showGameMessage();
        //Update Buttons
        updateGameActions();
        updateNavButtons();
        //Update hit points
        lblHitPoints.setText(String.valueOf(game.player.getHitPoints()));
    }
    //Supporting Methods
    public void updateGameState(){
        //UpdateMonster stats
       updateMonsterStats();
        //Show game message
        showGameMessage();
        //Update Action Options
        updateGameActions();
        //Update move Options
        updateNavButtons();
        //Update location
        updateLocation();

    }
    public void updateGameActions(){
        btnFight.setDisable(!game.isCanFight());
        btnRun.setDisable(!game.isCanRun());
        btnSearch.setDisable(!game.isCanSearch());
        btnSleep.setDisable(!game.isCanSleep());
    }
    public void updateNavButtons()
    {
        moveUp.setDisable(!game.getCanGoNorth());
        moveDown.setDisable(!game.getCanGoSouth());
        moveLeft.setDisable(!game.getCanGoWest());
        moveRight.setDisable(!game.getCanGoEast());
    }
    public void showGameMessage()
    {
        textArea.appendText(game.getCurrentMessage());
    }
    public void showPlayerStats(){
        lblHitPoints.setText(String.valueOf(game.player.getHitPoints()));
        lblStrength.setText(String.valueOf(game.player.getStrength()));
        lblDexterity.setText(String.valueOf(game.player.getDexterity()));
        lblIntelligence.setText(String.valueOf(game.player.getIntelligence()));
        lblGold.setText(String.valueOf(game.player.getTotalGold()));
    }
    public void initializeGameState() {
        //Show player starting statistics
        showPlayerStats();
        //Show starting game message
        showGameMessage();
        //Enable or disable nav buttons
        updateNavButtons();
        //Enable disable movement buttons
        updateGameActions();
        //Set row column
        updateLocation();
    }
    public void updateMonsterStats()
    {
        lblMonsterIntelligence.setText(String.valueOf(game.getCurMonsterIntelligence()));
        lblMonsterDexterity.setText(String.valueOf(game.getCurMonsterDexterity()));
        lblMonsterHitPoints.setText(String.valueOf(game.getCurMonsterHitPoints()));
        lblMonsterStrength.setText(String.valueOf(game.getCurMonsterStrength()));

    }
    public void updateLocation()
    {
        lblCol.setText(String.valueOf(game.getCurrentCol()));
        lblRow.setText(String.valueOf(game.getCurrentRow()));

    }
}