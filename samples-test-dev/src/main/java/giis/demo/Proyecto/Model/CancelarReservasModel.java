package giis.demo.Proyecto.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.DTO.SociosDTO;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;
import giis.demo.util.Util;

public class CancelarReservasModel {

	private Database db=new Database();

	private static String SQL1 = "SELECT r.idReserva , s.nombre , s.apellido1 , r.idInstalacion , r.fecha , r.horaInicio , r.estado "
			+ "FROM socios s "
			+ "INNER JOIN reservas r "
			+ "USING (idSocio) "
			+ "WHERE idSocio = ?";

	private static String SQL2 = "SELECT idSocio , nombre "
			+ "FROM socios "
			+ "WHERE idSocio = ? ";

	private static String SQL3 = "UPDATE reservas SET estado = 'Cancelada' WHERE idReserva = ?";
	private static String SQL4 = "SELECT estado FROM reservas WHERE idReserva = ? ";
	private static String SQL5 = "SELECT fecha , horaInicio FROM reservas WHERE idReserva = ? ";
	
	private static String SQL6 = "SELECT r.idReserva , r.horaInicio , r.horaFin , i.precioHora "
						+ "FROM instalaciones i "
						+ "INNER JOIN reservas r "
						+ "USING (idInstalacion) "
						+ "WHERE idReserva = ? ";

	
	
	
	
	public int getImporte(int idReserva) {

		List<ReservaDTO> data = db.executeQueryPojo(ReservaDTO.class, SQL6, idReserva);
		
		int precio = data.get(0).getPrecioHora();
		int horas = (int) (data.get(0).getHoraFin() - data.get(0).getHoraInicio());
		
		return horas*precio;	
	}



	public List<ReservaDTO> getReservas(int idSocio) {


		try {

			return db.executeQueryPojo(ReservaDTO.class, SQL1, idSocio);

		}

		catch(UnexpectedException e) {

			SwingUtil.showMessage("Error SQL" + e.toString(), "Error", 0);
			return new ArrayList<ReservaDTO>();
		}


	}


	public boolean yaPagada(int idReserva) {


		List<ReservaDTO> estado = db.executeQueryPojo(ReservaDTO.class, SQL4, idReserva);
		return (estado.get(0).getEstado().equalsIgnoreCase("pagada"));

	}

	public boolean enFecha(int idReserva) {

		List<ReservaDTO> reserva = db.executeQueryPojo(ReservaDTO.class, SQL5, idReserva);

		Date hoy = new Date();	
		Date fechaReserva = Util.isoStringToDate(reserva.get(0).getFecha());
		Date fechaHoraReserva = new Date(fechaReserva.getTime() + 1000*3600*(int)(reserva.get(0).getHoraInicio()));

		return (fechaHoraReserva.after(hoy));

	}



	public void cancelarReserva(int idReserva) {

		// Marcamos la reserva como cancelada en BD
		db.executeUpdate(SQL3, idReserva);


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
