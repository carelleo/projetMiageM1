package beans;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Evenement {
    
	private String dateD;
	private String dateF;
	private String titre;
    private int id;
	
	/**
	 * 
	 */
	public Evenement() {
    }
 
    /**
     * @param titre
     * @param dateD
     * @param dateF
     */
    public Evenement(String titre, String dateD, String dateF) {
        this.dateD = dateD;
        this.dateF = dateF;
        this.titre = titre;
    }
	
	/**
	 * @return
	 */
	public String getDateD() {
		return dateD;
	}

	/**
	 * @param dateD
	 */
	public void setDateD(String dateD) {
		this.dateD = dateD;
	}

	/**
	 * @return
	 */
	public String getDateF() {
		return dateF;
	}

	/**
	 * @param dateF
	 */
	public void setDateF(String dateF) {
		this.dateF = dateF;
	}

	/**
	 * @return
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return
	 */
	public Interval getInterval() {
		Interval interval = new Interval(new DateTime(getDateD()), new DateTime(getDateF()).plusDays(1));
		return interval;
	}

    /**
     * @return
     */
    public int getId() {
        return id;
    }
    
    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}
