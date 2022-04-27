package giis.demo.Proyecto.DTO;

import java.util.Date;

public class ActividadPeriodoDTO {

	private Integer idActividad;
	private String nombre;
	private String estado;
	
	private Date inicioInscrSocios;
	private Date finInscrSocios;
	private Date inicioInscrNoSocios;
	private Date finInscrNoSocios;
	
	
	
	public Integer getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getInicioInscrSocios() {
		return inicioInscrSocios;
	}
	public void setInicioInscrSocios(Date inicioInscrSocios) {
		this.inicioInscrSocios = inicioInscrSocios;
	}
	public Date getFinInscrSocios() {
		return finInscrSocios;
	}
	public void setFinInscrSocios(Date finInscrSocios) {
		this.finInscrSocios = finInscrSocios;
	}
	public Date getInicioInscrNoSocios() {
		return inicioInscrNoSocios;
	}
	public void setInicioInscrNoSocios(Date inicioInscrNoSocios) {
		this.inicioInscrNoSocios = inicioInscrNoSocios;
	}
	public Date getFinInscrNoSocios() {
		return finInscrNoSocios;
	}
	public void setFinInscrNoSocios(Date finInscrNoSocios) {
		this.finInscrNoSocios = finInscrNoSocios;
	}
	
	
	
	

	
}