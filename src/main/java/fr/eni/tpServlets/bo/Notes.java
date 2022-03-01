package fr.eni.tpServlets.bo;

public class Notes {

	private int id;
	private String content;
	
	public Notes() {};	
	
	public Notes(int id, String content) {
		this.id = id;
		this.content = content;
	}

	public Notes(String content) {
		this.content = content;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notes [id=" + id + ", content=" + content + "]";
	}
	
	
}
