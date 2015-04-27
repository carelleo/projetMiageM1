package beans;

public class Budget {
	
	
	private int annee;
	private int budgetEau;
	private int budgetElectricite;
	private int budgetGaz;
	private int budgetEntretien;
	private String commentaire;
	private int idS;
	
	
	/**
	 * 
	 */
	public Budget() {
	}

	
	/**
	 * @param annee
	 * @param budgetEau
	 * @param budgetElectricite
	 * @param budgetGaz
	 * @param budgetEntretien
	 * @param commentaire
	 * @param idS
	 */
	public Budget(int annee, int budgetEau, int budgetElectricite, int budgetGaz, int budgetEntretien, String commentaire,int idS ) {
		this.annee = annee;
		this.budgetEau = budgetEau;
		this.budgetElectricite = budgetElectricite;
		this.budgetGaz = budgetGaz;
		this.budgetEntretien = budgetEntretien; 
		this.commentaire=commentaire;
		this.idS = idS;
	}


	/**
	 * @return
	 */
	public int getAnnee() {
		return annee;
	}


	/**
	 * @param annee
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/**
	 * @return
	 */
	public int getBudgetEau() {
		return budgetEau;
	}


	/**
	 * @param budgetEau
	 */
	public void setBudgetEau(int budgetEau) {
		this.budgetEau = budgetEau;
	}


	/**
	 * @return
	 */
	public int getBudgetElectricite() {
		return budgetElectricite;
	}


	/**
	 * @param budgetElectricite
	 */
	public void setBudgetElectricite(int budgetElectricite) {
		this.budgetElectricite = budgetElectricite;
	}


	/**
	 * @return
	 */
	public int getBudgetGaz() {
		return budgetGaz;
	}


	/**
	 * @param budgetGaz
	 */
	public void setBudgetGaz(int budgetGaz) {
		this.budgetGaz = budgetGaz;
	}


	/**
	 * @return
	 */
	public int getBudgetEntretien() {
		return budgetEntretien;
	}


	/**
	 * @param budgetEntretien
	 */
	public void setBudgetEntretien(int budgetEntretien) {
		this.budgetEntretien = budgetEntretien;
	}


	/**
	 * @return
	 */
	public String getCommentaire() {
		return commentaire;
	}


	/**
	 * @param commentaire
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	/**
	 * @return
	 */
	public int getIdS() {
		return idS;
	}


	/**
	 * @param idS
	 */
	public void setIdS(int idS) {
		this.idS = idS;
	}






}
