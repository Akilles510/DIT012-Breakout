package breakout.model;

import static breakout.model.Breakout.GAME_HEIGHT;
import static breakout.model.Breakout.GAME_WIDTH;

/*
 * A Paddle for the Breakout game
 *
 */
public class Paddle extends BreakoutPiece implements IHitable{

    public static final double PADDLE_WIDTH = 60;
    public static final double PADDLE_HEIGHT = 10;
    public static final double PADDLE_SPEED = 5;
    public static final double MOVEMENT_IN_X_AXIS = 5;

    public Paddle() {
        x = GAME_WIDTH / 2;
        y = GAME_HEIGHT - 10;
        x2 = x + PADDLE_WIDTH;
        y2 = y + PADDLE_HEIGHT;
    }

    @Override
    public String toString() {
        return "Paddle{" +
                "x=" + x +
                ", x2=" + x2 +
                ", y=" + y +
                ", y2=" + y2 +
                '}';
    }

    @Override
    public double getWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public double getHeight() {
        return PADDLE_HEIGHT;
    }

    public boolean canMoveToPositionLeft(){
        return x >= MOVEMENT_IN_X_AXIS;
    }
    public boolean canMoveToRight(){
        return x+PADDLE_WIDTH <= GAME_WIDTH-MOVEMENT_IN_X_AXIS;
    }

    public void updatePaddleXPosition(double change){
        x += change;
        x2 += change;
    }

    /*

    public boolean inXRange(double xPos, double xPos2){
        return (xPos <= x2 && xPos >= x) || (xPos2 <= x2 && xPos2 >= x);
    }

    public boolean inYRange(double yPos, double yPos2){
        return (yPos <= y2 && yPos >= y) || (yPos2 <= y2 && yPos2 >= y);
    }

    public boolean hasBeenHit(Ball ball) {
        return inXRange(ball.getX(), ball.getX2()) && inYRange(ball.getY(), ball.getY2());
    }
    */
}
