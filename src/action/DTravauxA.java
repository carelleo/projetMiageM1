package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.DemandeTravaux;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;

public class DTravauxA extends ActionSupport implements SessionAware{
  //param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    DemandeDao tDao = new DemandeDao();
    
    ArrayList<DemandeTravaux> listT;
    
    @Override
    public String execute() throws Exception {
        
        listT = tDao.getTravaux();
        
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

    public ArrayList<DemandeTravaux> getListT() {
        return listT;
    }

    public void setListT( ArrayList<DemandeTravaux> listT ) {
        this.listT = listT;
    }

}
