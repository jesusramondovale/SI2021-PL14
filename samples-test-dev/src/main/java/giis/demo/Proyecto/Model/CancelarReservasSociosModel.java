package giis.demo.Proyecto.Model;

import java.util.Date;
import java.util.List;

import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.DTO.actividadReservaInstalacionDTO;
import giis.demo.Proyecto.DTO.estadoReservaDTO;
import giis.demo.util.Database;

public class CancelarReservasSociosModel {

	private Database db = new Database();


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
	
	

}
