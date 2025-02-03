package Model;

import java.util.ArrayList;

public class OtrosEventos {
	
	public String id_eventos;
	public String nombre;
	public String fecha;
	public String descripcion;
	public String precio;

	//constructor
	public OtrosEventos() {
		this.id_eventos="";
		this.nombre = "";
		this.fecha = "";
		this.descripcion = "";
		this.precio = "";
	}
	
	
	public OtrosEventos(String id_eventos, String nombre, String fecha, String descripcion, String precio) {
		this.id_eventos = id_eventos;
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.precio = precio;
	}



	//getters y setters


	public String getNombre() {
		return nombre;
	}



	public String getId_eventos() {
		return id_eventos;
	}


	public void setId_eventos(String id_eventos) {
		this.id_eventos = id_eventos;
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


}
