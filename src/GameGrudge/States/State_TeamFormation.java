package GameGrudge.States;

import GameGrudge.UIApplication;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class State_TeamFormation implements GameGrudgeState{
    @Override
    public Scene constructStage(UIApplication app) {
        //Creating the scene
        Label team1 = new Label("TEAM 1 = a");
        Label team2 = new Label("TEAM 2 = l");
        //Add a label for buzz in buttons (team 1 = a ; team 2 = l)

        Label numPlayers = new Label("How many players are on each team?");
        BorderPane sp = new BorderPane();
        sp.setLeft(team1);
        sp.setRight(team2);
        sp.setCenter(numPlayers);

        Button TEMPBUTTON = new Button("TEST BUTTON!");
        TEMPBUTTON.setOnAction(e -> {
            app.setCurrentState(new State_QuestionTossUp());
            app.setScene();
        });
        sp.setTop(TEMPBUTTON);


        sp.setMinSize(400,400);
        // ask how many players are on each team
        //submitting answer to how many players will detemine how many text fields should appear on screen AFTER

        // maybe something like HowManyPlayersButton triggers visibility on the text fields or something. check the javadocs im not entirely sure
        VBox buttons = new VBox();
        Button twoPlayers = new Button("Two");
        twoPlayers.setOnAction(e-> {
            populateField(app,2);
        });
        Button threePlayers = new Button("Three");
        threePlayers.setOnAction(e-> {
            populateField(app,3);
        });  //Gabe was here.
        Button fourPlayers = new Button("Four");
        fourPlayers.setOnAction(e-> {
            populateField(app,4);
        });
        Button fivePlayers = new Button("Five");
        fivePlayers.setOnAction(e-> {
            populateField(app,5);
        });
        buttons.getChildren().add(twoPlayers);
        buttons.getChildren().add(threePlayers);
        buttons.getChildren().add(fourPlayers);
        buttons.getChildren().add(fivePlayers);
        sp.setBottom(buttons);
        //After names are added, a button should be there like "Submit"
        //This button advances the app.CurrentState and saves the names to the UIApp's GameModel class.

        Scene scene = new Scene(sp);

        return scene;
    }

    public int populateField(UIApplication app, int numPlayers) {
        TextField answer = new TextField();
        return 0;

    }
}
