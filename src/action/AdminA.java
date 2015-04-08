package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Coproprietaire;
import beans.Syndic;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

import dao.UtilisateurDao;

public class AdminA extends ActionSupport implements SessionAware{
    //param page
    private String page;
    private String aUM;
    private String aUT;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private UtilisateurDao uDao = new UtilisateurDao();
    
    private String email;
    private ArrayList<Utilisateur> attU;
    private ArrayList<Utilisateur> tabU;
    
    @Override
    public String execute() throws Exception {
        
        String s = ERROR;
        
        if(session.get( "mail" )!=null){
            Utilisateur u = uDao.getOneUtilisateur((String)session.get( "mail" ));
            
            if(u.getType().equals( "admin" ))
                s = SUCCESS;
        }
        
        attU = uDao.getAttUtilisateur();
        tabU = uDao.getUtilisateur();
        
        return s;  
    }
    
    public String ajouterAttU() throws Exception {
    	
    	page = "administration";
    	
        attU = uDao.getAttUtilisateur();
        tabU = uDao.getUtilisateur();
        
        Syndic s;
        Coproprietaire c;
        
        if(aUT.equals( "syndic" )){
            s = uDao.getOneAttSyndic( aUM );
            uDao.addSyndic( s );
            uDao.supprAttUtilisateur( aUM );
        }
        else if(aUT.equals( "proprietaire" )){
            c = uDao.getOneAttCoproprietaire( aUM );
            uDao.addCoproprietaire( c );
            uDao.supprAttUtilisateur( aUM );
        }
        else if(aUT.equals( "locataire" )){
            c = uDao.getOneAttCoproprietaire( aUM );
            uDao.addCoproprietaire( c );
            uDao.supprAttUtilisateur( aUM );
        }
        
        attU = uDao.getAttUtilisateur();
        tabU = uDao.getUtilisateur();
        
        return SUCCESS;  
    }
    
    public String supprU() throws Exception {

    	page = "administration";
    	
        uDao.supprUtilisateur( aUM );
        
        attU = uDao.getAttUtilisateur();
        tabU = uDao.getUtilisateur();
        
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

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public ArrayList<Utilisateur> getAttU() {
        return attU;
    }

    public void setAttU( ArrayList<Utilisateur> attU ) {
        this.attU = attU;
    }

    public ArrayList<Utilisateur> getTabU() {
        return tabU;
    }

    public void setTabU( ArrayList<Utilisateur> tabU ) {
        this.tabU = tabU;
    }

    public String getAUT() {
        return aUT;
    }

    public void setAUT( String aUT ) {
        this.aUT = aUT;
    }

    public String getAUM() {
        return aUM;
    }

    public void setAUM( String aUM ) {
        this.aUM = aUM;
    }
}
