package giis.demo.Proyecto.DTO;


public class pagosDisplayDTO {
	
	private int idPago;
	private float importe;

	private String idSocio;
	private String idActividad;
	private String idReserva;
	
	public pagosDisplayDTO() {}
	
	
	public pagosDisplayDTO(int idPago, float importe, String idSocio,
			String idActividad, String idReserva) {
		this.idPago = idPago;
		this.importe = importe;
		this.idSocio = idSocio;
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


	public String getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
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