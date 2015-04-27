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
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    public String execute() throws Exception {
        
    	listB = bDao.getBudget();
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String supprB() throws Exception {
        
        page = "budget";
        
        bDao.supprB(anne);
        listB = bDao.getBudget();
        
        return SUCCESS;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public String consulterB() throws Exception{
    	System.out.println("bAnnee : " + annee);
    	System.out.println("getbAnnee : " + this.getAnnee());
		b = bDao.getOneBudget( annee );
		System.out.println("b : " + b);

		
	    session.put( "b", b );
		return SUCCESS;
    }
	    
    /**
     * @return
     * @throws Exception
     */
    public String modifB() throws Exception {
        b = bDao.getOneBudget( annee );
        session.put( "annee", annee );
        
        
        
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
	public int getAnne() {
		return anne;
	}

	/**
	 * @param anne
	 */
	public void setAnne(int anne) {
		this.anne = anne;
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
	public BudgetDao getbDao() {
		return bDao;
	}

	/**
	 * @param bDao
	 */
	public void setbDao(BudgetDao bDao) {
		this.bDao = bDao;
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
	public ArrayList<Budget> getListB() {
		return listB;
	}

	/**
	 * @param listB
	 */
	public void setListB(ArrayList<Budget> listB) {
		this.listB = listB;
	}

	/**
	 * @return
	 */
	public Budget getB() {
		return b;
	}

	/**
	 * @param b
	 */
	public void setB(Budget b) {
		this.b = b;
	}

	/**
	 * @return
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * @param annee
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}



   

    
	
	
}
