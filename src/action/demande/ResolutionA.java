package action.demande;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Resolution;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;

public class ResolutionA extends ActionSupport implements SessionAware {
	
	//param page
    private String page;
    private String sjt;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    DemandeDao tDao = new DemandeDao();
    
    ArrayList<Resolution> listResolution;
    
    @Override
    public String execute() throws Exception {
        
    	listResolution = tDao.getResolution();
        
        return SUCCESS;
    }
    
    public String supprR() throws Exception {
        
        page = "resolution";
        
        tDao.removeResolution(sjt);
        listResolution = tDao.getResolution();
        
        return SUCCESS;
    }
    
    public String plusR() throws Exception {
        
        page = "resolution";
        
        Resolution res = tDao.getOneResolution(sjt);
        res.plus();
        tDao.modifResolution(res, sjt);
        
        listResolution = tDao.getResolution();
        
        return SUCCESS;
    }
    
    public String moinsR() throws Exception {
        
        page = "resolution";
        
        Resolution res = tDao.getOneResolution(sjt);
        res.moins();
        tDao.modifResolution(res, sjt);
        
        listResolution = tDao.getResolution();
        
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

    public ArrayList<Resolution> getListR() {
        return listResolution;
    }

    public void setListR( ArrayList<Resolution> listResolution ) {
        this.listResolution = listResolution;
    }

    public DemandeDao gettDao() {
        return tDao;
    }

    public void settDao( DemandeDao tDao ) {
        this.tDao = tDao;
    }

    public ArrayList<Resolution> getListResolution() {
        return listResolution;
    }

    public void setListResolution( ArrayList<Resolution> listResolution ) {
        this.listResolution = listResolution;
    }

    public String getSjt() {
        return sjt;
    }

    public void setSjt( String sjt ) {
        this.sjt = sjt;
    }

    
	
	
}
