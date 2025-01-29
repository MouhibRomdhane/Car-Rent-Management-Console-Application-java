package agencelocation;

import java.util.ArrayList;
import java.util.Scanner;
public class LocEnCours {
    private ArrayList<Location> tablocation;
    //constructeur non parametrer
    public LocEnCours() {
        tablocation=new ArrayList<Location>();
    }
    //ajout une location si les conditions disponibiliter et l'existance de véhicule sont valide
    public void ajoutlocation(Parc p) {
        Location loc=new Location();
        boolean test;
       test= loc.saisieLocation(p);
        if(test==true)
        {tablocation.add(loc);
            System.out.println("Ajout location avec succee");}
        else
            System.out.println("echec d'ajout location");


    }
    //recherche la position d'une location selon matrecule et le numero CIN sinon retourner -1
    public int rechercheClienMat(String matr,int cin)
    {int i=0;
        int trouve=-1;


            while (i < tablocation.size() && trouve ==-1) {
                if((tablocation.get(i).getC().getCin()==cin)&&(tablocation.get(i).getV().getnumimmatrecul().equals(matr)))
                    trouve=i;
                else
                    i++;
            }

        return trouve;
    }
    //supprimer une location en cours selon une position donnee et remplire les tables de classe lochistorique
    public void supprimerlocation(int pos,LocHistorique loc) {

        Scanner s=new Scanner(System.in);
        String dateremise;
        int etatretour;
        EtatVech Et=new EtatVech();

         do {
             System.out.println("doonez la date de remise=");//condition date + date >datedebut
             dateremise = Tools.saisieDate();//date  < date fin else sopln("remarque:le client a retourné la voiture aprés la date correspandante  ")
         }while (Tools.datedifference(tablocation.get(pos).getDatedebut(),dateremise)<=0);
         if(Tools.datedifference(tablocation.get(pos).getDatefin(),dateremise)>0)
             Et.setRespectdate(false);
         else
             Et.setRespectdate(true);

            do  {
                System.out.println("est-ce que la voiture est remise dans un bon état?");
                System.out.println("                        1.oui                                      2.non");
                etatretour=s.nextInt();
            }while((etatretour!=1)&&(etatretour!=2));
            if (etatretour==2)
            {
                Et.setEtatv(false);
                tablocation.get(pos).getV().setetat(0);
            }
            else {
                Et.setEtatv(true);
                tablocation.get(pos).getV().setetat(1);
            }
            loc.ajoutLocHis(Et,tablocation.get(pos));
            tablocation.remove(pos);
        System.out.println("location est terminer");
    }
        //afficher les locationt en cours si le table est vide afficher ("aucune location en cours existant")
        public void afficherLocEnCours(){
        if(tablocation.size()==0)
            System.out.println("aucune location en cours existant");
        else{
            for(int i=0;i<tablocation.size();i++)
                System.out.println(tablocation.get(i).toString());
        }
        }
        //surcharge  de methode afficherLocEnCours() avec un parametre cin pour afficher les location d'un client presiser
    public void afficherLocEnCours(int cin){
        if(tablocation.size()==0)
            System.out.println("aucune location en cours existant");

        else {
            for (int i = 0; i < tablocation.size(); i++) {
                if (tablocation.get(i).getC().getCin() == cin)
                    System.out.println(tablocation.get(i).toString());
                else
                    System.out.println("aucune location pour le client de CIN=" + cin);
            }
        }
    }
    //retourner le nombre des location en cours dans une periode(dat1,dat2) a laide des methode de class Tools
public int nbLocationPeriod(String dat1,String dat2){
        int nb=0;
        for (int i=0 ;i<tablocation.size();i++) {
            if(Tools.DansDate(dat1,dat2,tablocation.get(i).getDatedebut())==true &&Tools.DansDate(dat1,dat2,tablocation.get(i).getDatefin())==true )
                nb++;
        }
        return nb;

}
    //retourner les revenues des location en cours dans une periode(dat1,dat2) a laide des methode de class Tools
    public float revenudansPeriod(String dat1,String dat2){
        float nb=0;
        for (int i=0 ;i<tablocation.size();i++) {
            if(Tools.DansDate(dat1,dat2,tablocation.get(i).getDatedebut())==true &&Tools.DansDate(dat1,dat2,tablocation.get(i).getDatefin())==true )
                nb+=tablocation.get(i).getPrixtotale();
        }
        return nb;

    }
    }





