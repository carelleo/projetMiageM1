package beans;

import java.io.Serializable;

/**
 * 
 */
public class Syndic {
	
	private String type = "syndic";
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    private String mdpc;
    private boolean condition;
    private String teleF;
    private String teleP;
    
    /**
     * 
     */
    public Syndic(){
    }
    
    /**
     * @param n
     * @param p
     * @param m
     * @param md
     */
    public Syndic(String n,String p,String m,String md){
        type = "syndic";
        nom=n;
        prenom=p;
        mail=m;
        mdp=md;
        mdpc=md;
        condition=true;
        teleF=null;
        teleP=null;
    }
    
    /**
     * @param n
     * @param p
     * @param m
     * @param md
     * @param tf
     * @param tp
     */
    public Syndic(String n,String p,String m,String md,String tf,String tp){
        type = "syndic";
        nom=n;
        prenom=p;
        mail=m;
        mdp=md;
        mdpc=md;
        condition=true;
        teleF=tf;
        teleP=tp;
    }
    
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o){

	      return (o instanceof Syndic ) /*&& (((Syndic)o).numeroLogement == numeroLogement) && (((Syndic)o).getNumeroTel() == getNumeroTel())*/ && 
	              (((Syndic)o).getNom() == getNom()) && (((Syndic)o).getPrenom() == getPrenom()) ; 
	      
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coproprietaire";
	}

    /**
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     */
    public void setNom( String nom ) {
        this.nom = nom;
    }

    /**
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom
     */
    public void setPrenom( String prenom ) {
        this.prenom = prenom;
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
    public void setMail( String mail ) {
        this.mail = mail;
    }

    /**
     * @return
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp
     */
    public void setMdp( String mdp ) {
        this.mdp = mdp;
    }

    /**
     * @return
     */
    public boolean isCondition() {
        return condition;
    }

    /**
     * @param condition
     */
    public void setCondition( boolean condition ) {
        this.condition = condition;
    }

    /**
     * @return
     */
    public String getMdpc() {
        return mdpc;
    }

    /**
     * @param mdpc
     */
    public void setMdpc( String mdpc ) {
        this.mdpc = mdpc;
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
	public void setType(String type) {
		this.type = type;
	}

    /**
     * @return
     */
    public String getTeleF() {
        return teleF;
    }

    /**
     * @param teleF
     */
    public void setTeleF( String teleF ) {
        this.teleF = teleF;
    }

    /**
     * @return
     */
    public String getTeleP() {
        return teleP;
    }

    /**
     * @param teleP
     */
    public void setTeleP( String teleP ) {
        this.teleP = teleP;
    }
}