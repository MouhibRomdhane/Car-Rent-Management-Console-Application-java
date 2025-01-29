package agencelocation;

import java.util.ArrayList;
import java.util.Scanner;


public class Parc {
    private ArrayList<Véhicule> vech;
    //constructeur non parametrer
    public Parc() {
        vech=new ArrayList<Véhicule>();
    }
    //Methode pour afficher le contenue du parc
    public void affichagevechparc() {
        if(vech.size()==0)
            System.out.println("Le parc est vide=");
        else {
            Véhicule current;
            for (int i = 0; i < vech.size(); i++) {
                current =  vech.get(i);
                System.out.println(current.toString());
                ;

            }
        }
    }
    //surcharge pour la methode affichagevechparc()  pour l'affichage des véhicule selon l'etat
    public void affichagevechparc(String etat) {
        if(vech.size()==0)
            System.out.println("Le parc est vide=");
        else {
            Véhicule current;
            for (int i = 0; i < vech.size(); i++) {

                current =  vech.get(i);
                if(current.getetat().equals(etat))
                System.out.println(current.toString());
                ;

            }
        }
    }
    //methode d'ajout un véhicule dans le parc sans repetition du voiture (selon num matrecule)
    public boolean ajoutparc(Véhicule current) {
        if(recherchevech(current.getnumimmatrecul())<0)
        {
            vech.add(current);
            return true;
        }
        else
        {
            return false;
        }

    }
    //methode retourner la position de véhicule dans le aarayliste si retourne -2 si n'existe pas /-1 si arraylist est vide sinon la position
    public int recherchevech(String matr)
    {int i=0;
        int trouve=-2;
        if(vech.isEmpty())
return -1;
        else {
            while (i < vech.size() && trouve ==-2) {
                if(vech.get(i).getnumimmatrecul().equals(matr))
                    trouve=i;
                else
                    i++;
            }
        }
        return trouve;
    }
    //supprision de véhicule selon leur position dans le arryliste
    public void suppressionparc(int i) {
 vech.remove(i);



    }
    //modification de l'etat de véhicule selon  position et num etat donnee
    public void setetatparc( int pos,int etat) {

            vech.get(pos).setetat(etat);

        }
    //les accesseurs
    public Véhicule getVech(int pos)
    {
        return vech.get(pos);
    }

}
