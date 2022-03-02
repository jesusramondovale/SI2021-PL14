package giis.demo.Proyecto.DTO;
import java.util.Date;

public class actividadesDisplayDTO {

	private int idActividad;
	private String nombre;
	private String tipo;
	private float precioSocio;
	private float precioNoSocio;
	private Date fechaInicio;
	private Date fechaFin;
	private float horaInicio;
	private float horaFin;
	private int idPeriodoInscripcion;
	private int estado;
	private int plazas;
	private int idInstalacion;
	
	public actividadesDisplayDTO() {}
	
	public actividadesDisplayDTO(int idActividad, String nombre, String tipo, float precioSocio, float precioNoSocio,
			Date fechaInicio, Date fechaFin, float horaInicio, float horaFin, int idPeriodoInscripcion, int estado,
			int plazas, int idInstalacion) {
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precioSocio = precioSocio;
		this.precioNoSocio = precioNoSocio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.idPeriodoInscripcion = idPeriodoInscripcion;
		this.estado = estado;
		this.plazas = plazas;
		this.idInstalacion = idInstalacion;
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPrecioSocio() {
		return precioSocio;
	}

	public void setPrecioSocio(float precioSocio) {
		this.precioSocio = precioSocio;
	}

	public float getPrecioNoSocio() {
		return precioNoSocio;
	}

	public void setPrecioNoSocio(float precioNoSocio) {
		this.precioNoSocio = precioNoSocio;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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

	public int getIdPeriodoInscripcion() {
		return idPeriodoInscripcion;
	}

	public void setIdPeriodoInscripcion(int idPeriodoInscripcion) {
		this.idPeriodoInscripcion = idPeriodoInscripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getIdInstalacion() {
		return idInstalacion;
	}

	public void setIdInstalacion(int idInstalacion) {
		this.idInstalacion = idInstalacion;
	}
	
}
