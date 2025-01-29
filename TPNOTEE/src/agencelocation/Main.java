package agencelocation;

import java.util.Scanner;
public class Main {
    //methode pour controler l'entrer de choix
    public static int controlChoix(int a, int b) {
        Scanner s = new Scanner(System.in);
        int val;
        boolean test = true;
        do {
            if (test == false)
                System.out.println("choix invalide");
            test = true;
            val = s.nextInt();
            if (val < a && val > b)
                test = false;


        } while (test = false);

        return val;
    }


    public static void main(String[] args) {
        int choix;
        boolean test;
        Scanner s = new Scanner(System.in);
        Parc parc1 = new Parc(); //instance de class parc
        LocEnCours loc = new LocEnCours();//instance de class LocEnCours
        LocHistorique loch = new LocHistorique();//instance de class LocHistorique

        do {



            System.out.println("1. Gestion du Parc de l’Agence :");
            System.out.println("2. Gestion Locations :");
            System.out.println("3. Statistiques :");
            System.out.println("4. Quitter :");

            choix = controlChoix(1, 4);


            switch (choix) {
                case 1: {
                    do {
                        Tools.clear();
                        System.out.println("Gestion du Parc de l’Agence :");
                        System.out.println("1. Nouvelle acquisition");
                        System.out.println("2. Modification de l’Etat d’un Véhicule");
                        System.out.println("3. Suppression d’un Véhicule");
                        System.out.println("4. Consultation Parc");
                        System.out.println("5. Liste des véhicules loués");
                        System.out.println("6. Liste des véhicules en cours de réparation");
                        System.out.println("7. Liste des véhicules disponibles");
                        System.out.println("8. Retour :");
                        choix = controlChoix(1, 8);
                        switch (choix) {
                            case 1: {
                                Véhicule car = new Véhicule();
                                car.saisievehicul();
                                test = parc1.ajoutparc(car);
                                if (test == true)
                                    System.out.println("la voiture ajouter avec succe");
                                else
                                    System.out.println("Cette voiture déja existe dans le parc ");
                                break;
                            }
                            case 2: {
                                int choix2;
                                String matrecul = "";
                                do {
                                    if (parc1.recherchevech(matrecul) == -1 && matrecul!="")
                                        System.out.println("parc est vide");
                                    else
                                    {
                                        if (parc1.recherchevech(matrecul) == -2 && matrecul!="")
                                        System.out.println("voiture n'existe pas");}
                                    System.out.println("donnez la matricule de voiture à modifier l'état=");
                                    matrecul = s.next();
                                } while (parc1.recherchevech(matrecul) == -2);
                                System.out.println("donnez le nouveau état");
                                System.out.println("0.  en cours de Réparation");
                                System.out.println("1.  Disponible");
                                System.out.println("2.  Loué");
                                choix2 = controlChoix(0, 2);
                                parc1.setetatparc(parc1.recherchevech(matrecul), choix2);
                                System.out.println("l'état de voiture a été changé");
                                break;

                            }
                            case 3: {
                                System.out.println("donnez la matricule de voiture à supprimer");
                                String matricule2;
                                matricule2 = s.next();
                                if ((parc1.recherchevech(matricule2)) == -2) {
                                    System.out.println("voiture inéxistante");
                                } else {
                                    if ((parc1.recherchevech(matricule2)) == -1)
                                        System.out.println("parc est vide");
                                    else {
                                        parc1.suppressionparc(parc1.recherchevech(matricule2));
                                        System.out.println("voiture est supprimée");
                                    }

                                }
                                break;
                            }
                            case 4: {
                                parc1.affichagevechparc();
                                break;
                            }
                            case 5: {
                                parc1.affichagevechparc("Loué");
                                break;
                            }
                            case 6: {
                                parc1.affichagevechparc("en cours de Réparation");
                                break;
                            }
                            case 7: {
                                parc1.affichagevechparc("Disponible");
                                break;
                            }
                        }
                    } while (choix != 8);
                    break;
                }
                case 2: {
                    do { Tools.clear();
                        System.out.println("Gestion Locations :");
                        System.out.println("1. Nouvelle Location");
                        System.out.println("2. Fin de Location");
                        System.out.println("3. Consultation des locations en cours");
                        System.out.println("4. Consultation des Véhicules Loués par un client");
                        System.out.println("5. Historique des locations");
                        System.out.println("6. retour");
                        choix = controlChoix(1, 6);
                        switch (choix) {
                            case 1:{

                                loc.ajoutlocation(parc1);
                                break;

                            }
                            case 2: {
                                String mat;
                                int cin;
                                System.out.println("entrer le CIN de client=");
                                cin = s.nextInt();
                                System.out.println("Entre le Matrecule de véhicule loué:");
                                mat = s.next();
                                if (loc.rechercheClienMat(mat, cin) == -1)
                                    System.out.println("Location introuvable");
                                else
                                    loc.supprimerlocation(loc.rechercheClienMat(mat, cin), loch);
                                break;
                            }
                            case 3:
                            {
                                loc.afficherLocEnCours();
                                break;
                            }
                            case 4: {
                                int cin;
                                System.out.println("entrer le CIN de client=");
                                cin = s.nextInt();
                                loc.afficherLocEnCours(cin);
                                break;

                            }
                            case 5: {
                                loch.afficherLocHis();
                                break;
                            }

                        }
                    } while (choix != 6);

                    break;
                }
                case 3: {
                    do { Tools.clear();
                        System.out.println("Statistiques :");
                        System.out.println("0. Nombre de locations pour une période déterminée");
                        System.out.println("1. Total des revenus pour une période déterminée");
                        System.out.println("2. Liste des clients à risque");
                        System.out.println("3. retour");

                        choix = controlChoix(0, 3);
                        switch (choix) {
                            case 0: {
                                String dat1, dat2;
                                do {
                                    System.out.println("Entre date de debut de periode=");
                                    dat1 = Tools.saisieDate();
                                    System.out.println("Entre date de fin de periode=");
                                    dat2 = Tools.saisieDate();

                                } while (Tools.datedifference(dat1, dat2) < 0);
                                System.out.println("nombre de location pour la periode(" + dat1 + "," + dat2 + ")=" + (loch.hesnbLocationPeriod(dat1, dat2) + loc.nbLocationPeriod(dat1, dat2)));

                                break;
                            }
                            case 1: {
                                String dat1, dat2;
                                do {
                                    System.out.println("Entre date de debut de periode=");
                                    dat1 = Tools.saisieDate();
                                    System.out.println("Entre date de fin de periode=");
                                    dat2 = Tools.saisieDate();

                                } while (Tools.datedifference(dat1, dat2) < 0);
                                System.out.println("Totale de revenue pour la periode(" + dat1 + "," + dat2 + ")=" + (loch.hesrevenudansPeriod(dat1, dat2) + loc.revenudansPeriod(dat1, dat2)));

                                break;
                            }
                            case 2: {
                                System.out.println("liste des clients a risque=");
                                loch.afficherClientRisque();
                                break;
                            }
                        }
                    } while (choix != 3);
                    break;
                }
            }
            Tools.clear();
        } while (choix != 4);


    }
}
