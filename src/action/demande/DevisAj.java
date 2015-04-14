package action.demande;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.DemandeTravaux;
import beans.Devis;
import beans.GrosTravaux;
import beans.PetitTravaux;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;

public class DevisAj extends ActionSupport implements SessionAware{
    //param page
    private String page;
    private String sjt;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private DemandeDao tDao = new DemandeDao();
    
    private Devis d;
    
    private ArrayList<DemandeTravaux> listT;
    private ArrayList<GrosTravaux> listGT;
    private ArrayList<PetitTravaux> listPT;
    
    @Override
    public String execute() throws Exception {
        
        page = "travaux";
        
        tDao.addDevis(d);
        
        listT = tDao.getTravaux();
        listGT = tDao.getGTrav();
        listPT = tDao.getPTrav();
        
        return SUCCESS;
    }
    
    public void validate(){
        
        if ( d.getEntreprise().length()==0 || d.getEntreprise().trim().equals( "" )){ 
            addFieldError( "d.entreprise", "Entreprise is required." );     
        }
        else if(d.getEntreprise().length()<3 || d.getEntreprise().length()>30){
            addFieldError( "d.entreprise", "Subject must have between 3 and 30 characters." );
        }
        else if ( d.getMontant()<=0 || d.getEntreprise().trim().equals( "" )){ 
            addFieldError( "d.entreprise", "Entreprise is required." );     
        }
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

    public void setSjt( String sjt ) {
        this.sjt = sjt;
    }

    public Devis getD() {
        return d;
    }

    public void setD( Devis d ) {
        this.d = d;
    }

    public ArrayList<GrosTravaux> getListGT() {
        return listGT;
    }

    public void setListGT( ArrayList<GrosTravaux> listGT ) {
        this.listGT = listGT;
    }

    public ArrayList<PetitTravaux> getListPT() {
        return listPT;
    }

    public void setListPT( ArrayList<PetitTravaux> listPT ) {
        this.listPT = listPT;
    }

}
