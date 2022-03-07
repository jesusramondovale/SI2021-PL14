package giis.demo.Proyecto.DTO;

public class horarioActividadDisplayDTO {

	private int idHorario;
	private int idActividad;
	private String dia;
	private float horaInicio;
	private float horaFin;
	
	public horarioActividadDisplayDTO() {}
	
	public horarioActividadDisplayDTO(int idHorario, int idActividad, String dia, float horaInicio, float horaFin) {
		super();
		this.idHorario = idHorario;
		this.idActividad = idActividad;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public float getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(float horaInicio) {
		this.horaInicio = horaInicio;
	}

	public float getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(float horaFin) {
		this.horaFin = horaFin;
	}
	
	
}
