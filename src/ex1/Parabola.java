package ex1;

public class Parabola {
    private int a;
    private int b;
    private int c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Punct varf() {
        double x = (double)-b / (2.0 * a);
        double y = (double) (-b*b+ 4*a*c)/(4* a);
        return new Punct(x, y);
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }


    public Punct mijlocVarf(Parabola p) {
        Punct varf1 = this.varf();
        Punct varf2 = p.varf();
        double mijlocX = (varf1.getX() + varf2.getX()) / 2;
        double mijlocY = (varf1.getY() + varf2.getY()) / 2;
        return new Punct(mijlocX, mijlocY);
    }

    public static Punct mijlocVarf(Parabola p1, Parabola p2) {
        Punct varf1 = p1.varf();
        Punct varf2 = p2.varf();
        double mijlocX = (varf1.getX() + varf2.getX()) / 2;
        double mijlocY = (varf1.getY() + varf2.getY()) / 2;
        return new Punct(mijlocX, mijlocY);
    }

    public double lungimeVarf(Parabola p) {
        Punct varf1 = this.varf();
        Punct varf2 = p.varf();
        return Math.hypot(varf2.getX() - varf1.getX(), varf2.getY() - varf1.getY());
    }

    public static double lungimeVarf(Parabola p1, Parabola p2) {
        Punct varf1 = p1.varf();
        Punct varf2 = p2.varf();
        return Math.hypot(varf2.getX() - varf1.getX(), varf2.getY() - varf1.getY());
    }
}
