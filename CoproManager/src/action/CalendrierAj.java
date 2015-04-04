package action;

import java.util.ArrayList;

import beans.Date;
import beans.Evenement;

import com.opensymphony.xwork2.ActionSupport;

import dao.EvenementDao;

public class CalendrierAj extends ActionSupport {
    
	//param page
    private String page;
    
    private Date date = new Date();
    
    private Evenement event = new Evenement();
    
    private EvenementDao eDao = new EvenementDao();
    
    private ArrayList<Evenement> tabE = new ArrayList<Evenement>();
    
    
    public String execute() throws Exception {
    	
    	eDao.addEvenement(event);
    	tabE = eDao.getEvenement();
    	
        return SUCCESS;
    }
    
    public void validate(){
		
        if ( event.getTitre().length()==0 || event.getTitre().trim().equals( "" )){ 
            addFieldError( "event.titre", "Title is required." );     
        }
        else if(event.getTitre().length()<3 || event.getTitre().length()>30){
            addFieldError( "event.titre", "Title must have between 3 and 30 characters." );
        }
        else if(eDao.containEvenement(event.getTitre())){
            addFieldError( "event.titre", "Title already exist." );
        }
    }

    public Evenement getEvent() {
        return event;
    }

    public void setEvent( Evenement event ) {
        this.event = event;
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
}
