package giis.demo.Proyecto.DTO;

public class reservasDisplayDTO {

	private String idReserva;
	private String fecha;
	private float horaInicio ;
	private float horaFin ;
	private String idInstalacion;
	private String idActividad;
	private String idSocio;
	private String estado;
	
	
	
	public reservasDisplayDTO() {}
	public reservasDisplayDTO(String rowIdReserva, String rowIdUsuario,String rowFechaReserva, float rowHoraInicioReserva,float rowHoraFinReserva,String rowNombreInstalacion, 
								String rowEstadoReserva,String rowNombreActividad) {
		this.idReserva=rowIdReserva;
		this.fecha=rowFechaReserva;
		this.horaInicio=rowHoraInicioReserva;
		this.horaFin=rowHoraFinReserva;
		this.idInstalacion = rowNombreInstalacion;
		this.idActividad = rowNombreActividad;
		this.idSocio=rowIdUsuario;
		this.estado=rowEstadoReserva;
	}
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public float getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(float horaInicio) {
		this.horaInicio = horaInicio;
	}
	public float getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(float horaFin) {
		this.horaFin = horaFin;
	}
	public String getIdInstalacion() {
		return idInstalacion;
	}
	public void setIdInstalacion(String idInstalacion) {
		this.idInstalacion = idInstalacion;
	}
	public String getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}
	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}