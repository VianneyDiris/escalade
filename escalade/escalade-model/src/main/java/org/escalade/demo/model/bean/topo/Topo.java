package org.escalade.demo.model.bean.topo;

import org.escalade.demo.model.bean.spot.Spot;
import javax.validation.constraints.*;

public class Topo {

	// ==================== Attributs ====================
	@NotNull(message = "id cannot be null")
	private Integer id;
	
	@NotNull(message = "nom cannot be null")
	@Max(value=100, message="nom trop long")
	private String nom;
	
	@NotNull(message = "description cannot be null")
	@Max(value=300,message="trop long")
	private String description;
	
	@NotNull(message = "photo cannot be null")
	@Max(value=255, message="nom de l'image trop long")
	private String photo;
	
	private boolean prive;
	private boolean reserve;
	private Spot spot;
		
	
	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
