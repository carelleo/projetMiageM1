package action.demande;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.DemandeTravaux;
import beans.Devis;
import beans.Evenement;
import beans.GrosTravaux;
import beans.PetitTravaux;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;
import dao.EvenementDao;
import dao.UtilisateurDao;

public class DevisAj extends ActionSupport implements SessionAware{
    //param page
    private String page;
    private String sjt;
    private String prop;
    private boolean event;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private DemandeDao tDao = new DemandeDao();
    private UtilisateurDao uDao = new UtilisateurDao();
    private EvenementDao eDao = new EvenementDao();
    
    private Devis d;
    private PetitTravaux pt;
    private GrosTravaux gt;
    
    private ArrayList<Devis> listD;
    
    @Override
    public String execute() throws Exception {
        
        page = "travaux";
        
        tDao.addDevis(d);
        gt = tDao.getOneGTravaux( d.getIdT() );
        
        sjt = gt.getSujet();
        
        event = false;
        
        prop = uDao.getOneUtilisateur(gt.getIdU()).getMail();
        
        session.put( "gt", gt );
        session.put( "idGT", tDao.getIdGT( sjt ) );
        
        listD = tDao.getDevis(tDao.getIdGT(sjt));
        
        return SUCCESS;
    }
    
    public String ajoutPT() throws Exception {
        
        page = "travaux";
        
        tDao.addDevis(d);
        pt = tDao.getOnePTravaux( d.getIdT() );
        
        sjt = pt.getSujet();
        
        Evenement e = new Evenement(pt.getSujet(), d.getDateD(), d.getDateF());
        eDao.addEvenement( e );
        
        prop = uDao.getOneUtilisateur(pt.getIdU()).getMail();
        
        session.put( "pt", pt );
        session.put( "idPT", tDao.getIdPT( sjt ) );
        
        listD = tDao.getDevis(tDao.getIdPT(sjt));
        
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

    public PetitTravaux getPt() {
        return pt;
    }

    public void setPt( PetitTravaux pt ) {
        this.pt = pt;
    }

    public EvenementDao geteDao() {
        return eDao;
    }

    public void seteDao( EvenementDao eDao ) {
        this.eDao = eDao;
    }

    public String getProp() {
        return prop;
    }

    public void setProp( String prop ) {
        this.prop = prop;
    }

    public ArrayList<Devis> getListD() {
        return listD;
    }

    public void setListD( ArrayList<Devis> listD ) {
        this.listD = listD;
    }

    public UtilisateurDao getuDao() {
        return uDao;
    }

    public void setuDao( UtilisateurDao uDao ) {
        this.uDao = uDao;
    }

    public GrosTravaux getGt() {
        return gt;
    }

    public void setGt( GrosTravaux gt ) {
        this.gt = gt;
    }

    public boolean isEvent() {
        return event;
    }

    public void setEvent( boolean event ) {
        this.event = event;
    }

}
