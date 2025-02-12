package Model;

public class Aerolineas {

	public String id_aerolinea;
	public String nombre;
	
	//constructor
	public Aerolineas() {
		this.id_aerolinea = "";
		this.nombre = "";
	}
	
	public Aerolineas(String id_aerolinea, String nombre) {
		this.id_aerolinea = id_aerolinea;
		this.nombre = nombre;
	}
	
	//getters y setters

	public String getId_aerolinea() {
		return id_aerolinea;
	}

	public void setId_aerolinea(String id_aerolinea) {
		this.id_aerolinea = id_aerolinea;
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
		return "Aerolineas [id_aerolinea=" + id_aerolinea + ", nombre=" + nombre + "]";
	}
	
	
	
}
