package giis.demo.Proyecto.DTO;



public class MostrarActividadesDTO {

	
	
	//private int idActividad;
	private String nombre;
	//private String tipo;
	private float precioSocio;
	private float precioNoSocio;
	private String fechaInicio;
	private float horaInicio;
	private float horaFin;
	
	//private int idPeriodoInscripcion;
	//private int estado;
	private int plazas;
	//private int idInstalacion;
	
	
	
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
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
	
	

}
