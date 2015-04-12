package beans;

public class GrosTravaux {
	private String dateD = null;
	private String dateF = null;
	private String sujet;
	private String artisan = null;
	private String contenu;
	
	public GrosTravaux(){
	}
	
	public GrosTravaux(String s, String c){
		sujet = s;
		contenu = c;
	}
	
	public GrosTravaux(String dd, String df, String s, String a, String c){
		dateD = dd;
		dateF = df;
		artisan = a;
		sujet = s;
		contenu = c;
	}

	public String getDateD() {
		return dateD;
	}

	public void setDateD(String dateD) {
		this.dateD = dateD;
	}

	public String getDateF() {
		return dateF;
	}

	public void setDateF(String dateF) {
		this.dateF = dateF;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getArtisan() {
		return artisan;
	}

	public void setArtisan(String artisan) {
		this.artisan = artisan;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
}
