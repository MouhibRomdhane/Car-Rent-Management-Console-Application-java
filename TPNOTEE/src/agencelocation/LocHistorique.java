package agencelocation;

import java.util.ArrayList;

public class LocHistorique {
    private ArrayList<Location> tablocationhistoriqueVech;//tableau de location
    private ArrayList<EtatVech> tablocationhistoriqueEt;//tableau de etat véhicule(dat remis et etat)
    //constructeur
    public LocHistorique() {
         tablocationhistoriqueVech=new ArrayList<Location>();
         tablocationhistoriqueEt=new ArrayList<EtatVech>();
    }
    //ajouter les location terminer et leur etat dans les liste;
    public void ajoutLocHis(EtatVech e,Location l)
    {
        tablocationhistoriqueVech.add(l);
        tablocationhistoriqueEt.add(e);
    }
    //affichage des locations terminer
public void afficherLocHis(){
    for (int i=0;i<tablocationhistoriqueEt.size();i++) {
        System.out.println( tablocationhistoriqueVech.get(i).toString() + tablocationhistoriqueEt.get(i).toString());
    }
}
    //retourner le nombre des location terminer dans une periode(dat1,dat2) a laide des methode de class Tools
    public int hesnbLocationPeriod(String dat1,String dat2){
        int nb=0;
        for (int i=0;i<tablocationhistoriqueVech.size();i++) {
            if(Tools.DansDate(dat1,dat2,tablocationhistoriqueVech.get(i).getDatedebut())==true &&Tools.DansDate(dat1,dat2,tablocationhistoriqueVech.get(i).getDatefin())==true )
                nb++;
        }
        return nb;

    }
    //retourner les revenues des location terminer dans une periode(dat1,dat2) a laide des methode de class Tools
    public float hesrevenudansPeriod(String dat1,String dat2){
        float nb=0;
        for (int i=0;i<tablocationhistoriqueVech.size();i++) {
            if(Tools.DansDate(dat1,dat2,tablocationhistoriqueVech.get(i).getDatedebut())==true &&Tools.DansDate(dat1,dat2,tablocationhistoriqueVech.get(i).getDatefin())==true )
                nb+=tablocationhistoriqueVech.get(i).getPrixtotale();
        }
        return nb;

    }
    //affichage Liste des clients à risque (Retard / mauvais état de véhicules rendus)
    public void afficherClientRisque()
    {
        for(int i=0;i<tablocationhistoriqueVech.size();i++) {
            if ((tablocationhistoriqueEt.get(i).isRespectdate() == false) || (tablocationhistoriqueEt.get(i).isEtatv() == false))
                System.out.println(tablocationhistoriqueVech.get(i).getC().toString());
        }

    }
}

