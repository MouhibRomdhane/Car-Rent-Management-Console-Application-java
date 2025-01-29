package agencelocation;
import java.util.Scanner;
public class Client {
    private int cin;
    private String nomprenom;
    private String adresse;
    //Methode pour saisir un client
    public void saisieClient(){
        Scanner s=new Scanner(System.in);
        do {

            System.out.println("Entrer N°CIN=");
            cin=s.nextInt();
        }while (String.valueOf(cin).length()!=8);
        s.nextLine();
        do {

            System.out.println("Entrer Nom et Prenom=");
            nomprenom=s.nextLine();
        }while (nomprenom.length()<7);
        do {
            System.out.println("Entrer L'adresse =");
            adresse=s.nextLine();
        }while (adresse.length()<7);

    }
    //les accesseurs d'un client
    public int getCin() {
        return cin;
    }
    public void setCin(int cin) {
        this.cin = cin;
    }
    public String getNomprenom() {
        return nomprenom;
    }
    public void setNomprenom(String nomprenom) {
        this.nomprenom = nomprenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
//redefinition de methode tostring
    public String toString() {
        return "Client [numéro de carte d'identité= " + cin + ", le nom et prénom= " + nomprenom + ", adresse= " + adresse + "]";
    }


}