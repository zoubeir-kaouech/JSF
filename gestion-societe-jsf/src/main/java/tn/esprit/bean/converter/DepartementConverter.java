package tn.esprit.bean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import tn.esprit.bean.ApplicationBean;
import tn.esprit.domain.Departement;

@FacesConverter("departementConverter")
public class DepartementConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent arg1, String value) {
		if(!value.equals("")){
			ApplicationBean bean=context.getCurrentInstance().getApplication().evaluateExpressionGet(context, "#{applicationBean}", ApplicationBean.class);
		return bean.doFindDepartemetById(Integer.parseInt(value));
		}
		return null;
	} 

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
	if(value!=null&&!value.equals("")){
		return String.valueOf(((Departement)value).getId());
	}
		return null;
	}

}
