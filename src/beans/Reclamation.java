package beans;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
@SuppressWarnings("serial")
public class Reclamation implements Serializable {
 
	private String objet;
	private String reclamation;

	/**
	 * 
	 */
	public Reclamation( String réclamation){
		this.reclamation = reclamation;
	}

	public String getRéclamation() {
		return reclamation;
	}


	public void setRéclamation(String reclamation) {
		this.reclamation = reclamation;
	}



	 public String toString(){
		   	
		   	return toString()+"\n"+reclamation;
		   		
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

}