package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DemandeTravaux;

public class DemandeDao {
    
    public ArrayList<DemandeTravaux> getTravaux(){
        ArrayList<DemandeTravaux> listU = new ArrayList<DemandeTravaux>();
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM travaux ORDER BY date DESC");
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                listU.add( new DemandeTravaux(r.getString( "sujet" ), r.getString( "contenu" )) );
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listU;
    }
    
    public DemandeTravaux getOneTravaux(int id){
        DemandeTravaux u = new DemandeTravaux(null,null);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM travaux WHERE id=?");
            p.setInt(1, id);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new DemandeTravaux(r.getString( "sujet" ), r.getString( "contenu" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
    
    public void addTravaux(DemandeTravaux t){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO travaux(sujet, contenu, etat, date) VALUES (?, ?, ?, now())");
            p.setString(1, t.getSujet());
            p.setString(2, t.getContenu());
            p.setString(3, t.getEtat());
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void removeTravaux(int id){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM travaux WHERE id=?");
            p.setInt(1, id);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //getReclamation()
    //getOneReclamation()
    //addReclamation()
    //removeReclamation()
    
    
    
}
