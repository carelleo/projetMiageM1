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
    
    @Override
    public String execute() throws Exception {
        
        listR = tDao.getReclamation();
        
        return SUCCESS;
    }
    
    public String supprR() throws Exception {
        
        page = "reclamation";
        
        tDao.removeReclamation(sjt);
        listR = tDao.getReclamation();
        
        return SUCCESS;
    }
    
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
    
    public String modifR() throws Exception {
        dt = tDao.getOneReclamation( dtSjt );
        
        session.put( "dtSjt", dtSjt );
        
        return SUCCESS;
    }
    
    public String consulterR() throws Exception{
    	dt = tDao.getOneReclamation( dtSjt );
    	prop = uDao.getOneUtilisateur(dt.getIdU()).getMail();
    	
        session.put( "dt", dt );
    	return SUCCESS;
    }
    
    public String accepterR() throws Exception{
        dt = tDao.getOneReclamation( sjt );
        tDao.modifT("ACCEPTER", sjt);
        
        listR = tDao.getReclamation();
        
        return SUCCESS;
    }
    
    public String refuserR() throws Exception{
    	dt = tDao.getOneReclamation( sjt );
    	tDao.modifT("REFUSER", sjt);
    	
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

    public void setListR( ArrayList<Reclamation> listR ) {
        this.listR = listR;
    }

    public DemandeDao gettDao() {
        return tDao;
    }

    public void settDao( DemandeDao tDao ) {
        this.tDao = tDao;
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

    public Reclamation getDt() {
        return dt;
    }

    public void setDt( Reclamation dt ) {
        this.dt = dt;
    }

	public UtilisateurDao getuDao() {
		return uDao;
	}

	public void setuDao(UtilisateurDao uDao) {
		this.uDao = uDao;
	}

	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}
}
