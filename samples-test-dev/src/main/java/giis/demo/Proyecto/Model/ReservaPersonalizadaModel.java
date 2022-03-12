package giis.demo.Proyecto.Model;

import java.util.List;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.ActividadDTO;
import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.DTO.SociosDTO;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;

public class ReservaPersonalizadaModel { 


	public Database db = new Database();

	private static String SQL = "INSERT INTO reservas VALUES (?,?,?,?,?,?,?,?)" ;


	private static String SQL2 = "SELECT fecha , idInstalacion , horaInicio , horaFin "
			+ "FROM reservas "		
			+ "WHERE fecha = ?";


	private static String SQL3 = "SELECT idSocio FROM socios";

	private String SQL4 = "SELECT idInstalacion FROM actividades "
			+ "WHERE idActividad = ?";

	private String SQL5 = "SELECT nombre, tipo, fechaInicio,  fechaFin "
			+ "FROM actividades "
			+ "WHERE fechaInicio = ?"; 
		

	public boolean isSocio(int id){

		List<SociosDTO> currentSocios = db.executeQueryPojo(SociosDTO.class, SQL3);
		boolean notFound = true;
		if(currentSocios.isEmpty()){

			return false;
		}

		else {
			for(int i =0; i<currentSocios.size() && notFound;i++){

				if(currentSocios.get(i).getIdSocio() == id){
					notFound = false;

				}

			}

			return !notFound;

		}

	}


	public void crearReserva(int idReserva, String fecha, double horaInicio, double horaFinal, int instalacion,
			int idActividad, int idSocio, int estado){


		try {
			db.executeUpdate(SQL, idReserva,  fecha,  horaInicio,  horaFinal,  instalacion,
					idActividad,  idSocio, estado);
					
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

		return db.executeQueryPojo(ReservaDTO.class, SQL2, fecha);

	}


	public List<ActividadDTO> getInstalacion(int idActividad) {

		try {
			List<ActividadDTO> actividad = db.executeQueryPojo(ActividadDTO.class, SQL4, idActividad);
					return actividad;	 
		}
		catch (UnexpectedException e) {

			JOptionPane.showMessageDialog(
					null, 
					"Se ha producido un error SQL (getInstalacion) ", 
					"Error",
					JOptionPane.ERROR_MESSAGE ); 	
			return null;
		}
	}

	public List<ActividadDTO> getListaActividades(String fecha){
		
		try {
		
			return db.executeQueryPojo(ActividadDTO.class, SQL5, fecha);
			
		}
		catch(UnexpectedException e) {
			SwingUtil.showMessage("Error SQL (getListaActividades)" , "Error", 0);
			return null;
		}
		
			
		
	}


}









