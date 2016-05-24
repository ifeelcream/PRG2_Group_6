package ch.hslu.prg2.team6.ship;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Tim Egeli on 10/05/2016.
 */
public class SinkShipController {
    private BattlefieldModel fieldPlayer;

    public void startGame() {

    }

    public void shootField(int id) {
        this.fieldPlayer.updateFieldModel(id);
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

    public boolean hasTurn() {
        return true;
    }
}
