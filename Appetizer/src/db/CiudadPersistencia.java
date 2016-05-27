package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Ciudad;

public class CiudadPersistencia {
	public ArrayList<Ciudad> getCiudades(){
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		Ciudad ciudad = null;
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		String query = "SELECT * FROM CIUDAD";
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			
			while(rset.next()){
				int id = rset.getInt(1);
				String nombre = rset.getString(2);
				String pais = rset.getString(3);
				
				ciudad = new Ciudad();
				ciudad.setId(id);
				ciudad.setNombre(nombre);
				ciudad.setPais(pais);
				
				ciudades.add(ciudad);
			}
			
			// limpieza
			rset.close();
			stmt.close();
			con.close();
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		
		return ciudades;
	}
}
