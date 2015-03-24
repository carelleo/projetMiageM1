package beans;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
@SuppressWarnings("serial")
public class Reponsedemandetravaux implements Serializable {

	private boolean refus;
	private String Message;

	/**
	 * 
	 */
	public Reponsedemandetravaux(Boolean refus, String Message) {
		this.setRefus(refus);
		this.Message = Message;
	}


	/**
	 * @param m
	 */
	public void ReponsedemandeTravaux(String m) {
		// TODO implement here
	}

	
	/**
	 * @return
	 */
	public String getMessage() {
		// TODO implement here
		return "";
	}

	/**
	 * @param m 
	 * @return
	 */
	public void setMessage(String m) {
		// TODO implement here
		
	}

	public boolean isRefus() {
		return refus;
	}


	public void setRefus(boolean refus) {
		this.refus = refus;
	}

}