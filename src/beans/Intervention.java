package beans;

import java.util.*;

/**
 * 
 */
public class Intervention {

	private Date dateDebut;
	private Date DateFin;
	private String Information;

	/**
	 * 
	 */
	public Intervention(Date dateDebut,Date DateFin, String Information) throws NullPointerException {
		 if( dateDebut == null || DateFin == null) throw new NullPointerException();
		this.setDateDebut(dateDebut);
		this.DateFin =  DateFin;
		this.Information = Information;
	}
	
		
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Override
	public String toString() {
		return "Intervention [dateDébut=" + dateDebut + ", DateFin=" + DateFin
				+ ", Information=" + Information + "]";
	}

}