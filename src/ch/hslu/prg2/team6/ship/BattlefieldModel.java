package ch.hslu.prg2.team6.ship;

import java.util.Random;
/**
 * Created by Tim Egeli on 10/05/2016.
 */
public class BattlefieldModel {
    private int numberOfHorizontalFields;
    private int numberOfVerticalFields;
    private int[][] battleField;

    public BattlefieldModel(int numberOfHorizontalFields, int numberOfVerticalFields) {
        this.numberOfHorizontalFields = numberOfHorizontalFields;
        this.numberOfVerticalFields = numberOfVerticalFields;
        this.battleField = new int[numberOfHorizontalFields][numberOfVerticalFields];
        
        
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
            while(!validateAvailableFields(startX, startY, l, isVertical, this.battleField));
            addShip(startX, startY, l, isVertical);
        }
        //System.out.println(BattleField);
    }
   
    private void addShip(int x, int y, int l, boolean isVertical){
        if (isVertical){
            for (int i = 0; i < l; i++){
                this.battleField[x][i] = 1;
            }
        }
        else{
            for (int i = 0; i < l; i++){
                this.battleField[i][y] =1;
                }
            }
        }
    
    private boolean validateAvailableFields(int x, int y, int l, boolean isVertical){
        boolean isAvailable = true;
        if (isVertical){
            for (int i = 0; i < l; i++){
                if (this.battleField[x][i] == 1){
                    isAvailable = false;
                    break;
                    } 
                }
            }
        else{
            for (int i = 0; i < l; i++){
                if (this.battleField[i][y] == 1){
                    isAvailable = false;
                    break;
                    } 
                }
            }
        return isAvailable;
        }
    
    public boolean isHit(String shot){
        boolean isHit = false;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int positionX =  alphabet.indexOf(shot.charAt(0));
        int positionY = (int) shot.charAt(1);  
        if (this.battleField[positionX][positionY] == 1){
            isHit = true;
            }
        return isHit;
        }
    
    public void updateFieldModel(String field, int newValue){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int positionX =  alphabet.indexOf(field.charAt(0));
        int positionY = (int) field.charAt(1);  
        this.battleField[positionX][positionY] = newValue;
        }
    
    public int getNumberOfHorizontalFields() {
        return numberOfHorizontalFields;
    }

   
    public int getNumberOfVerticalFields() {
        return numberOfVerticalFields;
    }
    
    public int[][] getBattleField(){
        return this.battleField;
        }

}
