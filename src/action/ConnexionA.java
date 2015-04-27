package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

import dao.UtilisateurDao;

public class ConnexionA extends ActionSupport implements SessionAware{
    //param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private UtilisateurDao uDao = new UtilisateurDao();
    
    private String mail = null;
    private String mdp;
     
 
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    public String execute() throws Exception {
        
        String s = ERROR;
        
        ArrayList<Utilisateur> liste = uDao.getUtilisateur();
        
        for(Utilisateur u: liste){
            if(u.getMail().equals( mail ) && u.getMotDePasse().equals( mdp )){
                s = SUCCESS;
                session.put("mail",u.getMail());
                session.put("type",u.getType());
                session.put("idU",u.getId());
            }
        }
        
        session.put("mail2",mail);
        
        return s;  
    }
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#validate()
     */
    public void validate(){
                         
        if(mail==null || mail.trim().length()==0){
            addFieldError( "mail", "Email is required." );
        }
        if(!mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
            addFieldError( "mail", "Email must have @ and '.' ." );
        }
        
        if((mdp==null || mdp.trim().length()==0)){
                addFieldError( "mdp", "Passwords is required.");
        }
        else if(mdp.trim().length()<3){
            addFieldError( "mdp","Passwords must have 3 characters or more.");
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
    public UtilisateurDao getuDao() {
        return uDao;
    }

    /**
     * @param uDao
     */
    public void setuDao( UtilisateurDao uDao ) {
        this.uDao = uDao;
    }

    /**
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail
     */
    public void setMail( String mail ) {
        this.mail = mail;
    }

    /**
     * @return
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp
     */
    public void setMdp( String mdp ) {
        this.mdp = mdp;
    }
}
