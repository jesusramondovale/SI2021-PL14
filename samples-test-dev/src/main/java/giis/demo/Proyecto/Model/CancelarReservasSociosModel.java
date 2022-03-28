package giis.demo.Proyecto.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import giis.demo.Proyecto.DTO.SociosDTO;
import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.DTO.actividadReservaInstalacionDTO;
import giis.demo.Proyecto.DTO.estadoReservaDTO;
import giis.demo.Proyecto.DTO.reservasDisplayDTO;
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
	public List<SociosDisplayDTO> getSocio(String dni) {

		String sql="SELECT nombre , apellido1 , apellido2 "
				+" from socios"
				+ " where dni=? ";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql,dni);
	}


	public List<reservasDisplayDTO> getReservas(String dni){
		String sql = "SELECT r.idReserva , i.nombre , r.fecha , r.horaInicio , r.horaFin , r.estado  " + 
				"	FROM reservas r " +  
				"	INNER JOIN instalaciones i USING(idInstalacion) " + 
				"	WHERE idSocio= ? AND fecha= ?";
		return db.executeQueryPojo(reservasDisplayDTO.class, sql,dni);

	}
	
	public void CancelarReserva (int idReserva) {
		//Falta borrar la reserva como tal
		db.executeUpdate("update reserva set estado=2 where id=?", idReserva);
	}

}
