package agencelocation;

import java.util.Scanner;


public class Véhicule {
    private String numimmatrecul;
    private String marquecommercial;
    private String construct;
    private String etat;
    private float  prixjour; //pour le faciliter de calculer le prix totale
//constructeur non parametrer
    public Véhicule()
    { Scanner s=new Scanner(System.in);
      prixjour=0;
        //saisie numimmatrecul
        numimmatrecul="";
        //saisie marque commercial
        marquecommercial="";
        construct="";
        etat="Disponible";
    }
    //Methode pour saisir de véhicule
    public void saisievehicul()
    {
        Scanner s=new Scanner(System.in);
        do{
            System.out.println("Entrer le Numéro d’immatriculation=");
            numimmatrecul=s.next();}while(numimmatrecul.length()<7);
        System.out.println("Entrer le constructeur=");
        construct=s.next();
        System.out.println("Entrer la marque de véhicule=");
        marquecommercial=s.next();
        do {
            System.out.println("Entrer le prix de jour de véhicule=");
            prixjour=s.nextFloat();
        }while(prixjour<=0);

    }

    public String getnumimmatrecul() {
        return numimmatrecul;
    }
    public void setnumimmatrecul(String b) {
        numimmatrecul = b;
    }
    public String getmarquecommercial() {
        return marquecommercial;
    }
    public void setmarquecommercial(String s) {
        marquecommercial = s;
    }
    public String getetat() {
        return etat;
    }
    public void setetat(int a) {
        if (a==0)
        { etat="en cours de Réparation";

        }
        else if (a==1)
        { etat="Disponible";

        }
        else if (a==2)
        { etat="Loué";

        }
        else
            System.out.println("erreur de code");// utuliser juste pour savoir si'il y a problème de saisie

    }

    public String getconstruct() {
        return construct;
    }
    public void setconstruct(String construct) {
        this.construct = construct;
    }
    public float getprixjour() {
        return prixjour;
    }
    public void setprixjour(float prixjour) {
        this.prixjour = prixjour;
    }
    //redefinition de methode tostring
    public String toString() {
        return "numéro de matricule= " + numimmatrecul + ", marque commercial=" + marquecommercial + ", Le constructeur="
                + construct + ", état=" + etat ;
    }


    public boolean equals(Object o) {
        Véhicule current=(Véhicule)o;
        if((numimmatrecul==current.numimmatrecul)&&(marquecommercial==current.marquecommercial))
        {
            return true;
        }
        else return false;
    }



}

