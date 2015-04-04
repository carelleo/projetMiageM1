package beans;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class ReponseGrostravaux extends Reponsedemandetravaux implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Entreprise> listeEntreprise;
	private ArrayList<Devis> listeDevis;

	/**
	 * 
	 */
	public ReponseGrostravaux(Boolean refus, String Message,ArrayList<Entreprise> listeEntreprise,ArrayList<Devis> listeDevis ) {
		super(refus, Message);
		// TODO Auto-generated constructor stub
		this.setListeEntreprise(listeEntreprise);
		this.setListeDevis(listeDevis); 
	}


	/**
	 * @return
	 */
	public ArrayList<Entreprise> getListeE() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public ArrayList<Devis> getListeD() {
		// TODO implement here
		return null;
	}


	public ArrayList<Entreprise> getListeEntreprise() {
		return listeEntreprise;
	}


	public void setListeEntreprise(ArrayList<Entreprise> listeEntreprise) {
		this.listeEntreprise = listeEntreprise;
	}


	public ArrayList<Devis> getListeDevis() {
		return listeDevis;
	}


	public void setListeDevis(ArrayList<Devis> listeDevis) {
		this.listeDevis = listeDevis;
	}

}