package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	private String driver;
	private String url;
	private String usuario;
	private String password;
	private Connection con;
	
	public Connection getConnection(){
		try{
			config();
			//Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, password);
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return con;
	}
	
	private void config(){
		Properties propConfig = new Properties();
		InputStream entrada = null;
		
		// intenta leer del archivo config.properties
		try{
			entrada = new FileInputStream("config.properties");
			propConfig.load(entrada);
			
			// asigna los valores correspondientes a los atributos
			driver = propConfig.getProperty("driver");
			url = propConfig.getProperty("url");
			usuario = propConfig.getProperty("usuario");
			password = propConfig.getProperty("password");
		}
		catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}
