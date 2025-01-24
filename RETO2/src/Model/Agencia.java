package Model;
/*
 * Este es el modelo pojos de la clase Agencia, vamos a generar sus getters y setters
 */
public class Agencia {
	
	private String ID;
	private String nombre;
	private String logo;
	private String color;
	private int numeroEmpleados;
	private String tipoAgencia;
	private String contra;
	
	//constructores
	public Agencia() {
		this.ID = "";
		this.nombre = "";
		this.logo = "";
		this.color = "";
		this.numeroEmpleados = 0;
		this.tipoAgencia = "";
		this.contra = "";
	}
	
	public Agencia(String ID, String nombre, String logo, String color, int numeroEmpleados, String tipoAgencia,
			String contra) {
		this.ID = ID;
		this.nombre = nombre;
		this.logo = logo;
		this.color = color;
		this.numeroEmpleados = numeroEmpleados;
		this.tipoAgencia = tipoAgencia;
		this.contra = contra;
	}
	
	//getters y setters
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
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
	public int getNumeroEmpleados() {
		return numeroEmpleados;
	}
	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}
	public String getTipoAgencia() {
		return tipoAgencia;
	}
	public void setTipoAgencia(String tipoAgencia) {
		this.tipoAgencia = tipoAgencia;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Agencia [ID=" + ID + ", nombre=" + nombre + ", logo=" + logo + ", color=" + color + ", numeroEmpleados="
				+ numeroEmpleados + ", tipoAgencia=" + tipoAgencia + ", contraseña=" + contra + "]";
	}
	
	
}
