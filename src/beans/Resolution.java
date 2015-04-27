package beans;

import java.io.Serializable;
import java.util.*;

import org.joda.time.DateTime;

/**
 * 
 */
@SuppressWarnings("serial")
public class Resolution implements Serializable{
	
    private String sujet;
    private String contenu;
    private String date = new DateTime().toString("yyyy-MM-dd");
    private String etat = "NON LU";
    private int positif = 0;
    private int negatif = 0;
    private int idU = 0;

	/**
	 * 
	 */
	public Resolution() {
	}	
	
	/**
	 * @param s
	 * @param c
	 * @param d
	 * @param p
	 * @param n
	 * @param e
	 * @param i
	 */
	public Resolution(String s, String c, String d, int p, int n, String e, int i){
        sujet = s;
        contenu = c;
        date = d;
        etat = e;
        positif = p;
        negatif = n;
        idU = i;
    }
    
    /**
     * 
     */
    public void plus() {
        positif++;
    }
    
    /**
     * 
     */
    public void moins() {
        negatif++;
    }

    /**
     * @return
     */
    public String getSujet() {
        return sujet;
    }

    /**
     * @param sujet
     */
    public void setSujet( String sujet ) {
        this.sujet = sujet;
    }

    /**
     * @return
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * @param contenu
     */
    public void setContenu( String contenu ) {
        this.contenu = contenu;
    }

    /**
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate( String date ) {
        this.date = date;
    }

    /**
     * @return
     */
    public String getEtat() {
        return etat;
    }

    /**
     * @param etat
     */
    public void setEtat( String etat ) {
        this.etat = etat;
    }

    /**
     * @return
     */
    public int getPositif() {
        return positif;
    }

    /**
     * @param positif
     */
    public void setPositif( int positif ) {
        this.positif = positif;
    }

    /**
     * @return
     */
    public int getNegatif() {
        return negatif;
    }

    /**
     * @param negatif
     */
    public void setNegatif( int negatif ) {
        this.negatif = negatif;
    }

    /**
     * @return
     */
    public int getIdU() {
        return idU;
    }

    /**
     * @param idU
     */
    public void setIdU( int idU ) {
        this.idU = idU;
    }
	
}