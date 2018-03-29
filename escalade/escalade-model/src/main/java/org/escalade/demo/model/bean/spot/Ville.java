package org.escalade.demo.model.bean.spot;

public class Ville {
	
	// ==================== Attributs ====================
	private int id;
	private String nom;
	private int codePostal;
	private Pays pays;
		
	
	// ==================== Getters/Setters ====================
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
	
	
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
		
	// ==================== Méthodes ====================

}
