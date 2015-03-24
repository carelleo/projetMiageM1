package action;

import java.util.ArrayList;

import beans.Date;
import beans.Evenement;

import com.opensymphony.xwork2.ActionSupport;

public class CalendrierA extends ActionSupport {
    
    private Date date = new Date();
    private Evenement event = new Evenement();
    private ArrayList<Evenement> tabE = new ArrayList<Evenement>();
    private String page;
    
    public String execute() throws Exception {
        return SUCCESS;
    }

    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }

    public Evenement getEvent() {
        return event;
    }

    public void setEvent( Evenement event ) {
        this.event = event;
    }

    public ArrayList<Evenement> getTabE() {
        return tabE;
    }

    public void setTabE( ArrayList<Evenement> tabE ) {
        this.tabE = tabE;
    }

    public String getPage() {
        return page;
    }

    public void setPage( String page ) {
        this.page = page;
    }
}
