package giis.demo.Proyecto.DTO;

public class VisualizarReservasSociosDTO {

	private int IdInstalacion;
	private String fechaInicio, fechaFin;
	
	public int getIdInstalacion() {
		return IdInstalacion;
	}
	public void setIdInstalacion(int idInstalacion) {
		IdInstalacion = idInstalacion;
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
	
}
