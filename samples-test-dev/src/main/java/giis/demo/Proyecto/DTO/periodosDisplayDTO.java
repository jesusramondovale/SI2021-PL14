package giis.demo.Proyecto.DTO;

public class periodosDisplayDTO {

	private int idPeriodoInscripcion;
	private String nombre;
	private String inicioInscrSocios;
	private String finInscrSocios;
	private String finInscrNoSocios;
	
	public periodosDisplayDTO() {}
	
	public periodosDisplayDTO(int idPeriodoInscripcion, String nombre, String inicioInscrSocios, String finInscrSocios,
			String finInscrNoSocios) {
		this.idPeriodoInscripcion = idPeriodoInscripcion;
		this.nombre = nombre;
		this.inicioInscrSocios = inicioInscrSocios;
		this.finInscrSocios = finInscrSocios;
		this.finInscrNoSocios = finInscrNoSocios;
	}

	public int getIdPeriodoInscripcion() {
		return idPeriodoInscripcion;
	}

	public void setIdPeriodoInscripcion(int idPeriodoInscripcion) {
		this.idPeriodoInscripcion = idPeriodoInscripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInicioInscrSocios() {
		return inicioInscrSocios;
	}

	public void setInicioInscrSocios(String inicioInscrSocios) {
		this.inicioInscrSocios = inicioInscrSocios;
	}

	public String getFinInscrSocios() {
		return finInscrSocios;
	}

	public void setFinInscrSocios(String finInscrSocios) {
		this.finInscrSocios = finInscrSocios;
	}

	public String getFinInscrNoSocios() {
		return finInscrNoSocios;
	}

	public void setFinInscrNoSocios(String finInscrNoSocios) {
		this.finInscrNoSocios = finInscrNoSocios;
	}
	
	
}
