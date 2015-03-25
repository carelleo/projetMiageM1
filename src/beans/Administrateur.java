package beans;

import java.util.*;

/**
 * 
 */
public class Administrateur implements InterfaceIntervention, InterfaceSuiteDemandePetitTravaux, InterfaceSuiteReclamation, InterfaceAvisPassage,InterfaceSuiteDemandeGrosTravaux, InterfaceFacture, InterfaceReclamation, InterfaceResolution, InterfaceDemandeTravaux {


	private String type = "admin";
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    private String mdpc;
    private boolean condition;

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


	@Override
	public DemandeTravaux CreerDemandeTravaux(String de) {
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
		return "Administrateur";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getMdpc() {
		return mdpc;
	}

	public void setMdpc(String mdpc) {
		this.mdpc = mdpc;
	}

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	
}