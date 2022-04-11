package giis.demo.Proyecto.Model;

import java.util.List;

import giis.demo.Proyecto.DTO.MostrarActividadesDTO;
import giis.demo.util.Database;

public class CancelarActividadesModel {

	private Database db=new Database();

	private static String SQL = "SELECT  a.idActividad , a.nombre, a.tipo, a.precioSocio,"
			+ " a.precioNoSocio, a.fechaInicio , a.fechaFin, a.plazas "
			+ "FROM actividades a "
			+ "WHERE a.estado=Vigente";
	
	
	public List<MostrarActividadesDTO> getListaActividades(String nombrePeriodo){
		return db.executeQueryPojo(MostrarActividadesDTO.class,SQL,nombrePeriodo);
	}
	
}
