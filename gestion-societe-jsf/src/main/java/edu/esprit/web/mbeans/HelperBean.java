package edu.esprit.web.mbeans;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;

@ManagedBean
@ApplicationScoped
public class HelperBean {

	private byte[] defaultPicture;

	public HelperBean() {
	}

	@PostConstruct
	public void init() {

		InputStream is = FacesContext.getCurrentInstance().getExternalContext()
				.getResourceAsStream("/resources/images/default.jpg");

		try {
			defaultPicture = IOUtils.toByteArray(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public byte[] getDefaultPicture() {
		return defaultPicture;
	}

	public void setDefaultPicture(byte[] defaultPicture) {
		this.defaultPicture = defaultPicture;
	}

}