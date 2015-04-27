package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;


import beans.Budget;

import com.opensymphony.xwork2.ActionSupport;

import dao.BudgetDao;

/**
 * @author Jean Francois
 *
 */
/**
 * @author Jean Francois
 *
 */
public class BudgetModif extends ActionSupport implements SessionAware{
    //param page
    private String page;
    private Budget b;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    BudgetDao bDao = new BudgetDao();
    
    ArrayList<Budget> listB;
    
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    public String execute() throws Exception {
        page = "budget";
        
        bDao.modifB( b, (int)session.get( "annee") );
        listB = bDao.getBudget();
        
        session.remove( "annee" );
        
        return SUCCESS;
    }
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#validate()
     */
    public void validate(){
    	
    	if(b.getAnnee()<=0){
    		addFieldError("b.annee", "Year must be positive" );
    	}
    	
        else if(!(b.getAnnee() == (int)session.get( "annee" ))){
            if(bDao.containtAnnee(b.getAnnee())){
                addFieldError( "b.annee", "A budget for this year already exist." );
            }
        }
    	
    	else if ( b.getBudgetEau()<=0){ 
            addFieldError( "b.budgetEau", "Budget eau must be positive." );     
        }
    	else if ( b.getBudgetElectricite()<=0){ 
            addFieldError( "b.budgetElectricite", "Budget électricité must be positive." );     
        }
    	
    	else if ( b.getBudgetGaz()<=0){ 
            addFieldError( "b.budgetGaz", "Budget gaz must be positive." );     
        }
    	else if ( b.getBudgetEntretien()<=0){ 
            addFieldError( "b.budgetEntretien", "Budget entretien must be positive." );     
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
	public ArrayList<Budget> getListB() {
		return listB;
	}

	/**
	 * @param listB
	 */
	public void setListB(ArrayList<Budget> listB) {
		this.listB = listB;
	}

    
    
}
