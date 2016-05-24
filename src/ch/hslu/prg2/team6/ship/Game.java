package ch.hslu.prg2.team6.ship;

/**
 * Created by Tim Egeli on 10/05/2016.
 */
public class Game {
    private boolean isServer = true;

    public static void main(String[] args) {
        Game g = new Game();
        //g.startServer();
        g.startClient();
    }

    private void startGame(){
        //Server server = new Server(); // Singleton?!
        //ShipView gui = new ShipView();
        //gui.displayGameType(); // or just start the game via main menu?
    }

    public void startServer(){
        Server server = new Server();
        //while (!server.isReady()){
        // sleep()
        //}
        createPlayer("1");


        // avoid multiple instances?

    }

    public void startClient(){
        //Client client = new Client();

        //while (!client.isReady()){
        // sleep()
        //}
        createPlayer("2");

        // avoid multiple instances?

    }
    private void createPlayer(String id){
        Client client = new Client(id);
        //BattlefieldModel fieldModel = new BattlefieldModel(id);
        //gui.displayModel(fieldModel);
    }
}
