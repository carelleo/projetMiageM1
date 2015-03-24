package beans;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class ReponsePetittravaux extends Reponsedemandetravaux implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Artisan;
	private Date datePrevue;
	private Date dateRealisation;

	
	/**
	 * 
	 */
	
	public ReponsePetittravaux(Boolean refus, String Message, String Artisan, Date datePrévue, Date dateRéalisation) {
		super(refus, Message);
		// TODO Auto-generated constructor stub
	this.setArtisan(Artisan);
		this.setDatePrevue(datePrevue);
		this.setDateRealisation(dateRealisation);

	}
	
	public void ReponsePetitTravaux() {
		// TODO implement here
	}

	public String getArtisan() {
		return Artisan;
	}

	public void setArtisan(String artisan) {
		Artisan = artisan;
	}

	public Date getDatePrevue() {
		return datePrevue;
	}

	public void setDatePrevue(Date datePrevue) {
		this.datePrevue = datePrevue;
	}

	public Date getDateRealisation() {
		return dateRealisation;
	}

	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	public String toString() {
		return "RéponsePetittravaux [Artisan=" + Artisan + ", datePrévue="
				+ datePrevue + ", dateRéalisation=" + dateRealisation + "]";
	}

	
}