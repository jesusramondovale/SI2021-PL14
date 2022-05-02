package giis.demo.Proyecto.DTO;


public class ActividadPeriodoDTO {

	private Integer idActividad;
	private String nombre;
	private String estado;
	
	private String inicioInscrSocios; 
	private String finInscrSocios;
	private String finInscrNoSocios;
	

	
	

	
	
	public ActividadPeriodoDTO() {
	}
	
	public ActividadPeriodoDTO(Integer idActividad, String nombre, String estado, String inicioInscrSocios,
			String finInscrSocios, String finInscrNoSocios) {
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.estado = estado;
		this.inicioInscrSocios = inicioInscrSocios;
		this.finInscrSocios = finInscrSocios;
		this.finInscrNoSocios = finInscrNoSocios;
	}
	public String getInicioInscrSocios() {
		return inicioInscrSocios;
	}
	public void setInicioInscrSocios(String inicioInscrSocios) {
		this.inicioInscrSocios = inicioInscrSocios;
	}
	public String getFinInscrSocios() {
		return finInscrSocios;
	}
	public void setFinInscrSocios(String finInscrSocios) {
		this.finInscrSocios = finInscrSocios;
	}
	public String getFinInscrNoSocios() {
		return finInscrNoSocios;
	}
	public void setFinInscrNoSocios(String finInscrNoSocios) {
		this.finInscrNoSocios = finInscrNoSocios;
	}
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
	
	
	
	
	

	
}