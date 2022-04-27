package giis.demo.Proyecto.Model;

import java.util.List;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.DTO.actividadReservaInstalacionDTO;
import giis.demo.Proyecto.DTO.estadoReservaDTO;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;

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
	
	public List<SociosDisplayDTO> getInfoSocio(int numSocio){
		String sql="SELECT nombre,apellido1, apellido2 from socios where idSocio=?";
		return db.executeQueryPojo(SociosDisplayDTO.class,sql,numSocio);
	}

	public List<Object[]> getListaInstalaciones(){

		String sql = "SELECT nombre from instalaciones order by idInstalacion";
		return db.executeQueryArray(sql);

	}

	public List<actividadReservaInstalacionDTO> getListaInstalacionParaActividades(double hora, String nombreInstalacion, String fecha){

		String sql = "SELECT a.nombre as Actividad, i.nombre as Instalacion, r.fecha as fechaReserva, r.horaInicio as hora " + 
				"FROM actividades a " + 
				"INNER JOIN instalaciones i USING(idInstalacion) " + 
				"INNER JOIN reservas r USING(idActividad)" + 
				"WHERE r.horaInicio=6 AND r.fecha='2022-03-03'";

		return db.executeQueryPojo(actividadReservaInstalacionDTO.class, sql, hora, nombreInstalacion, fecha);

	}


	public List<SociosDisplayDTO> getNumeroSocio(String dni) {

		String sql="SELECT * "
				+" from socios"
				+ " where dni=? ";

		return db.executeQueryPojo(SociosDisplayDTO.class, sql,dni);
	}


	public List<SociosDisplayDTO> getDniSociosReserva(String nombreInstalacion, double hora, String fecha){
		String sql = "SELECT idSocio " + 
				"	FROM reservas r " + 
				"	INNER JOIN socios s USING(idSocio) " + 
				"	INNER JOIN instalaciones i USING(idInstalacion) " + 
				"	WHERE i.nombre=? AND horaInicio=? AND fecha=? ";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql,nombreInstalacion,hora,fecha);

	}


	public List<estadoReservaDTO> getEstadoReserva(String nombreInstalacion, String fecha,double hora){
		String sql = "SELECT " + 
				"CASE WHEN (r.fecha=? AND r.horaInicio=? AND r.idActividad is NULL) THEN TRUE " + 
				"WHEN (r.fecha=? AND r.horaInicio=? AND r.idSocio is NULL) THEN a.nombre " + 
				"ELSE FALSE " + 
				"END EstadoReserva " + 
				"FROM reservas r  " + 
				"INNER JOIN instalaciones i USING(idInstalacion) " +
				"INNER JOIN actividades a USING (idActividad) " +
				"WHERE i.nombre=? AND r.horaInicio=? AND r.fecha=? ";
		return db.executeQueryPojo(estadoReservaDTO.class, sql, fecha,hora,fecha,hora,nombreInstalacion,hora,fecha);
	}

	

}