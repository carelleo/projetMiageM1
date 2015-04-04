package beans;


/**
 * 
 */
public class Utilisateur {

	private String mail;
	private String motDePasse;
	private String type;

	/**
	 * 
	 */
	public  Utilisateur( String m, String md, String t) {
		mail=m;
		motDePasse=md;
		type=t;
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

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

}