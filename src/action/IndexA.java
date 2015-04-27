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
    
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    public String execute() throws Exception {

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
}
