package beans;

/**
 * @author Jean Francois
 *
 */
public class GrosTravaux {
	private String dateD = null;
	private String dateF = null;
	private String sujet;
	private String artisan = null;
	private String contenu;
	private int idU;
	
	
	/**
	 * 
	 */
	public GrosTravaux(){
	}
	
	/**
	 * @param s
	 * @param c
	 * @param i
	 */
	public GrosTravaux(String s, String c, int i){
		sujet = s;
		contenu = c;
		idU = i;
	}
	
	/**
	 * @param dd
	 * @param df
	 * @param s
	 * @param a
	 * @param c
	 * @param i
	 */
	public GrosTravaux(String dd, String df, String s, String a, String c, int i){
		dateD = dd;
		dateF = df;
		artisan = a;
		sujet = s;
		contenu = c;
		idU = i;
	}

	/**
	 * @return
	 */
	public String getDateD() {
		return dateD;
	}

	/**
	 * @param dateD
	 */
	public void setDateD(String dateD) {
		this.dateD = dateD;
	}

	/**
	 * @return
	 */
	public String getDateF() {
		return dateF;
	}

	/**
	 * @param dateF
	 */
	public void setDateF(String dateF) {
		this.dateF = dateF;
	}

	/**
	 * @return
	 */
	public String getSujet() {
		return sujet;
	}

	/**
	 * @param sujet
	 */
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	/**
	 * @return
	 */
	public String getArtisan() {
		return artisan;
	}

	/**
	 * @param artisan
	 */
	public void setArtisan(String artisan) {
		this.artisan = artisan;
	}

	/**
	 * @return
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * @param contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

    /**
     * @return
     */
    public int getIdU() {
        return idU;
    }

    /**
     * @param idU
     */
    public void setIdU( int idU ) {
        this.idU = idU;
    }
	
	
}
