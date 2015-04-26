package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Budget;
import beans.Resolution;

public class BudgetDao {

	   public ArrayList<Budget> getBudget(){
	        ArrayList<Budget> listU = new ArrayList<Budget>();
	        
	        try{
	            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM budget");
	            
	            ResultSet r = p.executeQuery();
	            
	            while(r.next())
	                listU.add( new Budget(r.getInt( "annee" ), r.getInt( "eau" ), r.getInt( "electricite" ), r.getInt( "gaz" ), r.getInt( "entretien" ),r.getString("commentaire")) );
	                
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        
	        return listU;
	    }
	    
	    public Budget getOneBudget(int anne){
	        Budget b = new Budget(0,0,0,0,0,null);
	        
	        try{
	            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM budget WHERE annee=?");
	            p.setInt(1, anne);
	            
	            ResultSet r = p.executeQuery();
	            
	            while(r.next())
	                b = new Budget(r.getInt( "annee" ), r.getInt( "eau" ), r.getInt( "electricite" ), r.getInt( "gaz" ), r.getInt( "entretien" ),r.getString("commentaire"));
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        
	        return b;
	    }
	    
	    public void addBudget(Budget b, int id){
	        try{
	            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO budget(annee, eau, electricite, gaz, entretien, commentaire, idSyndic) VALUES (?, ?, ?, ?,?,?,?)");
	            p.setInt(1, b.getAnnee());
	            p.setInt(2, b.getBudgetEau());
	            p.setInt(3, b.getBudgetElectricite());
	            p.setInt(4, b.getBudgetGaz());
	            p.setInt(5, b.getBudgetEntretien());
	            p.setString(6, b.getCommentaire());
	            p.setInt(7, id);

	            
	            p.executeUpdate();
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    
	    public void supprB(int anne){
	        try{
	            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM Budget WHERE annee=?");
	            p.setInt(1, anne);
	            p.executeUpdate();
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    
	    public void modifB(Budget b, int anne){
	        try{
	            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("UPDATE budget SET annee=?, eau=?, electricite=?, gaz=?, entretien=?, commentaire=?  WHERE annee=?");
	            p.setInt(1, b.getAnnee());
	            p.setInt(2, b.getBudgetEau());
	            p.setInt(3, b.getBudgetElectricite());
	            p.setInt(4, b.getBudgetGaz());
	            p.setInt(5, b.getBudgetEntretien());
	            p.setString(6,b.getCommentaire());
	            p.setInt(7, anne);
	            
	            p.executeUpdate();
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    
	
	    public boolean containtAnnée(int année){
			
			boolean b = false;
			
			try{
				PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM budget WHERE annee=?");
				p.setInt(1, année);
				
				ResultSet r = p.executeQuery();
				
				if(r.next())
					b = true;
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return b;
		}
	
}
