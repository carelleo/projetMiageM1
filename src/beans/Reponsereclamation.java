package beans;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Reponsereclamation implements Serializable{

	
	private String suiteReclamation;
	private Boolean Refus;

	public Reponsereclamation( String suiteReclamation, Boolean Refus){
		
		this.Refus= Refus;
		this.suiteReclamation = suiteReclamation;
		
	}


	public String getSuiteReclamation() {
		return suiteReclamation;
	}


	public void setSuiteReclamation(String suiteReclamation) {
		this.suiteReclamation = suiteReclamation;
	}


	public Boolean getRefus() {
		return Refus;
	}


	public void setRefus(Boolean refus) {
		Refus = refus;
	}


	@Override
	public String toString() {
		return "Réponseréclamation [suiteRéclamation=" + suiteReclamation
				+ ", Refus=" + Refus + "]";
	}

	
}