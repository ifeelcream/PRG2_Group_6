package ch.hslu.prg2.team6.ship;

import java.util.HashMap;
import java.util.Random;

/**
 * This class creates a battlefield and puts the ships randomly on it
 *
 * @author Adrian Althaus
 */
public class BattlefieldModel {

    /**
     * The number of the horizontal fields
     */
    private int numberOfHorizontalFields;

    /**
     * The number of the vertical fields
     */
    private int numberOfVerticalFields;

    /**
     * A single battlefield
     */
    private int[][] singleBattleField;

    /**
     * All the battlefields combined with the client id as identifier
     */
    private HashMap<Integer, int[][]> battleField = new HashMap<>();

    /**
     * Creates a battlefield and places the ships on it.
     * @param numberOfHorizontalFields The number of horizontal fields
     * @param numberOfVerticalFields The number of vertical fields
     * @param id The id of the client
     */
    public BattlefieldModel(int numberOfHorizontalFields, int numberOfVerticalFields, int id) {
        this.numberOfHorizontalFields = numberOfHorizontalFields;
        this.numberOfVerticalFields = numberOfVerticalFields;
        this.singleBattleField = new int[numberOfHorizontalFields][numberOfVerticalFields];

        for (ShipType s : ShipType.values()) {
            int length = s.getLength();
            int startX;
            int startY;
            boolean isVertical;
            do {
                Random rnd = new Random();

                isVertical = rnd.nextBoolean();
                if (isVertical) {
                    startX = rnd.nextInt(numberOfHorizontalFields);
                    startY = rnd.nextInt(numberOfVerticalFields - length);
                } else {
                    startX = rnd.nextInt(numberOfHorizontalFields - length);
                    startY = rnd.nextInt(numberOfVerticalFields);
                }
            }
            while (!validateAvailableFields(startX, startY, length, isVertical));
            addShip(startX, startY, length, isVertical);
        }
        this.battleField.put(id, this.singleBattleField);
    }

    /**
     * Adds a ship to the battlefield.
     * @param xCoordinate The starting x-coordinate
     * @param yCoordinate The starting y-coordinate
     * @param length The length of the ship
     * @param isVertical Determines if the ship is vertical or horizontal
     */
    private void addShip(int xCoordinate, int yCoordinate, int length, boolean isVertical) {
        if (isVertical) {
            for (int i = 0; i < length; i++) {
                this.singleBattleField[xCoordinate][i] = 1;
            }
        } else {
            for (int i = 0; i < length; i++) {
                this.singleBattleField[i][yCoordinate] = 1;
            }
        }
    }

    /**
     * Checks whether there is space for the ship available on the field.
     * @param xCoordinate The starting x-coordinate
     * @param yCoordinate The starting y-coordinate
     * @param length The length of the ship
     * @param isVertical Determines if the ship is vertical or horizontal
     * @return If the ship can be placed there
     */
    private boolean validateAvailableFields(int xCoordinate, int yCoordinate, int length, boolean isVertical) {
        boolean isAvailable = true;
        if (isVertical) {
            for (int i = 0; i < length; i++) {
                if (this.singleBattleField[xCoordinate][i] == 1) {
                    isAvailable = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (this.singleBattleField[i][yCoordinate] == 1) {
                    isAvailable = false;
                    break;
                }
            }
        }
        return isAvailable;
    }

    /**
     * Checks if a ship was hit.
     * @param shot The field that was shot
     * @return If the ship was hit
     */
    public boolean isHit(String shot) {
        boolean isHit = false;
        int positionX = (int) shot.charAt(0);
        int positionY = (int) shot.charAt(1);
        if (this.singleBattleField[positionX][positionY] == 1) {
            isHit = true;
        }
        return isHit;
    }

    /**
     * Updates the field model with the shot field
     * @param field Field which was shot
     * @param newValue The new value of the field
     */
    public void updateFieldModel(String field, int newValue) {
        int positionX = (int) field.charAt(0);
        int positionY = (int) field.charAt(1);
        this.singleBattleField[positionX][positionY] = newValue;
    }

    /**
     * Returns the number of the horizontal fields.
     * @return Number of horizontal fields
     */
    public int getNumberOfHorizontalFields() {
        return numberOfHorizontalFields;
    }


    /**
     * Returns the number of the vertical fields
     * @return Number of vertical fields
     */
    public int getNumberOfVerticalFields() {
        return numberOfVerticalFields;
    }

    /**
     * Returns a HashMap with both battlefields.
     * @return Both battlefields
     */
    public HashMap<Integer, int[][]> getBattleField() {
        return this.battleField;
    }

}
