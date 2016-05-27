package ch.hslu.prg2.team6.ship;

import java.util.HashMap;

/**
 * This class performs all the necessary actions and updates the model
 *
 * @author Tim Egeli
 */
public class SinkShipController {
    /**
     * The battlefield of the first player
     */
    private BattlefieldModel fieldPlayer1;

    /**
     * The battlefield of the second player
     */
    private BattlefieldModel fieldPlayer2;

    /**
     * Determines whose turn it is, Begins with player1
     */
    private int turn = 0;

    /**
     * Creates two new battlefields for player 1 and player 2.
     */
    public SinkShipController() {
        //Es darf nur einmal ein neuer Controller erstellt werden, ansonsten werden Felder immer neu gemacht
        this.fieldPlayer1 = new BattlefieldModel(8,8,1);
        this.fieldPlayer2 = new BattlefieldModel(8,8,2);
    }

    /**
     * Starts a new server and a new client.
     * @return The created client
     */
    public Client startServer() {
        Server s = new Server();
        new Thread(s).start();

        System.out.println("Server started");

        return new Client(1, "localhost");
    }

    /**
     * Starts a new client
     * @param IPAddress IP address of the server
     * @return The created client
     */
    public Client startClient(String IPAddress) {
        // Client darf nur einmal erstellt werden, wie lösen?
        System.out.println("Client created");

        return new Client(2, IPAddress);
    }

    /**
     * Shoots the specified field.
     * @param id Id of the player
     * @param shotField The field that was shot
     */
    public void shootField(int id, String shotField) {
        //this.fieldPlayer.updateFieldModel(id, shotField);
    }

    /**
     * Returns the updated field.
     * @return Updated field
     */
    public HashMap<Integer, int[][]> getUpdatedField() {
        return this.fieldPlayer1.getBattleField();
    }

    /**
     * Return the id of the player that has his turn.
     * @return Number, which has turn
     */
    public int hasTurn() {
        return ((turn % 2) + 1);
    }

    /**
     * Increment the turn number by 1
     */
    public void incrementTurn() {
        this.turn++;
    }
}
