package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Ingrediente;

public class IngredientePersistencia {
	public ArrayList<Ingrediente> getIngredientesTodos(){
		ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
		Ingrediente ingrediente = null;
		
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		String query = "SELECT * FROM INGREDIENTE";
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			
			while(rset.next()){
				int id = 0;
				String nombreIngrediente = "";
				double precioIngrediente = 0;
				// recupera los valores de la tabla ingrediente
				id = rset.getInt(1);
				nombreIngrediente = rset.getString(2);
				precioIngrediente = rset.getDouble(3);
				
				// forma el nuevo ingrediente con los valores recuperados
				ingrediente = new Ingrediente();
				ingrediente.setId(id);
				ingrediente.setNombre(nombreIngrediente);
				ingrediente.setCoste(precioIngrediente);
				
				// añade el nuevo ingrediente a la lista
				listaIngredientes.add(ingrediente);
			}
			
			rset.close();
			stmt.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		
		return listaIngredientes;
	}
}
