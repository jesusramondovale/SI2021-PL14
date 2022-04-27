package giis.demo.Proyecto.Model;

import java.util.List;

import giis.demo.Proyecto.DTO.MostrarActividadesDTO;
import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.DTO.reservasDisplayDTO;
import giis.demo.util.Database;

public class CancelarActividadesModel {

	private Database db=new Database();

	private static String SQL = "SELECT  idActividad , nombre, tipo, precioSocio,"
			+ " precioNoSocio, fechaInicio , fechaFin, plazas, estado "
			+ "FROM actividades";
	
	private static String SQL4 = "SELECT estado FROM reservas WHERE idReserva = ? ";
	private static String SQL6 = "SELECT r.idReserva , r.horaInicio , r.horaFin , i.precioHora "
			+ "FROM instalaciones i "
			+ "INNER JOIN reservas r "
			+ "USING (idInstalacion) "
			+ "WHERE idReserva = ? ";
	
	
	public List<MostrarActividadesDTO> getListaActividades(){
		return db.executeQueryPojo(MostrarActividadesDTO.class,SQL);
	}

	public List<reservasDisplayDTO> getReservas(int idActividad){
		String sql = "SELECT r.idActividad  " + 
				"	FROM reservas r " +  
				"	WHERE idReserva= ? ";
		return db.executeQueryPojo(reservasDisplayDTO.class, sql,idActividad);

	}
	public List<SociosDisplayDTO> getSocios(int idActividad){
		 String SQL = "SELECT s.nombre, s.apellido1, s.apellido2, s.telefono, i.idActividad "
				+ "FROM socios s "
				+ "INNER JOIN inscripciones i "
				+ "USING (idSocio) "
				+ "WHERE idActividad = ? ";
		return db.executeQueryPojo(SociosDisplayDTO.class, SQL,idActividad);

	}
	
	public void CancelarActividad (int idActividad) {
		//Falta borrar la reserva como tal
		db.executeUpdate("UPDATE actividades "
				+ "SET estado = 'Cancelada' "
				+ "WHERE idActividad = ? ", idActividad);
	}
	
	//Libera las reservas, por tanto borramos la fila de la bd
	public void LiberaResevas (int idActividad) {
		db.executeUpdate("DELETE FROM reservas "
				+ "WHERE idActividad = ? ", idActividad);
	}
	
	//Avisar a los socios y devolucion importe
	
	public boolean yaPagada(int idActividad) {

		List<reservasDisplayDTO> estado = db.executeQueryPojo(reservasDisplayDTO.class, SQL4, idActividad);
		return (estado.get(0).getEstado().equalsIgnoreCase("PAGADA"));

	}
	/*
	public int getImporte(int idActividad) {

		List<ReservaDTO> data = db.executeQueryPojo(ReservaDTO.class, SQL6, idActividad);
		
		int precio = data.get(0).getPrecioHora();
		int horas = (int) (data.get(0).getHoraFin() - data.get(0).getHoraInicio());
		
		return horas*precio;	
	}
	*/
	
}
