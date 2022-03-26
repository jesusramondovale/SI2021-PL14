package giis.demo.Proyecto.Model;

import java.util.ArrayList;
import java.util.List;

import giis.demo.Proyecto.DTO.ActividadDTO;
import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.DTO.SociosDTO;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;

public class EstadoCuentasModel {

	public Database db = new Database();



	private String SQL1 = "SELECT a.nombre , a.fechaInicio , a.precioSocio , a.estado "
			+ "FROM reservas r "
			+ "INNER JOIN actividades a "
			+ "USING (idActividad) "
			+ "WHERE r.idSocio = ? AND r.idActividad IS NOT NULL " ;


	private String SQL2 = "SELECT i.idInstalacion , r.fecha ,  r.horaFin , r.horaInicio , i.precioHora , r.estado "
			+ "FROM reservas r "
			+ "INNER JOIN instalaciones i "
			+ "USING (idInstalacion) "
			+ "WHERE r.idSocio = ? AND r.idActividad IS NULL " ;

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




	public List<ActividadDTO> getActividades(int idSocio){

		try {
			return db.executeQueryPojo(ActividadDTO.class, SQL1, idSocio);

		}
		catch(UnexpectedException e) {

			System.err.println("Excepcion SQL: (EstadoCuentasModel : getActividades)");
			return null;
		}

	}




	public List<ReservaDTO> getInstalaciones(int idSocio){



		try {
			List<ReservaDTO> list = new ArrayList<ReservaDTO>(); 
			List<ReservaDTO> rawList = db.executeQueryPojo(ReservaDTO.class, SQL2, idSocio);

			for(int i = 0 ; i < rawList.size() ; i++) {
				ReservaDTO DTO = new ReservaDTO();

				DTO.setIdInstalacion(rawList.get(i).getIdInstalacion());
				DTO.setFecha(rawList.get(i).getFecha());
				DTO.setPrecioSocio( (int) (( rawList.get(i).getHoraFin() - rawList.get(i).getHoraInicio() ) *  rawList.get(i).getPrecioSocio())   ); 
				DTO.setEstado(rawList.get(i).getEstado());

				list.add(DTO);
			}

			return list;

		}
		catch(UnexpectedException e) {

			System.err.println("Excepcion SQL (EstadoCuentasModel : getInstalaciones)");
			return null;
		}




	}



}
