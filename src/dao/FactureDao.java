package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.joda.time.DateTime;

import beans.Coproprietaire;
import beans.Date;
import beans.Factures;
import beans.Reclamation;
import beans.Resolution;

public class FactureDao {
	
	public ArrayList<Factures> getFactures(int idU, UtilisateurDao uDao){
		
		ArrayList<Factures> liste = new ArrayList<Factures>();
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM facture WHERE idCoproprietaire = ? " );
			p.setInt(1, idU);
			ResultSet r = p.executeQuery();
			
			while(r.next()){
				liste.add(new Factures(r.getString("sujet") ,r.getInt("montant"),r.getString("detail"),uDao.getOneUtilisateur(r.getInt("idCoproprietaire")).getMail()));
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return liste;
	}
	

	
	public void supprFacture(String sujet, int id){
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM facture WHERE sujet=? AND idCoproprietaire=? ");
			p.setString(1, sujet);
			p.setInt(2, id);

			p.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean containFacture(String sujet){
		
		boolean b = false;
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM facture WHERE sujet=?");
			p.setString(1, sujet);
			
			ResultSet r = p.executeQuery();
			
			if(r.next())
				b = true;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return b;
	}
	
    public void addFacture(Factures f, int id){
        try{
        	
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO facture(sujet, montant, detail, idCoproprietaire) VALUES (?,?,?,?)");
            p.setString(1, f.getSujet());
            p.setInt(2, f.getMontantAPayer());
            p.setString(3, f.getDetail());
            p.setInt(4, id);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Factures getOneFacture(String sujet ,UtilisateurDao uDao){
        Factures f = new Factures(null,0,null,null);
        
        try{
        	
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM facture WHERE sujet=?");
            p.setString(1, sujet);
            
            ResultSet r = p.executeQuery();
            
            while(r.next()){
            	System.out.println("f : " + r.getString("sujet"));
            	System.out.println("f : " + r.getInt("montant"));
            	System.out.println("f : " + r.getString("detail"));
            	System.out.println("f : " + r.getInt("idCoproprietaire"));
                f = new Factures(r.getString("sujet"),r.getInt( "montant" ), r.getString( "detail" ),uDao.getOneUtilisateur(r.getInt("idCoproprietaire")).getMail());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return f;
    }

	
}
