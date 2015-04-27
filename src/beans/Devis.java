package beans;

import java.util.*;

public class Devis {
    private int id = 0;
    private String entreprise;
    private int montant;
    private String dateD;
    private String dateF;
    private int idT;
    
	/**
	 * 
	 */
	public Devis() {
	}
	
	/**
	 * @param i
	 * @param e
	 * @param m
	 * @param dd
	 * @param df
	 * @param it
	 */
	public Devis(int i, String e, int m, String dd, String df, int it){
	    id = i;
	    entreprise = e;
	    montant = m;
	    dateD = dd;
	    dateF = df;
	    idT = it;
	}

    /**
     * @return
     */
    public String getEntreprise() {
        return entreprise;
    }

    /**
     * @param entreprise
     */
    public void setEntreprise( String entreprise ) {
        this.entreprise = entreprise;
    }

    /**
     * @return
     */
    public int getMontant() {
        return montant;
    }

    /**
     * @param montant
     */
    public void setMontant( int montant ) {
        this.montant = montant;
    }

    /**
     * @return
     */
    public String getDateD() {
        return dateD;
    }

    /**
     * @param dateD
     */
    public void setDateD( String dateD ) {
        this.dateD = dateD;
    }

    /**
     * @return
     */
    public String getDateF() {
        return dateF;
    }

    /**
     * @param dateF
     */
    public void setDateF( String dateF ) {
        this.dateF = dateF;
    }

    /**
     * @return
     */
    public int getIdT() {
        return idT;
    }

    /**
     * @param idT
     */
    public void setIdT( int idT ) {
        this.idT = idT;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId( int id ) {
        this.id = id;
    }


}