package agencelocation;

public class EtatVech {
    private boolean respectdate;//si le client respecter la date de remis ou non
    private boolean etatv;// si le véhicule a été remis dans un bon état ou non.
 //getter and setter
    public boolean isRespectdate() {
        return respectdate;
    }

    public boolean isEtatv() {
        return etatv;
    }

    public void setRespectdate(boolean respectdate) {
        this.respectdate = respectdate;
    }

    public void setEtatv(boolean etatv) {
        this.etatv = etatv;
    }

    @Override
    public String toString() {
        String resdat,etat;
        if(respectdate==false)
            resdat="Retard";
        else
            resdat="au temps";
        if (etatv==false)
            etat="mouvais état";
        else
            etat="bon état";
        return "L'etat de véhicule="+etat+"remis de véhicule="+resdat;

    }
}
