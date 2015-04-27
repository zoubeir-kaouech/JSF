package tn.esprit.bean.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import tn.esprit.bean.ApplicationBean;

@FacesValidator("departementValidator")
public class DepartementValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent arg1, Object value)
			throws ValidatorException {
	String name=String.valueOf(value);
	ApplicationBean bean=context.getCurrentInstance().getApplication().evaluateExpressionGet(context, "#{applicationBean}", ApplicationBean.class);
	if(bean.doExistDeperatementByName(name)){
		throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Departement existe deja"));
	}
	
		
	}

}
