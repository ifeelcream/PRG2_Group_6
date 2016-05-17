/**
 * Created by Tim Egeli on 10/05/2016.
 */
public class BattlefieldModel {
    private int numberOfHorizontalFields;
    private int numberOfVerticalFields;

    public BattlefieldModel(int numberOfHorizontalFields, int numberOfVerticalFields) {
        this.numberOfHorizontalFields = numberOfHorizontalFields;
        this.numberOfVerticalFields = numberOfVerticalFields;
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
