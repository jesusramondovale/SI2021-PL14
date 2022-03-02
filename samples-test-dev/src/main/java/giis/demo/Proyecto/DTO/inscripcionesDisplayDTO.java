package giis.demo.Proyecto.DTO;

public class inscripcionesDisplayDTO {

	private String idActividad;
	private String idSocio;
	private String idNoSocio;
	
	public inscripcionesDisplayDTO() {}
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
	public String getIdNoSocio() {
		return idNoSocio;
	}
	public void setIdNoSocio(String idNoSocio) {
		this.idNoSocio = idNoSocio;
	}
	public inscripcionesDisplayDTO(String idActividad, String idSocio, String idNoSocio) {
		this.idActividad = idActividad;
		this.idSocio = idSocio;
		this.idNoSocio = idNoSocio;
	}
	
	
	
}
