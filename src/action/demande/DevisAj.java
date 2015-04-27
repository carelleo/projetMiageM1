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
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
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
    
    /**
     * @return
     * @throws Exception
     */
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
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#validate()
     */
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
    public Devis getD() {
        return d;
    }

    /**
     * @param d
     */
    public void setD( Devis d ) {
        this.d = d;
    }

    /**
     * @return
     */
    public PetitTravaux getPt() {
        return pt;
    }

    /**
     * @param pt
     */
    public void setPt( PetitTravaux pt ) {
        this.pt = pt;
    }

    /**
     * @return
     */
    public EvenementDao geteDao() {
        return eDao;
    }

    /**
     * @param eDao
     */
    public void seteDao( EvenementDao eDao ) {
        this.eDao = eDao;
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
    public void setProp( String prop ) {
        this.prop = prop;
    }

    /**
     * @return
     */
    public ArrayList<Devis> getListD() {
        return listD;
    }

    /**
     * @param listD
     */
    public void setListD( ArrayList<Devis> listD ) {
        this.listD = listD;
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
    public void setuDao( UtilisateurDao uDao ) {
        this.uDao = uDao;
    }

    /**
     * @return
     */
    public GrosTravaux getGt() {
        return gt;
    }

    /**
     * @param gt
     */
    public void setGt( GrosTravaux gt ) {
        this.gt = gt;
    }

    /**
     * @return
     */
    public boolean isEvent() {
        return event;
    }

    /**
     * @param event
     */
    public void setEvent( boolean event ) {
        this.event = event;
    }

}
