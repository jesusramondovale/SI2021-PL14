package giis.demo.Proyecto.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import giis.demo.Proyecto.DTO.SociosDTO;
import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.DTO.actividadReservaInstalacionDTO;
import giis.demo.Proyecto.DTO.estadoReservaDTO;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;

public class CancelarReservasSociosModel {

	private Database db = new Database();

	private static String SQL3 = "SELECT idSocio , nombre "
			+ "FROM socios "
			+ "WHERE idSocio = ? ";
	
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

	public List<Object[]> getListaInstalaciones(){

		String sql = "SELECT nombre from instalaciones order by idInstalacion";
		return db.executeQueryArray(sql);

	}
	public List<SociosDisplayDTO> getNumeroSocio(String dni) {

		String sql="SELECT * "
				+" from socios"
				+ " where dni=? ";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql,dni);
	}


	public List<SociosDisplayDTO> getDniSociosReserva(String nombreInstalacion, Date fecha, double horaInicio, double horaFin, String estado ){
		String sql = "SELECT dni " + 
				"	FROM reservas r " + 
				"	INNER JOIN socios s USING(idSocio) " + 
				"	INNER JOIN instalaciones i USING(idInstalacion) " + 
				"	WHERE i.nombre=?  AND fecha=? AND horaInicio=? AND horaInicio=? AND horaFin=?";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql,nombreInstalacion,fecha,horaInicio, horaFin, estado);

	}
	
	public void CancelarReserva (int idReserva) {
		//Falta borrar la reserva como tal
		db.executeUpdate("update reserva set estado=0 where id=?", idReserva);
	}

}
