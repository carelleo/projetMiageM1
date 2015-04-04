package beans;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Avisdepassage implements Serializable {


	
	private Date datePassage;

	
	private String Objet;// objet de l'avis de passage

	public Avisdepassage() {
	}

	public Date getDatePassage() {
		return datePassage;
	}

	public void setDatePassage(Date datePassage) {
		this.datePassage = datePassage;
	}

	public String getObjet() {
		return Objet;
	}

	public void setObjet(String objet) {
		Objet = objet;
	}

	@Override
	public String toString() {
		return "Avisdepassage [datePassage=" + datePassage + ", Objet=" + Objet
				+ "]";
	}

	
	
}