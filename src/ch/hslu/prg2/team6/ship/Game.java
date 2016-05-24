package ch.hslu.prg2.team6.ship;

import java.util.HashMap;

/**
 * Created by Tim Egeli on 10/05/2016.
 */
public class Game {
    private boolean isServer = true;

    public static void main(String[] args) {
        Game game = new Game();
        game.startServer();
        game.startClient();

        Client c = new Client(1);
        c.sendShotField("A21");
    }

    private void startGame(){
        //ShipView gui = new ShipView();
        //gui.displayGameType(); // or just start the game via main menu?
    }

    public void startServer(){
        Server s = new Server();
        new Thread(s).start();

        createPlayer(1);
    }

    public void startClient(){
        createPlayer(2);
    }

    private void createPlayer(int id){
        Client client = new Client(id);
        //BattlefieldModel fieldModel = new BattlefieldModel(id);
        //gui.displayModel(fieldModel);
    }
}
