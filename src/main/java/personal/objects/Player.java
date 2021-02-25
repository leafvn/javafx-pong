package personal.objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;


public class Player  {

    private IntegerProperty lScore = new SimpleIntegerProperty(0);
    private IntegerProperty rScore= new SimpleIntegerProperty(0);

    public int getLScore() {
        return lScore.get();
    }


    public void setLScore(int lScore) {
        this.lScore.set(lScore);
    }

    public int getRScore() {
        return rScore.get();
    }



    public void setRScore(int rScore) {
        this.rScore.set(rScore);
    }
}
