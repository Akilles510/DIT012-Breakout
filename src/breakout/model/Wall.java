package breakout.model;

/*
        A wall for the ball to bounce
 */
public class Wall extends BreakoutPiece implements IHitable{

    private Dir direction;
    private double width;
    private double height;
    public static final double WALL_WIDTH_VERTIKAL = 3;

    public Wall(Dir direction, double xPos) {
        this.direction = direction;
        initializeCorrectWall(xPos);
    }

    public enum Dir {
        HORIZONTAL, VERTICAL
    }

    @Override
    public String toString() {
        return "Wall{" +
                "x=" + x +
                ", x2=" + x2 +
                ", y=" + y +
                ", y2=" + y2 +
                '}';
    }

    private void initializeCorrectWall(double xPos){
        if(direction == Dir.HORIZONTAL){
           width = Breakout.GAME_WIDTH;
           height = 3;
           x = 0;
           x2 = x + Breakout.GAME_WIDTH;
           y2 = y + height;
        }
        else{
            height = Breakout.GAME_HEIGHT;
            y2 = y + height;
            if(xPos >= Breakout.GAME_WIDTH / 2 ){
                x = Breakout.GAME_WIDTH - WALL_WIDTH_VERTIKAL;
                x2 = x + WALL_WIDTH_VERTIKAL;
            }
            else{
                x2 = x + WALL_WIDTH_VERTIKAL;
            }
        }
    }

    public Dir getDirection() {
        return direction;
    }


    @Override
    public boolean inXRange(Ball ball, BreakoutPiece br){
        if(x > Breakout.GAME_WIDTH/2){
            return ball.getX2() >= (br.getX()) && ball.getX2() <= br.getX2();
        }
        else{
            return ball.getX() <= width;
        }

    }
}
