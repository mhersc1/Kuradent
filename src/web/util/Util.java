package web.util;

import java.io.InputStream;
import java.util.Properties;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class Util {
	
	private static Log log = LogFactory.getLog(Util.class);

  	public static Properties getProperties(String file){
		Properties props=new Properties();
		InputStream input=null;
  		try {			
			input=FacesContext.class.getClassLoader().getResourceAsStream(file);			
			props.load(input);				
			return props;							
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			log.info("Ocurrio excepcion al leer el Properties :"+ file);
			e.printStackTrace();
			return null;
		}finally{
			if(input==null){
				System.out.println("No se pudo encontrar "+ file);
				
			}
		}
	}
  	
  	public static String getContextPath(String path){
  		
  		String contextPath = "";
  		ExternalContext externalContext = (ExternalContext)FacesContext.getCurrentInstance().
  										getExternalContext();
  		contextPath = externalContext.getContextName();
  		return contextPath;
  	} 

}
