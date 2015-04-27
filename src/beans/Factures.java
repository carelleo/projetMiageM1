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
	
	/**
	 * 
	 */
	public Factures() {
	}

	
	/**
	 * @param sujet
	 * @param montantAPayer
	 * @param detail
	 * @param mail
	 */
	public Factures(String sujet, int montantAPayer, String detail, String mail ) {
		this.sujet = sujet;
		this.montantAPayer = montantAPayer;
		this.detail = detail;
		this.mail = mail;
	}

	
	/**
	 * @return
	 */
	public String getSujet() {
		return sujet;
	}


	/**
	 * @param date
	 */
	public void setSujet(String date) {
		this.sujet = date;
	}
	
	/**
	 * @return
	 */
	public int getMontantAPayer() {
		return montantAPayer;
	}


	/**
	 * @param montantAPayer
	 */
	public void setmontantAPayer(int montantAPayer) {
		this.montantAPayer = montantAPayer;
	}
	
	

	/**
	 * @return
	 */
	public String getDetail() {
		return detail;
	}


	/**
	 * @param detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	/**
	 * @return
	 */
	public String getMail() {
		return mail;
	}




	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Factures [montantAPayer=" + montantAPayer + "]";
	}


	/**
	 * @param montantAPayer
	 */
	public void setMontantAPayer(int montantAPayer) {
		this.montantAPayer = montantAPayer;
	}


	/**
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

}