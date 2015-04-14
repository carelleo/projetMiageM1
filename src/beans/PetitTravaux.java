package beans;

public class PetitTravaux {
	private String dateD = null;
	private String dateF = null;
	private String sujet;
	private String artisan = null;
	private String contenu;
	private int idU;
	
	public PetitTravaux(){
	}
	
	public PetitTravaux(String s, String c, int i){
		sujet = s;
		contenu = c;
		idU = i;
	}
	
	public PetitTravaux(String dd, String df, String s, String a, String c){
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

    public int getIdU() {
        return idU;
    }

    public void setIdU( int idU ) {
        this.idU = idU;
    }
	
	
}
