package breakout.model;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*
 *  Overall all logic for the Breakout Game
 *  Model class representing the full game
 *  This class should use other objects delegate work.
 *
 *  NOTE: Nothing visual here
 *
 */
public class Breakout {

    public static final double GAME_WIDTH = 400;
    public static final double GAME_HEIGHT = 400;
    public static final double BALL_SPEED_FACTOR = 1.05; // Increase ball speed
    public static final long SEC = 1_000_000_000;  // Nano seconds used by JavaFX

    private int ballsLeft = 5;
    int points;

    private Ball ball;
    private List<Brick> bricks;
    private Paddle paddle;
    private List<Wall> walls;
    private Brick brickToRemove;

    // TODO Constructor that accepts all objects needed for the model


    public Breakout(Ball ball, List<Brick> bricks, Paddle paddle, List<Wall> walls) {
        this.ball = ball;
        this.bricks = bricks;
        this.paddle = paddle;
        this.walls = walls;
        brickToRemove = null;
        timeForLastHit = System.currentTimeMillis();
    }


    // --------  Game Logic -------------

    private long timeForLastHit;         // To avoid multiple collisions

    public void update(long now) {
        ball.updateBallPosition();

        if(shouldSpawnNewBall()){
            System.out.println("Should spawn new ball");
            spawnNewBall();
        }
        else{
            if(paddle.hasBeenHit(ball, paddle)){
                changeYDirectionPositive();
            }
            else if(hasCollidedWithBrick()){
                brickCollisionHandling();
            }
            else if(wallThatWasHit()!=null){
                if(wallThatWasHit().getDirection() == Wall.Dir.HORIZONTAL){
                    changeYDirection();
                }
                else if(wallThatWasHit().getDirection() == Wall.Dir.VERTICAL){
                    changeXDirection();
                }
            }

        }
    }

    // ----- Helper methods--------------

    public boolean shouldSpawnNewBall(){
        // Hade även kunnat slänga in > gameWidth || x2 < 0 för att gardera mot Buggar
        return ball.getY() > GAME_HEIGHT;
    }

    public void spawnNewBall(){
        ballsLeft--;
        ball = new Ball();
    }


    public void changeXDirection(){
        if(ball.shouldMoveRight()){
            ball.setDx(-ball.getDx());
        }
        else if (ball.shouldMoveLeft()){
            ball.setDx(-ball.getDx());
        }
    }

    public void changeYDirectionPositive(){
        ball.setDy(-ball.getDy());
    }

    public void changeYDirection(){
        if(ball.shouldMoveDown()){
            ball.setDy(-ball.getDy());
        }
        else if(!ball.shouldMoveDown()){
            changeYDirectionPositive();
        }
    }

    public void changeDirectionOfBall(){
        if(ball.shouldMoveRight() || ball.shouldMoveLeft()){
            changeXDirection();
        }
        else{
            changeYDirection();
        }
    }


    public Wall wallThatWasHit(){
        return walls.stream()
                .filter(wall -> wall.hasBeenHit(ball, wall))
                .findFirst()
                .orElse(null);
    }

    public boolean hasCollidedWithBrick(){
        for(Brick brick : bricks){
            if(brick.hasBeenHit(ball, brick)){
                brickToRemove = brick;
                return true;
            }
        }
        return false;
    }

    public void brickCollisionHandling(){
        // Ta reda på vart bollen bör ändra sig efter, så vi kan slopa changeDirectionOfBall
        points += brickToRemove.getPoints();
        bricks.remove(brickToRemove);
        changeDirectionOfBall();
    }


    // --- Used by GUI  ------------------------

    public List<IPositionable> getPositionables() {
        List<IPositionable> list = new ArrayList<>();
        list.add(paddle);
        list.add(ball);
        list.addAll(bricks);
        list.addAll(walls);
        return list;  // TODO return all objects to be rendered by GUI
    }

    public int getPoints() {
        return points;
    }

    public int getBallsLeft() {
        return ballsLeft;
    }

    public Paddle getPaddle() {
        return paddle;
    }
}
