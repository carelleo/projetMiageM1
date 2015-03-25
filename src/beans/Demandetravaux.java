package beans;

import java.io.Serializable;

import org.joda.time.DateTime;

/**
 * 
 */
public class DemandeTravaux implements Serializable{

    private String sujet;
    private String contenu;
    private String date;
    private String etat;
    private int positif;
    private int negatif;

    //private int cptDemandeTravaux;
    
    public DemandeTravaux(){
    }
    
    public DemandeTravaux(String s, String c){
        sujet = s;
        contenu = c;
        date = new DateTime().toString("yyyy-MM-dd");
        etat = "NON_LU";
        positif = 0;
        negatif = 0;
    }

    /**
     * @param s
     */
    public void DemandeTravaux(String s) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getDemande() {
        // TODO implement here
        return "";
    }

    /**
     * @param s 
     * @return
     */
    public void setDemande(String s) {
        // TODO implement here
        
    }

    /**
     * 
     */
    public void addCompteurTravaux() {
        // TODO implement here
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet( String sujet ) {
        this.sujet = sujet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu( String contenu ) {
        this.contenu = contenu;
    }

    public String getDate() {
        return date;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat( String etat ) {
        this.etat = etat;
    }

    public int getPositif() {
        return positif;
    }

    public void setPositif( int positif ) {
        this.positif = positif;
    }

    public int getNegatif() {
        return negatif;
    }

    public void setNegatif( int negatif ) {
        this.negatif = negatif;
    }

}