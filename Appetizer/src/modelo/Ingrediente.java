package modelo;

public class Ingrediente {
	private int id;
	private String nombre;
	private double coste;
	private int idCiudad;
	
	// constructores
	public Ingrediente(){}
	
	// metodos de acceso
	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCoste() {
		return coste;
	}
	public void setCoste(double coste) {
		this.coste = coste;
	}
	public void setIdCiudad(int id){
		this.idCiudad = id;
	}
	public int getIdCiudad()
	{
		return idCiudad;
	}
	
	public String toString(){
		return this.nombre;
	}
}
