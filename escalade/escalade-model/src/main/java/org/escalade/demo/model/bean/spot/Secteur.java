package org.escalade.demo.model.bean.spot;

public class Secteur {

	// ==================== Attributs ====================
	private int id;
	private String nom;
	private Spot spot;
	
	
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
	
	
	public Spot getSpot() {
		return spot;
	}
	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	
	// ==================== Méthodes ====================
}
