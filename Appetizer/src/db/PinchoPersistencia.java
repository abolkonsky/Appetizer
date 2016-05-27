package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pincho;

public class PinchoPersistencia {
	public int introducePinchoNuevo(Pincho pincho){
		int resp = 0;
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		String query = "INSERT INTO PINCHO VALUES (PINCHO_SQ.NEXTVAL, ?, ?, ?, ?)";
		
		try{
			PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1, pincho.getNombre());
			prep.setDouble(2, pincho.getPrecio());
			prep.setDouble(3, pincho.getCoste());
			prep.setInt(4, pincho.getProcedencia().getId());
			
			resp = prep.executeUpdate();
			
			prep.close();
			con.close();
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return resp;
	}
}
