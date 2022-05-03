package giis.demo.Proyecto.Model;

import java.util.Date;
import java.util.List;

import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.DTO.pagosDisplayDTO;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class ContabilidadMensualSociosModel {
	private Database db = new Database();
	

	private static String SQL5 = "SELECT a.idSocio , a.idActividad, a.idReserva, a.importe,a.estado "
			+ "FROM pagos a "
			+ "ORDER BY a.idSocio";
	
	private static String SQL9 = "SELECT a.idActividad , a.precioSocio "
			+ "FROM actividades a ";
	private static String SQL6 = "SELECT r.idReserva , r.horaInicio , r.horaFin , i.precioHora "
			+ "FROM instalaciones i "
			+ "INNER JOIN reservas r "
			+ "USING (idInstalacion) "
			+ "WHERE idReserva = ? ";
	
	/*
	 * Retorna el importe (coste instalacion/h x Nºhoras) 
	 * de la reserva indicada como argumento
	 * 
	 */
	public int getImporteReserva(int idReserva) {

		List<ReservaDTO> data = db.executeQueryPojo(ReservaDTO.class, SQL6, idReserva);
		
		int precio = (int) data.get(0).getPrecioHora();
		int horas = (int) (data.get(0).getHoraFin() - data.get(0).getHoraInicio());
		
		return horas*precio;	
	}
	/*
	 * Retorna el precio de la Actividad
	 * 
	 */
	public int getImporteActividad(int idActividad) {

		List<ReservaDTO> data = db.executeQueryPojo(ReservaDTO.class, SQL9, idActividad);
		
		int precio = (int) data.get(0).getPrecioHora();
		int horas = (int) (data.get(0).getHoraFin() - data.get(0).getHoraInicio());
		
		return horas*precio;	
	}
	
	public List<Object[]> getSocios(){

		String sql = "SELECT dni from instalaciones order by idSocio";
		return db.executeQueryArray(sql);
	}
	
	
	public List<pagosDisplayDTO> getPagosRealizados(Date fecha_inicial, Date fecha_hoy){
		String sql = "SELECT p.idSocio, COUNT(p.idActividad) as idActividad, count (p.idReserva) as idReserva, sum(p.importe) as importe "
				+ "	FROM pagos p"
				+ "	INNER JOIN socios USING (idSocio)"
				+ " WHERE fecha > ? AND  fecha < ?"
				+ "	GROUP BY (idSocio)"	;
		
		return db.executeQueryPojo(pagosDisplayDTO.class, sql, Util.dateToIsoString(fecha_inicial), Util.dateToIsoString(fecha_hoy));
		
	}
	
	public List<pagosDisplayDTO> getPagosPendientes(){
		
		return db.executeQueryPojo(pagosDisplayDTO.class,SQL5);
	}
	
}