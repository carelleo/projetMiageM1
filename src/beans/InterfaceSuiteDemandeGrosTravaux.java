package beans;

import java.util.*;

/**
 * 
 */
public interface InterfaceSuiteDemandeGrosTravaux {

	/**
	 * @param ld 
	 * @param le
	 */
	public void CreerSuiteDemandeGrosTravaux(ArrayList<Devis> ld, ArrayList<Entreprise> le);

	/**
	 * @return
	 */
	public void DetruireDemandeTravaux();
}