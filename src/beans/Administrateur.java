package beans;

import java.util.*;

/**
 * 
 */
public class Administrateur extends Utilisateur implements InterfaceIntervention, InterfaceSuiteDemandePetitTravaux, InterfaceSuiteReclamation, InterfaceAvisPassage,InterfaceSuiteDemandeGrosTravaux, InterfaceFacture, InterfaceReclamation, InterfaceResolution, InterfaceDemandeTravaux {


	private ArrayList<Utilisateur> ListeUtilisateur;

	public Administrateur(String mail, String motDePasse, String nom,
			String prenom, int NumeroTel, Boolean actif,ArrayList<Utilisateur> ListeUtilisateur ) {
		super(mail, motDePasse, nom, prenom, NumeroTel, actif);
		// TODO Auto-generated constructor stub
		this.ListeUtilisateur = ListeUtilisateur;
		
	}

	/**
	 * @param u 
	 * @return
	 */
	public void ActiverCompte(Utilisateur u) {
		// TODO implement here
		
	}

	/**
	 * @param u 
	 * @return
	 */
	public void DésactiverCompte(Utilisateur u) {
		// TODO implement here
		
	}


	public ArrayList<Utilisateur> getListeUtilisateur() {
		return ListeUtilisateur;
	}


	public void setListeUtilisateur(ArrayList<Utilisateur> listeUtilisateur) {
		ListeUtilisateur = listeUtilisateur;
	}


	@Override
	public Demandetravaux CreerDemandeTravaux(String de) {
		return null;
		// TODO Auto-generated method stub
		
	}


	@Override
	public Resolution CreerResolution(String r) {
		return null;
		// TODO Auto-generated method stub
		
	}


	@Override
	public void DetruireResolution() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Reclamation CreerReclamation(String r) {
		return new Reclamation(r);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DetruireReclamation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Factures CreerFacture(int montant) {
		return null;
		// TODO Auto-generated method stub
		
	}


	@Override
	public void DetruireFacture() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void CreerSuiteDemandeGrosTravaux(ArrayList<Devis> ld,
			ArrayList<Entreprise> le) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void DetruireDemandeTravaux() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Avisdepassage CreerAvisPassage(String objet, Date d) {
		return null;
		// TODO Auto-generated method stub
		
	}


	@Override
	public void DetruireAvisPassage() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void CreerSuiteReclamation(String s) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void DetruireSuiteReclamation() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void CreerSuiteDemandePetitTravaux(String a, Date dp, Date dr) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void DetruireSuiteDemandePetitTravaux() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Intervention CreerIntervention(Date db, Date df, String i) {
		return null;
		// TODO Auto-generated method stub
		
	}


	@Override
	public void Detruire() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Administrateur [ListeUtilisateur=" + ListeUtilisateur + "]";
	}

	
}