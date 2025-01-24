package Model;

public class Alojamientos {

	public String id_evento;
	public String nombre_hotel;
	public String ciudad;
	public int precio;
	public String f_entrada;
	public String f_salida;
	public String tipo_hab;
	
	
	//constructor
	public Alojamientos() {
		this.id_evento = "";
		this.nombre_hotel = "";
		this.ciudad = "";
		this.precio = 0;
		this.f_entrada = "";
		this.f_salida = "";
		this.tipo_hab = "";
	}
	
	
	public Alojamientos(String id_evento, String nombre_hotel, String ciudad, int precio, String f_entrada,
			String f_salida, String tipo_hab) {
		this.id_evento = id_evento;
		this.nombre_hotel = nombre_hotel;
		this.ciudad = ciudad;
		this.precio = precio;
		this.f_entrada = f_entrada;
		this.f_salida = f_salida;
		this.tipo_hab = tipo_hab;
	}

	//getters y setters
	public String getId_evento() {
		return id_evento;
	}


	public void setId_evento(String id_evento) {
		this.id_evento = id_evento;
	}


	public String getNombre_hotel() {
		return nombre_hotel;
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
		return "Alojamientos [id_evento=" + id_evento + ", nombre_hotel=" + nombre_hotel + ", ciudad=" + ciudad
				+ ", precio=" + precio + ", f_entrada=" + f_entrada + ", f_salida=" + f_salida + ", tipo_hab="
				+ tipo_hab + "]";
	}
	
	
	
	
	
}
