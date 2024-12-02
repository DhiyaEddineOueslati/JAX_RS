package tn.enig.model;

public class Etudiant {
	private int id;
    private String nom;
    private String prenom;
    private int idGroupe;
	public Etudiant(int id, String nom, String prenom, int idGroupe) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.idGroupe = idGroupe;
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}
    
}
