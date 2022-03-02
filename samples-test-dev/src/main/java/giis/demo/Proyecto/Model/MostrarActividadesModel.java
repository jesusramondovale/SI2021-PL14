package giis.demo.Proyecto.Model;


import java.util.List;

import giis.demo.Proyecto.DTO.MostrarActividadesDTO;
import giis.demo.util.Database;

public class MostrarActividadesModel {

	private Database db=new Database();

	private static String SQL = "SELECT  nombre , precioSocio, precioNoSocio, fechaInicio , "
			+ "horaInicio , horaFin , plazas "
			+ "FROM actividades "
			+ "WHERE idPeriodoInscripcion=? " ;
	
	
	public List<MostrarActividadesDTO> getListaActividades(int idPer){
		return db.executeQueryPojo(MostrarActividadesDTO.class,SQL,idPer);
	}
	
	
}
