package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Budget;

import com.opensymphony.xwork2.ActionSupport;

import dao.BudgetDao;

public class BudgetAj extends ActionSupport implements SessionAware{
    //param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    BudgetDao bDao = new BudgetDao();
    
    Budget b;
    ArrayList<Budget> listB;
    
    @Override
    public String execute() throws Exception {
        
        page = "budget";
        
        bDao.addBudget(b, (int)session.get( "idU" ));
        listB = bDao.getBudget();
        
        return SUCCESS;
    }
    
    public void validate(){
        
    	
    	
        if ( b.getAnnee() <= 0 ){ 
            addFieldError( "b.année", "Year is required." );     
        }
        
        else if(bDao.containtAnnée(b.getAnnee())){
                addFieldError( "b.année", "A budget for this year already exist." );
        }
        
        else if(b.getBudgetEau()<=0 ){
            addFieldError( "b.budgetEau", "Budget eau must be positive." );
        }
        else if(b.getBudgetElectricite()<=0 ){
            addFieldError( "b.budgetElectricite", "Budget electricite must be positive." );
        }
        else if(b.getBudgetGaz()<=0 ){
            addFieldError( "b.budgetGaz", "Budget Gaz must be positive." );
        }
        else if(b.getBudgetEntretien()<=0 ){
            addFieldError( "b.budgetEntretien", "Budget Entretien must be positive." );
        }
        else if(b.getCommentaire().length() == 0 || b.getCommentaire().equals("") ){
            addFieldError( "b.budgetEntretien", "Commentaire is required." );
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

	public BudgetDao getbDao() {
		return bDao;
	}

	public void setbDao(BudgetDao bDao) {
		this.bDao = bDao;
	}

	public Budget getB() {
		return b;
	}

	public void setB(Budget b) {
		this.b = b;
	}

	public ArrayList<Budget> getListB() {
		return listB;
	}

	public void setListB(ArrayList<Budget> listB) {
		this.listB = listB;
	}



}
