package tn.enig.model;

public class Groupe {
	private int id;
    private String description;
    private String niveau;
	public Groupe(int id, String description, String niveau) {
		super();
		this.id = id;
		this.description = description;
		this.niveau = niveau;
	}
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


}
