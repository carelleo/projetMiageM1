package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Budget;


import com.opensymphony.xwork2.ActionSupport;

import dao.BudgetDao;
import dao.UtilisateurDao;

public class BudgetA extends ActionSupport implements SessionAware {
	
	//param page
    private String page;
    private int anne;
    private int annee;
    private String prop;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private BudgetDao bDao = new BudgetDao();
    private UtilisateurDao uDao = new UtilisateurDao();
    
    ArrayList<Budget> listB;
    private Budget b;
    
    @Override
    public String execute() throws Exception {
        
    	listB = bDao.getBudget();
        
        return SUCCESS;
    }
    
    public String supprB() throws Exception {
        
        page = "budget";
        
        bDao.supprB(anne);
        listB = bDao.getBudget();
        
        return SUCCESS;
    }
    
    public String consulterB() throws Exception{
    	System.out.println("bAnnee : " + annee);
    	System.out.println("getbAnnee : " + this.getAnnee());
		b = bDao.getOneBudget( annee );
		System.out.println("b : " + b);

		
	    session.put( "b", b );
		return SUCCESS;
    }
	    
    public String modifB() throws Exception {
        b = bDao.getOneBudget( annee );
        session.put( "annee", annee );
        
        
        
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

	public int getAnne() {
		return anne;
	}

	public void setAnne(int anne) {
		this.anne = anne;
	}



	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

	public BudgetDao getbDao() {
		return bDao;
	}

	public void setbDao(BudgetDao bDao) {
		this.bDao = bDao;
	}

	public UtilisateurDao getuDao() {
		return uDao;
	}

	public void setuDao(UtilisateurDao uDao) {
		this.uDao = uDao;
	}

	public ArrayList<Budget> getListB() {
		return listB;
	}

	public void setListB(ArrayList<Budget> listB) {
		this.listB = listB;
	}

	public Budget getB() {
		return b;
	}

	public void setB(Budget b) {
		this.b = b;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}



   

    
	
	
}
