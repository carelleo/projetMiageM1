
package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import beans.Date;
import beans.Factures;
import beans.Utilisateur;
import dao.FactureDao;
import dao.UtilisateurDao;

public class FactureAj extends ActionSupport implements SessionAware{

	//param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    FactureDao fDao = new FactureDao();
    UtilisateurDao uDao = new UtilisateurDao();
    
    Factures f;
    ArrayList<Factures> listF;
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    public String execute() throws Exception {
    	
    	page = "facture";

    		fDao.addFacture(f, uDao.getOneUtilisateur(f.getMail()).getId() );
    	  	if(!session.containsKey("idU"))
        		return SUCCESS;
        	else{	
	    		listF = fDao.getFactures(uDao);
	    		return SUCCESS;
    	}
    }
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#validate()
     */
    public void validate(){

        if ( f.getSujet().length() == 0 || f.getSujet().trim().equals("")){ 
            addFieldError( "f.sujet", "Sujet is required." );     
        }
        	
        if ( f.getMontantAPayer()==0){ 
            addFieldError( "f.montantAPayer", "Montant is required." );     
        }
        if(f.getDetail().length()<3 || f.getDetail().length()>100){
            addFieldError( "f.detail", "Detail must have between 3 and 30 characters." );
        }
        
        if(f.getMail().length()==0 || f.getMail().trim().equals( "" ))
        	addFieldError( "f.mail", "e-mail is required." );   
        
        if (uDao.getOneUtilisateur(f.getMail()).getId() == 0)
        	addFieldError( "f.mail", "this e-mail doesn't exist " );
        	
        
        
    }

    /**
     * @return
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page
     */
    public void setPage( String page ) {
        this.page = page;
    }

    /**
     * @return
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /* (non-Javadoc)
     * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
     */
    public void setSession( Map<String, Object> session ) {
        this.session = session;
    }

    /**
     * @return
     */
    public FactureDao gettDao() {
        return fDao;
    }

    /**
     * @param fDao
     */
    public void settDao( FactureDao fDao ) {
        this.fDao = fDao;
    }

    /**
     * @return
     */
    public ArrayList<Factures> getListF() {
        return listF;
    }

    /**
     * @param listF
     */
    public void setListT( ArrayList<Factures> listF ) {
        this.listF = listF;
    }

	/**
	 * @return
	 */
	public Factures getF() {
		return f;
	}

	/**
	 * @param f
	 */
	public void setF(Factures f) {
		this.f = f;
	}

	/**
	 * @return
	 */
	public FactureDao getfDao() {
		return fDao;
	}

	/**
	 * @param fDao
	 */
	public void setfDao(FactureDao fDao) {
		this.fDao = fDao;
	}

	/**
	 * @return
	 */
	public UtilisateurDao getuDao() {
		return uDao;
	}

	/**
	 * @param uDao
	 */
	public void setuDao(UtilisateurDao uDao) {
		this.uDao = uDao;
	}

	/**
	 * @param listF
	 */
	public void setListF(ArrayList<Factures> listF) {
		this.listF = listF;
	}

	
}
