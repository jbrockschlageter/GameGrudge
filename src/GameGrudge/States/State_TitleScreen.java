package GameGrudge.States;

import GameGrudge.UIApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class State_TitleScreen implements GameGrudgeState{

    public Scene constructStage(UIApplication app){
        //Creating the scene

        //Creating label for scene
        Label l = new Label("Welcome to Game Grudge!");

        //Creating start button. Setting this button to advance the state and to set the new scene
        Button startButton = new Button("Start Game!");
        startButton.setOnAction(e -> {
            app.setCurrentState(new State_TeamFormation());
            //app.setCurrentState(new State_TeamFormation()); <- this is correct, just commenting out until team formation is done
            app.setScene();
        });

        //Creating the quit button. Setting this button to exit the program.
        Button quitButton = new Button("Exit Game");
        quitButton.setOnAction(e -> {
            System.exit(0);
        });

        //Adding the components to a VBox, to be in a vertical colomn
        VBox vb = new VBox(l, startButton, quitButton);
        vb.setSpacing(10);
        BorderPane sp = new BorderPane(vb);
        sp.setMinSize(400,400);

        //Creating the scene and adding the vbox collection. Sending it back to UIApp
        Scene scene = new Scene(sp);
        return scene;
    }

}
