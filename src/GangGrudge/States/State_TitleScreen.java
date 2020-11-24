package GangGrudge.States;

import GangGrudge.UIApplication;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class State_TitleScreen implements GangGrudgeState {

    public Scene constructStage(UIApplication app){
        //Creating the scene

        //Creating label for scene
        Label l = new Label("Welcome to Gang Grudge!");

        //Creating start button. Setting this button to advance the state and to set the new scene
        Button startButton = new Button("Start Game!");
        startButton.setOnAction(e -> {
            app.setCurrentState(new State_TeamFormation());
            app.setScene();
        });

        //Creating the quit button. Setting this button to exit the program.
        Button quitButton = new Button("Exit Game");
        quitButton.setOnAction(e -> {
            System.exit(0);
        });

        //Adding the components to a VBox, to be in a vertical column
        VBox vBox = new VBox();
        vBox.getChildren().addAll(l, startButton, quitButton);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(700,700);
        borderPane.setCenter(vBox);

        //Creating the scene and adding the vbox collection. Sending it back to UIApp
        Scene scene = new Scene(borderPane);
        return scene;
    }

}
