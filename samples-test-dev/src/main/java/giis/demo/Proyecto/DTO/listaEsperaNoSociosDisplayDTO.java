package giis.demo.Proyecto.DTO;

public class listaEsperaNoSociosDisplayDTO {

	private int idActividad;
	private int idSocio;
	private int posicion;
	
	public listaEsperaNoSociosDisplayDTO() {}
	
	public listaEsperaNoSociosDisplayDTO(int idActividad, int idSocio, int posicion) {
		this.idActividad = idActividad;
		this.idSocio = idSocio;
		this.posicion = posicion;
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

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
}

