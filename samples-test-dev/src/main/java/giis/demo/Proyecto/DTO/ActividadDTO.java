package giis.demo.Proyecto.DTO;

import java.sql.Date;

public class ActividadDTO {

	private int id;
	private String nombre,tipo; //tipo = tipo de deporte
	private Integer precio_socio, precio_noSocio;
	private String fechaInicio,fechaFin, deporte;
	private Integer plazas, id_instalacion, id_periodoIncr, estado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getPrecio_socio() {
		return precio_socio;
	}
	public void setPrecio_socio(Integer precio_socio) {
		this.precio_socio = precio_socio;
	}
	public Integer getPrecio_noSocio() {
		return precio_noSocio;
	}
	public void setPrecio_noSocio(Integer precio_noSocio) {
		this.precio_noSocio = precio_noSocio;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public Integer getPlazas() {
		return plazas;
	}
	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}
	public Integer getId_instalacion() {
		return id_instalacion;
	}
	public void setId_instalacion(Integer id_instalacion) {
		this.id_instalacion = id_instalacion;
	}
	public Integer getId_periodoIncr() {
		return id_periodoIncr;
	}
	public void setId_periodoIncr(Integer id_periodoIncr) {
		this.id_periodoIncr = id_periodoIncr;
	}
	
	
	public String toString() {
		return "ActividadDTO [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", precio="
				+ precio_socio + ", precio_ns=" + precio_noSocio + ", fecha_ini=" + fechaInicio + ", fecha_fin=" + fechaFin 
				+ ", deporte=" + deporte +  ", plazas=" + plazas  + ", id_instalacion="+ id_instalacion + ", periodoIns_id=" + id_periodoIncr 
				+ ", estado=" + estado + "]";
	}
	
}
