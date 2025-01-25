package Model;

import java.util.ArrayList;

public class Eventos {
	
	public String id_eventos;
	public String tipo;
	public ArrayList<Viajes>id_viaje;
	
	
	//Constructor
	public Eventos() {
		this.id_eventos = "";
		this.tipo = "";
		ArrayList<Viajes>id_viaje = new ArrayList();
	}
	
	public Eventos(String id_eventos, String tipo, ArrayList<Viajes> id_viaje) {
		this.id_eventos = id_eventos;
		this.tipo = tipo;
		this.id_viaje = id_viaje;
	}
	
	
	//Getters y setters
	public String getId_eventos() {
		return id_eventos;
	}
	public void setId_eventos(String id_eventos) {
		this.id_eventos = id_eventos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ArrayList<Viajes> getId_viaje() {
		return id_viaje;
	}
	public void setId_viaje(ArrayList<Viajes> id_viaje) {
		this.id_viaje = id_viaje;
	}

	
	//toString
	@Override
	public String toString() {
		return "Eventos [id_eventos=" + id_eventos + ", tipo=" + tipo + ", id_viaje=" + id_viaje + "]";
	}
	
	
	
	

}
