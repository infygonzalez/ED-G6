package Model;

public class OtrosEventos {
	
	public String id_eventos;
	public String nombre;
	public String fecha;
	public String descripcion;
	public String precio;

	//constructor
	public OtrosEventos() {
		id_eventos = "";
		this.nombre = "";
		this.fecha = "";
		this.descripcion = "";
		this.precio = "";
	}
	
	public OtrosEventos(String iD, String nombre, String fecha, String descripcion, String precio) {
		id_eventos = iD;
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	
	//getters y setters
	public String getid_eventos() {
		return id_eventos;
	}

	public void setid_eventos(String iD) {
		id_eventos = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	//tostring
	
	@Override
	public String toString() {
		return "OtrosEventos [ID=" + id_eventos + ", nombre=" + nombre + ", fecha=" + fecha + ", descripcion=" + descripcion
				+ ", precio=" + precio + "]";
	}
	
}
