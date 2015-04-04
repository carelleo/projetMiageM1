package beans;


/**
 * 
 */
public interface InterfaceFacture {

	/**
	 * @param montant 
	 * @return
	 */
	public Factures CreerFacture(int montant);
	/**
	 * @return
	 */
	public void DetruireFacture();

}