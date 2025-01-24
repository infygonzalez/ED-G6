package Model;

public class Viajes {

	private String ID;
	private String nombre;
	private String descripcion;
	private String tipo_viaje;
	private String fecInicio;
	private String fecFin;
	private String duracion;
	private String pais;
	private String servicios;
	private String ID_agencia;
	
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo_viaje() {
		return tipo_viaje;
	}
	public void setTipo_viaje(String tipo_viaje) {
		this.tipo_viaje = tipo_viaje;
	}
	public String getFecInicio() {
		return fecInicio;
	}
	public void setFecInicio(String fecInicio) {
		this.fecInicio = fecInicio;
	}
	public String getFecFin() {
		return fecFin;
	}
	public void setFecFin(String fecFin) {
		this.fecFin = fecFin;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getServicios() {
		return servicios;
	}
	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
	public String getID_agencia() {
		return ID_agencia;
	}
	public void setID_agencia(String iD_agencia) {
		ID_agencia = iD_agencia;
	}
	@Override
	public String toString() {
		return "Viajes [ID=" + ID + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipo_viaje=" + tipo_viaje
				+ ", fecInicio=" + fecInicio + ", fecFin=" + fecFin + ", duracion=" + duracion + ", pais=" + pais
				+ ", servicios=" + servicios + ", ID_agencia=" + ID_agencia + "]";
	}
	
	
}
