package agencelocation;

import java.util.Scanner;


public class Location {
    private Véhicule v;
    private Client c;
    private float prixtotale;
    private float montantavancee;
    private String datedebut;
    private String datefin;
//constructeur non parametrer
    public Location() {
        v=new Véhicule();
        c=new Client();
        prixtotale=0;
        montantavancee=0;
        datedebut="";
        datefin="";
    }
//saire une location selon une matrecule de voiture existe et disponible
    public boolean saisieLocation(Parc p){
        Scanner s=new Scanner(System.in);
        String mat;
        boolean test=true;
        c.saisieClient();
        System.out.println("Entrer le Numéro d’immatriculation=");

        mat=s.next();
        if(p.recherchevech(mat)<0)
        {  System.out.println("véhicule n'existe pas");
        test=false;
        }
        else {
            if(p.getVech(p.recherchevech(mat)).getetat().equals("Loué")||p.getVech(p.recherchevech(mat)).getetat().equals("en cours de Réparation"))
            {System.out.println("véhicul indisponible");
            test=false;}
        else {
            v = p.getVech(p.recherchevech(mat));
            v.setetat(2);
            System.out.println("donnez le date de début pour cette location= ");//controle de date
            datedebut = Tools.saisieDate();
            do {
                System.out.println("donnez le date de fin pour cette location=");//controle de date
                datefin = Tools.saisieDate();
            } while (Tools.datedifference(datedebut, datefin) <= 0); //il faux que la dte de debut plus ancien que la date de fin


            prixtotale = Tools.datedifference(datedebut, datefin) * v.getprixjour();//calcule de prix total =jour * prix par jour
            do {
                System.out.println("donnez la montant avancée=");
                montantavancee = s.nextFloat();
            } while ((montantavancee <= 0) || (montantavancee > prixtotale));

        }
    }
    return test;}
    //les accesseurs
    public Véhicule getV() {
        return v;
    }
    public void setV(Véhicule v) {
        this.v = v;
    }
    public Client getC() {
        return c;
    }
    public void setC(Client c) {
        this.c = c;
    }
    public float getPrixtotale() {
        return prixtotale;
    }
    public void setPrixtotale(float prixtotale) {
        this.prixtotale = prixtotale;
    }
    public float getMontantavancee() {
        return montantavancee;
    }
    public void setMontantavancee(float montantavancee) {
        this.montantavancee = montantavancee;
    }
    public String getDatedebut() {
        return datedebut;
    }
    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }
    public String getDatefin() {
        return datefin;
    }
    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }
    //redefinition de methode tostring
    public String toString() {
        return  "cette location de" +c.toString()+" avec "+v.toString()+ ", de prix totale=" + prixtotale + ", et de montant avancée=" + montantavancee
                + ", la date de début de location=" + datedebut + ", la date de fin=" + datefin + "]";
    }

    public boolean equals(Object o) {
        Location loc=(Location) o;
        return v.equals(loc.v);
    }
}



