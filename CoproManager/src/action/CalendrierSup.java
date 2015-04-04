package action;

import java.util.ArrayList;

import beans.Date;
import beans.Evenement;

import com.opensymphony.xwork2.ActionSupport;

import dao.EvenementDao;

public class CalendrierSup extends ActionSupport {
    
	//param page
    private String page;
    
    private Date date = new Date();
    
    private String titre;
    
    private EvenementDao eDao = new EvenementDao();
    
    private ArrayList<Evenement> tabE = new ArrayList<Evenement>();
    
    
    public String execute() throws Exception {
    	
    	eDao.supprEvenement(titre);
    	tabE = eDao.getEvenement();
    	
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
}
