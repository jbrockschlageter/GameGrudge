package GameGrudge;
import GameGrudge.States.GameGrudgeState;
import GameGrudge.States.State_TitleScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class UIApplication extends Application {
    public GameGrudgeState currentState;
    private Stage stage;
    private GameModel gameModel;

    public void setCurrentState(GameGrudgeState currentState) {
        this.currentState = currentState;
    }

    @Override
    public void start( Stage stage ) {
        gameModel = new GameModel();
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

    public static void main( String[] args ) {
        launch(args);
    }
}
