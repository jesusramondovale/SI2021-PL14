package giis.demo.Proyecto.DTO;

public class SociosDisplayDTO {
	
	private int idSocio;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String corrientePago;
	private int cuota;
	private String telefono;

	public SociosDisplayDTO() {}

	
	
	
	
	public SociosDisplayDTO(int idSocio, String dni, String nombre, String apellido1, String apellido2,
			String corrientePago, int cuota, String telefono) {
		super();
		this.idSocio = idSocio;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.corrientePago = corrientePago;
		this.cuota = cuota;
		this.telefono = telefono;
	}




	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCorrientePago() {
		return corrientePago;
	}
	public void setCorrientePago(String corrientePago) {
		this.corrientePago = corrientePago;
	}
	public int getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getdni() {
		return dni;
	}
	public void setdni(String dNI_NIF) {
		dni = dNI_NIF;
	}
	
	public int getCuota() {
		return cuota;
	}
	public void setCuota(int cuota) {
		this.cuota = cuota;
	}
	@Override
	public String toString() {
		return "Socio: "+ nombre + " " + apellido1 + " " + apellido2  + " con teléfono: "+ telefono + " " ;
	}
}