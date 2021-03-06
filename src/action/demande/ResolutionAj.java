package action.demande;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Resolution;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandeDao;

public class ResolutionAj extends ActionSupport implements SessionAware{
    //param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    DemandeDao tDao = new DemandeDao();
    
    Resolution dr;
    ArrayList<Resolution> listResolution;
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    public String execute() throws Exception {
        
        page = "resolution";
        
        tDao.addResolution(dr, (int)session.get( "idU" ));
        listResolution = tDao.getResolution();
        
        return SUCCESS;
    }
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#validate()
     */
    public void validate(){
        
        if ( dr.getSujet().length()==0 || dr.getSujet().trim().equals( "" )){ 
            addFieldError( "dr.sujet", "Subject is required." );     
        }
        else if(dr.getSujet().length()<3 || dr.getSujet().length()>30){
            addFieldError( "dr.sujet", "Subject must have between 3 and 30 characters." );
        }
        else if(tDao.containTSujet(dr.getSujet())){
            addFieldError( "dr.sujet", "Subject already exist." );
        }
        
        if ( dr.getContenu().length()==0 || dr.getContenu().trim().equals( "" )){ 
            addFieldError( "dr.contenu", "Contenu is required." );     
        }
        else if(dr.getContenu().length()<5){
            addFieldError( "dr.contenu", "Contenu must have more than 5 characters." );
        }
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

    /**
     * @return
     */
    public DemandeDao gettDao() {
        return tDao;
    }

    /**
     * @param tDao
     */
    public void settDao( DemandeDao tDao ) {
        this.tDao = tDao;
    }

    /**
     * @return
     */
    public Resolution getDr() {
        return dr;
    }

    /**
     * @param dr
     */
    public void setDr( Resolution dr ) {
        this.dr = dr;
    }

    /**
     * @return
     */
    public ArrayList<Resolution> getListResolution() {
        return listResolution;
    }

    /**
     * @param listResolution
     */
    public void setListResolution( ArrayList<Resolution> listResolution ) {
        this.listResolution = listResolution;
    }

}
