package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Administrateur;
import beans.Coproprietaire;
import beans.DemandeTravaux;
import beans.Syndic;
import beans.Utilisateur;

public class UtilisateurDao {
	
    /*BDD utilisateurs*/
    
    /**
     * @param mail
     * @return
     */
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
    
    /**
     * @param id
     * @return
     */
    public Utilisateur getOneUtilisateur(int id){
        
        Utilisateur u = new Utilisateur(0,null,null,null);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM utilisateurs WHERE id=?");
            p.setInt(1, id);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new Utilisateur(r.getInt( "id" ), r.getString( "mail" ), r.getString( "mdp" ),r.getString( "type" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
    
	/**
	 * @return
	 */
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
	
	/**
	 * @param cp
	 */
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
	
	/**
	 * @param s
	 */
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
	
	/**
	 * @param a
	 */
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
	
	/**
	 * @param mail
	 */
	public void supprUtilisateur(String mail){
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM utilisateurs WHERE mail=?");
			p.setString(1, mail);
			
			p.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Coproprietaire getOneCoproprietaire(int id){
        
        Coproprietaire u = new Coproprietaire(null,null,null,null,null,null,null);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM utilisateurs WHERE id=?");
            p.setInt(1, id);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new Coproprietaire(r.getString( "type" ), r.getString( "nom" ), r.getString( "prenom" ), r.getString( "mail" ), r.getString( "mdp" ), r.getString( "teleF" ), r.getString( "teleP" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
	
	/**
	 * @param id
	 * @return
	 */
	public Syndic getOneSyndic(int id){
        
	    Syndic u = new Syndic(null,null,null,null,null,null);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM utilisateurs WHERE id=?");
            p.setInt(1, id);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new Syndic(r.getString( "nom" ), r.getString( "prenom" ), r.getString( "mail" ), r.getString( "mdp" ), r.getString( "teleF" ), r.getString( "teleP" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
	
	/**
	 * @param id
	 * @return
	 */
	public Administrateur getOneAdmin(int id){
        
	    Administrateur u = new Administrateur(null,null,null,null,null,null);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM utilisateurs WHERE id=?");
            p.setInt(1, id);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new Administrateur(r.getString( "nom" ), r.getString( "prenom" ), r.getString( "mail" ), r.getString( "mdp" ), r.getString( "teleF" ), r.getString( "teleP" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
	
	/**
	 * @param c
	 * @param id
	 */
	public void modifU(Coproprietaire c, int id){
	    System.out.println("modif "+id+" "+c.getTeleF());
	    
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("UPDATE utilisateurs SET nom=?, prenom=?, mail=?, type=?, mdp=?, teleF=?, teleP=?  WHERE id=?");
            p.setString(1, c.getNom());
            p.setString(2, c.getPrenom());
            p.setString(3, c.getMail());
            p.setString(4, c.getType());
            p.setString(5, c.getMdp());
            p.setString(6, c.getTeleF());
            p.setString(7, c.getTeleP());
            p.setInt(8, id);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	
	/**
	 * @param c
	 * @param id
	 */
	public void modifU(Syndic c, int id){
        System.out.println("modif "+id+" "+c.getTeleF());
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("UPDATE utilisateurs SET nom=?, prenom=?, mail=?, type=?, mdp=?, teleF=?, teleP=?  WHERE id=?");
            p.setString(1, c.getNom());
            p.setString(2, c.getPrenom());
            p.setString(3, c.getMail());
            p.setString(4, "syndic");
            p.setString(5, c.getMdp());
            p.setString(6, c.getTeleF());
            p.setString(7, c.getTeleP());
            p.setInt(8, id);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	
	/**
	 * @param c
	 * @param id
	 */
	public void modifU(Administrateur c, int id){
        System.out.println("modif "+id+" "+c.getTeleF());
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("UPDATE utilisateurs SET nom=?, prenom=?, mail=?, type=?, mdp=?, teleF=?, teleP=?  WHERE id=?");
            p.setString(1, c.getNom());
            p.setString(2, c.getPrenom());
            p.setString(3, c.getMail());
            p.setString(4, "admin");
            p.setString(5, c.getMdp());
            p.setString(6, c.getTeleF());
            p.setString(7, c.getTeleP());
            p.setInt(8, id);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	
	/*BDD attutilisateurs*/
	
	/**
	 * @param mail
	 * @return
	 */
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
    
    /**
     * @return
     */
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
    
    /**
     * @param cp
     */
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
    
    /**
     * @param s
     */
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
    
    /**
     * @param mail
     */
    public void supprAttUtilisateur(String mail){
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM attutilisateurs WHERE mail=?");
            p.setString(1, mail);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param mail
     * @return
     */
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
    
    /**
     * @param mail
     * @return
     */
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
