package action.demande;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.DemandeTravaux;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;

public class DTravauxModif extends ActionSupport implements SessionAware{
	//param page
    private String page;
    
    private DemandeTravaux dt;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    DemandeDao tDao = new DemandeDao();
    
    ArrayList<DemandeTravaux> listT;
    
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    public String execute() throws Exception {
        page = "travaux";
        
        tDao.modifT( dt, (String)session.get( "dtSjt") );
        listT = tDao.getTravaux();
        
        session.remove( "dtSjt" );
        
        return SUCCESS;
    }
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#validate()
     */
    public void validate(){
        
        if ( dt.getSujet().length()==0 || dt.getSujet().trim().equals( "" )){ 
            addFieldError( "dt.sujet", "Subject is required." );     
        }
        else if(dt.getSujet().length()<3 || dt.getSujet().length()>30){
            addFieldError( "dt.sujet", "Subject must have between 3 and 30 characters." );
        }
        else if(!dt.getSujet().equals( session.get( "dtSjt" ) )){
            if(tDao.containTSujet(dt.getSujet())){
                addFieldError( "dt.sujet", "Subject already exist." );
            }
        }
        
        if ( dt.getContenu().length()==0 || dt.getContenu().trim().equals( "" )){ 
            addFieldError( "dt.contenu", "Contenu is required." );     
        }
        else if(dt.getContenu().length()<5){
            addFieldError( "dt.contenu", "Contenu must have more than 5 characters." );
        }
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
    public DemandeDao gettDao() {
        return tDao;
    }

    /**
     * @param tDao
     */
    public void settDao( DemandeDao tDao ) {
        this.tDao = tDao;
    }

    /**
     * @return
     */
    public ArrayList<DemandeTravaux> getListT() {
        return listT;
    }

    /**
     * @param listT
     */
    public void setListT( ArrayList<DemandeTravaux> listT ) {
        this.listT = listT;
    }

	/**
	 * @return
	 */
	public DemandeTravaux getDt() {
		return dt;
	}

	/**
	 * @param dt
	 */
	public void setDt(DemandeTravaux dt) {
		this.dt = dt;
	}
}
