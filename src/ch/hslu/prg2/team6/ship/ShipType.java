package ch.hslu.prg2.team6.ship;

/**
 * Created by Tim Egeli on 10/05/2016.
 */
public enum ShipType {
    CARRIER(5), BATTLESHIP(4), DESTROYER(3), PATROLBOAT(2);

    private final int length;

    private ShipType(final int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }
}
