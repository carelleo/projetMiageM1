package beans;

import java.io.Serializable;


/**
 * 
 */
@SuppressWarnings("serial")
public class Informationpersonelle implements Serializable {

private String infos; 

	public Informationpersonelle(String infos ) {
		this.infos = infos;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

}