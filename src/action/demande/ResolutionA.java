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
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    public String execute() throws Exception {
        
    	listResolution = tDao.getResolution();
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String supprR() throws Exception {
        
        page = "resolution";
        
        tDao.removeResolution(sjt);
        listResolution = tDao.getResolution();
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
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
    
    /**
     * @return
     * @throws Exception
     */
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
    
    /**
     * @return
     * @throws Exception
     */
    public String modifR() throws Exception {
        dt = tDao.getOneResolution( dtSjt );
        
        session.put( "dtSjt", dtSjt );
        
        return SUCCESS;
    }

    /**
     * @return
     * @throws Exception
     */
    public String consulterR() throws Exception{
    	dt = tDao.getOneResolution( dtSjt );
    	prop = uDao.getOneUtilisateur(dt.getIdU()).getMail();
    	
        session.put( "dt", dt );
    	return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String accepterR() throws Exception{
    	dt = tDao.getOneResolution( sjt );
    	tDao.modifT("ACCEPTER", sjt);
    	
    	listResolution = tDao.getResolution();
    	
    	return SUCCESS;
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
    public ArrayList<Resolution> getListR() {
        return listResolution;
    }

    /**
     * @param listResolution
     */
    public void setListR( ArrayList<Resolution> listResolution ) {
        this.listResolution = listResolution;
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
    public ArrayList<Resolution> getListResolution() {
        return listResolution;
    }

    /**
     * @param listResolution
     */
    public void setListResolution( ArrayList<Resolution> listResolution ) {
        this.listResolution = listResolution;
    }

    /**
     * @return
     */
    public String getSjt() {
        return sjt;
    }

    /**
     * @param sjt
     */
    public void setSjt( String sjt ) {
        this.sjt = sjt;
    }

    /**
     * @return
     */
    public String getDtSjt() {
        return dtSjt;
    }

    /**
     * @param dtSjt
     */
    public void setDtSjt( String dtSjt ) {
        this.dtSjt = dtSjt;
    }

    /**
     * @return
     */
    public Resolution getDt() {
        return dt;
    }

    /**
     * @param dt
     */
    public void setDt( Resolution dt ) {
        this.dt = dt;
    }

	/**
	 * @return
	 */
	public String getProp() {
		return prop;
	}

	/**
	 * @param prop
	 */
	public void setProp(String prop) {
		this.prop = prop;
	}

    
	
	
}
