package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;


import beans.Budget;

import com.opensymphony.xwork2.ActionSupport;

import dao.BudgetDao;

public class BudgetModif extends ActionSupport implements SessionAware{
    //param page
    private String page;
    private Budget b;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    BudgetDao bDao = new BudgetDao();
    
    ArrayList<Budget> listB;
    
    
    @Override
    public String execute() throws Exception {
        page = "budget";
        
        bDao.modifB( b, (int)session.get( "annee") );
        listB = bDao.getBudget();
        
        session.remove( "annee" );
        
        return SUCCESS;
    }
    
    public void validate(){
        
    	System.out.println("Année ; "  + b.getAnnee() );
    	System.out.println("eau ; "  + b.getBudgetEau());
    	System.out.println("electricite ; "  + b.getBudgetElectricite() );
    	System.out.println("gaz ; "  + b.getBudgetGaz());
    	System.out.println("entetien ; "  + b.getBudgetEntretien());
    	System.out.println("commentaire ; "  + b.getCommentaire());
    	
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

	public Budget getB() {
		return b;
	}

	public void setB(Budget b) {
		this.b = b;
	}

	public BudgetDao getbDao() {
		return bDao;
	}

	public void setbDao(BudgetDao bDao) {
		this.bDao = bDao;
	}

	public ArrayList<Budget> getListB() {
		return listB;
	}

	public void setListB(ArrayList<Budget> listB) {
		this.listB = listB;
	}

    
    
}
