package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.joda.time.DateTime;

import beans.Coproprietaire;
import beans.Evenement;

public class EvenementDao {
	
	public ArrayList<Evenement> getEvenement(){
		
		ArrayList<Evenement> liste = new ArrayList<Evenement>();
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM evenements");
			ResultSet r = p.executeQuery();
			
			while(r.next()){
				liste.add(new Evenement(r.getString("titre"), r.getString("dateD"), r.getString("dateF")));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return liste;
	}
	
	public void addEvenement(Evenement ev){
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO evenements(titre, dateD, dateF) VALUES (?, ?, ?)");
			p.setString(1, ev.getTitre());
			p.setString(2, ev.getDateD());
			p.setString(3, ev.getDateF());

			p.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void supprEvenement(String titre){
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM evenements WHERE titre=?");
			p.setString(1, titre);

			p.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean containEvenement(String titre){
		
		boolean b = false;
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM evenements WHERE titre=?");
			p.setString(1, titre);
			
			ResultSet r = p.executeQuery();
			
			if(r.next())
				b = true;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return b;
	}
}
