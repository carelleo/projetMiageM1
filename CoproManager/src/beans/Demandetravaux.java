package beans;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Demandetravaux implements Serializable{

	
	private String demande;

	private int cptDemandeTravaux;

	/**
	 * 
	 */
	public Demandetravaux( String demande) {
		this.cptDemandeTravaux = 0;
		this.demande = demande;
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

}