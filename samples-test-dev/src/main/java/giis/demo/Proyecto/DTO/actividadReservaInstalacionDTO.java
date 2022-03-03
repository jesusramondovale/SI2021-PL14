package giis.demo.Proyecto.DTO;

public class actividadReservaInstalacionDTO {

	private String actividad;
	private String instalacion;
	private String fecha;
	private double hora;
	
	
	
	public actividadReservaInstalacionDTO(String rowActividad, String rowInstalacion, String rowFecha, double rowHora) {
		super();
		this.actividad = rowActividad;
		this.instalacion = rowInstalacion;
		this.fecha = rowFecha;
		this.hora = rowHora;
	}



	public String getActividad() {return actividad;}
	public void setActividad(String actividad) {this.actividad = actividad;}
	public String getInstalacion() {return instalacion;}
	public void setInstalacion(String instalacion) {this.instalacion = instalacion;}
	public String getFecha() {return fecha;}
	public void setFecha(String fecha) {this.fecha = fecha;}
	public double getHora() {return hora;}
	public void setHora(double hora) {this.hora = hora;}
	
	
	
	
	
	
	
	
	

}
