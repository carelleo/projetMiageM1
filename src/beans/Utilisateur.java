package beans;


/**
 * 
 */
/**
 * @author Jean Francois
 *
 */
/**
 * @author Jean Francois
 *
 */
/**
 * @author Jean Francois
 *
 */
public class Utilisateur {
    
    private int id;
	private String mail;
	private String motDePasse;
	private String type;

	/**
	 * 
	 */
	public  Utilisateur( int i, String m, String md, String t) {
		id=i;
	    mail=m;
		motDePasse=md;
		type=t;
	}

	/**
	 * @param mail 
	 * @param motdepasse 
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
	 */
	public void setActif(Boolean b) {
		// TODO implement here
		
	}
	
	
	/**
	 * @return
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

    /**
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType( String type ) {
        this.type = type;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId( int id ) {
        this.id = id;
    }

}