package giis.demo.Proyecto.DTO;

public class PeriodosIncripcionesDTO {
	String nombre;
	int id, id_actividad, socio_id, noSocio_id;
	
	
	public PeriodosIncripcionesDTO() {}
	public PeriodosIncripcionesDTO(int id_actividad, int socio_id, int noSocio_id) {
		super();
		this.id_actividad = id_actividad;
		this.socio_id = socio_id;
		this.noSocio_id = noSocio_id;
	}
	
	public String toString() {
		return "InscripcionDTO [actividad_id=" + id_actividad + ", socio_id=" + socio_id + ", noSocio_id=" + noSocio_id
				+ "]";
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_actividad() {
		return id_actividad;
	}
	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}
	public int getSocio_id() {
		return socio_id;
	}
	public void setSocio_id(int socio_id) {
		this.socio_id = socio_id;
	}
	public int getNoSocio_id() {
		return noSocio_id;
	}
	public void setNoSocio_id(int noSocio_id) {
		this.noSocio_id = noSocio_id;
	}
	
	
}
