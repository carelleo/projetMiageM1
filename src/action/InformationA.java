package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Administrateur;
import beans.Coproprietaire;
import beans.Syndic;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

import dao.UtilisateurDao;

public class InformationA extends ActionSupport implements SessionAware{
    //param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private UtilisateurDao uDao = new UtilisateurDao();
    
    @Override
    public String execute() throws Exception {
        int id = (int)session.get("idU");
        
        Utilisateur u = uDao.getOneUtilisateur( id );
        
        if(u.getType().equals( "proprietaire" ) || u.getType().equals( "locataire" )){
            Coproprietaire  c = uDao.getOneCoproprietaire( id );
            
            session.put( "utilisateur", c );
        }
        else if(u.getType().equals( "syndic" )){
            Syndic s = uDao.getOneSyndic( id );
            
            session.put( "utilisateur", s );
        }
        else if(u.getType().equals( "admin" )){
            Administrateur a = uDao.getOneAdmin( id );
            
            session.put( "utilisateur", a );
        }
        
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

    public UtilisateurDao getuDao() {
        return uDao;
    }

    public void setuDao( UtilisateurDao uDao ) {
        this.uDao = uDao;
    }
}
