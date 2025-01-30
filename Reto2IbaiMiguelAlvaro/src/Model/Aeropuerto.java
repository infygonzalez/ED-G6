package Model;

public class Aeropuerto {
	
	private String id_aeropuetro;
	private String nombre;
	private Paises pais;
	public String getId_aeropuetro() {
		return id_aeropuetro;
	}
	public void setId_aeropuetro(String id_aeropuetro) {
		this.id_aeropuetro = id_aeropuetro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Aeropuerto(String id_aeropuetro, String nombre, Paises pais) {
		this.id_aeropuetro = id_aeropuetro;
		this.nombre = nombre;
		this.pais = pais;
	}
	
	public Aeropuerto() {
		this.id_aeropuetro = "";
		this.nombre = "";
		this.pais = new Paises();
	}
	
	@Override
	public String toString() {
		return "Aeropuerto [id_aeropuetro=" + id_aeropuetro + ", nombre=" + nombre + ", pais=" + pais + "]";
	}
	public Paises getPais() {
		return pais;
	}
	public void setPais(Paises pais) {
		this.pais = pais;
	}

}
