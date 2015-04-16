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
import dao.EvenementDao;
import dao.UtilisateurDao;

public class DTravauxA extends ActionSupport implements SessionAware{
	//param page
    private String page;
    private String sjt;
    private String dtSjt;
    private String prop;
    private int idD;
    
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
    
    @Override
    public String execute() throws Exception {
        page ="travaux";
        
        listT = tDao.getTravaux();
        listGT = tDao.getGTrav();
        listPT = tDao.getPTrav();
        
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
    
    public String modifT() throws Exception {
        page ="travaux";
        
        dt = tDao.getOneTravaux( dtSjt );
        
        session.put( "dtSjt", dtSjt );
        
        return SUCCESS;
    }
    
    public String consulterT() throws Exception{
        page ="travaux";
        
    	dt = tDao.getOneTravaux( dtSjt );
    	prop = uDao.getOneUtilisateur(dt.getIdU()).getMail();
    	
        session.put( "dt", dt );
    	return SUCCESS;
    }
    
    public String refuserT() throws Exception{
        page ="travaux";
        
    	dt = tDao.getOneTravaux( sjt );
    	tDao.modifT("REFUSER", sjt);
    	
    	listT = tDao.getTravaux();
    	
    	return SUCCESS;
    }
    
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
    
    public String consulterPT() throws Exception{
        page="travaux";
        
        pt = tDao.getOnePTravaux( sjt );
        prop = uDao.getOneUtilisateur(pt.getIdU()).getMail();
        
        session.put( "pt", pt );
        session.put( "idPT", tDao.getIdPT( sjt ) );
        
        listD = tDao.getDevis(tDao.getIdPT(sjt));
        
        return SUCCESS;
    }
    
    public String consulterGT() throws Exception{
        page="travaux";
        
        gt = tDao.getOneGTravaux( sjt );
        prop = uDao.getOneUtilisateur(gt.getIdU()).getMail();
        
        session.put( "grt", gt );
        session.put( "idGT", tDao.getIdGT( sjt ) );
        
        listD = tDao.getDevis(tDao.getIdGT(sjt));
        
        return SUCCESS;
    }
    
    public String supprPTD(){
        page = "travaux";
        
        eDao.supprEvenement( tDao.getOnePTravaux( tDao.getOneDevis( idD ).getIdT() ).getSujet() );
        tDao.removeDevis( idD );
        
        session.put( "idPT", tDao.getIdPT( sjt ) );
        
        listD = tDao.getDevis(tDao.getIdPT(sjt));
        
        return SUCCESS;
    }
    
    public String supprGTD(){
        page = "travaux";
        
        tDao.removeDevis( idD );
        
        session.put( "idGT", tDao.getIdGT( sjt ) );
        listD = tDao.getDevis(tDao.getIdGT(sjt));
        
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

    public GrosTravaux getGt() {
        return gt;
    }

    public void setGt( GrosTravaux gt ) {
        this.gt = gt;
    }

    public PetitTravaux getPt() {
        return pt;
    }

    public void setPt( PetitTravaux pt ) {
        this.pt = pt;
    }

    public ArrayList<Devis> getListD() {
        return listD;
    }

    public void setListD( ArrayList<Devis> listD ) {
        this.listD = listD;
    }

    public int getIdD() {
        return idD;
    }

    public void setIdD( int idD ) {
        this.idD = idD;
    }

    public EvenementDao geteDao() {
        return eDao;
    }

    public void seteDao( EvenementDao eDao ) {
        this.eDao = eDao;
    }
}
