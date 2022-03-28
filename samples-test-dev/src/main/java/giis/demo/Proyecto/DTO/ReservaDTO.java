package giis.demo.Proyecto.DTO;

public class ReservaDTO {

	private int idReserva;
	private String fecha;
	private float horaInicio;
	private float horaFin;
	
	private int idInstalacion;
	private int idActividad;
	private int idSocio;
	
	private String estado;
	private float precioHora;
	

	public ReservaDTO() {
		super();
	}

	
	
	public float getPrecioHora() {
		return precioHora;
	}



	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}



	public ReservaDTO(String fecha, int idInstalacion, String estado, int precio) {
		super();
		this.fecha = fecha;
		this.idInstalacion = idInstalacion;
		this.estado = estado;
		this.precioHora = precio;
	}



	public ReservaDTO(String fecha, float horaInicio, float horaFin, int idInstalacion, String estado, int precio) {
		super();
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.idInstalacion = idInstalacion;
		this.estado = estado;
		this.precioHora = precio;
	}



	public ReservaDTO(String fecha, float horaInicio, float horaFin) {
		super();
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public ReservaDTO(int idReserva, int idInstalacion, int idActividad, int idSocio) {
		super();
		this.idReserva = idReserva;
		this.idInstalacion = idInstalacion;
		this.idActividad = idActividad;
		this.idSocio = idSocio;
	}

	public ReservaDTO(int idReserva, String fecha, float horaInicio, float horaFin, int idInstalacion, int idActividad,
			int idSocio, String estado) {
		super();
		this.idReserva = idReserva;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.idInstalacion = idInstalacion;
		this.idActividad = idActividad;
		this.idSocio = idSocio;
		this.estado = estado;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getFecha() {
		return fecha;
	}
	
	

	public float getPrecioSocio() {
		return precioHora;
	}



	public void setPrecioSocio(int precio) {
		this.precioHora = precio;
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

	public int getIdInstalacion() {
		return idInstalacion;
	}

	public void setIdInstalacion(int idInstalacion) {
		this.idInstalacion = idInstalacion;
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
