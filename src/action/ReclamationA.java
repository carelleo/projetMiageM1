package action;

import java.util.*;
import org.apache.struts2.interceptor.SessionAware;

import beans.Reclamation;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;

public class ReclamationA extends ActionSupport implements SessionAware {

	//param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    DemandeDao tDao = new DemandeDao();
    
    ArrayList<Reclamation> listR;
    
    @Override
    public String execute() throws Exception {
        
        listR = tDao.getReclamation();
        
        return SUCCESS;
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

    public DemandeDao getDao() {
        return tDao;
    }

    public void setDao( DemandeDao tDao ) {
        this.tDao = tDao;
    }

    public ArrayList<Reclamation> getListR() {
        return listR;
    }

    public void setListR( ArrayList<reclamation> listR ) {
        this.listR = listR;
    }

    
	
	
	
	
}
