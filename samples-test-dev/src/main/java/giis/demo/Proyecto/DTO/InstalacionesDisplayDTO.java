package giis.demo.Proyecto.DTO;

public class InstalacionesDisplayDTO {
	private int idInstalacion;
	private String nombreInstalacion;
	private float precioHora;
	
	
	public InstalacionesDisplayDTO() {}
	public InstalacionesDisplayDTO(int rowIdInstalacion,String rowNombre,float rowPrecioHora) {
		this.idInstalacion=rowIdInstalacion;
		this.nombreInstalacion=rowNombre;
		this.setPrecioHora(rowPrecioHora);
	}
	public int getIdInstalacion() {
		return idInstalacion;
	}
	public void setIdInstalacion(int idInstalacion) {
		this.idInstalacion = idInstalacion;
	}
	public String getNombreInstalacion() {
		return nombreInstalacion;
	}
	public void setNombreInstalacion(String nombreInstalacion) {
		this.nombreInstalacion = nombreInstalacion;
	}
	public float getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}
}