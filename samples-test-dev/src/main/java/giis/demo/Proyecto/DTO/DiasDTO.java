package giis.demo.Proyecto.DTO;

public class DiasDTO {
	String actividad_id;
	String dia_sem;
	String hora_ini;
	String hora_fin;
	public String getActividad_id() {
		return actividad_id;
	}
	public void setActividad_id(String actividad_id) {
		this.actividad_id = actividad_id;
	}
	public String getDia_sem() {
		return dia_sem;
	}
	public void setDia_sem(String diasem) {
		this.dia_sem = diasem;
	}
	public String getHora_ini() {
		return hora_ini;
	}
	@Override
	public String toString() {
		return "DiasDTO [actividad_id=" + actividad_id + ", diasem=" + dia_sem + ", hora_ini=" + hora_ini + ", hora_fin="
				+ hora_fin + "]";
	}
	public void setHora_ini(String hora_ini) {
		this.hora_ini = hora_ini;
	}
	public String getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

}
