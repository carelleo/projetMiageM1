package action;

import org.apache.struts2.interceptor.SessionAware;
import java.util.*;

import beans.Resolution;

public class ResolutionA extends ActionSupport implements SessionAware {
	
	//param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    ResolutionDao tDao = new ResolutionDao();
    
    ArrayList<Resolution> listResolution;
    
    @Override
    public String execute() throws Exception {
        
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

    public ResolutionDao getDao() {
        return tDao;
    }

    public void setDao( ResolutionDao tDao ) {
        this.tDao = tDao;
    }

    public ArrayList<Resolution> getListR() {
        return listResolution;
    }

    public void setListR( ArrayList<Resolution> listResolution ) {
        this.listR = listResolution;
    }

    
	
	
}
