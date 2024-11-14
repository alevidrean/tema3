package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Parabola> parabole = new ArrayList<>();
        Scanner scanner=new Scanner(new File("src/ex1/in.txt"));

        while(scanner.hasNext())
        {
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int c=scanner.nextInt();
            parabole.add(new Parabola(a, b, c));
        }
        for (Parabola p : parabole) {
            System.out.println(p.toString());
            Punct varf = p.varf();
            System.out.println("Vârful parabolei: " + varf);
        }

        if (parabole.size() >= 2) {
            Parabola p1 = parabole.get(0);
            Parabola p2 = parabole.get(1);
            Punct mijlocinstanta= p1.mijlocVarf(p2);
            System.out.println("Mijlocul segm care uneste vf parab curente cu o parab" + mijlocinstanta);
            Punct mijloc = Parabola.mijlocVarf(p1, p2);
            System.out.println("Mijlocul segmentului care unește vârfurile celor două parabole: " + mijloc);

            double lungime = Parabola.lungimeVarf(p1, p2);
            System.out.println("Lungimea segmentului care unește vârfurile celor două parabole: " + lungime);
        }
    }

}
