package personal.objects;


import javafx.beans.binding.Bindings;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import personal.Game;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class Ball extends Pane {
    private static final Logger logger = Logger.getLogger(Ball.class.getName());
    //private static final double ONE =1.9;
    private static final double TWO =2.9;
    private static final double THREE =3.9;
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

       // isLeft = true;
       randomSpeed();
       getChildren().add(circle);

    }

    public void checkPaddle(Paddle left, Paddle right){
         if(x<left.getRX()+2*left.getWIDTH()
                 &&y<left.getRY()+left.getHEIGHT()/3
                 &&y>left.getRY()-left.getHEIGHT()/1.5){
             reverseX();
            // reverseY();
         }
         if(x>right.getRX()-2*right.getWIDTH()
                 &&y<right.getRY()+right.getHEIGHT()/3
                 &&y>right.getRY()-right.getHEIGHT()/1.5){
             reverseX();
            // reverseY();
         }
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
       //  logger.info(circle.getCenterX()+" "+circle.getCenterY());
    }
    private void goLeft(){
        x +=xSpeed;
        y +=ySpeed;

    }
    private void goRight(){
        x -=xSpeed;
        y -=ySpeed;
    }
    private void reverseX(){
       // logger.info("speed x: "+xSpeed);
         xSpeed *=-1.02;

    }
    private void reverseY(){
      //  logger.info("speed y: "+ySpeed);
         ySpeed *=-1.02;
    }
    private void reset(){
            x = Game.WIDTH/2;
            y = Game.HEIGHT/2;
    }
    public void checkCollision(){
        if(y <0 ||y>Game.HEIGHT){
           reverseY();
        }
    }
    public void checkScore(Player left, Player right, Text lText, Text rText){
        if(x <0 ){
            right.setRScore(right.getRScore()+1);
            rText.textProperty().bind(Bindings.createStringBinding(()->(""+right.getRScore())));
            isLeft = turnLeft();
            reset();
        }
        if(x>Game.WIDTH){
            left.setLScore(left.getLScore()+1);
            lText.textProperty().bind(Bindings.createStringBinding(()->(""+left.getLScore())));
            isLeft = turnLeft();
            reset();
        }
    }
    private void randomSpeed(){
        int rdNum = ThreadLocalRandom.current().nextInt(0,4);
        logger.info("number "+ rdNum);
        switch (rdNum){
            case 0:xSpeed=-TWO;ySpeed=-TWO;
            case 1:xSpeed=-THREE;ySpeed=-THREE;
            case 2:xSpeed=THREE;ySpeed=THREE;
            case 3:xSpeed=-TWO;ySpeed=TWO;

        }
    }
    private boolean turnLeft(){
      //  Random random = new Random();
        return  new Random().nextBoolean();
       // return random.nextBoolean();
    }
}
