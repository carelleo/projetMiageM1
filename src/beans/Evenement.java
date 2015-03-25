package beans;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Evenement {
    
	private String dateD;
	private String dateF;
	private String titre;
    private int id;
	
	public Evenement() {
    }
 
    public Evenement(String titre, String dateD, String dateF) {
        this.dateD = dateD;
        this.dateF = dateF;
        this.titre = titre;
    }
	
	public String getDateD() {
		return dateD;
	}

	public void setDateD(String dateD) {
		this.dateD = dateD;
	}

	public String getDateF() {
		return dateF;
	}

	public void setDateF(String dateF) {
		this.dateF = dateF;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Interval getInterval() {
		Interval interval = new Interval(new DateTime(getDateD()), new DateTime(getDateF()).plusDays(1));
		return interval;
	}

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
