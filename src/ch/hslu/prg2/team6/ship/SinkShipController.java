package ch.hslu.prg2.team6.ship;

/**
 * Created by Tim Egeli on 10/05/2016.
 */
public class SinkShipController {
    private BattlefieldModel fieldPlayer1;
    private BattlefieldModel fieldPlayer2;

    public void startGame() {

    }

    public void shootField(BattlefieldModel field) {

    }

    public void createField() {
        this.fieldPlayer1 = new BattlefieldModel(8,8);
        this.fieldPlayer2 = new BattlefieldModel(8,8);
    }

    public void placeShips() {

    }

    public boolean hasTurn() {
        return true;
    }
}
