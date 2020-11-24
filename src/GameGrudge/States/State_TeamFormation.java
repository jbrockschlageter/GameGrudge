package GameGrudge.States;

import GameGrudge.UIApplication;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class State_TeamFormation implements GameGrudgeState{
    public BorderPane borderPane;


    @Override
    public Scene constructStage(UIApplication app) {
        //Creating the scene
        Label team1 = new Label("TEAM 1 = Stardust Crusaders (Press A)");
        Label team2 = new Label("TEAM 2 = Dream Team Purple Cobras (Press L)");
        //Add a label for buzz in buttons (team 1 = a ; team 2 = l)

        Label numPlayers = new Label("How many players are on each team?");
        borderPane = new BorderPane();
        borderPane.setLeft(team1);
        borderPane.setRight(team2);

        borderPane.setMinSize(700,700);

        VBox buttons = new VBox();
        Button twoPlayers = new Button("Two");
        twoPlayers.setOnAction(e-> {
            populateField(app,2, buttons);
        });
        Button threePlayers = new Button("Three");
        threePlayers.setOnAction(e-> {
            populateField(app,3, buttons);
        });  //Gabe was here.
        Button fourPlayers = new Button("Four");
        fourPlayers.setOnAction(e-> {
            populateField(app,4, buttons);
        });
        Button fivePlayers = new Button("Five");
        fivePlayers.setOnAction(e-> {
            populateField(app,5, buttons);
        });
        buttons.getChildren().addAll(numPlayers,twoPlayers,threePlayers,
                fourPlayers,fivePlayers);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        borderPane.setCenter(buttons);
        //After names are added, a button should be there like "Submit"
        //This button advances the app.CurrentState and saves the names to the UIApp's GameModel class.

        Scene scene = new Scene(borderPane);

        return scene;
    }

    public int populateField(UIApplication app, int numPlayers, VBox buttons) {
        borderPane.getChildren().remove(buttons);

        app.setCurrentState(new State_QuestionTossUp());
        app.setScene();

        return 0; //Succesful function
    }
}
