package breakout.model;

/*
 *   A brick for the rows of bricks
 */

public class Brick extends BreakoutPiece implements IHitable{

    public static final double BRICK_WIDTH = 20;
    public static final double BRICK_HEIGHT = 10;
    private double x2;
    private double y2;
    public int points;

    @Override
    public String toString() {
        return "Brick{" +
                "x=" + x +
                " x2=" + x2 +
                " y=" + y +
                " y2=" + y2 +
                '}';
    }

    public int getPoints() {
        return points;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }


    @Override
    public boolean inXRange(Ball ball, BreakoutPiece br){
        return ball.getX() <= x2 && ball.getX() >= x;
    }

    @Override
    public boolean inYRange(Ball ball, BreakoutPiece br){
        return ball.getY() <= y2 && ball.getY() >= y;
    }

    @Override
    public double getWidth() {
        return BRICK_WIDTH;
    }

    @Override
    public double getHeight() {
        return BRICK_HEIGHT;
    }
}

