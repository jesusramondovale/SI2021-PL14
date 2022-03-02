package giis.demo.Proyecto.model;

import java.util.Date;
import java.util.List;

import giis.demo.util.Database;
import giis.demo.util.Util;
import giis.demo.Proyecto.DTO.*;

public class visualizarReservasInstalacionesModel {
	
	private Database db = new Database();


	public List<Object[]> getListaInstalaciones(){

		String sql = "SELECT nombre from instalaciones order by idInstalacion";
		return db.executeQueryArray(sql);

	}

	public List<ActividadReservaInstalacionDTO> getListaInstalacionParaActividades(double hora, String nombreInstalacion, Date fecha){

		String sql = "SELECT a.nombre as Actividad, i.nombre as Instalacion, r.fecha as fechaReserva, r.horaInicio as hora " + 
				"FROM actividades a " + 
				"INNER JOIN instalaciones i USING(idInstalacion) " + 
				"INNER JOIN reservas r USING(idActividad)" + 
				"WHERE r.horaInicio=9 AND r.fecha='2021-05-12'";

		return db.executeQueryPojo(ActividadReservaInstalacionDTO.class, sql, hora, nombreInstalacion, fecha);

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


	public List<EstadoReservaDTO> getEstadoReserva(String nombreInstalacion, String fecha,double hora){
		String sql = "SELECT " + 
				"CASE WHEN (r.fecha=? AND r.horaInicio=? AND r.idActividad is NULL) THEN 'Por un socio' " + 
				"WHEN (r.fecha=? AND r.horaInicio=? AND r.idSocio is NULL) THEN a.nombre " + 
				"ELSE 'Libre' " + 
				"END EstadoReserva " + 
				"FROM reservas r  " + 
				"INNER JOIN instalaciones i USING(idInstalacion) " +
				"INNER JOIN actividades a USING (idActividad) " +
				"WHERE i.nombre=? AND r.horaInicio=? AND r.fecha=? ";
		return db.executeQueryPojo(EstadoReservaDTO.class, sql, fecha,hora,fecha,hora,nombreInstalacion,hora,fecha);
	}

	

}