package giis.demo.Proyecto.DTO;

public class InformeActividadDTO {

	private String nombre;
	private int plazas;
	private int inscritos;
	private int idInstalacion;
	private String fechaIni;
	private String fechaFin;
	private float precioSocio;
	private float precioNoSocio;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	public int getInscritos() {
		return inscritos;
	}
	public void setInscritos(int inscritos) {
		this.inscritos = inscritos;
	}
	public int getIdInstalacion() {
		return idInstalacion;
	}
	public void setIdInstalacion(int idInstalacion) {
		this.idInstalacion = idInstalacion;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
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
	
	
}