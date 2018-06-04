package org.escalade.demo.webapp.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.spot.Pays;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.spot.Ville;
import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GestionAddAction extends ActionSupport {
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	private ManagerFactory managerFactory;
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private List<Spot> listSpot;
	private List<Pays> listPays;
	private List<Ville> listVille;
	
	private String nom;
	private String description;
	private String StringPays;
	private String StringVille;
	
	private String StringSpot;
	private String prive;
	// ==================== Getters/Setters ====================
	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}
	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
	public File getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	public List<Spot> getListSpot() {
		return listSpot;
	}
	public void setListSpot(List<Spot> listSpot) {
		this.listSpot = listSpot;
	}
	public List<Pays> getListPays() {
		return listPays;
	}
	public void setListPays(List<Pays> listPays) {
		this.listPays = listPays;
	}
	public List<Ville> getListVille() {
		return listVille;
	}
	public void setListVille(List<Ville> listVille) {
		this.listVille = listVille;
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
	public String getStringPays() {
		return StringPays;
	}
	public void setStringPays(String stringPays) {
		StringPays = stringPays;
	}
	public String getStringVille() {
		return StringVille;
	}
	public void setStringVille(String stringVille) {
		StringVille = stringVille;
	}
	public String getStringSpot() {
		return StringSpot;
	}
	public void setStringSpot(String stringSpot) {
		StringSpot = stringSpot;
	}
	public String getPrive() {
		return prive;
	}
	public void setPrive(String prive) {
		this.prive = prive;
	}
	
	// ==================== Méthodes ====================
	public String doAdd() {
		listSpot=managerFactory.getSpotManager().allSpot();
		listPays=managerFactory.getPaysManager().allPays();
		listVille=managerFactory.getVilleManager().allVille();
		return ActionSupport.SUCCESS;
	} 

	public String doAddSpot() {
		Spot newSpot =new Spot();
		
		 if (!StringUtils.isAllEmpty(nom)){
			 newSpot.setNom(nom);					 
		 }
		 else {
			 this.addFieldError(nom, "le nom du spot ne peut être vide");
		 }
		 if (!StringUtils.isAllEmpty(description)){
			 newSpot.setDescription(description);					 
		 }
		 else {
			 this.addFieldError(description, "la description du topo ne peut être vide");
		 }
		 
		 try {
			Pays pays = managerFactory.getPaysManager().getPays(Integer.valueOf(StringPays));
			Ville ville =managerFactory.getVilleManager().getVille(Integer.valueOf(StringVille));
			
			if(ville.getPays().getId()==pays.getId()) {
				newSpot.setPays(pays);
				newSpot.setVille(ville);
			}
			else {
				newSpot.setPays(ville.getPays());
				newSpot.setVille(ville);
			}
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("resource_image\\");  
        File fileToCreate = new File(filePath,fileUploadFileName);  
    
        try {
			FileUtils.copyFile(fileUpload, fileToCreate);//copying source file to new file  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        newSpot.setPhoto(fileUploadFileName);
        managerFactory.getSpotManager().addSpot(newSpot);
        
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	public String doAddTopo() {
		Topo newTopo =new Topo();
		 if (!StringUtils.isAllEmpty(nom)){
			 newTopo.setNom(nom);					 
		 }
		 else {
			 this.addFieldError(nom, "le nom du topo ne peut être vide");
		 }
		 if (!StringUtils.isAllEmpty(description)){
			 newTopo.setDescription(description);					 
		 }
		 else {
			 this.addFieldError(description, "la description du topo ne peut être vide");
		 }
		 
		 newTopo.setPrive(Boolean.parseBoolean(prive));
		 newTopo.setReserve(false);
		 newTopo.setPhoto(fileUploadFileName);
		 try {
			Spot spot=managerFactory.getSpotManager().getSpot(Integer.valueOf(StringSpot));
			newTopo.setSpot(spot);
			}
		 catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("resource_image\\");  
        File fileToCreate = new File(filePath,fileUploadFileName);  
    
        try {
			FileUtils.copyFile(fileUpload, fileToCreate);//copying source file to new file  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        managerFactory.getTopoManager().addTopo(newTopo);
        
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
}
