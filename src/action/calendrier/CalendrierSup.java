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
    
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    public String execute() throws Exception {
    	
    	eDao.supprEvenement(titre);
    	tabE = eDao.getEvenement();
    	
    	page = "calendrier";
    	
        return SUCCESS;
    }
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#validate()
     */
    public void validate(){
		
        if(!eDao.containEvenement(titre)){
            addFieldError( "titre", "Title doesn't exist." );
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
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return
	 */
	public ArrayList<Evenement> getTabE() {
		return tabE;
	}

	/**
	 * @param tabE
	 */
	public void setTabE(ArrayList<Evenement> tabE) {
		this.tabE = tabE;
	}

	/**
	 * @return
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
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
	public void seteDao(EvenementDao eDao) {
		this.eDao = eDao;
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
}
