package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Coproprietaire;
import beans.Syndic;

import com.opensymphony.xwork2.ActionSupport;

import dao.UtilisateurDao;

public class IndexA extends ActionSupport implements SessionAware{
    //param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    public String execute() throws Exception {

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
