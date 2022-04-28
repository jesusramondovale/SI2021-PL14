package giis.demo.Proyecto.DTO;

public class InstalacionesDisplayDTO {
	private int idInstalacion;
	private String nombre;
	private float precioHora;
	
	
	public InstalacionesDisplayDTO() {}


	public InstalacionesDisplayDTO(int idInstalacion, String nombre, float precioHora) {
		super();
		this.idInstalacion = idInstalacion;
		this.nombre = nombre;
		this.precioHora = precioHora;
	}


	public int getIdInstalacion() {
		return idInstalacion;
	}


	public void setIdInstalacion(int idInstalacion) {
		this.idInstalacion = idInstalacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getPrecioHora() {
		return precioHora;
	}


	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}
	
	
	
	
}