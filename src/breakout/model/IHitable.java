package breakout.model;

public interface IHitable{

    default boolean inXRange(Ball ball, BreakoutPiece br){
        return (ball.getX() <= br.getX2() && ball.getX() >= br.getX());
    }

    default boolean inYRange(Ball ball, BreakoutPiece br){
        return (ball.getY() <= br.getY2() && ball.getY() >= br.getY());
    }

    default boolean hasBeenHit(Ball ball, BreakoutPiece br){
        return inXRange(ball, br) && inYRange(ball, br);
    }
}
