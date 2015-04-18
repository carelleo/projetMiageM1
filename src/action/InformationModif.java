package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import beans.Administrateur;
import beans.Adresse;
import beans.Coproprietaire;
import beans.Syndic;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

import dao.UtilisateurDao;

public class InformationModif extends ActionSupport implements SessionAware{
    //param page
    private String page;
    
    //la session
    private Map<String, Object> session;
    
    //dao
    private UtilisateurDao uDao = new UtilisateurDao();
    
    Coproprietaire c;
    Syndic s;
    Administrateur a;
    
    @Override
    public String execute() throws Exception {
        int id = (int)session.get("idU");
        
        Utilisateur u = uDao.getOneUtilisateur( id );
        
        if(u.getType().equals( "proprietaire" ) || u.getType().equals( "locataire" )){
            uDao.modifU(c, id);
            c = uDao.getOneCoproprietaire( id );
            
            session.put( "utilisateur", c );
        }
        else if(u.getType().equals( "syndic" )){
            uDao.modifU(s, id);
            s = uDao.getOneSyndic( id );
            
            session.put( "utilisateur", s );
        }
        else if(u.getType().equals( "admin" )){
            uDao.modifU(a, id);
            a = uDao.getOneAdmin( id );
            
            session.put( "utilisateur", a );
        }
        
        return SUCCESS;
    }
    
    /*public void validate(){
        
        if ( c.getNom().length()==0 || c.getNom().trim().equals( "" )){ 
            addFieldError( "c.nom", "Family name is required." );     
        }
        else if(c.getNom().length()<3 || c.getNom().length()>15){
            addFieldError( "c.nom", "Family name must have between 3 and 15 characters." );
        }
        
        if ( c.getPrenom().length()==0 || c.getPrenom().trim().equals( "" )){ 
            addFieldError( "c.prenom", "First name is required." );     
        }
        else if(c.getPrenom().length()<2 || c.getPrenom().length()>15){
            addFieldError( "c.prenom", "First name must have between 2 and 15 characters." );
        }
                 
        if(c.getMail()==null || c.getMail().trim().length()==0){
            addFieldError( "c.mail", "Email is required." );
        }
        if(!c.getMail().matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
            addFieldError( "c.mail", "Email must have @ and '.' ." );
        }
        
        if((c.getMdp()==null || c.getMdp().trim().length()==0) && (c.getMdpc()==null || c.getMdpc().trim().length()==0)){
            if(!c.getMdp().equals(c.getMdpc()))
                addFieldError( "c.mdp", "Passwords must be the same.");
        }
        else if(c.getMdp().trim().length()<3){
            addFieldError( "c.mdp","Passwords must have 3 characters or more.");
        }
        
        /********************************************************************************/
        
        /*if ( s.getNom().length()==0 || s.getNom().trim().equals( "" )){ 
            addFieldError( "s.nom", "Family name is required." );     
        }
        else if(s.getNom().length()<3 || s.getNom().length()>15){
            addFieldError( "s.nom", "Family name must have between 3 and 15 characters." );
        }
        
        if ( s.getPrenom().length()==0 || s.getPrenom().trim().equals( "" )){ 
            addFieldError( "s.prenom", "First name is required." );     
        }
        else if(s.getPrenom().length()<2 || s.getPrenom().length()>15){
            addFieldError( "s.prenom", "First name must have between 2 and 15 characters." );
        }
                 
        if(s.getMail()==null || s.getMail().trim().length()==0){
            addFieldError( "s.mail", "Email is required." );
        }
        if(!s.getMail().matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
            addFieldError( "s.mail", "Email must have @ and '.' ." );
        }
        
        if((s.getMdp()==null || s.getMdp().trim().length()==0) && (s.getMdpc()==null || s.getMdpc().trim().length()==0)){
            if(!s.getMdp().equals(s.getMdpc()))
                addFieldError( "s.mdp", "Passwords must be the same.");
        }
        else if(s.getMdp().trim().length()<3){
            addFieldError( "s.mdp","Passwords must have 3 characters or more.");
        }
        
        /********************************************************************************/
        
        /*if ( a.getNom().length()==0 || a.getNom().trim().equals( "" )){ 
            addFieldError( "a.nom", "Family name is required." );     
        }
        else if(a.getNom().length()<3 || a.getNom().length()>15){
            addFieldError( "a.nom", "Family name must have between 3 and 15 characters." );
        }
        
        if ( a.getPrenom().length()==0 || a.getPrenom().trim().equals( "" )){ 
            addFieldError( "a.prenom", "First name is required." );     
        }
        else if(a.getPrenom().length()<2 || a.getPrenom().length()>15){
            addFieldError( "a.prenom", "First name must have between 2 and 15 characters." );
        }
                 
        if(a.getMail()==null || a.getMail().trim().length()==0){
            addFieldError( "a.mail", "Email is required." );
        }
        if(!a.getMail().matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
            addFieldError( "a.mail", "Email must have @ and '.' ." );
        }
        
        if((a.getMdp()==null || a.getMdp().trim().length()==0) && (a.getMdpc()==null || a.getMdpc().trim().length()==0)){
            if(!a.getMdp().equals(a.getMdpc()))
                addFieldError( "a.mdp", "Passwords must be the same.");
        }
        else if(a.getMdp().trim().length()<3){
            addFieldError( "a.mdp","Passwords must have 3 characters or more.");
        }
        
    }*/

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

    public Coproprietaire getC() {
        return c;
    }

    public void setC( Coproprietaire c ) {
        this.c = c;
    }

    public Syndic getS() {
        return s;
    }

    public void setS( Syndic s ) {
        this.s = s;
    }

    public Administrateur getA() {
        return a;
    }

    public void setA( Administrateur a ) {
        this.a = a;
    }
}
