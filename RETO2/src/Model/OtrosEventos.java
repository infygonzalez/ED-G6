package Model;

public class OtrosEventos {
	
	public String ID;
	public String nombre;
	public String fecha;
	public String descripcion;
	public String precio;

	//constructor
	public OtrosEventos() {
		ID = "";
		this.nombre = "";
		this.fecha = "";
		this.descripcion = "";
		this.precio = "";
	}
	
	public OtrosEventos(String iD, String nombre, String fecha, String descripcion, String precio) {
		ID = iD;
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	
	//getters y setters
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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
		return "OtrosEventos [ID=" + ID + ", nombre=" + nombre + ", fecha=" + fecha + ", descripcion=" + descripcion
				+ ", precio=" + precio + "]";
	}
	
}
