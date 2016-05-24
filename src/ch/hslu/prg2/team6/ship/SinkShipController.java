package ch.hslu.prg2.team6.ship;

/**
 * Created by Tim Egeli on 10/05/2016.
 */
public class SinkShipController {
    private BattlefieldModel fieldPlayer;

    public void startGame() {

    }

    public void shootField(BattlefieldModel field) {

    }

    public int[][] createField(int numberOfPlayer) {
        int[] field = new int[numberOfPlayer];

        for (int i=1; i<=numberOfPlayer;i++) {
            this.fieldPlayer = new BattlefieldModel(8,8);
            field[i] = this.fieldPlayer.getBattleField();
        }

        return this.fieldPlayer.getBattleField();
    }

    public void placeShips() {

    }

    public boolean hasTurn() {
        return true;
    }
}
