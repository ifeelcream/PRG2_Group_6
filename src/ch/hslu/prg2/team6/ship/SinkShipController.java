package ch.hslu.prg2.team6.ship;

import java.util.HashMap;

/**
 * Created by Tim Egeli on 10/05/2016.
 */
public class SinkShipController {
    private BattlefieldModel fieldPlayer;
    private int turn = 0;

    public static void main(String[] args) {
        SinkShipController sinkShipController = new SinkShipController();
        sinkShipController.startServer();
        sinkShipController.startClient();

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

    public void shootField(int id) {
        //this.fieldPlayer.updateFieldModel(id);
    }

    public int[][] createField(int numberOfPlayer) {
        int[] field = new int[numberOfPlayer];

        HashMap<Integer, int[][]> battleField = new HashMap<>();

        for (int i=1; i<=numberOfPlayer;i++) {
            this.fieldPlayer = new BattlefieldModel(8,8);
            battleField.put(i, this.fieldPlayer.getBattleField());
        }

        return this.fieldPlayer.getBattleField();
    }

    // Return the id of the player that has his turn
    public int hasTurn() {
        return ((turn % 2) + 1);
    }

    public void incrementTurn() {
        this.turn++;
    }
}
