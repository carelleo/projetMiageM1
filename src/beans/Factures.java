package beans;
/**
 * 
 */
public class Factures {

	private int montantAPayer;
	
	public Factures( int montantAPayer ) {
		this.montantAPayer = montantAPayer;
	}

	
	public int getMontantAPayer() {
		return montantAPayer;
	}


	public void setMontantAPayer(int montantAPayer) {
		this.montantAPayer = montantAPayer;
	}

	@Override
	public String toString() {
		return "Factures [montantAPayer=" + montantAPayer + "]";
	}

}