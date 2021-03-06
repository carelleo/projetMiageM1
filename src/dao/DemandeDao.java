package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DemandeTravaux;
import beans.Devis;
import beans.GrosTravaux;
import beans.PetitTravaux;
import beans.Reclamation;
import beans.Resolution;

public class DemandeDao {
    
    /**
     * @return
     */
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
    
    /**
     * @param sjt
     * @return
     */
    public DemandeTravaux getOneTravaux(String sjt){
        DemandeTravaux u = new DemandeTravaux(null,null,null,0,0,null,0);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE sujet=? AND type='travaux'");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new DemandeTravaux(r.getString( "sujet" ), r.getString( "contenu" ), r.getString( "date" ), r.getInt( "positif" ), r.getInt( "negatif" ), r.getString( "etat" ), r.getInt( "idCoproprietaire" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(u.getSujet());
        return u;
    }
    
    /**
     * @param t
     * @param id
     */
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
    
    /**
     * @param sjt
     */
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
    
    /**
     * @param sjt
     * @return
     */
    public boolean containTSujet(String sjt){
		
		boolean b = false;
		
		try{
			PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE sujet=?");
			p.setString(1, sjt);
			
			ResultSet r = p.executeQuery();
			
			if(r.next())
				b = true;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return b;
	}
    
    /**
     * @param t
     * @param sjt
     */
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
    
    /**
     * @param t
     * @param sjt
     */
    public void modifT(String t, String sjt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("UPDATE demandes SET etat=?  WHERE sujet=?");
            p.setString(1, t);
            p.setString(2, sjt);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //getReclamation()
    /**
     * @return
     */
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
    /**
     * @param sjt
     * @return
     */
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
    /**
     * @param t
     * @param id
     */
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
    /**
     * @param sjt
     */
    public void removeReclamation(String sjt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM demandes WHERE sujet=? AND type='reclamation'");
            p.setString(1, sjt);

            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param t
     * @param sjt
     */
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
    /**
     * @return
     */
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
    
    /**
     * @param sjt
     * @return
     */
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
    
    /**
     * @param t
     * @param id
     */
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
    
    /**
     * @param sjt
     */
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
    
    /**
     * @param t
     * @param sjt
     */
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
    
    /**
     * @param sjt
     * @param idU
     * @return
     */
    public boolean AlreadyCompteur(String sjt,int idU){
        int idD = 0;
        String a = null;
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE sujet=?");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                idD = r.getInt( "id" );
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM compteur WHERE idUtilisateur=? AND idDemande=?");
            p.setInt(1, idU);
            p.setInt(2, idD);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                a = r.getString( "action" );
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(a!=null)
            return true;//deja fait
        else
            return false;//pas encore fait
    }
    
    /**
     * @param sjt
     * @param idU
     * @param a
     */
    public void addCompteur(String sjt, int idU, String a){
        int idD = 0;
        System.out.println("add");
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM demandes WHERE sujet=?");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                idD = r.getInt( "id" );
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO compteur(idUtilisateur, idDemande, action) VALUES (?, ?, ?)");
            p.setInt(1, idU);
            p.setInt(2, idD);
            p.setString(3, a);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Petit et Gros travaux
    
    /**
     * @param pt
     */
    public void addPTrav(DemandeTravaux pt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO travaux(sujet, contenu, type, idU) VALUES (?, ?, ?,?)");
            p.setString(1, pt.getSujet());
            p.setString(2, pt.getContenu());
            p.setString(3, "petits travaux");
            p.setInt(4, pt.getIdU());
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param sjt
     */
    public void removePTrav(String sjt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM travaux WHERE sujet=? AND type='petits travaux'");
            p.setString(1, sjt);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @return
     */
    public ArrayList<PetitTravaux> getPTrav(){
        ArrayList<PetitTravaux> listU = new ArrayList<PetitTravaux>();
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM travaux WHERE type=?");
            p.setString(1, "petits travaux");
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                listU.add( new PetitTravaux(r.getString( "sujet" ), r.getString( "contenu" ), r.getInt( "idU" )) );
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listU;
    }
    
    /**
     * @param sjt
     * @return
     */
    public int getIdPT(String sjt){
        int u = 0;
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM travaux WHERE sujet=? AND type='petits travaux'");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = r.getInt( "id" );
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
    
    /**
     * @param sjt
     * @return
     */
    public PetitTravaux getOnePTravaux(String sjt){
        PetitTravaux u = new PetitTravaux(null, null, null, null, null, 0);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM travaux WHERE sujet=? AND type='petits travaux'");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new PetitTravaux(null, null, r.getString( "sujet" ), null, r.getString( "contenu" ), r.getInt( "idU" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }

        return u;
    }
    
    /**
     * @param id
     * @return
     */
    public PetitTravaux getOnePTravaux(int id){
        PetitTravaux u = new PetitTravaux(null, null, null, null, null, 0);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM travaux WHERE id =? AND type='petits travaux'");
            p.setInt(1, id);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new PetitTravaux(null, null, r.getString( "sujet" ), null, r.getString( "contenu" ), r.getInt( "idU" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }

        return u;
    }
    
    /**
     * @param gt
     */
    public void addGTrav(DemandeTravaux gt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO travaux(sujet, contenu, type, idU) VALUES (?, ?, ?, ?)");
            p.setString(1, gt.getSujet());
            p.setString(2, gt.getContenu());
            p.setString(3, "gros travaux");
            p.setInt(4, gt.getIdU());
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param sjt
     */
    public void removeGTrav(String sjt){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM travaux WHERE sujet=? AND type='gros travaux'");
            p.setString(1, sjt);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @return
     */
    public ArrayList<GrosTravaux> getGTrav(){
        ArrayList<GrosTravaux> listU = new ArrayList<GrosTravaux>();
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM travaux WHERE type=?");
            p.setString(1, "gros travaux");
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                listU.add( new GrosTravaux(r.getString( "sujet" ), r.getString( "contenu" ), r.getInt( "idU" )) );
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listU;
    }
    
    /**
     * @param sjt
     * @return
     */
    public GrosTravaux getOneGTravaux(String sjt){
        GrosTravaux u = new GrosTravaux(null, null, null, null, null, 0);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM travaux WHERE sujet=? AND type='gros travaux'");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new GrosTravaux(null, null, r.getString( "sujet" ), null, r.getString( "contenu" ), r.getInt( "idU" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(u.getSujet());
        return u;
    }
    
    /**
     * @param id
     * @return
     */
    public GrosTravaux getOneGTravaux(int id){
        GrosTravaux u = new GrosTravaux(null, null, null, null, null, 0);
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM travaux WHERE id=? AND type='gros travaux'");
            p.setInt(1, id);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = new GrosTravaux(null, null, r.getString( "sujet" ), null, r.getString( "contenu" ), r.getInt( "idU" ));
            
        }catch(Exception e){
            e.printStackTrace();
        }

        return u;
    }
    
    /**
     * @param sjt
     * @return
     */
    public int getIdGT(String sjt){
        int u = 0;
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM travaux WHERE sujet=? AND type='gros travaux'");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                u = r.getInt( "id" );
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
    
    /**
     * @param sjt
     * @param dd
     * @param df
     * @param a
     */
    public void modifGPTrav(String sjt, String dd, String df, String a){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("UPDATE travaux SET dateD=?, dateF=?, artisan=? WHERE sujet=?");
            p.setString(1, dd);
            p.setString(2, df);
            p.setString(3, a);
            p.setString(4, sjt);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param sjt
     * @return
     */
    public boolean containGPTSujet(String sjt){
        
        boolean b = false;
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM travaux WHERE sujet=?");
            p.setString(1, sjt);
            
            ResultSet r = p.executeQuery();
            
            if(r.next())
                b = true;
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return b;
    }
    
    //Devis
    
    /**
     * @param idT
     * @return
     */
    public ArrayList<Devis> getDevis(int idT){
        ArrayList<Devis> listU = new ArrayList<Devis>();
        
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM Devis WHERE idT=?");
            p.setInt(1, idT);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                listU.add( new Devis(r.getInt( "id" ), r.getString( "entreprise" ), r.getInt( "montant" ), r.getString( "dateD" ), r.getString( "dateF" ), r.getInt( "idT" )) );
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listU;
    }
    
    /**
     * @param id
     * @return
     */
    public Devis getOneDevis(int id){
        Devis d = new Devis();
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("SELECT * FROM Devis WHERE id=?");
            p.setInt(1, id);
            
            ResultSet r = p.executeQuery();
            
            while(r.next())
                d = new Devis(r.getInt( "id" ), r.getString( "entreprise" ), r.getInt( "montant" ), r.getString( "dateD" ), r.getString( "dateF" ), r.getInt( "idT" ));
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return d;
    }
    
    /**
     * @param d
     */
    public void addDevis(Devis d){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("INSERT INTO devis(entreprise, montant, dateD, dateF, idT) VALUES (?, ?, ?, ?, ?)");
            p.setString(1, d.getEntreprise());
            p.setInt(2, d.getMontant());
            p.setString(3, d.getDateD());
            p.setString(4, d.getDateF());
            p.setInt(5, d.getIdT());
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param id
     */
    public void removeDevis(int id){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM devis WHERE id=?");
            p.setInt(1, id);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param idT
     * @param id
     */
    public void removeAllDevis(int idT, int id){
        try{
            System.out.println("idT "+idT);
            System.out.println("id "+id);
            
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM devis WHERE idT=? AND id!=?");
            p.setInt(1, idT);
            p.setInt(2, id);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param idT
     */
    public void removeAllDevis(int idT){
        try{
            PreparedStatement p = ConnexionBDD.getConnection().prepareStatement("DELETE FROM devis WHERE idT=?");
            p.setInt(1, idT);
            
            p.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
