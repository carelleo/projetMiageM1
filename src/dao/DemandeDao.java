package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DemandeTravaux;
import beans.Reclamation;
import beans.Resolution;

public class DemandeDao {
    
    public ArrayList<DemandeTravaux> getTravaux(){
        ArrayList<DemandeTravaux> listU = new ArrayList<DemandeTravaux>();
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE type=?");
            p.setString(1, "travaux");
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                listU.add( new DemandeTravaux(r.getString( "sujet" ), r.getString( "contenu" ), r.getString( "date" ), r.getInt( "positif" ), r.getInt( "negatif" ), r.getString( "etat" ), r.getInt( "idCoproprietaire" )) );
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listU;
    }
    
    public DemandeTravaux getOneTravaux(String sjt){
        DemandeTravaux u = new DemandeTravaux(null,null,null,0,0,null,0);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE sujet=?");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new DemandeTravaux(r.getString( "sujet" ), r.getString( "contenu" ), r.getString( "date" ), r.getInt( "positif" ), r.getInt( "negatif" ), r.getString( "etat" ), r.getInt( "idCoproprietaire" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
    
    public void addTravaux(DemandeTravaux t, int id){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO demandes(sujet, contenu, etat, date, type, positif, negatif, idCoproprietaire) VALUES (?, ?, ?, now(), ?, ?, ?,?)");
            p.setString(1, t.getSujet());
            p.setString(2, t.getContenu());
            p.setString(3, t.getEtat());
            p.setString(4, "travaux");
            p.setInt(5, t.getPositif());
            p.setInt(6, t.getNegatif());
            p.setInt(7, id);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void removeTravaux(String sjt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM demandes WHERE sujet=? AND type='travaux'");
            p.setString(1, sjt);
            System.out.println("dao");
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean containTSujet(String sjt){
		
		boolean b = false;
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE sujet=? and type='travaux'");
			p.setString(1, sjt);
			
			ResultSet r = p.executeQuery();
			
			if(r.next())
				b = true;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return b;
	}
    
    public void modifT(DemandeTravaux t, String sjt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("UPDATE demandes SET sujet=?, contenu=?, etat=?, positif=?, negatif=?  WHERE sujet=?");
            p.setString(1, t.getSujet());
            p.setString(2, t.getContenu());
            p.setString(3, t.getEtat());
            p.setInt(4, t.getPositif());
            p.setInt(5, t.getNegatif());
            p.setString(6, sjt);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //getReclamation()
    public ArrayList <Reclamation> getReclamation(){
        
         ArrayList <Reclamation> listr = new ArrayList <Reclamation>();
         
         try{
             PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE type=?");
             p.setString(1, "reclamation");
             
             ResultSet r = p.executeQuery();
             
             while(r.next())
                 listr.add( new Reclamation(r.getString( "sujet" ), r.getString( "contenu" ), r.getString( "date" ), r.getInt( "positif" ), r.getInt( "negatif" ), r.getString( "etat" ), r.getInt( "idCoproprietaire" )) );
             
         }catch(Exception e){
             e.printStackTrace();
         }
         
         return listr;
    
    }
    
    //getOneReclamation()
    public Reclamation getOneReclamation(String sjt){
        Reclamation u = new Reclamation(null,null,null,0,0,null,0);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE sujet=?");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new Reclamation(r.getString( "sujet" ), r.getString( "contenu" ), r.getString( "date" ), r.getInt( "positif" ), r.getInt( "negatif" ), r.getString( "etat" ), r.getInt( "idCoproprietaire" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
    
    //addReclamation()
    public void addReclamation(Reclamation t, int id){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO demandes(sujet, contenu, etat, date, type, positif, negatif, idCoproprietaire) VALUES (?, ?, ?, now(), ?, ?, ?,?)");
            p.setString(1, t.getSujet());
            p.setString(2, t.getContenu());
            p.setString(3, t.getEtat());
            p.setString(4, "reclamation");
            p.setInt(5, t.getPositif());
            p.setInt(6, t.getNegatif());
            p.setInt(7, id);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //removeReclamation()
    public void removeReclamation(String sjt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM demandes WHERE sujet=? AND type='reclamation'");
            p.setString(1, sjt);

            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void modifR(Reclamation t, String sjt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("UPDATE demandes SET sujet=?, contenu=?, etat=?, positif=?, negatif=?  WHERE sujet=?");
            p.setString(1, t.getSujet());
            p.setString(2, t.getContenu());
            p.setString(3, t.getEtat());
            p.setInt(4, t.getPositif());
            p.setInt(5, t.getNegatif());
            p.setString(6, sjt);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //resolutions
    public ArrayList<Resolution> getResolution(){
        ArrayList<Resolution> listU = new ArrayList<Resolution>();
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE type=?");
            p.setString(1, "resolution");
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                listU.add( new Resolution(r.getString( "sujet" ), r.getString( "contenu" ), r.getString( "date" ), r.getInt( "positif" ), r.getInt( "negatif" ), r.getString( "etat" ), r.getInt( "idCoproprietaire" )) );
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listU;
    }
    
    public Resolution getOneResolution(String sjt){
        Resolution u = new Resolution(null,null,null,0,0,null,0);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE sujet=?");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new Resolution(r.getString( "sujet" ), r.getString( "contenu" ), r.getString( "date" ), r.getInt( "positif" ), r.getInt( "negatif" ), r.getString( "etat" ), r.getInt( "idCoproprietaire" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
    
    public void addResolution(Resolution t, int id){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO demandes(sujet, contenu, etat, date, type, positif, negatif, idCoproprietaire) VALUES (?, ?, ?, now(), ?, ?, ?,?)");
            p.setString(1, t.getSujet());
            p.setString(2, t.getContenu());
            p.setString(3, t.getEtat());
            p.setString(4, "resolution");
            p.setInt(5, t.getPositif());
            p.setInt(6, t.getNegatif());
            p.setInt(7, id);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void removeResolution(String sjt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM demandes WHERE sujet=? AND type='resolution'");
            p.setString(1, sjt);
            System.out.println("dao");
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean containResolutionSujet(String sjt){
        
        boolean b = false;
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE sujet=? AND type='resolution'");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            if(r.next())
                b = true;
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return b;
    }
    
    public void modifResolution(Resolution t, String sjt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("UPDATE demandes SET sujet=?, contenu=?, etat=?, positif=?, negatif=?  WHERE sujet=?");
            p.setString(1, t.getSujet());
            p.setString(2, t.getContenu());
            p.setString(3, t.getEtat());
            p.setInt(4, t.getPositif());
            p.setInt(5, t.getNegatif());
            p.setString(6, sjt);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
