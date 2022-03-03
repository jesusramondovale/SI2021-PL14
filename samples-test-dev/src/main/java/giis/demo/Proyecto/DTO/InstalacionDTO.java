package giis.demo.Proyecto.DTO;

public class InstalacionDTO {

	private int id,precioPorHora;
	private String nombre;
	
	public InstalacionDTO() {}
	public InstalacionDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public InstalacionDTO(String nombre, int precioPorHora) {
		super();
		this.nombre = nombre;
		this.precioPorHora=precioPorHora;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrecioPorHora() {
		return precioPorHora;
	}
	public void setPrecioPorHora(int precioPorHora) {
		this.precioPorHora = precioPorHora;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
