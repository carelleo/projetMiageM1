package action;

import com.opensymphony.xwork2.ActionSupport; 
import java.util.Map; 
import org.apache.struts2.interceptor.SessionAware; 
 
public class Effacer extends ActionSupport implements SessionAware{ 
   
    private Map<String, Object> session; 
   
    @Override 
    public String execute(){ 
        String cp=(String)session.get("cp"); 
        String s=(String)session.get("s");

        if(cp!=null)
            session.remove("cp"); 
        
        if(s!=null)
            session.remove( "s" );
        
        return SUCCESS; 
    } 
 
    @Override 
    public void setSession(Map<String, Object> map) { 
        this.session=map; 
    } 
} 
