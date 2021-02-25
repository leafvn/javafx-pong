package personal;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import personal.objects.Ball;
import personal.objects.Paddle;
import personal.objects.Player;


import java.util.logging.Logger;


/**
 * 20.2.2021 My very first game , first project as well
 */
public class Game extends Application {
    private static final Logger logger = Logger.getLogger(Game.class.getName());
    public static final double WIDTH =600;
    public static final double HEIGHT=300;
    private final double FPS = 20;
    private Timeline animation;
    private Player playerL;
    private Player playerR;
    private Text rightText;
    private Text leftText;
    private Paddle right;
    private Paddle left;
    private Ball ball;

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        var scene = new Scene(root,WIDTH,HEIGHT);
        ball = new Ball();
        left = new Paddle(true);
        right= new Paddle(false);
        playerL = new Player();
        playerR = new Player();
        leftText = new Text();
        rightText = new Text();
        leftText.setText(" "+playerL.getLScore());
        leftText.relocate(WIDTH/4,HEIGHT/10);
        leftText.setFill(Color.WHITE);
        leftText.setFont(Font.font(25));
        rightText.setText(" "+playerR.getRScore());
        rightText.relocate(WIDTH-WIDTH/4,HEIGHT/10);
        rightText.setFill(Color.WHITE);
        rightText.setFont(Font.font(25));

        move(scene,left,right);

        animation = new Timeline();
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setAutoReverse(true);
        animation.getKeyFrames().add(new KeyFrame(Duration.millis(FPS),e-> {

            ball.move();
            ball.checkScore(playerL, playerR,leftText,rightText);
            ball.checkPaddle(left, right);
            ball.checkCollision();
            if(limit()){
                animation.stop();
            }
        }));
        animation.play();

        root.getChildren().addAll(ball,left,right,leftText,rightText);
        stage.setScene(scene);
        stage.setTitle("Pong");
        stage.setResizable(false);
        stage.show();
        scene.setFill(Color.BLACK);

    }
    private void move(Scene scene, Paddle left, Paddle right){
        scene.setOnKeyPressed(keyEvent -> {
                    switch (keyEvent.getCode()){
                        case W:left.moveUp();break;
                        case UP:right.moveUp();break;
                        case S:left.moveDown();break;
                        case DOWN:right.moveDown();break;

                    }
           // logger.info(left.getLayoutX()+" "+left.getLayoutY());
                }
        );

    }

    private boolean limit(){
        if(playerL.getLScore()>2){
            //System.out.println("player 2 win");
            return true;
        }
        //System.out.println("player 1 win");
        return playerR.getRScore() > 2;
        //logger.info("score : "+playerL.getLScore());
        //logger.info("score : "+playerR.getRScore());
    }

    public static void main(String[] args) {
        launch();
    }

}