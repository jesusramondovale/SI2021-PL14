package giis.demo.Proyecto.Model;

import java.util.ArrayList;
import java.util.List;


import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.DTO.SociosDTO;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;

public class CancelarReservasModel {

	private Database db=new Database();
	
	private static String SQL1 = "SELECT s.idSocio , s.nombre , s.apellido1 , s.apellido2 , r.idInstalacion , r.fecha , r.horaInicio "
			+ "FROM socios s "
			+ "INNER JOIN reservas r "
			+ "USING (idSocio) "
			+ "WHERE idSocio = ?";
	
	private static String SQL2 = "SELECT idSocio , nombre "
			+ "FROM socios "
			+ "WHERE idSocio = ? ";
	
	public List<ReservaDTO> getReservas(int idSocio) {
		
		
		try {
			
			return db.executeQueryPojo(ReservaDTO.class, SQL1, idSocio);
			
		}
		
		catch(UnexpectedException e) {
			
			SwingUtil.showMessage("Error SQL" + e.toString(), "Error", 0);
			return new ArrayList<ReservaDTO>();
		}
		
		
	}
	
	
	public boolean isSocio(int idSocio) {
		
		List<SociosDTO> socios = new ArrayList<SociosDTO>();
		
		try {
			 socios = db.executeQueryPojo(SociosDTO.class, SQL2, idSocio);
		}
		catch(UnexpectedException e) {
			
			SwingUtil.showMessage("Error SQL", "Error", 0);

		}
				
		return (!socios.isEmpty());
		
		
	}
}
