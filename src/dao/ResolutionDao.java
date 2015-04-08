package dao;


import beans.Resolution;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ResolutionDao {
	
	public ArrayList<Resolution> getResolution(){
		
		ArrayList<Resolution> listeResolution = new ArrayList<Resolution>();
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM resolution");
			ResultSet r = p.executeQuery();
			
			while(r.next()){
				listeResolution.add(new Resolution(r.getString("resolution")));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return listeResolution;
	}
	
	public void addResolsution(Resolution r){
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO resolution(resolution, idCoproprietaire) VALUES (?, ?)");
			p.setString(1, r.getResolution());
			p.setInt(1, r.getIdCoproprietaire());

			p.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void supprResolution(String r){
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM resolution WHERE resolution=?");
			p.setString(1, r);

			p.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean containResolution(String resolution){
		
		boolean b = false;
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM resolution WHERE resolution=?");
			p.setString(1, resolution);
			
			ResultSet r = p.executeQuery();
			
			if(r.next())
				b = true;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return b;
	}

}
