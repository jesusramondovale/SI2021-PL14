package giis.demo.Proyecto.Model;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.DTO.actividadReservaInstalacionDTO;
import giis.demo.Proyecto.DTO.estadoReservaDTO;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;
import giis.demo.util.Util;

public class visualizaReservasInstalaciones2Model {

	private Database db = new Database();
	private String sql2 = "SELECT idSocio FROM socios";
	
	public List<SociosDisplayDTO> obtenerSocio() {
		try {
			List<SociosDisplayDTO> socios= db.executeQueryPojo(SociosDisplayDTO.class, sql2);
			return socios;
			
		}catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en Obtener socio.","Error",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}


	public List<Object[]> getListaInstalaciones(){

		String sql = "SELECT nombre from instalaciones order by idInstalacion";
		return db.executeQueryArray(sql);

	}

	public List<actividadReservaInstalacionDTO> getListaInstalacionParaActividades(double hora, String nombreInstalacion, Date fecha){

		String sql = "SELECT a.nombre as Actividad, i.nombre as Instalacion, r.fecha as fechaReserva, r.horaInicio as hora " + 
				"FROM actividades a " + 
				"INNER JOIN instalaciones i USING(idInstalacion) " + 
				"INNER JOIN reservas r USING(idActividad)" + 
				"WHERE r.horaInicio=9 AND r.fecha='2021-05-12'";

		return db.executeQueryPojo(actividadReservaInstalacionDTO.class, sql, hora, nombreInstalacion, fecha);

	}


	public List<SociosDisplayDTO> getNumeroSocio(String dni) {

		String sql="SELECT * "
				+" from socios"
				+ " where dni=? ";

		return db.executeQueryPojo(SociosDisplayDTO.class, sql,dni);
	}


	public List<SociosDisplayDTO> getDniSociosReserva(String nombreInstalacion, double hora, String fecha){
		String sql = "SELECT dni " + 
				"	FROM reservas r " + 
				"	INNER JOIN socios s USING(idSocio) " + 
				"	INNER JOIN instalaciones i USING(idInstalacion) " + 
				"	WHERE i.nombre=? AND horaInicio=? AND fecha=? ";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql,nombreInstalacion,hora,fecha);

	}


	public List<estadoReservaDTO> getEstadoReserva(String nombreInstalacion, String fecha,double hora){
		String sql = "SELECT " + 
				"CASE WHEN (r.fecha=? AND r.horaInicio=? AND r.idActividad is NULL) THEN 'Por un socio' " + 
				"WHEN (r.fecha=? AND r.horaInicio=? AND r.idSocio is NULL) THEN 'Por una actividad' " + 
				"ELSE 'Libre' " + 
				"END EstadoReserva " + 
				"FROM reservas r  " + 
				"INNER JOIN instalaciones i USING(idInstalacion) " + 
				"WHERE i.nombre=? AND r.horaInicio=? AND r.fecha=? ";
		return db.executeQueryPojo(estadoReservaDTO.class, sql, fecha,hora,fecha,hora,nombreInstalacion,hora,fecha);
	}





}
