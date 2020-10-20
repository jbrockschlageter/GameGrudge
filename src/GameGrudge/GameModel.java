package GameGrudge;

import java.util.ArrayList;

public class GameModel {
    //This class holds the model info for the UI Application

    public ArrayList<String> team1;
    public ArrayList<String> team2;

    public void saveNames(int numberOfPlayers){
        team1.add("Team 1");
        team2.add("Team 2");
        for(int i = 1 ; i <= numberOfPlayers; i++){
            team1.add("Player " + i);
            team2.add("Player " + i);
        }
    }

}
