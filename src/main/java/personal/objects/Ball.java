package personal.objects;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import personal.Game;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class Ball extends Pane {
    private static final Logger logger = Logger.getLogger(Ball.class.getName());
    private static final double ONE =1;
    private static final double TWO =2;
    private static final double THREE =3;
    private final double radius = 10;
    private double x = Game.WIDTH/2;
    private double y = Game.HEIGHT/2;
    private double xSpeed;
    private double ySpeed;
    private Circle circle;
    private boolean isLeft;

    public Ball(){
       circle = new Circle(radius, Color.WHITE);
       circle.setCenterY(x);
       circle.setCenterY(y);
       isLeft = turnLeft();
       randomDirection();
       getChildren().add(circle);

    }
    public void move(){
        circle.setCenterX(x);
        circle.setCenterY(y);
        if(isLeft){
            goLeft();
        }
        else{
            goRight();
        }
        checkCollision();
        // logger.info(circle.getCenterX()+" "+circle.getCenterY());

    }
    private void goLeft(){
        x +=xSpeed;
        y +=ySpeed;

    }
    private void goRight(){
        x -=xSpeed;
        y -=ySpeed;
    }
    private void checkCollision(){
        if(x <0 ||x>Game.WIDTH){
            x = Game.WIDTH/2;
        }
        if(y <0 ||y>Game.HEIGHT){
            ySpeed *=-1;
        }
    }
    private void randomDirection(){
        int rdNum = ThreadLocalRandom.current().nextInt(0,11);
        logger.info("number "+ rdNum);
        switch (rdNum){
            case 0:xSpeed=-ONE;ySpeed=-TWO;
            case 1:xSpeed=ONE;ySpeed=-THREE;
            case 2:xSpeed=-ONE;ySpeed=TWO;
            case 3:xSpeed=ONE;ySpeed=-THREE;
            case 4:xSpeed=TWO;ySpeed=ONE;
            case 5:xSpeed=-TWO;ySpeed=-ONE;
            case 6:xSpeed=TWO;ySpeed=THREE;
            case 7:xSpeed=-TWO;ySpeed=-THREE;
            case 8:xSpeed=THREE;ySpeed=ONE;
            case 9:xSpeed=-THREE;ySpeed=-TWO;
            case 10:xSpeed=THREE;ySpeed=TWO;
            case 11:xSpeed=-THREE;ySpeed=THREE;
        }
    }
    private boolean turnLeft(){
      //  Random random = new Random();
        return  new Random().nextBoolean();
       // return random.nextBoolean();
    }
}
