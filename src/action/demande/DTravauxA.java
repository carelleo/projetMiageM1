package action.demande;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.DemandeTravaux;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;

public class DTravauxA extends ActionSupport implements SessionAware{
	//param page
    private String page;
    private String sjt;
    private String dtSjt;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private DemandeDao tDao = new DemandeDao();
    
    private ArrayList<DemandeTravaux> listT;
    private DemandeTravaux dt;
    
    @Override
    public String execute() throws Exception {
        listT = tDao.getTravaux();
        
        return SUCCESS;
    }
    
    public String supprT() throws Exception {
    	
    	page = "travaux";
    	
    	tDao.removeTravaux(sjt);
        listT = tDao.getTravaux();
        
        return SUCCESS;
    }
    
    public String plusT() throws Exception {
    	
    	page = "travaux";
    	
    	DemandeTravaux demT = tDao.getOneTravaux(sjt);
    	
    	if(!tDao.AlreadyCompteur( sjt, (int)session.get( "idU" ))){
    	    demT.plus();
    	    tDao.modifT(demT, sjt);
    	    tDao.addCompteur( sjt, (int)session.get( "idU" ), "plus" );
    	    
    	    listT = tDao.getTravaux();
    	    
    	    return SUCCESS;
    	}
    	else
    	    return ERROR;
    }
    
    public String moinsT() throws Exception {
    	
        DemandeTravaux demT = tDao.getOneTravaux(sjt);
        
        if(!tDao.AlreadyCompteur( sjt, (int)session.get( "idU" ))){
            demT.moins();
            tDao.modifT(demT, sjt);
            tDao.addCompteur( sjt, (int)session.get( "idU" ), "plus" );
            
            listT = tDao.getTravaux();
            
            return SUCCESS;
        }
        else
            return ERROR;
    }
    
    public String modifT() throws Exception {
        dt = tDao.getOneTravaux( dtSjt );
        
        session.put( "dtSjt", dtSjt );
        
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

	public String getSjt() {
		return sjt;
	}

	public void setSjt(String sjt) {
		this.sjt = sjt;
	}

    public String getDtSjt() {
        return dtSjt;
    }

    public void setDtSjt( String dtSjt ) {
        this.dtSjt = dtSjt;
    }

    public DemandeTravaux getDt() {
        return dt;
    }

    public void setDt( DemandeTravaux dt ) {
        this.dt = dt;
    }

}
