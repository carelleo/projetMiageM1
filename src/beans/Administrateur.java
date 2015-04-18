package beans;

import java.util.*;

/**
 * 
 */
public class Administrateur {


	private String type = "admin";
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    private String mdpc;
    private boolean condition;
    private int teleF = 0;
    private int teleP = 0;
    private String adresse = null;
    
    public Administrateur(){
    }
    
    public Administrateur(String n, String p, String ma, String m){
        nom = n;
        prenom = p;
        mail = ma;
        mdp = m;
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

    public int getTeleF() {
        return teleF;
    }

    public void setTeleF( int teleF ) {
        this.teleF = teleF;
    }

    public int getTeleP() {
        return teleP;
    }

    public void setTeleP( int teleP ) {
        this.teleP = teleP;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

	
}