package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Administrateur;
import beans.Coproprietaire;
import beans.Syndic;

public class UtilisateurDao {
	
	public ArrayList<String> getUtilisateur(){
		
		ArrayList<String> liste = new ArrayList<String>();
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM utilisateurs ORDER BY id ASC");
			ResultSet r = p.executeQuery();
			
			while(r.next())
				liste.add(r.getString("mail"));
			
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
}
