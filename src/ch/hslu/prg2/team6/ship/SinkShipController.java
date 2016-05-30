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
     * Starts a new server and a new client.
     * @return The created client
     */
    public Client startServer() {
        Server s = new Server();
        new Thread(s).start();
        createBattleFields();
        return new Client(1, "localhost");
    }

    /**
     * Creates two new battlefields
     */
    public void createBattleFields() {
        this.fieldPlayer1 = new BattlefieldModel(8,8);
        this.fieldPlayer2 = new BattlefieldModel(8,8);
    }

    /**
     * Starts a new client
     * @param IPAddress IP address of the server
     * @return The created client
     */
    public Client startClient(String IPAddress) {
        // Client darf nur einmal erstellt werden, wie lösen?
        System.out.println("starting client: "+IPAddress);
        return new Client(2, IPAddress);
    }

    /**
     * Shoots the specified field.
     * @param id Id of the player
     * @param shotField The field that was shot
     */
    public int shootField(int id, String shotField) {
        int newValue;
        System.out.println("shooting"+id);
        if (id == 1){
            newValue = this.fieldPlayer2.updateFieldModel(shotField);
            
        }
        else{
            newValue = this.fieldPlayer1.updateFieldModel(shotField);
        }
        return newValue;
    }

    /**
     * Returns the updated field.
     * @return Updated field
     */
    public int[][] getUpdatedField() {
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
