package org.escalade.demo.webapp.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.spot.Pays;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.spot.Ville;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddSpotAction extends ActionSupport {
	// ==================== Attributs ====================
    // ----- Paramètres en sortie
	private ManagerFactory managerFactory;
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String spot;
	private String description;
	private String StringPays;
	private String StringVille;
	
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
	public String getSpot() {
		return spot;
	}
	public void setSpot(String spot) {
		this.spot = spot;
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
	
	// ==================== Méthodes ==============================
	public String doAddSpot() {
		Spot newSpot =new Spot();
		
		 if (!StringUtils.isAllEmpty(spot)){
			 newSpot.setNom(spot);					 
		 }
		 else {
			 this.addFieldError(spot, "le nom du spot ne peut être vide");
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
}
