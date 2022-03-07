package giis.demo.Proyecto.Model;


import java.util.List;

import giis.demo.Proyecto.DTO.MostrarActividadesDTO;
import giis.demo.util.Database;

public class MostrarActividadesModel {

	private Database db=new Database();

	private static String SQL = "SELECT  a.nombre , a.precioSocio, a.precioNoSocio, a.fechaInicio , "
			+ "a.horaInicio , a.horaFin , a.plazas "
			+ "FROM actividades a "
			+ "INNER JOIN periodos p "
			+ "USING (idPeriodoInscripcion)"
			+ "WHERE p.nombre=? " ;
	
	
	public List<MostrarActividadesDTO> getListaActividades(String nombrePeriodo){
		return db.executeQueryPojo(MostrarActividadesDTO.class,SQL,nombrePeriodo);
	}
	
	
}
