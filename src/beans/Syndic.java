package beans;

import java.io.Serializable;

/**
 * 
 */
public class Syndic implements InterfaceReclamation, InterfaceResolution, InterfaceDemandeTravaux, Serializable{
	
	private String type = "syndic";
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    private String mdpc;
    private boolean condition;
    
    public Syndic(){
    }
    
    public Syndic(String n,String p,String m,String md){
        type = "syndic";
        nom=n;
        prenom=p;
        mail=m;
        mdp=md;
        mdpc=md;
        condition=true;
    }
    
	/**
	 * @param RQ 
	 * @return
	 */
	public void RépondreQuestion(String RQ) {
		// TODO implement here
		
	}

	@Override
	public DemandeTravaux CreerDemandeTravaux( String de) {
		return null;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DetruireDemandeTravaux() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Resolution CreerResolution(String r) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DetruireResolution() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reclamation CreerReclamation(String r) {
		
		return new Reclamation(r);
		
	}

	@Override
	public void DetruireReclamation() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * */
	public boolean equals(Object o){

	      return (o instanceof Syndic ) /*&& (((Syndic)o).numeroLogement == numeroLogement) && (((Syndic)o).getNumeroTel() == getNumeroTel())*/ && 
	              (((Syndic)o).getNom() == getNom()) && (((Syndic)o).getPrenom() == getPrenom()) ; 
	      
	}

	@Override
	public String toString() {
		return "Coproprietaire";
	}

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail( String mail ) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp( String mdp ) {
        this.mdp = mdp;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition( boolean condition ) {
        this.condition = condition;
    }

    public String getMdpc() {
        return mdpc;
    }

    public void setMdpc( String mdpc ) {
        this.mdpc = mdpc;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}