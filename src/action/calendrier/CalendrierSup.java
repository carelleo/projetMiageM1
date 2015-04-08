package action.calendrier;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Date;
import beans.Evenement;

import com.opensymphony.xwork2.ActionSupport;

import dao.EvenementDao;

public class CalendrierSup extends ActionSupport implements SessionAware{
    
	//param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    private Date date = new Date();
    
    private String titre;
    
    private EvenementDao eDao = new EvenementDao();
    
    private ArrayList<Evenement> tabE = new ArrayList<Evenement>();
    
    
    public String execute() throws Exception {
    	
    	eDao.supprEvenement(titre);
    	tabE = eDao.getEvenement();
    	
    	page = "calendrier";
    	
        return SUCCESS;
    }
    
    public void validate(){
		
        if(!eDao.containEvenement(titre)){
            addFieldError( "titre", "Title doesn't exist." );
        }
    }

    public String getPage() {
        return page;
    }

    public void setPage( String page ) {
        this.page = page;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Evenement> getTabE() {
		return tabE;
	}

	public void setTabE(ArrayList<Evenement> tabE) {
		this.tabE = tabE;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public EvenementDao geteDao() {
		return eDao;
	}

	public void seteDao(EvenementDao eDao) {
		this.eDao = eDao;
	}

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession( Map<String, Object> session ) {
        this.session = session;
    }
}
