package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioLoginPersistencia {
	
	// metodos
	public boolean ConectaA_DB(String usr, String pwd){
		boolean usuarioOk = false;
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		String query = "SELECT NOMBRE, PWD FROM USUARIOS WHERE NOMBRE = ? AND PWD = ?";
		
		try{
			PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1, usr);
			prep.setString(2, pwd);
			
			ResultSet rset = prep.executeQuery();
			while(rset.next()){
				usuarioOk = true;
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return usuarioOk;
	}
}
