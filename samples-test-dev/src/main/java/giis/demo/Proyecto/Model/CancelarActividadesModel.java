package giis.demo.Proyecto.Model;

import java.util.List;

import giis.demo.Proyecto.DTO.MostrarActividadesDTO;
import giis.demo.util.Database;

public class CancelarActividadesModel {

	private Database db=new Database();

	private static String SQL = "SELECT  idActividad , nombre, tipo, precioSocio,"
			+ " precioNoSocio, fechaInicio , fechaFin, plazas "
			+ "FROM actividades";
	
	
	public List<MostrarActividadesDTO> getListaActividades(){
		return db.executeQueryPojo(MostrarActividadesDTO.class,SQL);
	}
	
}
