package ex2;

import java.time.LocalDate;

public class Produs {
    private String denumire;
    private float pret;
    private int cantitate;
    private LocalDate data_exp;

    public Produs(String denumire,float pret, int cantitate,LocalDate data_exp)
    {
        this.denumire=denumire;
        this.pret=pret;
        this.cantitate=cantitate;
        this.data_exp=data_exp;
    }
    public LocalDate getData_exp() {
        return data_exp;
    }

    public boolean dataexp()
    {
        return data_exp.isAfter(LocalDate.now());
    }

    public float getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }
    public String getDenumire()
    {
        return denumire;
    }

public static float incasari=0;
    public void vanzari(int cantitatevanduta) {
        if (cantitatevanduta <= cantitate) {
            cantitate = cantitate - cantitatevanduta;
            incasari= cantitatevanduta*pret;
            System.out.println("Produs vandut: " + denumire + " Cantitatea vanduta: "+ cantitatevanduta + " Cantitatea ramanasa " + cantitate);
            System.out.println("Incasari: " + incasari);
        }
        else {
            System.out.println("nu exista cantitate destula pe stoc");
        }


    }
    @Override
    public String toString()
   {
       return "(" + denumire + "," + pret + "," + cantitate + "," + data_exp + ")";
   }

}
