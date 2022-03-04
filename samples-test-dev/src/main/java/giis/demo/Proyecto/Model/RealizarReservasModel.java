package giis.demo.Proyecto.Model;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;

public class RealizarReservasModel { 

	
	public Database db = new Database();
	
	private static String SQL = "INSERT INTO reservas VALUES (?,?,?,?,?,?,?,?)" ;
	private static String SQL2 = "SELECT idReserva, fecha , horaInicio , horaFin , idInstalacion , idActividad , idSocio , estado "
			+ "FROM reservas";
			
			//+ "WHERE fecha > ?";
	
	public void crearReserva(int idReserva, Date fecha, double horaInicio, double horaFinal, int instalacion,
			int deporte, int idSocio, int i){
		
		
		try {
			db.executeUpdate(SQL, idReserva,  fecha,  horaInicio,  horaFinal,  instalacion,
					 deporte,  idSocio,  i);
			JOptionPane.showMessageDialog(
				    null, 
				    "Reserva creada con éxito! ", 
				    "Éxito",
				    JOptionPane.INFORMATION_MESSAGE ); 		
		}
		catch(UnexpectedException e){
			
			JOptionPane.showMessageDialog(
				    null, 
				    "Se ha producido un error en la inserción SQL! ", 
				    "Error",
				    JOptionPane.WARNING_MESSAGE ); 		
		}
		 
			
	}
	
	
	
	public List<ReservaDTO> getListaReservas(String fecha) {

			return db.executeQueryPojo(ReservaDTO.class, SQL2);
		
	}





}
		
		

	

	
	
	

