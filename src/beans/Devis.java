package beans;

import java.util.*;

public class Devis {
    private int id = 0;
    private String entreprise;
    private int montant;
    private String dateD;
    private String dateF;
    private int idT;
    
	public Devis() {
	}
	
	public Devis(int i, String e, int m, String dd, String df, int it){
	    id = i;
	    entreprise = e;
	    montant = m;
	    dateD = dd;
	    dateF = df;
	    idT = it;
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

    public int getIdT() {
        return idT;
    }

    public void setIdT( int idT ) {
        this.idT = idT;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }


}