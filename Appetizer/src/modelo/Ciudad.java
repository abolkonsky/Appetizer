package modelo;

public class Ciudad {
	private int id;
	private String nombre;
	private String pais;
	
	// constructores
	public Ciudad(){}
	
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String toString(){
		return nombre;
	}
	
}
