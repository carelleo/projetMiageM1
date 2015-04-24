package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import beans.Date;
import beans.DemandeTravaux;
import beans.Factures;
import beans.GrosTravaux;
import beans.PetitTravaux;
import beans.Utilisateur;
import dao.DemandeDao;
import dao.FactureDao;
import dao.UtilisateurDao;

public class FactureA extends ActionSupport implements SessionAware{
	//param page
    private String page;
    private String sujet;

    
    //la session
    private Map<String, Object> session;
    
    //dao
    private FactureDao fDao = new FactureDao();
    private UtilisateurDao uDao = new UtilisateurDao();
    
    private ArrayList<Factures> listF;
    private Factures f;
    
    @Override
    public String execute() throws Exception {
    	page = "factures";    	
    	if(!session.containsKey("idU"))
    		return SUCCESS;
    	else{
    		int id = (int)session.get( "idU" );
    		listF = fDao.getFactures(id, uDao);
    		return SUCCESS;
    		
    	}
    }
    
    
    
    public String supprF() throws Exception {
    	
    	page = "facture"; 
    	System.out.println("Sujet  : "+sujet);
    	int id =  (int)session.get( "idU" );
    	System.out.println("ID  : "+ id);
    	fDao.supprFacture(sujet, (int)session.get("idU") );
        listF = fDao.getFactures((int)session.get( "idU" ),uDao);
        
        return SUCCESS;
    }

    
    public String consulterF() throws Exception{
    	System.out.println("Sujet : " + sujet);
    	f = fDao.getOneFacture( sujet ,uDao );
    	System.out.println("f : " + f);
        session.put( "f", f );
    	return SUCCESS;
    }
    

    public void setSession( Map<String, Object> session ) {
        this.session = session;
    }
    
    
    public String getPage() {
        return page;
    }

    public void setPage( String page ) {
        this.page = page;
    }

    public FactureDao getfDao() {
        return fDao;
    }

    public void setfDao( FactureDao fDao ) {
        this.fDao = fDao;
    }
    
	public UtilisateurDao getuDao() {
		return uDao;
	}

	public void setuDao(UtilisateurDao uDao) {
		this.uDao = uDao;
	}

    public ArrayList<Factures> getListF() {
        return listF;
    }

    public void setListF( ArrayList<Factures> listF ) {
        this.listF = listF;
    }


    public String getSujet() {
        return sujet;
    }

    public void setSujet( String sujet ) {
        this.sujet = sujet;
    }



	public Factures getF() {
		return f;
	}



	public void setF(Factures f) {
		this.f = f;
	}



	public Map<String, Object> getSession() {
		return session;
	}
    
    


	

}
