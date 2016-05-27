package modelo;

import java.util.ArrayList;

public class Restaurante {
	private int id;
	private String nombre;
	private String direccion;
	private double facturacionAnual;
	private ArrayList<Pincho> listaPinchos;
	
	// constructor
	public Restaurante(){}

	// metodos de acceso
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getFacturacionAnual() {
		return facturacionAnual;
	}

	public void setFacturacionAnual(double facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}

	public ArrayList<Pincho> getListaPinchos() {
		return listaPinchos;
	}

	public void setListaPinchos(ArrayList<Pincho> listaPinchos) {
		this.listaPinchos = listaPinchos;
	}
}
