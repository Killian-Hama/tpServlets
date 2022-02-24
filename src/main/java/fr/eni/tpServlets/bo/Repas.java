package fr.eni.tpServlets.bo;

import java.sql.Date;

public class Repas {

	private int id;
	private Date date;
	private String[] aliments;
	
	public Repas(int id, Date date, String[] aliments) {
		super();
		this.id = id;
		this.date = date;
		this.aliments = aliments;
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
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
