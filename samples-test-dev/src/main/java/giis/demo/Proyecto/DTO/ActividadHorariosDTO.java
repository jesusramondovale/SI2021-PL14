package giis.demo.Proyecto.DTO;

public class ActividadHorariosDTO {

	
	private int idActividad;
	private String fechaInicio, fechaFin;
	private int idInstalacion;
	private String dia;
	private int horaInicio, horaFin;
	
	
	
	
	
	public ActividadHorariosDTO() {
		
	}


	public ActividadHorariosDTO(int idActividad, String fechaInicio, String fechaFin, int instalacion, String dia,
			int horaInicio, int horaFin) {
		super();
		this.idActividad = idActividad;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idInstalacion = instalacion;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	
	public int getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
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
	public int getIdInstalacion() {
		return idInstalacion;
	}
	public void setIdInstalacion(int instalacion) {
		this.idInstalacion = instalacion;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}
	
	
	
	
	
}
