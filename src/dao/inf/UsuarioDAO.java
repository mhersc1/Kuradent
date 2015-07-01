package dao.inf;


public interface UsuarioDAO {
	
	public Integer login(String usuario, String password, Integer sistema);
}
