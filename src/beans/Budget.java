package beans;

public class Budget {
	
	
	private int annee;
	private int budgetEau;
	private int budgetElectricite;
	private int budgetGaz;
	private int budgetEntretien;
	private String commentaire;
	
	
	public Budget() {
	}

	
	public Budget(int annee, int budgetEau, int budgetElectricite, int budgetGaz, int budgetEntretien, String commentaire ) {
		this.annee = annee;
		this.budgetEau = budgetEau;
		this.budgetElectricite = budgetElectricite;
		this.budgetGaz = budgetGaz;
		this.budgetEntretien = budgetEntretien; 
		this.commentaire=commentaire;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getBudgetEau() {
		return budgetEau;
	}


	public void setBudgetEau(int budgetEau) {
		this.budgetEau = budgetEau;
	}


	public int getBudgetElectricite() {
		return budgetElectricite;
	}


	public void setBudgetElectricite(int budgetElectricite) {
		this.budgetElectricite = budgetElectricite;
	}


	public int getBudgetGaz() {
		return budgetGaz;
	}


	public void setBudgetGaz(int budgetGaz) {
		this.budgetGaz = budgetGaz;
	}


	public int getBudgetEntretien() {
		return budgetEntretien;
	}


	public void setBudgetEntretien(int budgetEntretien) {
		this.budgetEntretien = budgetEntretien;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}






}
