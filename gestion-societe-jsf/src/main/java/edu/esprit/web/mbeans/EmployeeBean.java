package edu.esprit.web.mbeans;

import java.io.ByteArrayInputStream;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped
public class EmployeeBean {

	private StreamedContent image;

//	@ManagedProperty("#{param.employeeId}")
//	private int employeeId;
//	

	@ManagedProperty("#{helperBean.defaultPicture}")
	private byte[] defaultPicture;
@ManagedProperty("#{loginBean.employee.photo}")
	private byte[] photo;
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@PostConstruct
	public void init() {
	
	
		if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the view. Return a stub StreamedContent so
			// that it will generate right URL.
			image = new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Return a real
			// StreamedContent with the image bytes.
			byte[] productPicture = photo;
			if (productPicture == null) {
				image = new DefaultStreamedContent(new ByteArrayInputStream(
						defaultPicture));
			} else {
				image = new DefaultStreamedContent(new ByteArrayInputStream(
						productPicture));
			}

		}
	}

	public StreamedContent getImage() {
		return image;
	}

	public void setImage(StreamedContent image) {
		this.image = image;
	}

	public byte[] getDefaultPicture() {
		return defaultPicture;
	}

	public void setDefaultPicture(byte[] defaultPicture) {
		this.defaultPicture = defaultPicture;
	}

}