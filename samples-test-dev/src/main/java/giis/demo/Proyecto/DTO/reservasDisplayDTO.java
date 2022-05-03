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
	private String nombreInstalacion;
	private String nombre;
	
	
	
	
	public reservasDisplayDTO(String idReserva, String fecha, float horaInicio, float horaFin, String estado,
			String nombre) {
		super();
		this.idReserva = idReserva;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.estado = estado;
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreInstalacion() {
		return nombreInstalacion;
	}
	public void setNombreInstalacion(String nombreInstalacion) {
		this.nombreInstalacion = nombreInstalacion;
	}
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
	
	public reservasDisplayDTO(String idReserva, String fecha, float horaInicio, float horaFin, String idInstalacion,
			String idSocio, String estado, String nombreInstalacion) {
		super();
		this.idReserva = idReserva;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.idInstalacion = idInstalacion;
		this.idSocio = idSocio;
		this.estado = estado;
		this.nombreInstalacion = nombreInstalacion;
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
	
	@Override
	public String toString() {
		return idActividad;
	}
	
}