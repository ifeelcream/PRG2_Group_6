package ch.hslu.prg2.team6.ship;

/**
 * Created by Tim Egeli on 10/05/2016.
 */
public class ShipModel {
    private String startPosition;
    private String endPosition;
    private int numberOfHits;
    private String[] partsHit;

    public ShipModel(String startPosition, String endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition;
    }

    public int getNumberOfHits() {
        return numberOfHits;
    }

    public void setNumberOfHits(int numberOfHits) {
        this.numberOfHits = numberOfHits;
    }

    public String[] getPartsHit() {
        return partsHit;
    }

    public void setPartsHit(String[] partsHit) {
        this.partsHit = partsHit;
    }
}
