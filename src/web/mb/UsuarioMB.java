package web.mb;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import web.form.UsuarioForm;
import web.util.MessageBean;
import web.util.Util;
import dao.impl.UsuarioDAOImpl;
import dao.inf.UsuarioDAO;

@ManagedBean(name="usuarioMB")
@ViewScoped
public class UsuarioMB {
	
	private Log logger = LogFactory.getLog(UsuarioMB.class);
	
	@ManagedProperty(value="#{message}")
	private MessageBean message;
	
	Properties properties;
	private UsuarioForm usuario;

	UsuarioDAO usuarioDAO;	
	
	@PostConstruct
	private void init(){
		usuarioDAO = new UsuarioDAOImpl();
		this.setUsuario(new UsuarioForm());
		usuario = new UsuarioForm();
		properties = Util.getProperties("parametros.properties");
	}
	
	public String login(){
		String usuario = this.usuario.getUsuario();
		String password = this.usuario.getPassword();
		Integer sistema = 0;
		
		Integer codigo;
		codigo = usuarioDAO.login(usuario, password, sistema);
		logger.info("Estado User >>>" + properties.getProperty("codigo_"+codigo));
		message.showMessage(codigo);
		if(codigo == 0){
			return "ingresopaciente";
		}else{
			return "";
		}
	}
	public UsuarioForm getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioForm usuario) {
		this.usuario = usuario;
	}
	
	public MessageBean getMessage() {
		return message;
	}

	public void setMessage(MessageBean message) {
		this.message = message;
	}
}
