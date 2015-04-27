package action.calendrier;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.joda.time.DateTime;

import beans.Date;
import beans.Evenement;

import com.opensymphony.xwork2.ActionSupport;

import dao.EvenementDao;

public class CalendrierA extends ActionSupport implements SessionAware{
    
	//param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    private Date date = new Date();
    
    private Evenement event = new Evenement();
    
    private EvenementDao eDao = new EvenementDao();
    
    private ArrayList<Evenement> tabE = new ArrayList<Evenement>();
    
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    public String execute() throws Exception {
    	
    	tabE = eDao.getEvenement();
    	
        return SUCCESS;
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
    public void setDate( Date date ) {
        this.date = date;
    }

    /**
     * @return
     */
    public Evenement getEvent() {
        return event;
    }

    /**
     * @param event
     */
    public void setEvent( Evenement event ) {
        this.event = event;
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
    public void setTabE( ArrayList<Evenement> tabE ) {
        this.tabE = tabE;
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
    public EvenementDao geteDao() {
        return eDao;
    }

    /**
     * @param eDao
     */
    public void seteDao( EvenementDao eDao ) {
        this.eDao = eDao;
    }
}
