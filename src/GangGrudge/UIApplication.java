package GangGrudge;
import GangGrudge.States.GangGrudgeState;
import GangGrudge.States.State_TitleScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class UIApplication extends Application {
    public GangGrudgeState currentState;
    private Stage stage;
    public GameModel gameModel;

    public void setCurrentState(GangGrudgeState currentState) {
        this.currentState = currentState;
    }

    @Override
    public void start( Stage stage ) {
        gameModel = new GameModel();
        gameModel.loadQuestions();
        this.stage = stage;
        stage.setTitle("Game Grudge!");
        currentState = new State_TitleScreen();

        setScene();
    }

    public void setScene(){
        Scene scene = currentState.constructStage(this);
        stage.setScene( scene );
        stage.show();
    }

    public void refreshStage(){
        stage.show();
    }

    public static void main( String[] args ) {
        launch(args);
    }
}
