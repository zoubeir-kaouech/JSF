package tn.esprit.bean.converter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import tn.esprit.bean.ApplicationBean;
import tn.esprit.domain.Departement;
import tn.esprit.services.gestion.departement.GestionDepartementLocal;

@ManagedBean
@RequestScoped
public class DepartementConverterM implements Converter{
	@EJB
GestionDepartementLocal  local;
	@Override
	public Object getAsObject(FacesContext context, UIComponent arg1, String value) {
		if(!value.equals("")){
			return local.findDepartementById(Integer.parseInt(value));
		}
		return null;
	} 

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
	if(value!=null&&!value.equals("")){
		return String.valueOf(((Departement)value).getId());
	}
		return "";
	}

}
