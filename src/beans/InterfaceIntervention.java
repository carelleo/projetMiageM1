package beans;

import java.util.*;

/**
 * 
 */
public interface InterfaceIntervention {

	
	/**
	 * @param db 
	 * @param df 
	 * @param i 
	 * @return
	 */
	public Intervention CreerIntervention(Date db, Date df, String i);
	/**
	 * @return
	 */
	public void Detruire();
}