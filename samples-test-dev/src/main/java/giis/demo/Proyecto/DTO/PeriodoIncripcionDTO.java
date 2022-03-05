package giis.demo.Proyecto.DTO;

public class PeriodoIncripcionDTO {

	private int id_periodo;
	private String nombre_periodo, fechaInicioIncripcion, fechaFinIncripcion, fechaFinIncripcionNoSocio;
	
	public PeriodoIncripcionDTO() {}
	public PeriodoIncripcionDTO(int id_periodo, String nombre_periodo, String fechaInicioIncripcion, String fechaFinIncripcion,
			String fechaFinIncripcionNoSocio) {
		super();
		this.id_periodo = id_periodo;
		this.nombre_periodo = nombre_periodo;
		this.fechaInicioIncripcion = fechaInicioIncripcion;
		this.fechaFinIncripcion = fechaFinIncripcion;
		this.fechaFinIncripcionNoSocio = fechaFinIncripcionNoSocio;
	}
	
	public int getId_periodo() {
		return id_periodo;
	}
	public void setId_periodo(int id_periodo) {
		this.id_periodo = id_periodo;
	}
	public String getNombre_periodo() {
		return nombre_periodo;
	}
	public void setNombre_periodo(String nombre_periodo) {
		this.nombre_periodo = nombre_periodo;
	}
	public String getFechaInicioIncripcion() {
		return fechaInicioIncripcion;
	}
	public void setFechaInicioIncripcion(String fechaInicioIncripcion) {
		this.fechaInicioIncripcion = fechaInicioIncripcion;
	}
	public String getFechaFinIncripcion() {
		return fechaFinIncripcion;
	}
	public void setFechaFinIncripcion(String fechaFinIncripcion) {
		this.fechaFinIncripcion = fechaFinIncripcion;
	}
	public String getFechaFinIncripcionNoSocio() {
		return fechaFinIncripcionNoSocio;
	}
	public void setFechaFinIncripcionNoSocio(String fechaFinIncripcionNoSocio) {
		this.fechaFinIncripcionNoSocio = fechaFinIncripcionNoSocio;
	}
	

}
