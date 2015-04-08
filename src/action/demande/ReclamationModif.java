package action.demande;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.DemandeTravaux;
import beans.Reclamation;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;

public class ReclamationModif extends ActionSupport implements SessionAware{
    //param page
    private String page;
    private Reclamation dt;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    DemandeDao tDao = new DemandeDao();
    
    ArrayList<Reclamation> listR;
    
    
    @Override
    public String execute() throws Exception {
        
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

    public DemandeDao gettDao() {
        return tDao;
    }

    public void settDao( DemandeDao tDao ) {
        this.tDao = tDao;
    }

    public Reclamation getDt() {
        return dt;
    }

    public void setDt( Reclamation dt ) {
        this.dt = dt;
    }

    public ArrayList<Reclamation> getListR() {
        return listR;
    }

    public void setListR( ArrayList<Reclamation> listR ) {
        this.listR = listR;
    }
}
