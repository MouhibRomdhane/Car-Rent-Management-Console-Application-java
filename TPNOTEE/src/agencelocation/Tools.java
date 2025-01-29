package agencelocation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
// cette classe contient des methodes statique utiliser dans plusieurs class
public  class  Tools {
    //methode pour ajouter un espace dans le menu
    public static void  clear()
    {
        System.out.println("\n \n \n \n \n \n \n \n \n ");
    }
    //methode DansDate() permet verifier si la dat3 entre la dat1 et dat2
    public static boolean DansDate(String dat1,String dat2,String dat3){
        long n=datedifference(dat1,dat2);

        if((datedifference(dat1,dat3)>=0 && datedifference(dat1,dat3)<=n )&&(datedifference(dat2,dat3)<=0 && datedifference(dat2,dat3)>=-n ))
            return true;
        else
            return false;


    }
    //methode datedifference() permet de retourner le nombre de jour entre deux date
    // si la date de fin plus ancien que la date de debut alors retourner un nombre negative de jours
    public static long datedifference(String datedebut,String datefin){

        LocalDate dateBefore = LocalDate.parse(datedebut);
        LocalDate dateAfter = LocalDate.parse(datefin);


        long nbjour = ChronoUnit.DAYS.between(dateBefore, dateAfter);


        return nbjour;

    }
//permet de covertire des entier donnee a un date de type chaine de caractere selon le format (YYYY-MM-JJ)!!la class localdate accepte cette format
    public static String dateToStr(int j,int m,int y) {
        String jj,mm;
        if(j<10)
            jj="0"+j;
        else
            jj=String.valueOf(j);

        if(m<10)
            mm="0"+m;
        else
            mm=String.valueOf(m);

        return y+"-"+mm+"-"+jj;



    }

//methode permet de controler le saisir d'un date
    public static String saisieDate() {
        Scanner s=new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today=formatter.format(date).toString();
        int j,m,y;
        boolean test=true;
        do {
            if(test==false)
                System.out.println("date invalide ");
            test=true;

            System.out.print("Jour:");
            j=s.nextInt();
            System.out.print("Moi:");
            m=s.nextInt();
            System.out.print("Annee:");
            y= s.nextInt();
            if(String.valueOf(y).length()!=4 ||(m<0 || m>12)||(j<=0||j>31))
                test=false;
            else {
                if (m % 2 != 1 && m == 31)
                    test = false;
                else {
                    if (((y % 4 == 1 || y % 400 == 1) && (m > 28) && (m == 2)) || ((y % 4 == 0 || y % 400 == 0) && (m > 29) && (m == 2)))
                        test = false;
                    else{
                        if(datedifference(today,dateToStr(j,m,y))<0)
                            test=false;}
                }
            }
            }while (test==false);
        return dateToStr(j,m,y);
        }



    }

