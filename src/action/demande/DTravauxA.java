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

public class DTravauxA extends ActionSupport implements SessionAware{
	//param page
    private String page;
    private String sjt;
    private String dtSjt;
    private String prop;
    private int idD;
    private boolean event;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private DemandeDao tDao = new DemandeDao();
    private UtilisateurDao uDao = new UtilisateurDao();
    private EvenementDao eDao = new EvenementDao();
    
    private ArrayList<DemandeTravaux> listT;
    private DemandeTravaux dt;
    
    private ArrayList<GrosTravaux> listGT;
    private ArrayList<PetitTravaux> listPT;
    
    private GrosTravaux gt;
    private PetitTravaux pt;
    
    private ArrayList<Devis> listD;
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    public String execute() throws Exception {
        page ="travaux";
        
        listT = tDao.getTravaux();
        listGT = tDao.getGTrav();
        listPT = tDao.getPTrav();
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String supprT() throws Exception {
    	
    	page = "travaux";
    	
    	tDao.removeTravaux(sjt);
        listT = tDao.getTravaux();
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
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
    
    /**
     * @return
     * @throws Exception
     */
    public String moinsT() throws Exception {
        page ="travaux";
        
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
    
    /**
     * @return
     * @throws Exception
     */
    public String modifT() throws Exception {
        page ="travaux";
        
        dt = tDao.getOneTravaux( dtSjt );
        
        session.put( "dtSjt", dtSjt );
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String consulterT() throws Exception{
        page ="travaux";
        
    	dt = tDao.getOneTravaux( dtSjt );
    	prop = uDao.getOneUtilisateur(dt.getIdU()).getMail();
    	
        session.put( "dt", dt );
    	return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String refuserT() throws Exception{
        page ="travaux";
        
    	dt = tDao.getOneTravaux( sjt );
    	tDao.modifT("REFUSER", sjt);
    	
    	listT = tDao.getTravaux();
    	
    	return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String accepterGT() throws Exception{
        page ="travaux";
        
        dt = tDao.getOneTravaux( sjt );
        
        if(!tDao.containGPTSujet( sjt )){
            tDao.addGTrav( dt );
        
            tDao.removeTravaux( dt.getSujet() );
            
            listT = tDao.getTravaux();
            listGT = tDao.getGTrav();
            listPT = tDao.getPTrav();
            
            return SUCCESS;
        }
        else
            return ERROR;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String accepterPT() throws Exception{
        page ="travaux";
        
        dt = tDao.getOneTravaux( sjt );
        
        if(!tDao.containGPTSujet( sjt )){
            tDao.addPTrav( dt );
    
            tDao.removeTravaux( dt.getSujet() );
        
            listT = tDao.getTravaux();
            listGT = tDao.getGTrav();
            listPT = tDao.getPTrav();
            
            return SUCCESS;
        }
        else
            return ERROR;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String consulterPT() throws Exception{
        page="travaux";
        
        pt = tDao.getOnePTravaux( sjt );
        prop = uDao.getOneUtilisateur(pt.getIdU()).getMail();
        
        session.put( "pt", pt );
        session.put( "idPT", tDao.getIdPT( sjt ) );
        
        listD = tDao.getDevis(tDao.getIdPT(sjt));
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String consulterGT() throws Exception{
        page="travaux";
        
        gt = tDao.getOneGTravaux( sjt );
        prop = uDao.getOneUtilisateur(gt.getIdU()).getMail();
        
        event = eDao.containEvenement( sjt );
        
        session.put( "grt", gt );
        session.put( "idGT", tDao.getIdGT( sjt ) );
        
        listD = tDao.getDevis(tDao.getIdGT(sjt));
        
        return SUCCESS;
    }
    
    /**
     * @return
     */
    public String supprPTD(){
        page = "travaux";
        
        eDao.supprEvenement( tDao.getOnePTravaux( tDao.getOneDevis( idD ).getIdT() ).getSujet() );
        tDao.removeDevis( idD );
        
        session.put( "idPT", tDao.getIdPT( sjt ) );
        
        listD = tDao.getDevis(tDao.getIdPT(sjt));
        
        return SUCCESS;
    }
    
    /**
     * @return
     */
    public String supprGTD(){
        page = "travaux";
        
        Devis d = tDao.getOneDevis( idD );
        gt = tDao.getOneGTravaux( d.getIdT() );
        
        prop = uDao.getOneUtilisateur(gt.getIdU()).getMail();
        
        sjt = gt.getSujet();
        
        tDao.removeDevis( idD );
        
        if(eDao.containEvenement( sjt ))
            eDao.supprEvenement( sjt );
        
        event = false;
        
        session.put( "grt", gt );
        session.put( "idGT", d.getIdT() );
        
        listD = tDao.getDevis(d.getIdT());
        
        return SUCCESS;
    }
    
    /**
     * @return
     */
    public String accepterD(){
        page = "travaux";
        
        Devis d = tDao.getOneDevis( idD );
        gt = tDao.getOneGTravaux( d.getIdT() );
        
        sjt = gt.getSujet();
        
        Evenement e = new Evenement(gt.getSujet(), d.getDateD(), d.getDateF());
        eDao.addEvenement( e );
        
        event = eDao.containEvenement( sjt );
        
        prop = uDao.getOneUtilisateur(gt.getIdU()).getMail();
        
        session.put( "grt", gt );
        session.put( "idGT", tDao.getIdGT( sjt ) );
        
        tDao.removeAllDevis(d.getIdT(), idD);
        
        listD = tDao.getDevis(tDao.getIdGT(sjt));
        
        return SUCCESS;
    }
    
    /**
     * @return
     */
    public String supprimerPT(){
        page = "travaux";
        
        pt = tDao.getOnePTravaux( sjt );
        
        eDao.supprEvenement( sjt );
        
        tDao.removeAllDevis( tDao.getIdPT( sjt ) );
        
        tDao.removePTrav( sjt );
        
        listT = tDao.getTravaux();
        listGT = tDao.getGTrav();
        listPT = tDao.getPTrav();
        
        return SUCCESS;
    }
    
    /**
     * @return
     */
    public String supprimerGT(){
        page = "travaux";
        
        gt = tDao.getOneGTravaux( sjt );
        
        eDao.supprEvenement( sjt );
        
        tDao.removeAllDevis( tDao.getIdGT( sjt ) );
        
        tDao.removeGTrav( sjt );
        
        listT = tDao.getTravaux();
        listGT = tDao.getGTrav();
        listPT = tDao.getPTrav();
        
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
    public ArrayList<DemandeTravaux> getListT() {
        return listT;
    }

    /**
     * @param listT
     */
    public void setListT( ArrayList<DemandeTravaux> listT ) {
        this.listT = listT;
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
	public void setSjt(String sjt) {
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
    public DemandeTravaux getDt() {
        return dt;
    }

    /**
     * @param dt
     */
    public void setDt( DemandeTravaux dt ) {
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

    /**
     * @return
     */
    public ArrayList<GrosTravaux> getListGT() {
        return listGT;
    }

    /**
     * @param listGT
     */
    public void setListGT( ArrayList<GrosTravaux> listGT ) {
        this.listGT = listGT;
    }

    /**
     * @return
     */
    public ArrayList<PetitTravaux> getListPT() {
        return listPT;
    }

    /**
     * @param listPT
     */
    public void setListPT( ArrayList<PetitTravaux> listPT ) {
        this.listPT = listPT;
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
    public int getIdD() {
        return idD;
    }

    /**
     * @param idD
     */
    public void setIdD( int idD ) {
        this.idD = idD;
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
