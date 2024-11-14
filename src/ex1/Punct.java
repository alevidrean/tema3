package ex1;

public class Punct {
    private double x, y;

    public Punct(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
