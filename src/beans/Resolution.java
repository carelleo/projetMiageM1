package beans;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
@SuppressWarnings("serial")
public class Resolution implements Serializable{

	private String resolution;


	/**
	 * 
	 */
	public Resolution(String resolution) {
		this.setResolution(resolution);
	}


	public String getResolution() {
		return resolution;
	}


	public void setResolution(String resolution) {
		this.resolution = resolution;
	}


	
	
}