package GameGrudge.States;

import GameGrudge.UIApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class State_TitleScreen implements GameGrudgeState{

    public Scene constructStage(UIApplication app){

        Label l = new Label("Welcome to Game Grudge!");

        Button startButton = new Button("Start Game!");
        startButton.toFront();

        startButton.setOnAction(e -> {
            app.setCurrentState(new State_TeamFormation());
            app.setScene();
        });



        BorderPane sp = new BorderPane();
        sp.setMinSize(400,400);
        sp.setTop(l);

        sp.setCenter(startButton);

        Scene scene = new Scene(sp);
        return scene;
    }



}
