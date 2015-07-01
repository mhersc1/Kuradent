package web.util;

import java.io.Serializable;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@ManagedBean(name="message")
@ViewScoped
public class MessageBean implements Serializable{

	private String message;
	Properties properties;
	
	@PostConstruct
	public void init()
	{
		properties = Util.getProperties("parametros.properties");
	}
	
	public void showMessage(int option)
	{
		FacesContext context=FacesContext.getCurrentInstance();
		switch(option){
		
		case 0:
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," "+properties.getProperty("codigo_"+option)+" ",properties.getProperty("message_"+option)));
			break;
		case 1:
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR," "+properties.getProperty("codigo_"+option)+" ",properties.getProperty("message_"+option)));
			break;
		case 2:
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR," "+properties.getProperty("codigo_"+option)+" ",properties.getProperty("message_"+option)));
			break;			
		case 3:
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR," "+properties.getProperty("codigo_"+option)+" ",properties.getProperty("message_"+option)));
			break;
		case 4:
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN," "+properties.getProperty("codigo_"+option)+" ",properties.getProperty("message_"+option)));
			break;
		case 5:
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL," "+properties.getProperty("codigo_"+option)+" "," "));
			break;			
		}
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
