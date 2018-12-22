package breakout.model;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static breakout.model.Breakout.GAME_HEIGHT;
import static breakout.model.Breakout.GAME_WIDTH;

/*
 *    A Ball for the Breakout game
 */

public class Ball extends BreakoutPiece {

    private double dx;
    private double dy;

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public Ball() {
        x = GAME_WIDTH/2;       // Start parametrar
        y = GAME_HEIGHT/2;      // Start PARAMETERAR
        dx = getRandomSpeed();
        dy = -getRandomSpeed();
        width = 8;
        height = 8;
        x2 = x + width;
        y2 = y + height;
    }

    public Ball(double x){
        super();
        setX(x);
        setX2(x + 8);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "x=" + x +
                ", x2=" + x2 +
                ", y=" + y +
                ", y2=" + y2 +
                '}';
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public boolean shouldMoveDown(){
        return y >= 0;
    }

    public boolean shouldMoveRight(){
        return  x <= Wall.WALL_WIDTH_VERTIKAL;
    }

    public boolean shouldMoveLeft(){
        return x2 >= GAME_WIDTH - Wall.WALL_WIDTH_VERTIKAL;
    }

    public double getRandomSpeed(){
        return ThreadLocalRandom.current().nextDouble(1.5,3);
    }

    public void updateBallPosition(){
        setX(x + dx);
        setY(y + dy);
        setX2(x2 + dx);
        setY2(y2 + dy);
    }

}

