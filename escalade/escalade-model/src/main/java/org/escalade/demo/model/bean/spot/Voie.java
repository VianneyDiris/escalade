package org.escalade.demo.model.bean.spot;

public class Voie {
	
	// ==================== Attributs ====================
	private int id;
	private String nom;
	private int nbLongueur;
	private Cotation cotation;
	private Orientation orientation;
	private Secteur secteur;
	
	
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
	
	
	public int getNbLongueur() {
		return nbLongueur;
	}
	public void setNbLongueur(int nbLongueur) {
		this.nbLongueur = nbLongueur;
	}
	
	
	public Cotation getCotation() {
		return cotation;
	}
	public void setCotation(Cotation cotation) {
		this.cotation = cotation;
	}
	
	
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	
	public Secteur getSecteur() {
		return secteur;
	}
	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
	
	
	// ==================== Méthodes ====================
}
