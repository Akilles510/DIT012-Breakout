package breakout.model;

public class Position {

    double xPosition;
    double yPosition;

    public Position(double xPosition, double yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }
}
