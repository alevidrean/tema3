package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) throws FileNotFoundException {

  String denumire;
  float pret;
  int cantitate;
  LocalDate data_exp;
        List<Produs> produse=new ArrayList<Produs>();
        Scanner scanner=new Scanner(new File("src/ex2/produse.csv"));
int k=0;

        while(scanner.hasNext())
        {
       String[] val=scanner.nextLine().split(",");
       denumire=val[0];
       pret=Float.parseFloat(val[1]);
       cantitate=Integer.parseInt(val[2]);
       data_exp=LocalDate.parse(val[3]);
       produse.add(new Produs(denumire,pret,cantitate,data_exp));

        }
        scanner.close();

        Scanner scanner1=new Scanner(System.in);
        int opt;
        PrintStream out=new PrintStream(new File("src/ex2/out.txt"));
        do{
            System.out.println("1.Afisati produsele.");
            System.out.println("2.Afisarea produselor expirate");
            System.out.println("3.Vanzarea unui produs");
            System.out.println("4.Afisarea produselor cu pretul minim");
            System.out.println("5.Salvarea produselor cu cantitate minima in fisier");
            System.out.println("6.exit");
            System.out.println("Introduceti optiunea:");
            opt=scanner1.nextInt();

            switch (opt)
            {
                case 1:
                    for(Produs produs:produse)
                    {
                        System.out.println(produs);
                    }
                    break;
                case 2:for(Produs produs:produse)
                {
                    if(produs.dataexp()==false)
                        System.out.println("Produse expirate:"+produs);
                }
                    break;
                case 3:
                    System.out.println("Denumire:");
                    String denumirea=scanner1.next();
                    System.out.println("Cantitatea de vandut:");
                    int cantitatea=scanner1.nextInt();

                   for (Produs produs : produse) {
                       if (produs.getDenumire().equals(denumirea))
                       {
                           produs.vanzari(cantitatea);
                       }
                       if(produs.getCantitate()==0)
                       {
                           produse.remove(produs);
                       }

                   }
                    break;
                case 4:
                    float pretminim;
                    pretminim=Integer.MAX_VALUE;
                    for (Produs p:produse) {
                        if (p.getPret() < pretminim) {
                            pretminim = p.getPret();
                        }
                    }
                    for (Produs p:produse) {
                        if(p.getPret()==pretminim)
                            System.out.println(p);

                    }

                    break;
                case 5:
                    System.out.println("Introduceti cantitatea:");
                    int cantitat=scanner1.nextInt();
                    for(Produs produs:produse)
                    {
                        if(produs.getCantitate()<cantitat)
                            out.println("Produsele cu valoarea cantitatii mai mica:"+produs);
                    }
                    break;
                case 6:scanner1.close();
                out.close();
                System.exit(0);
                    break;
                default:
                    System.out.println("Nu ati introdus optiunea buna!");
                    break;
            }




        }while(true);
    }
}
