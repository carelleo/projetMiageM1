package action.demande;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.DemandeTravaux;
import beans.Resolution;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;
import dao.UtilisateurDao;

public class ResolutionA extends ActionSupport implements SessionAware {
	
	//param page
    private String page;
    private String sjt;
    private String dtSjt;
    private String prop;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private DemandeDao tDao = new DemandeDao();
    private UtilisateurDao uDao = new UtilisateurDao();
    
    ArrayList<Resolution> listResolution;
    private Resolution dt;
    
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
        
        if(!tDao.AlreadyCompteur( sjt, (int)session.get( "idU" ))){
            res.plus();
            tDao.modifResolution(res, sjt);
            tDao.addCompteur( sjt, (int)session.get( "idU" ), "plus" );
            
            listResolution = tDao.getResolution();
            
            return SUCCESS;
        }
        else
            return ERROR;
    }
    
    public String moinsR() throws Exception {
        
        page = "resolution";
        
        Resolution res = tDao.getOneResolution(sjt);
        
        if(!tDao.AlreadyCompteur( sjt, (int)session.get( "idU" ))){
            res.moins();
            tDao.modifResolution(res, sjt);
            tDao.addCompteur( sjt, (int)session.get( "idU" ), "plus" );
            
            listResolution = tDao.getResolution();
            
            return SUCCESS;
        }
        else
            return ERROR;
    }
    
    public String modifR() throws Exception {
        dt = tDao.getOneResolution( dtSjt );
        
        session.put( "dtSjt", dtSjt );
        
        return SUCCESS;
    }

    public String consulterR() throws Exception{
    	dt = tDao.getOneResolution( dtSjt );
    	prop = uDao.getOneUtilisateur(dt.getIdU()).getMail();
    	
        session.put( "dt", dt );
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

    public String getDtSjt() {
        return dtSjt;
    }

    public void setDtSjt( String dtSjt ) {
        this.dtSjt = dtSjt;
    }

    public Resolution getDt() {
        return dt;
    }

    public void setDt( Resolution dt ) {
        this.dt = dt;
    }

	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

    
	
	
}
