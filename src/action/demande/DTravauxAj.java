package action.demande;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.DemandeTravaux;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;

public class DTravauxAj extends ActionSupport implements SessionAware{
	//param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    DemandeDao tDao = new DemandeDao();
    
    DemandeTravaux dt;
    ArrayList<DemandeTravaux> listT;
    
    @Override
    public String execute() throws Exception {
    	
    	page = "travaux";
    	
    	tDao.addTravaux(dt, (int)session.get( "idU" ));
        listT = tDao.getTravaux();
        
        return SUCCESS;
    }
    
    public void validate(){
		
        if ( dt.getSujet().length()==0 || dt.getSujet().trim().equals( "" )){ 
            addFieldError( "dt.sujet", "Subject is required." );     
        }
        else if(dt.getSujet().length()<3 || dt.getSujet().length()>30){
            addFieldError( "dt.sujet", "Subject must have between 3 and 30 characters." );
        }
        else if(tDao.containTSujet(dt.getSujet())){
            addFieldError( "dt.sujet", "Subject already exist." );
        }
        
        if ( dt.getContenu().length()==0 || dt.getContenu().trim().equals( "" )){ 
            addFieldError( "dt.contenu", "Contenu is required." );     
        }
        else if(dt.getContenu().length()<5){
            addFieldError( "dt.contenu", "Contenu must have more than 5 characters." );
        }
    }

    public String getPage() {
        return page;
    }

    public void setPage( String page ) {
        this.page = page;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession( Map<String, Object> session ) {
        this.session = session;
    }

    public DemandeDao gettDao() {
        return tDao;
    }

    public void settDao( DemandeDao tDao ) {
        this.tDao = tDao;
    }

    public ArrayList<DemandeTravaux> getListT() {
        return listT;
    }

    public void setListT( ArrayList<DemandeTravaux> listT ) {
        this.listT = listT;
    }

	public DemandeTravaux getDt() {
		return dt;
	}

	public void setDt(DemandeTravaux dt) {
		this.dt = dt;
	}

}
