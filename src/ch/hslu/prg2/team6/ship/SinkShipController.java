package ch.hslu.prg2.team6.ship;

import java.util.HashMap;

/**
 * Created by Tim Egeli on 10/05/2016.
 */
public class SinkShipController {
    private BattlefieldModel fieldPlayer1;
    private BattlefieldModel fieldPlayer2;
    private int turn = 0;

    public SinkShipController() {
        this.fieldPlayer1 = new BattlefieldModel(8,8,1);
        this.fieldPlayer2 = new BattlefieldModel(8,8,2);
    }

    private void startGame() {
        //ShipView gui = new ShipView();
        //gui.displayGameType(); // or just start the game via main menu?
    }

    public Client startServer() {
        Server s = new Server();
        new Thread(s).start();

        System.out.println("Server started");

        return new Client(1, "localhost");
    }

    public Client startClient(String IPAddress) {
        // Client darf nur einmal erstellt werden, wie lösen?
        System.out.println("Client created");

        return new Client(2, IPAddress);
    }

    private void createPlayer() {
        //BattlefieldModel fieldModel = new BattlefieldModel(id);
        //gui.displayModel(fieldModel);
    }

    public void shootField(int id, String shotField) {
        //this.fieldPlayer.updateFieldModel(id, shotField);
    }

    public HashMap<Integer, int[][]> getUpdatedField() {
        return this.fieldPlayer1.getBattleField();
    }

    // Return the id of the player that has his turn
    public int hasTurn() {
        return ((turn % 2) + 1);
    }

    public void incrementTurn() {
        this.turn++;
    }
}
