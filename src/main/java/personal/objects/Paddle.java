package personal.objects;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import personal.Game;

import java.util.logging.Logger;

public class Paddle extends Pane {
    private static final Logger logger = Logger.getLogger(Paddle.class.getName());
    private Rectangle rectangle;
    private final double WIDTH=5;
    private final double HEIGHT=60;
    private double leftWidthX = 0;
    private double rightWidthX = Game.WIDTH-WIDTH;
    private double height = Game.HEIGHT/2;
    private double dy = 20;


    public Paddle(boolean isLeft){
        rectangle = new Rectangle(WIDTH,HEIGHT,Color.WHITE);
        if(isLeft){
            rectangle.relocate(leftWidthX,height);

        }
        else
           rectangle.relocate(rightWidthX,height);
        getChildren().add(rectangle);
    }


    public void moveDown() {
        if(rectangle.getY()+HEIGHT<=Game.HEIGHT/2){
            rectangle.setY(rectangle.getY()+dy);
            logger.info("y: "+rectangle.getY());
        }

    }

    public void moveUp(){
        if(rectangle.getY()>=-Game.HEIGHT/2){
            rectangle.setY(rectangle.getY()-dy);
            logger.info("y: "+rectangle.getY());
        }
    }

}
