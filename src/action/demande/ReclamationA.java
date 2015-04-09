package action.demande;

import java.util.*;

import org.apache.struts2.interceptor.SessionAware;

import beans.DemandeTravaux;
import beans.Reclamation;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;

public class ReclamationA extends ActionSupport implements SessionAware {

	//param page
    private String page;
    private String sjt;
    private String dtSjt;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    DemandeDao tDao = new DemandeDao();
    
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
        demR.plus();
        tDao.modifR(demR, sjt);
        
        listR = tDao.getReclamation();
        
        return SUCCESS;
    }
    
    public String moinsR() throws Exception {
        
        page = "reclamation";
        
        Reclamation demR = tDao.getOneReclamation(sjt);
        demR.moins();
        tDao.modifR(demR, sjt);
        
        listR = tDao.getReclamation();
        
        return SUCCESS;
    }
    
    public String modifR() throws Exception {
        dt = tDao.getOneReclamation( dtSjt );
        
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
}
