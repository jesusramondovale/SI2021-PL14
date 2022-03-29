package giis.demo.Proyecto.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.DTO.SociosDTO;
import giis.demo.Proyecto.DTO.SociosDisplayDTO;

import giis.demo.Proyecto.DTO.reservasDisplayDTO;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;
import giis.demo.util.Util;

public class CancelarReservasSociosModel {

	private Database db = new Database();

	private static String SQL3 = "SELECT idSocio , nombre , apellido1 , apellido2 "
			+ "FROM socios "
			+ "WHERE idSocio = ? ";
	private static String SQL4 = "SELECT estado FROM reservas WHERE idReserva = ? ";
	private static String SQL5 = "SELECT fecha , horaInicio FROM reservas WHERE idReserva = ? ";
	private static String SQL6 = "SELECT r.idReserva , r.horaInicio , r.horaFin , i.precioHora "
			+ "FROM instalaciones i "
			+ "INNER JOIN reservas r "
			+ "USING (idInstalacion) "
			+ "WHERE idReserva = ? ";
	
	// Función para comprobar si el ID de socio existe
	// Returns true si existe, false si no
	public boolean isSocio(int idSocio) {

		List<SociosDTO> socios = new ArrayList<SociosDTO>();

		try {
			socios = db.executeQueryPojo(SociosDTO.class, SQL3, idSocio);
		}
		catch(UnexpectedException e) {

			SwingUtil.showMessage("Error SQL -> Model", "Error", 0);

		}
		return (!socios.isEmpty());
	}

	public List<Object[]> getListaInstalaciones(){

		String sql = "SELECT nombre from instalaciones order by idInstalacion";
		return db.executeQueryArray(sql);

	}
	public List<SociosDisplayDTO> getSocio(String id) {

		String sql="SELECT nombre , apellido1 , apellido2 "
				+"FROM socios "
				+ "WHERE idSocio = ? ";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql,id);
	}


	public List<reservasDisplayDTO> getReservas(String dni){
		String sql = "SELECT r.idReserva , i.nombre , r.fecha , r.horaInicio , r.horaFin , r.estado  " + 
				"	FROM reservas r " +  
				"	INNER JOIN instalaciones i USING(idInstalacion) " + 
				"	WHERE idSocio= ? ";
		return db.executeQueryPojo(reservasDisplayDTO.class, sql,dni);

	}
	
	public void CancelarReserva (int idReserva) {
		//Falta borrar la reserva como tal
		db.executeUpdate("UPDATE reservas "
				+ "SET estado = 'Cancelada' "
				+ "WHERE idReserva = ? ", idReserva);
	}
	
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

	/*
	 * Retorna cierto si aún no ha pasado 
	 * la  fecha de la reserva indicada
	 * Retorna falso si la fecha ya ha pasado
	 * 
	 */
	public boolean enFecha(int idReserva) {

		List<reservasDisplayDTO> reserva = db.executeQueryPojo(reservasDisplayDTO.class, SQL5, idReserva);

		Date hoy = new Date();	
		Date fechaReserva = Util.isoStringToDate(reserva.get(0).getFecha());
		Date fechaHoraReserva = new Date(fechaReserva.getTime() + 1000*3600*(int)(reserva.get(0).getHoraInicio()));

		Date fechaHoraTope = new Date(fechaHoraReserva.getTime() - 1000*3600);
		return (fechaHoraTope.after(hoy));

	}

}
