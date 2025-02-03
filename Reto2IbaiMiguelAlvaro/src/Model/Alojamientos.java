package Model;

import java.util.ArrayList;

public class Alojamientos {

	//poner nombre o id del evento
	public ArrayList<Eventos>eventos;
	public String nombre_hotel;
	public String ciudad;
	public int precio;
	public String f_entrada;
	public String f_salida;
	public String tipo_hab;
	
	
	//constructor
	public Alojamientos() {
		ArrayList<Eventos>eventos = new ArrayList();
		this.nombre_hotel = "";
		this.ciudad = "";
		this.precio = 0;
		this.f_entrada = "";
		this.f_salida = "";
		this.tipo_hab = "";
	}
	

	public Alojamientos(ArrayList<Eventos> eventos, String nombre_hotel, String ciudad, int precio, String f_entrada,
			String f_salida, String tipo_hab) {
		this.eventos = eventos;
		this.nombre_hotel = nombre_hotel;
		this.ciudad = ciudad;
		this.precio = precio;
		this.f_entrada = f_entrada;
		this.f_salida = f_salida;
		this.tipo_hab = tipo_hab;
	}




	//getters y setters


	public String getNombre_hotel() {
		return nombre_hotel;
	}


	public ArrayList<Eventos> getEventos() {
		return eventos;
	}


	public void setEventos(ArrayList<Eventos> eventos) {
		this.eventos = eventos;
	}


	public void setNombre_hotel(String nombre_hotel) {
		this.nombre_hotel = nombre_hotel;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getF_entrada() {
		return f_entrada;
	}


	public void setF_entrada(String f_entrada) {
		this.f_entrada = f_entrada;
	}


	public String getF_salida() {
		return f_salida;
	}


	public void setF_salida(String f_salida) {
		this.f_salida = f_salida;
	}


	public String getTipo_hab() {
		return tipo_hab;
	}


	public void setTipo_hab(String tipo_hab) {
		this.tipo_hab = tipo_hab;
	}

	//toString
	@Override
	public String toString() {
		return "Alojamientos [eventos=" + eventos + ", nombre_hotel=" + nombre_hotel + ", ciudad=" + ciudad
				+ ", precio=" + precio + ", f_entrada=" + f_entrada + ", f_salida=" + f_salida + ", tipo_hab="
				+ tipo_hab + "]";
	}

}
