package beans;

import java.util.*;

/**
 * 
 */
public class Intervention {

	private Date dateDébut;
	private Date DateFin;
	private String Information;

	/**
	 * 
	 */
	public Intervention(Date dateDébut,Date DateFin, String Information) throws NullPointerException {
		 if( dateDébut == null || DateFin == null) throw new NullPointerException();
		this.setDateDébut(dateDébut);
		this.DateFin =  DateFin;
		this.Information = Information;
	}
	
		
	public Date getDateDébut() {
		return dateDébut;
	}
	public void setDateDébut(Date dateDébut) {
		this.dateDébut = dateDébut;
	}

	@Override
	public String toString() {
		return "Intervention [dateDébut=" + dateDébut + ", DateFin=" + DateFin
				+ ", Information=" + Information + "]";
	}

}