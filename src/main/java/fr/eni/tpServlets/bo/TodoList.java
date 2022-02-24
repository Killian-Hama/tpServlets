package fr.eni.tpServlets.bo;

public class TodoList {

	private int id;
	private String libelle;
	
	public int getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public TodoList(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	

}
