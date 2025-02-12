package Model;

import java.util.ArrayList;

/*
 * Este es el modelo pojos de la clase Agencia, vamos a generar sus getters y setters
 */
public class Agencia {
	
	private int ID;
	private String nombre;
	private String logo;
	private String color;
	private String numeroEmpleados;
	private String tipoAgencia;
	private String contra;
	private ArrayList<Viajes>viajes;
	
	//constructores
	public Agencia() {
		this.ID = 0;
		this.nombre = "";
		this.logo = "";
		this.color = "";
		this.numeroEmpleados = "";
		this.tipoAgencia = "";
		this.contra = "";
		ArrayList<Viajes> viajes = new ArrayList();
	}
	
	public Agencia(int ID, String nombre, String logo, String color, String numeroEmpleados, String tipoAgencia,
			String contra, ArrayList<Viajes> viajes) {
		this.ID = ID;
		this.nombre = nombre;
		this.logo = logo;
		this.color = color;
		this.numeroEmpleados = numeroEmpleados;
		this.tipoAgencia = tipoAgencia;
		this.contra = contra;
		this.viajes=viajes;
	}
	
	//getters y setters
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public int getID() {
		return ID;
	}
	public void setID(int id2) {
		ID = id2;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumeroEmpleados() {
		return numeroEmpleados;
	}
	public void setNumeroEmpleados(String numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}
	public String getTipoAgencia() {
		return tipoAgencia;
	}
	public void setTipoAgencia(String tipoAgencia) {
		this.tipoAgencia = tipoAgencia;
	}
	
	public ArrayList<Viajes> getViajes() {
		return viajes;
	}

	public void setViajes(ArrayList<Viajes> viajes) {
		this.viajes = viajes;
	}

	@Override
	public String toString() {
		return "Agencia [ID=" + ID + ", nombre=" + nombre + ", logo=" + logo + ", color=" + color + ", numeroEmpleados="
				+ numeroEmpleados + ", tipoAgencia=" + tipoAgencia + ", contra=" + contra + ", viajes=" + viajes + "]";
	}
	
	
}
