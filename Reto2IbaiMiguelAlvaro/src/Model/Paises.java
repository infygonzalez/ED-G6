package Model;

public class Paises {

	public String id_pais;
	public String nombre;
	
	//constructor
	public Paises() {
		this.id_pais = "";
		this.nombre = "";
	}
	
	public Paises(String id_pais, String nombre) {
		this.id_pais = id_pais;
		this.nombre = nombre;
	}

	
	//getters y setters
	public String getId_pais() {
		return id_pais;
	}

	public void setId_pais(String id_pais) {
		this.id_pais = id_pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	//to String
	@Override
	public String toString() {
		return "Paises [id_pais=" + id_pais + ", nombre=" + nombre + "]";
	}

}
