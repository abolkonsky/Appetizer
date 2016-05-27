package modelo;

import java.util.ArrayList;

public class Pincho {
	private int id;
	private String nombre;
	private double precio;
	private double coste;
	private Ciudad procedencia;
	private ArrayList<Ingrediente> ingredientes;
	
	// constructores
	public Pincho(){}
	
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getCoste() {
		return coste;
	}
	public void setCoste(double coste) {
		this.coste = coste;
	}
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public Ciudad getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(Ciudad procedencia) {
		this.procedencia = procedencia;
	}
	
	
	
	
}
