package giis.demo.Proyecto.Model;

import javax.swing.JOptionPane;

import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;

public class RealizarReservasModel { 

	
	public Database db = new Database();
	
	private String SQL = "INSERT INTO reservas VALUES (?,?,?,?,?,?,?,?)" ;
	
	
	public void crearReserva(int idReserva, String fecha, double horaInicio, double horaFinal, int instalacion,
			int deporte, int idSocio, int i){
		
		
		try {
			db.executeUpdate(SQL, idReserva,  fecha,  horaInicio,  horaFinal,  instalacion,
					 deporte,  idSocio,  i);
			JOptionPane.showMessageDialog(
				    null, 
				    "Resrva creada con éxito! ", 
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


	
}
	
	
	

