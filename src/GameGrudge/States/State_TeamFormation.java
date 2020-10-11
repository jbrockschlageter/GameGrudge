package GameGrudge.States;

import GameGrudge.UIApplication;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class State_TeamFormation implements GameGrudgeState{
    @Override
    public Scene constructStage(UIApplication app) {
        //Creating the scene
        Label l = new Label("TEAM FORMATION");

        // ask how many players are on each team

        //submitting answer to how many players will detemine how many text fields should appear on screen AFTER
        // maybe something like HowManyPlayersButton triggers visibility on the text fields or something. check the javadocs im not entirely sure

        //After names are added, a button should be there like "Submit"
        //This button advances the app.CurrentState and saves the names to the UIApp's GameModel class.

        BorderPane sp = new BorderPane(l);
        sp.setMinSize(400,400);
        Scene scene = new Scene(sp);

        return scene;
    }
}
