package giis.demo.Proyecto.DTO;

public class ReservaDTO {

	private int idReserva;
	private String fecha;
	private float horaInicio;
	private float horaFin;
	
	private int idInstalacion;
	private int idActividad;
	private int idSocio;
	private String nombre, apellido1 , apellido2;
	private String estado;
	private int precioHora; 
	
	

	public ReservaDTO() {
		
	}

	
	
	
	
	
	






	public ReservaDTO(int idReserva, float horaInicio, float horaFin, int idInstalacion, int precio) {
		super();
		this.idReserva = idReserva;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.idInstalacion = idInstalacion;
		this.precioHora = precio;
	}







	public ReservaDTO(int idReserva, String fecha, float horaInicio, float horaFin, int idInstalacion, int idActividad,
			int idSocio, String nombre, String apellido1, String apellido2, String estado, int precio) {
		super();
		this.idReserva = idReserva;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.idInstalacion = idInstalacion;
		this.idActividad = idActividad;
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.estado = estado;
		this.precioHora = precio;
	}







	public ReservaDTO(int idReserva, String fecha, float horaInicio, int idInstalacion, String nombre, String apellido1,
			String estado) {
		super();
		this.idReserva = idReserva;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.idInstalacion = idInstalacion;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.estado = estado;
	}






	public ReservaDTO(int idReserva, String fecha, float horaInicio) {
		super();
		this.idReserva = idReserva;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
	}






	public ReservaDTO(int idReserva, String estado) {
		super();
		this.idReserva = idReserva;
		this.estado = estado;
	}





	public ReservaDTO(String fecha, float horaInicio, int idInstalacion, int idSocio, String nombre, String apellido1,
			String apellido2) {
		super();
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.idInstalacion = idInstalacion;
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}





	public ReservaDTO(int idReserva, float horaInicio, float horaFin, int precioHora) {
		super();
		this.idReserva = idReserva;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.precioHora = precioHora;
	}







	public ReservaDTO(int idReserva, String fecha, float horaInicio, float horaFin, int idInstalacion, int idActividad,
			int idSocio, String nombre, String apellido1, String apellido2, String estado) {
		super();
		this.idReserva = idReserva;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.idInstalacion = idInstalacion;
		this.idActividad = idActividad;
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.estado = estado;
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

	
	
	
	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getApellido1() {
		return apellido1;
	}





	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}





	public String getApellido2() {
		return apellido2;
	}





	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}





	public int getPrecioHora() {
		return precioHora;
	}







	public void setPrecioHora(int precio) {
		this.precioHora = precio;
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