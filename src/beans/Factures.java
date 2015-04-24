package beans;

import org.joda.time.DateTime;


/**
 * 
 */

public class Factures {
	
	private String sujet;
	private int montantAPayer;
	private String detail;
	private String mail;
	
	public Factures() {
	}

	
	public Factures(String sujet, int montantAPayer, String detail, String mail ) {
		this.sujet = sujet;
		this.montantAPayer = montantAPayer;
		this.detail = detail;
		this.mail = mail;
	}

	
	public String getSujet() {
		return sujet;
	}


	public void setSujet(String date) {
		this.sujet = date;
	}
	
	public int getMontantAPayer() {
		return montantAPayer;
	}


	public void setmontantAPayer(int montantAPayer) {
		this.montantAPayer = montantAPayer;
	}
	
	

	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getMail() {
		return mail;
	}




	
	@Override
	public String toString() {
		return "Factures [montantAPayer=" + montantAPayer + "]";
	}


	public void setMontantAPayer(int montantAPayer) {
		this.montantAPayer = montantAPayer;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}

}