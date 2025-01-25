package Model;

import java.util.ArrayList;

public class Vuelos {
	
	private ArrayList<Eventos>eventos;
	public String aero_origen;
	public String aero_destino;
	public String cod_vuelo_ida;
	public Aerolineas aerolinea_ida;
	public int precio;
	public String f_salida;
	public String h_salida;
	public String duracion_ida;
	public String tipo_vuelo;
	public String f_vuelta;
	public String h_vuelta;
	public String duracion_vuelta;
	public String cod_vuelo_vuelta;
	public Aerolineas aerolinea_vuelta;
	
	//constructor
	public Vuelos() {
		ArrayList <Eventos> eventos = new ArrayList();
		this.aero_origen = "";
		this.aero_destino = "";
		this.cod_vuelo_ida = "";
		this.aerolinea_ida = new Aerolineas();
		this.precio = 0;
		this.f_salida = "";
		this.h_salida = "";
		this.duracion_ida = "";
		this.tipo_vuelo = "";
		this.f_vuelta = "";
		this.h_vuelta = "";
		this.duracion_vuelta = "";
		this.cod_vuelo_vuelta = "";
		this.aerolinea_vuelta = new Aerolineas();
	}

	

	public Vuelos(ArrayList<Eventos> eventos, String aero_origen, String aero_destino, String cod_vuelo_ida,
			Aerolineas aerolinea_ida, int precio, String f_salida, String h_salida, String duracion_ida,
			String tipo_vuelo, String f_vuelta, String h_vuelta, String duracion_vuelta, String cod_vuelo_vuelta,
			Aerolineas aerolinea_vuelta) {
		this.eventos = eventos;
		this.aero_origen = aero_origen;
		this.aero_destino = aero_destino;
		this.cod_vuelo_ida = cod_vuelo_ida;
		this.aerolinea_ida = aerolinea_ida;
		this.precio = precio;
		this.f_salida = f_salida;
		this.h_salida = h_salida;
		this.duracion_ida = duracion_ida;
		this.tipo_vuelo = tipo_vuelo;
		this.f_vuelta = f_vuelta;
		this.h_vuelta = h_vuelta;
		this.duracion_vuelta = duracion_vuelta;
		this.cod_vuelo_vuelta = cod_vuelo_vuelta;
		this.aerolinea_vuelta = aerolinea_vuelta;
	}



	//getters y setters


	public String getAero_origen() {
		return aero_origen;
	}


	public ArrayList<Eventos> getEventos() {
		return eventos;
	}


	public void setEventos(ArrayList<Eventos> eventos) {
		this.eventos = eventos;
	}


	public void setAero_origen(String aero_origen) {
		this.aero_origen = aero_origen;
	}


	public String getAero_destino() {
		return aero_destino;
	}


	public void setAero_destino(String aero_destino) {
		this.aero_destino = aero_destino;
	}


	public String getCod_vuelo_ida() {
		return cod_vuelo_ida;
	}


	public void setCod_vuelo_ida(String cod_vuelo_ida) {
		this.cod_vuelo_ida = cod_vuelo_ida;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getF_salida() {
		return f_salida;
	}


	public void setF_salida(String f_salida) {
		this.f_salida = f_salida;
	}


	public String getH_salida() {
		return h_salida;
	}


	public void setH_salida(String h_salida) {
		this.h_salida = h_salida;
	}


	public String getDuracion_ida() {
		return duracion_ida;
	}


	public void setDuracion_ida(String duracion_ida) {
		this.duracion_ida = duracion_ida;
	}


	public String getTipo_vuelo() {
		return tipo_vuelo;
	}


	public void setTipo_vuelo(String tipo_vuelo) {
		this.tipo_vuelo = tipo_vuelo;
	}


	public String getF_vuelta() {
		return f_vuelta;
	}


	public void setF_vuelta(String f_vuelta) {
		this.f_vuelta = f_vuelta;
	}


	public String getH_vuelta() {
		return h_vuelta;
	}


	public void setH_vuelta(String h_vuelta) {
		this.h_vuelta = h_vuelta;
	}


	public String getDuracion_vuelta() {
		return duracion_vuelta;
	}


	public void setDuracion_vuelta(String duracion_vuelta) {
		this.duracion_vuelta = duracion_vuelta;
	}


	public String getCod_vuelo_vuelta() {
		return cod_vuelo_vuelta;
	}


	public void setCod_vuelo_vuelta(String cod_vuelo_vuelta) {
		this.cod_vuelo_vuelta = cod_vuelo_vuelta;
	}


	public Aerolineas getAerolinea_ida() {
		return aerolinea_ida;
	}



	public void setAerolinea_ida(Aerolineas aerolinea_ida) {
		this.aerolinea_ida = aerolinea_ida;
	}



	public Aerolineas getAerolinea_vuelta() {
		return aerolinea_vuelta;
	}



	public void setAerolinea_vuelta(Aerolineas aerolinea_vuelta) {
		this.aerolinea_vuelta = aerolinea_vuelta;
	}


	//to String
	@Override
	public String toString() {
		return "Vuelos [eventos=" + eventos + ", aero_origen=" + aero_origen + ", aero_destino=" + aero_destino
				+ ", cod_vuelo_ida=" + cod_vuelo_ida + ", aerolinea_ida=" + aerolinea_ida + ", precio=" + precio
				+ ", f_salida=" + f_salida + ", h_salida=" + h_salida + ", duracion_ida=" + duracion_ida
				+ ", tipo_vuelo=" + tipo_vuelo + ", f_vuelta=" + f_vuelta + ", h_vuelta=" + h_vuelta
				+ ", duracion_vuelta=" + duracion_vuelta + ", cod_vuelo_vuelta=" + cod_vuelo_vuelta
				+ ", aerolinea_vuelta=" + aerolinea_vuelta + "]";
	}

}
