package giis.demo.Proyecto.Model;

import java.util.List;

import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;

public class EstadoCuentasModel {

	public Database db = new Database();



	private String SQL1 = "SELECT a.nombre , a.fechaInicio , a.precioSocio , a.estado "
			+ "FROM reservas r "
			+ "INNER JOIN actividades a "
			+ "USING (idActividad) "
			+ "WHERE r.idSocio = ? AND r.idActividad = ? " ;


	private String SQL2 = "SELECT i.idInstalacion , r.fecha , (r.horaFin - r.horaInicio) * i.precio , r.estado "
			+ "FROM reservas r "
			+ "INNER JOIN instalaciones i "
			+ "USING (idInstalacion) "
			+ "WHERE r.idSocio = ? AND r.idActividad = 'NULL' " ;



	public List<ReservaDTO> getActividades(int idSocio , int idActividad){

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL1, idSocio , idActividad);

		}
		catch(UnexpectedException e) {

			System.err.println("Excepcion SQL: (EstadoCuentasModel : getActividades)");
			return null;
		}

	}




	public List<ReservaDTO> getReservas(int idSocio){

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL2, idSocio);

		}
		catch(UnexpectedException e) {

			System.err.println("Excepcion SQL (EstadoCuentasModel : getReservas)");
			return null;
		}

	}



}
