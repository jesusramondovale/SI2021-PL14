package giis.demo.Proyecto.Model;

import giis.demo.util.Database;
import java.util.*;
import javax.swing.JOptionPane;

import giis.demo.util.Util;
import giis.demo.Proyecto.DTO.*;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;

public class VisualizarReservasSociosModel {

	public Database db=new Database();

	public List<Object[]> getListaInstalaciones(){

		String sql = "SELECT nombre from instalaciones order by idInstalacion";
		return db.executeQueryArray(sql);

	}
	public List<SociosDisplayDTO> getNombreSocio (String dni) {

		String sql="SELECT nombre "
				+" from socios"
				+ " where dni=? ";

		return db.executeQueryPojo(SociosDisplayDTO.class, sql,dni);
	}
	
	public List<SociosDisplayDTO> getApellido1Socio (String dni) {

		String sql="SELECT apellido1 "
				+" from socios"
				+ " where dni=? ";

		return db.executeQueryPojo(SociosDisplayDTO.class, sql,dni);
	}
	
	public List<SociosDisplayDTO> getApellido2Socio (String dni) {

		String sql="SELECT apellido2 "
				+" from socios"
				+ " where dni=? ";

		return db.executeQueryPojo(SociosDisplayDTO.class, sql,dni);
	}
	
	public List<SociosDisplayDTO> getFecha (Date fecha) {

		String sql="SELECT fecha "
				+" from reservas"
				+ " where fecha=? ";

		return db.executeQueryPojo(SociosDisplayDTO.class, sql,fecha);
	}
	
	public List<actividadReservaInstalacionDTO> getListaInstalacionParaReservar(double hora, String nombreInstalacion, String fecha){

		String sql = "SELECT a.nombre as Actividad, i.nombre as Instalacion, r.fecha as fechaReserva, r.horaInicio as hora " + 
				"FROM actividades a " + 
				"INNER JOIN instalaciones i USING(idInstalacion) " + 
				"INNER JOIN reservas r USING(idActividad)" + 
				"WHERE r.horaInicio=6 AND r.fecha='2022-03-03'";

		return db.executeQueryPojo(actividadReservaInstalacionDTO.class, sql, hora, nombreInstalacion, fecha);

	}

}
