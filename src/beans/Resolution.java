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

	public Resolution() {
	}	
	
	public Resolution(String s, String c, String d, int p, int n, String e, int i){
        sujet = s;
        contenu = c;
        date = d;
        etat = e;
        positif = p;
        negatif = n;
        idU = i;
    }
    
    public void plus() {
        positif++;
    }
    
    public void moins() {
        negatif++;
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

    public int getIdU() {
        return idU;
    }

    public void setIdU( int idU ) {
        this.idU = idU;
    }
	
}