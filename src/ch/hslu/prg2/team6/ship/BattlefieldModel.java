package ch.hslu.prg2.team6.ship;

import java.util.Random;
/**
 * Created by Tim Egeli on 10/05/2016.
 */
public class BattlefieldModel {
    private int numberOfHorizontalFields;
    private int numberOfVerticalFields;

    public BattlefieldModel(int numberOfHorizontalFields, int numberOfVerticalFields) {
        this.numberOfHorizontalFields = numberOfHorizontalFields;
        this.numberOfVerticalFields = numberOfVerticalFields;
        int[][] BattleField = new int[numberOfHorizontalFields][numberOfVerticalFields];
        
        for (ShipType s : ShipType.values()){
            int l = s.getLength();
            int startX;
            int startY;
            boolean isVertical;
            do{
                Random rnd = new Random();
          
                isVertical= rnd.nextBoolean();
                if (isVertical){
                    startX = rnd.nextInt(numberOfHorizontalFields);
                    startY = rnd.nextInt(numberOfVerticalFields -l);
                }
                else{
                    startX = rnd.nextInt(numberOfHorizontalFields - l);
                    startY = rnd.nextInt(numberOfVerticalFields);
                }
            }
            while(!validateAvailableFields(startX, startY, l, isVertical, BattleField));
            addShip(startX, startY, l, isVertical, BattleField);
        }
        //System.out.println(BattleField);
    }
   
    private void addShip(int x, int y, int l, boolean isVertical, int[][] BattleField){
        if (isVertical){
            for (int i = 0; i < l; i++){
                BattleField[x][i] = 1;
            }
        }
        else{
            for (int i = 0; i < l; i++){
                BattleField[i][y] =1;
                }
            }
        }
    
    private boolean validateAvailableFields(int x, int y, int l, boolean isVertical, int[][] BattleField){
        boolean isAvailable = true;
        if (isVertical){
            for (int i = 0; i < l; i++){
                if (BattleField[x][i] == 1){
                    isAvailable = false;
                    break;
                    } 
                }
            }
        else{
            for (int i = 0; i < l; i++){
                if (BattleField[i][y] == 1){
                    isAvailable = false;
                    break;
                    } 
                }
            }
        return isAvailable;
        }
    
    public boolean isHit(int[][] BattleField, String shot){
        boolean isHit = false;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int positionX =  alphabet.indexOf(shot.charAt(0));
        int positionY = (int) shot.charAt(1);  
        if (BattleField[positionX][positionY] == 1){
            isHit = true;
            }
        return isHit;
        }
    
    public void updateFieldModel(int[][] BattleField, String field, int newValue){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int positionX =  alphabet.indexOf(field.charAt(0));
        int positionY = (int) field.charAt(1);  
        BattleField[positionX][positionY] = newValue;
        }
    
    public int getNumberOfHorizontalFields() {
        return numberOfHorizontalFields;
    }

    public void setNumberOfHorizontalFields(int numberOfHorizontalFields) {
        this.numberOfHorizontalFields = numberOfHorizontalFields;
    }

    public int getNumberOfVerticalFields() {
        return numberOfVerticalFields;
    }

    public void setNumberOfVerticalFields(int numberOfVerticalFields) {
        this.numberOfVerticalFields = numberOfVerticalFields;
    }    
}
