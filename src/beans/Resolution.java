package beans;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
@SuppressWarnings("serial")
public class Resolution implements Serializable{
	
	private int id;
	private String resolution;
	private int idCoproprietaire;


	/**
	 * 
	 */
	public Resolution(String resolution) {
		this.setResolution(resolution);
	}


	public String getResolution() {
		return resolution;
	}


	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdCoproprietaire() {
		return idCoproprietaire;
	}


	public void setIdCoproprietaire(int idCoproprietaire) {
		this.idCoproprietaire = idCoproprietaire;
	}

	
	
}