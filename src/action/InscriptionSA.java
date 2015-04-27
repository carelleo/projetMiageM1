package action;
 
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Syndic;

import com.opensymphony.xwork2.ActionSupport;

import dao.UtilisateurDao;
 

public class InscriptionSA extends ActionSupport implements SessionAware{
     
    //param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private UtilisateurDao uDao = new UtilisateurDao();
    
    private Syndic s;
     
 

    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    public String execute() throws Exception {
        session.put("s",s);
        
        uDao.addAttSyndic(s);
        
        return SUCCESS;  
    }
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#validate()
     */
    public void validate(){
        
        if ( s.getNom().length()==0 || s.getNom().trim().equals( "" )){ 
            addFieldError( "s.nom", "Family name is required." );     
        }
        else if(s.getNom().length()<3 || s.getNom().length()>15){
            addFieldError( "s.nom", "Family name must have between 3 and 15 characters." );
        }
        
        if ( s.getPrenom().length()==0 || s.getPrenom().trim().equals( "" )){ 
            addFieldError( "s.prenom", "First name is required." );     
        }
        else if(s.getPrenom().length()<2 || s.getPrenom().length()>15){
            addFieldError( "s.prenom", "First name must have between 2 and 15 characters." );
        }
         
                 
        if(s.getMail()==null || s.getMail().trim().length()==0){
            addFieldError( "s.mail", "Email is required." );
        }
        if(!s.getMail().matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
            addFieldError( "s.mail", "Email must have @ and '.' ." );
        }
        
        if((s.getMdp()==null || s.getMdp().trim().length()==0) && (s.getMdpc()==null || s.getMdpc().trim().length()==0)){
            if(!s.getMdp().equals(s.getMdpc()))
                addFieldError( "s.mdp", "Passwords must be the same.");
        }
        else if(s.getMdp().trim().length()<3){
            addFieldError( "s.mdp","Passwords must have 3 characters or more.");
        }
         
        if ( s.isCondition()==false ){ 
            addFieldError( "s.condition", "Generals Conditions are not checked." );    
        } 
    }
    
    
    /**
     * @return 
     */
    public Syndic getS() {
        return s;  
    }
     
    /**
     * @param s
     */
    public void setS(Syndic s) {
         
        this.s = s;
         
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