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
    
    public String execute() throws Exception {
    	
    	tabE = eDao.getEvenement();
    	
        return SUCCESS;
    }

    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }

    public Evenement getEvent() {
        return event;
    }

    public void setEvent( Evenement event ) {
        this.event = event;
    }

    public ArrayList<Evenement> getTabE() {
        return tabE;
    }

    public void setTabE( ArrayList<Evenement> tabE ) {
        this.tabE = tabE;
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

    public EvenementDao geteDao() {
        return eDao;
    }

    public void seteDao( EvenementDao eDao ) {
        this.eDao = eDao;
    }
}
