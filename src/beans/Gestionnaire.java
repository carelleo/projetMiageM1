package beans;

import java.util.*;

/**
 * 
 */
public class Gestionnaire extends Utilisateur implements InterfaceIntervention, InterfaceAvisPassage, InterfaceSuiteDemandePetitTravaux,InterfaceSuiteDemandeGrosTravaux, InterfaceFacture{
	
	
	private ArrayList <Intervention> planningintervention;
	
	public Gestionnaire(String mail, String motDePasse, String nom,
			String prenom, int NumeroTel, Boolean actif, ArrayList <Intervention> planningintervention) {
		super(NumeroTel, mail, motDePasse, nom);
		// TODO Auto-generated constructor stub
	
		this.setPlanningintervention(planningintervention);
	}


	/**
	 * @param suiteR
	 */
	public void SaisirSuiteRéclamation(String suiteR) {
		// TODO implement here
	}

	/**
	 * @param travaux 
	 * @return
	 */
	public void SaisirSuiteDemandePetitTravaux(String travaux) {
		// TODO implement here
		
	}

	/**
	 * @param travaux 
	 * @return
	 */
	public void SaisirSuiteDemandeGrosTravaux(String travaux) {
		// TODO implement here
		
	}

	/**
	 * @param DateAvisPassage 
	 * @return
	 */
	public void SaisirAvisDePassage(Date DateAvisPassage) {
		// TODO implement here
		
	}

	/**
	 * @param intervention
	 */
	public void SaisirPlanningIntervention(ArrayList<Intervention> intervention) {
		// TODO implement here
	}

	/**
	 * @param Q 
	 * @return
	 */
	public void PoserQuestion(String Q) {
		// TODO implement here
		
	}

	/**
	 * @param m
	 */
	public void SaisirFacture(int m) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public String toString() {
		// TODO implement here
		return "";
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
	public void CreerSuiteDemandePetitTravaux(String a, Date dp, Date dr) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void DetruireSuiteDemandePetitTravaux() {
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
	public Intervention CreerIntervention(Date db, Date df, String i) {
		return null;
		// TODO Auto-generated method stub
		
	}


	@Override
	public void Detruire() {
		// TODO Auto-generated method stub
		
	}


	public ArrayList <Intervention> getPlanningintervention() {
		return planningintervention;
	}


	public void setPlanningintervention(ArrayList <Intervention> planningintervention) {
		this.planningintervention = planningintervention;
	}

}