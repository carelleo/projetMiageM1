package action;
 
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Coproprietaire;

import com.opensymphony.xwork2.ActionSupport;

import dao.UtilisateurDao;
 
public class InscriptionPA extends ActionSupport implements SessionAware{
     
    //param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private UtilisateurDao uDao = new UtilisateurDao();
    
    private Coproprietaire cp;
     
 
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    public String execute() throws Exception {
        session.put("cp",cp);
        
        uDao.addAttCoproprietaire(cp);
        
        return SUCCESS;  
    }
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#validate()
     */
    public void validate(){
        
        if ( cp.getNom().length()==0 || cp.getNom().trim().equals( "" )){ 
            addFieldError( "cp.nom", "Family name is required." );     
        }
        else if(cp.getNom().length()<3 || cp.getNom().length()>15){
            addFieldError( "cp.nom", "Family name must have between 3 and 15 characters." );
        }
        
        if ( cp.getPrenom().length()==0 || cp.getPrenom().trim().equals( "" )){ 
            addFieldError( "cp.prenom", "First name is required." );     
        }
        else if(cp.getPrenom().length()<2 || cp.getPrenom().length()>15){
            addFieldError( "cp.prenom", "First name must have between 2 and 15 characters." );
        }
         
                 
        if(cp.getMail()==null || cp.getMail().trim().length()==0){
            addFieldError( "cp.mail", "Email is required." );
        }
        if(!cp.getMail().matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
            addFieldError( "cp.mail", "Email must have @ and '.' ." );
        }
        
        if((cp.getMdp()==null || cp.getMdp().trim().length()==0) && (cp.getMdpc()==null || cp.getMdpc().trim().length()==0)){
            if(!cp.getMdp().equals(cp.getMdpc()))
                addFieldError( "cp.mdp", "Passwords must be the same.");
        }
        else if(cp.getMdp().trim().length()<3){
            addFieldError( "cp.mdp","Passwords must have 3 characters or more.");
        }
         
        if ( cp.isCondition()==false ){ 
            addFieldError( "cp.condition", "Generals Conditions are not checked." );    
        } 
    }
     
    /**
     * @return
     */
    public Coproprietaire getCp() {
        return cp;  
    }
     
    /**
     * @param cp
     */
    public void setCp(Coproprietaire cp) {
         
        this.cp = cp;
         
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
 
}