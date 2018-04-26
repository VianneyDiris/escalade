package org.escalade.demo.model.bean.topo;

import org.escalade.demo.model.bean.spot.Spot;

public class Topo {

	// ==================== Attributs ====================
	private int id;
	private String nom;
	private String description;
	private String photo;
	private boolean prive;
	private boolean reserve;
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
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	public boolean isPrive() {
		return prive;
	}
	public void setPrive(boolean prive) {
		this.prive = prive;
	}
	
	
	public boolean isReserve() {
		return reserve;
	}
	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}
	public Spot getSpot() {
		return spot;
	}
	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	
	
	
	// ==================== Méthodes ====================
	
}
