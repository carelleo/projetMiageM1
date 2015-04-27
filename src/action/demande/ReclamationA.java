package action.demande;

import java.util.*;

import org.apache.struts2.interceptor.SessionAware;

import beans.DemandeTravaux;
import beans.Reclamation;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;
import dao.UtilisateurDao;

public class ReclamationA extends ActionSupport implements SessionAware {

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
    
    ArrayList<Reclamation> listR;
    private Reclamation dt;
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    public String execute() throws Exception {
        
        listR = tDao.getReclamation();
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String supprR() throws Exception {
        
        page = "reclamation";
        
        tDao.removeReclamation(sjt);
        listR = tDao.getReclamation();
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String plusR() throws Exception {
        
        page = "reclamation";
        
        Reclamation demR = tDao.getOneReclamation(sjt);
        
        if(!tDao.AlreadyCompteur( sjt, (int)session.get( "idU" ))){
            demR.plus();
            tDao.modifR(demR, sjt);
            tDao.addCompteur( sjt, (int)session.get( "idU" ), "plus" );
            
            listR = tDao.getReclamation();
            
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
        
        page = "reclamation";
        
        Reclamation demR = tDao.getOneReclamation(sjt);
        
        if(!tDao.AlreadyCompteur( sjt, (int)session.get( "idU" ))){
            demR.moins();
            tDao.modifR(demR, sjt);
            tDao.addCompteur( sjt, (int)session.get( "idU" ), "plus" );
            
            listR = tDao.getReclamation();
            
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
        dt = tDao.getOneReclamation( dtSjt );
        
        session.put( "dtSjt", dtSjt );
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String consulterR() throws Exception{
    	dt = tDao.getOneReclamation( dtSjt );
    	prop = uDao.getOneUtilisateur(dt.getIdU()).getMail();
    	
        session.put( "dt", dt );
    	return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String accepterR() throws Exception{
        dt = tDao.getOneReclamation( sjt );
        tDao.modifT("ACCEPTER", sjt);
        
        listR = tDao.getReclamation();
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String refuserR() throws Exception{
    	dt = tDao.getOneReclamation( sjt );
    	tDao.modifT("REFUSER", sjt);
    	
    	listR = tDao.getReclamation();
    	
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
    public DemandeDao getDao() {
        return tDao;
    }

    /**
     * @param tDao
     */
    public void setDao( DemandeDao tDao ) {
        this.tDao = tDao;
    }

    /**
     * @return
     */
    public ArrayList<Reclamation> getListR() {
        return listR;
    }

    /**
     * @param listR
     */
    public void setListR( ArrayList<Reclamation> listR ) {
        this.listR = listR;
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
    public Reclamation getDt() {
        return dt;
    }

    /**
     * @param dt
     */
    public void setDt( Reclamation dt ) {
        this.dt = dt;
    }

	/**
	 * @return
	 */
	public UtilisateurDao getuDao() {
		return uDao;
	}

	/**
	 * @param uDao
	 */
	public void setuDao(UtilisateurDao uDao) {
		this.uDao = uDao;
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
