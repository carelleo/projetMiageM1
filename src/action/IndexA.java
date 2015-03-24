package action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexA extends ActionSupport {

    private String page = null; 
    
    public String execute() throws Exception {

        return SUCCESS;
    }

    public String getPage() {
        return page;
    }

    public void setPage( String page ) {
        this.page = page;
    }
}
