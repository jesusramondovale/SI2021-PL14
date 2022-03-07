package giis.demo.Proyecto.DTO;

import java.sql.Date;

public class ActividadDTO {

	private int id;
	private String nombre,tipo; //tipo=descripcion
	private Integer precioSocio, precioNoSocio;
	private String fechaInicio,fechaFin;
	private Integer plazas, idInstalacion, idPeriodoInscripcion, estado;
	
	
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


	public Integer getPrecioSocio() {
		return precioSocio;
	}


	public void setPrecioSocio(Integer precioSocio) {
		this.precioSocio = precioSocio;
	}


	public Integer getPrecioNoSocio() {
		return precioNoSocio;
	}


	public void setPrecioNoSocio(Integer precioNoSocio) {
		this.precioNoSocio = precioNoSocio;
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


	public Integer getPlazas() {
		return plazas;
	}


	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}


	public Integer getIdInstalacion() {
		return idInstalacion;
	}


	public void setIdInstalacion(Integer idInstalacion) {
		this.idInstalacion = idInstalacion;
	}


	public Integer getIdPeriodoInscripcion() {
		return idPeriodoInscripcion;
	}


	public void setIdPeriodoInscripcion(Integer idPeriodoInscripcion) {
		this.idPeriodoInscripcion = idPeriodoInscripcion;
	}


	public Integer getEstado() {
		return estado;
	}


	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public String toString() {
		return "ActividadDTO [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", precio="
				+ precioSocio + ", precio_ns=" + precioNoSocio + ", fecha_ini=" + fechaInicio + ", fecha_fin=" + fechaFin 
				+ ", plazas=" + plazas  + ", id_instalacion="+ idInstalacion + ", periodoIns_id=" + idPeriodoInscripcion 
				+ ", estado=" + estado + "]";
	}
	
}
