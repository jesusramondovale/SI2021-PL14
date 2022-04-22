package giis.demo.Proyecto.Model;

import java.util.List;

import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.util.Database;

public class ContabilidadMensualSociosModel {
	private Database db = new Database();
	
	private static String SQL5 = "SELECT a.idActividad , a.precioSocio "
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

		List<ReservaDTO> data = db.executeQueryPojo(ReservaDTO.class, SQL5, idActividad);
		
		int precio = (int) data.get(0).getPrecioHora();
		int horas = (int) (data.get(0).getHoraFin() - data.get(0).getHoraInicio());
		
		return horas*precio;	
	}
	
	public List<Object[]> getSocios(){

		String sql = "SELECT dni from instalaciones order by idSocio";
		return db.executeQueryArray(sql);
	}
	

	public List<Object[]> getPagosRealizados(){
		String sql = "SELECT pago.id, estado, importe, fecha, pago.socio_id, nombre, apellido1, apellido2 FROM pago INNER JOIN socio ON pago.socio_id =socio.id WHERE estado=1";
		return db.executeQueryArray( sql);
		
	}
	
	public List<Object[]> getPagosPendientes(){
		String sql = "SELECT pago.id, importe, fecha, pago.socio_id, nombre, apellido1, apellido2 FROM pago INNER JOIN socio ON pago.socio_id =socio.id WHERE estado=0";
		
		return db.executeQueryArray(sql);
	}
	
}
