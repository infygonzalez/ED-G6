package Model;

import java.util.ArrayList;

public class OtrosEventos {
	
	public ArrayList<Eventos>eventos;
	public String nombre;
	public String fecha;
	public String descripcion;
	public String precio;

	//constructor
	public OtrosEventos() {
		ArrayList<Eventos>eventos = new ArrayList();
		this.nombre = "";
		this.fecha = "";
		this.descripcion = "";
		this.precio = "";
	}
	
	
	public OtrosEventos(ArrayList<Eventos> eventos, String nombre, String fecha, String descripcion, String precio) {
		this.eventos = eventos;
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.precio = precio;
	}



	//getters y setters


	public String getNombre() {
		return nombre;
	}

	public ArrayList<Eventos> getEventos() {
		return eventos;
	}


	public void setEventos(ArrayList<Eventos> eventos) {
		this.eventos = eventos;
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
		return "OtrosEventos [eventos=" + eventos + ", nombre=" + nombre + ", fecha=" + fecha + ", descripcion="
				+ descripcion + ", precio=" + precio + "]";
	}

}
