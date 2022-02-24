package fr.eni.tpServlets.bo;

import java.sql.Date;
import java.time.LocalDateTime;

public class Repas {

	private int id;
	private LocalDateTime date;
	private String[] aliments;
	
	public Repas(int id, LocalDateTime date, String[] aliments) {
		super();
		this.id = id;
		this.date = date;
		this.aliments = aliments;
	}
	
	public Repas(LocalDateTime date, String repas) {
		super();
		this.date = date;
		this.aliments = repas.split(", ");
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getDate() {
		return date;
	}
	
	public String getTime() {
		return date.toLocalTime().toString();
		}

	public String[] getAliments() {
		return aliments;
	}
	
	public String getRepas() {
		StringBuilder str = new StringBuilder();
		boolean once = true;
		for (String string : aliments) {
			if(once)
				once = false;
			else
				str.append(", ");
			str.append(string);
		}
		return str.toString();
	}
	

}
