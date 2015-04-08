package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Administrateur;
import beans.Coproprietaire;
import beans.Syndic;
import beans.Utilisateur;

public class UtilisateurDao {
	
    /*BDD utilisateurs*/
    
    public Utilisateur getOneUtilisateur(String mail){
        
        Utilisateur u = new Utilisateur(0,null,null,null);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM utilisateurs WHERE mail=?");
            p.setString(1, mail);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new Utilisateur(r.getInt( "id" ), r.getString( "mail" ), r.getString( "mdp" ),r.getString( "type" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
    
	public ArrayList<Utilisateur> getUtilisateur(){
		
		ArrayList<Utilisateur> liste = new ArrayList<Utilisateur>();
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM utilisateurs ORDER BY id ASC");
			ResultSet r = p.executeQuery();
			
			while(r.next()){
			    Utilisateur u = new Utilisateur(r.getInt( "id" ), r.getString( "mail" ), r.getString( "mdp" ),r.getString( "type" ));
				liste.add(u);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return liste;
	}
	
	public void addCoproprietaire(Coproprietaire cp){
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO utilisateurs(mail, nom, prenom, type, mdp, date) VALUES (?, ?, ?, ?, ?, now())");
			p.setString(1, cp.getMail());
			p.setString(2, cp.getNom());
			p.setString(3, cp.getPrenom());
			p.setString(4, cp.getType());
			p.setString(5, cp.getMdp());
			
			p.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addSyndic(Syndic s){
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO utilisateurs(mail, nom, prenom, type, mdp, date) VALUES (?, ?, ?, ?, ?, now())");
			p.setString(1, s.getMail());
			p.setString(2, s.getNom());
			p.setString(3, s.getPrenom());
			p.setString(4, s.getType());
			p.setString(5, s.getMdp());
			
			p.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addAdmin(Administrateur a){
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO utilisateurs(mail, nom, prenom, type, mdp, date) VALUES (?, ?, ?, ?, ?, now())");
			p.setString(1, a.getMail());
			p.setString(2, a.getNom());
			p.setString(3, a.getPrenom());
			p.setString(4, a.getType());
			p.setString(5, a.getMdp());
			
			p.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void supprUtilisateur(String mail){
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM utilisateurs WHERE mail=?");
			p.setString(1, mail);
			
			p.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*BDD attutilisateurs*/
	
	public Utilisateur getOneAttUtilisateur(String mail){
        
        Utilisateur u = new Utilisateur(0,null,null,null);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM attutilisateurs WHERE mail=?");
            p.setString(1, mail);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new Utilisateur(r.getInt( "id" ), r.getString( "mail" ), r.getString( "mdp" ),r.getString( "type" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
    
    public ArrayList<Utilisateur> getAttUtilisateur(){
        
        ArrayList<Utilisateur> liste = new ArrayList<Utilisateur>();
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM attutilisateurs ORDER BY id ASC");
            ResultSet r = p.executeQuery();
            
            while(r.next()){
                Utilisateur u = new Utilisateur(r.getInt( "id" ), r.getString( "mail" ), r.getString( "mdp" ),r.getString( "type" ));
                liste.add(u);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return liste;
    }
    
    public void addAttCoproprietaire(Coproprietaire cp){
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO attutilisateurs(mail, nom, prenom, type, mdp, date) VALUES (?, ?, ?, ?, ?, now())");
            p.setString(1, cp.getMail());
            p.setString(2, cp.getNom());
            p.setString(3, cp.getPrenom());
            p.setString(4, cp.getType());
            p.setString(5, cp.getMdp());
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void addAttSyndic(Syndic s){
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO attutilisateurs(mail, nom, prenom, type, mdp, date) VALUES (?, ?, ?, ?, ?, now())");
            p.setString(1, s.getMail());
            p.setString(2, s.getNom());
            p.setString(3, s.getPrenom());
            p.setString(4, s.getType());
            p.setString(5, s.getMdp());
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void supprAttUtilisateur(String mail){
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM attutilisateurs WHERE mail=?");
            p.setString(1, mail);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Syndic getOneAttSyndic( String mail ) {
        Syndic s = new Syndic();
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM attutilisateurs WHERE mail=?");
            p.setString(1, mail);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                s = new Syndic(r.getString( "nom" ),r.getString( "prenom" ),r.getString( "mail" ), r.getString( "mdp" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return s;
    }
    
    public Coproprietaire getOneAttCoproprietaire( String mail ) {
        Coproprietaire s = new Coproprietaire();
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM attutilisateurs WHERE mail=?");
            p.setString(1, mail);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                s = new Coproprietaire(r.getString( "type" ),r.getString( "nom" ),r.getString( "prenom" ),r.getString( "mail" ), r.getString( "mdp" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return s;
    }
}
