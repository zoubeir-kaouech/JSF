package tn.esprit.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import tn.esprit.bean.ApplicationBean;
import tn.esprit.domain.Departement;
@FacesConverter("departementConverter")
public class DepartementConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(!value.equals("")){
			ApplicationBean bean = FacesContext
					.getCurrentInstance()
					.getApplication()
					.evaluateExpressionGet(context, "#{applicationBean}",
							ApplicationBean.class);
			return bean.findDepartemetById(Integer.parseInt(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value!=null &&!value.equals(""))
		return String.valueOf(((Departement)value).getId());
		return "";
	}

}
