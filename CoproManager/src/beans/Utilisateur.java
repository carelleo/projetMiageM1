package beans;

import java.util.*;

/**
 * 
 */
public class Utilisateur {

	private String mail;
	private String motDePasse;
	private String nom;
	private String prenom;
	private int NumeroTel;
	private Boolean actif;

	/**
	 * 
	 */
	public  Utilisateur( String mail, String motDePasse, String nom, String prenom, int NumeroTel, Boolean actif) {
		// TODO implement here
		this.setMotDePasse(motDePasse);
		this.setMail(mail);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setNumeroTel(NumeroTel);
		this.actif = false;
	}

	/**
	 * @param mail 
	 * @param motdepasse 
	 * @return
	 */
	public void Connexion(String mail, String motdepasse) {
		// TODO implement here
		
	}


	/**
	 * @return
	 */
	public Boolean getActif() {
		// TODO implement here
		return null;
	}

	/**
	 * @param b 
	 * @return
	 */
	public void setActif(Boolean b) {
		// TODO implement here
		
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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

	public int getNumeroTel() {
		return NumeroTel;
	}

	public void setNumeroTel(int numeroTel) {
		NumeroTel = numeroTel;
	}

}