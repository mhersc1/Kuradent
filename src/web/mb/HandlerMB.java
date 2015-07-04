package web.mb;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import web.util.Parametros;
import web.util.Util;

@ManagedBean(name="handlerMB")
@ViewScoped
public class HandlerMB {
	
	private String selected;
	
	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public void goToCitas() throws IOException{
		
		System.out.print("Pintando ando");
		FacesContext context = FacesContext.getCurrentInstance();
		String realPath = Util.getContextPath(Parametros.CITAS);
		context.getExternalContext().redirect("citas.xhtml");
/*		NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
		navigationHandler.handleNavigation(context, null, arg2);*/
		
	}	
}
