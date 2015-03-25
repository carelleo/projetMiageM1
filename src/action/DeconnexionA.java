package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DeconnexionA extends ActionSupport implements SessionAware{
    //param page
    private String page;
    
    //la session
    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        
        session.clear();
        
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
}
