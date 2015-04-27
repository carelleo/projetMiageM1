package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;

public class Date {
	private DateTime d;
	private int an;
	private DateTime d1er;
	private DateTime[][][] cal;
	private DateTime dException;
	
	/**
	 * 
	 */
	public Date(){
		DateTime ajd = new DateTime();
		d = new DateTime(ajd.getYear(),ajd.getMonthOfYear(),ajd.getDayOfMonth(),00,00,00);
		an = ajd.getYear();
		d1er = new DateTime(an,01,01,00,00,00);
		dException = new DateTime(0,05,05,0,0,0);
		constructCalendrier(1);
	}
	
	/**
	 * @return
	 */
	public String[] getMois() {
		
		String[] mois = {"Jan","Fev","Mar","Avr","Mai","Jui","Jui","Aout»","Sep","Oct","Nov","Dec"};
		
		return mois;
	}
	
	/**
	 * @return
	 */
	public String[] getJourSem() {
		
		String[] jour = {"","Lun","Mar","Mer","Jeu","Ven","Sam","Dim"};
		
		return jour;
	}
	
	/**
	 * @return
	 */
	public DateTime getD1er() {
		return d1er;
	}

	/**
	 * @param d1er
	 */
	public void setD1er(DateTime d1er) {
		this.d1er = d1er;
	}
	
	/**
	 * @return
	 */
	public DateTime getD() {
		return d;
	}
	
	/**
	 * @return
	 */
	public DateTime[][][] getCalendrier() {
		return cal;
	}
	
	/**
	 * @return
	 */
	public DateTime getDException() {
		return dException;
	}
	
	/**
	 * @param n
	 */
	public void constructCalendrier(int n){
		cal = new DateTime[n][12][31];
		
		for(int a = 0; a < n; a++){
			for(int m = 0; m < 12; m++){
				for(int j = 0; j < 31; j++){
					if(d1er.getMonthOfYear() == m+1){
						cal[a][m][j] = d1er;
						d1er = d1er.plusDays(1);
					}
					else
						cal[a][m][j] = dException;
				}
			}
		}
	}
}
