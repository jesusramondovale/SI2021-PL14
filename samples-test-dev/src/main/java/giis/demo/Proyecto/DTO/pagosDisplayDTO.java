package giis.demo.Proyecto.DTO;

public class pagosDisplayDTO {
	
	private int idPago;
	private float importe;
	private String fecha;
	private int estado;
	private String idSocio;
	private String idNoSocio;
	private String idActividad;
	private String idReserva;
	
	public pagosDisplayDTO() {}
	
	public pagosDisplayDTO(int idPago, float importe, String fecha, int estado, String idSocio, String idNoSocio,
			String idActividad, String idReserva) {
		this.idPago = idPago;
		this.importe = importe;
		this.fecha = fecha;
		this.estado = estado;
		this.idSocio = idSocio;
		this.idNoSocio = idNoSocio;
		this.idActividad = idActividad;
		this.idReserva = idReserva;
	}

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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

	public String getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}

	public String getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	
	
}
