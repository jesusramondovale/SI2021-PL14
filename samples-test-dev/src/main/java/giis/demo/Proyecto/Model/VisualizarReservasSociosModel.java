package giis.demo.Proyecto.Model;

import giis.demo.util.Database;
import java.util.*;

import giis.demo.Proyecto.DTO.*;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;

public class VisualizarReservasSociosModel {

	public Database db=new Database();
	private static String SQL3 = "SELECT idSocio , nombre "
			+ "FROM socios "
			+ "WHERE idSocio = ? ";

	public List<Object[]> getListaInstalaciones(){

		String sql = "SELECT nombre from instalaciones order by idInstalacion";
		return db.executeQueryArray(sql);

	}
	public List<SociosDisplayDTO> getSocio(String id) {

		String sql="SELECT nombre , apellido1 , apellido2 "
				+"FROM socios "
				+ "WHERE idSocio = ? ";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql,id);
	}

	public List<reservasDisplayDTO> getReservas(String dni, String InicioFecha, String FinFecha){
		String sql = "SELECT r.idReserva , i.nombre , r.fecha , r.horaInicio , r.horaFin , r.estado  " + 
				"	FROM reservas r " +  
				"	INNER JOIN instalaciones i USING(idInstalacion) " + 
				"	WHERE idSocio= ? AND fecha>= ? AND fecha <= ?  ";
		return db.executeQueryPojo(reservasDisplayDTO.class, sql,dni,InicioFecha,FinFecha);

	}

	// Función para comprobar si el ID de socio existe
	// Returns true si existe, false si no
	public boolean isSocio(int idSocio) {

		List<SociosDTO> socios = new ArrayList<SociosDTO>();

		try {
			socios = db.executeQueryPojo(SociosDTO.class, SQL3, idSocio);
		}
		catch(UnexpectedException e) {

			SwingUtil.showMessage("Error SQL -> EstadoCuentasModel", "Error", 0);

		}

		return (!socios.isEmpty());

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