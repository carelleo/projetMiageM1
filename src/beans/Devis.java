package beans;

import java.util.*;

public class Devis {
    private String entreprise;
    private int montant;
    private String dateD;
    private String dateF;
    
	public Devis() {
	}

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise( String entreprise ) {
        this.entreprise = entreprise;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant( int montant ) {
        this.montant = montant;
    }

    public String getDateD() {
        return dateD;
    }

    public void setDateD( String dateD ) {
        this.dateD = dateD;
    }

    public String getDateF() {
        return dateF;
    }

    public void setDateF( String dateF ) {
        this.dateF = dateF;
    }


}