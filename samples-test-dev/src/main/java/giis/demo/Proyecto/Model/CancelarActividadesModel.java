package giis.demo.Proyecto.Model;

import java.util.List;

import giis.demo.Proyecto.DTO.MostrarActividadesDTO;
import giis.demo.Proyecto.DTO.reservasDisplayDTO;
import giis.demo.util.Database;

public class CancelarActividadesModel {

	private Database db=new Database();

	private static String SQL = "SELECT  idActividad , nombre, tipo, precioSocio,"
			+ " precioNoSocio, fechaInicio , fechaFin, plazas, estado "
			+ "FROM actividades";
	
	
	public List<MostrarActividadesDTO> getListaActividades(){
		return db.executeQueryPojo(MostrarActividadesDTO.class,SQL);
	}

	public List<reservasDisplayDTO> getReservas(String dni){
		String sql = "SELECT r.idReserva , i.nombre , r.fecha , r.horaInicio , r.horaFin , r.estado  " + 
				"	FROM reservas r " +  
				"	INNER JOIN instalaciones i USING(idInstalacion) " + 
				"	WHERE idSocio= ? ";
		return db.executeQueryPojo(reservasDisplayDTO.class, sql,dni);

	}
	
	public void CancelarActividad (int idActividad) {
		//Falta borrar la reserva como tal
		db.executeUpdate("UPDATE actividades "
				+ "SET estado = 'Cancelada' "
				+ "WHERE idActividad = ? ", idActividad);
	}
	/*
	public boolean yaPagada(int idReserva) {

		List<reservasDisplayDTO> estado = db.executeQueryPojo(reservasDisplayDTO.class, SQL4, idReserva);
		return (estado.get(0).getEstado().equalsIgnoreCase("PAGADA"));

	}
	
	public int getImporte(int idReserva) {

		List<ReservaDTO> data = db.executeQueryPojo(ReservaDTO.class, SQL6, idReserva);
		
		int precio = data.get(0).getPrecioHora();
		int horas = (int) (data.get(0).getHoraFin() - data.get(0).getHoraInicio());
		
		return horas*precio;	
	}
*/
	
}
