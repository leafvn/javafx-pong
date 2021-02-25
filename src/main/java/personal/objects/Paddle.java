package personal.objects;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import personal.Game;

import java.util.logging.Logger;

public class Paddle extends Pane {
    private static final Logger logger = Logger.getLogger(Paddle.class.getName());
    private Rectangle rectangle;
    private final double WIDTH=10;
    private final double HEIGHT=60;
    private double leftWidthX = 0;
    private double rightWidthX = Game.WIDTH-WIDTH;
    private double height = Game.HEIGHT/2;
    private double dy = 20;



    public Paddle(boolean isLeft){
        rectangle = new Rectangle(WIDTH,HEIGHT,Color.WHITE);
        if(isLeft){
            rectangle.relocate(leftWidthX+2*WIDTH,height);
        }
        else
           rectangle.relocate(rightWidthX-2*WIDTH,height);
        getChildren().add(rectangle);
    }


    public void moveDown() {
        if(rectangle.getY()+HEIGHT<=Game.HEIGHT/2){
            rectangle.setY(rectangle.getY()+dy);
           // logger.info("y: "+rectangle.getY());
           // logger.info("bound x: "+rectangle.getBoundsInParent().getCenterX()
           //                +" bound y: "+rectangle.getBoundsInParent().getCenterY());
        }
    }

    public void moveUp(){
        if(rectangle.getY()>=-Game.HEIGHT/2){
            rectangle.setY(rectangle.getY()-dy);
          //  logger.info("y: "+rectangle.getY());
          //  logger.info("bound x: "+rectangle.getBoundsInParent().getCenterX()
          //                  +" bound y: "+rectangle.getBoundsInParent().getCenterY());
        }
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

    public double getRX() {
        return rectangle.getBoundsInParent().getCenterX();
    }
    public double getRY() {
        return rectangle.getBoundsInParent().getCenterY();
    }
}
