package GameGrudge;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class UIApplication extends Application {
    private GameGrudgeState currentState;

    @Override
    public void start( Stage stage ) {

        //add comment

        String javaVersion = System.getProperty( "java.version" );
        String javafxVersion = System.getProperty( "javafx.version" );
        Scene scene = new Scene( new StackPane(), 640, 480 );
        stage.setScene( scene );
        stage.show();
    }

    public static void main( String[] args ) {
        launch();
    }
}
