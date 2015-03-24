package action;
 
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Syndic;

import com.opensymphony.xwork2.ActionSupport;
 
public class InscriptionSA extends ActionSupport implements SessionAware{
     
    //param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    private Syndic s;
     
 
    @Override
    public String execute() throws Exception {
        session.put("s",s);
        return SUCCESS;  
    }
    
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
     
    public Syndic getS() {
        return s;  
    }
     
    public void setS(Syndic s) {
         
        this.s = s;
         
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
 
}