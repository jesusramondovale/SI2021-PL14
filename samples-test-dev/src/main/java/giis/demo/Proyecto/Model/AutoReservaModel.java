package giis.demo.Proyecto.Model;

import java.util.List;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.ActividadDTO;
import giis.demo.Proyecto.DTO.ActividadHorariosDTO;
import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.DTO.SociosDTO;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;

public class AutoReservaModel { 


	public Database db = new Database();

	private static String SQL1 = "SELECT nombre, tipo, fechaInicio, fechaFin "
			+ "FROM actividades";

	private static String SQL2 = "SELECT idActividad , fechaInicio, fechaFin , idInstalacion , dia , horaInicio , horaFin "
			+ "FROM actividades "
			+ "INNER JOIN horarioActividad USING (idActividad) "
			+ "INNER JOIN horarios USING (idHorarios) "
			+ "WHERE idActividad = ? ";
	
	private static String SQL4 = "SELECT a.idActividad , a.fechaInicio, a.fechaFin , a.idInstalacion , h.dia , h.horaInicio , h.horaFin "
			+ "FROM actividades a "
			+ "INNER JOIN reservas r USING (idActividad) "
			+ "INNER JOIN horarioActividad hA USING (idActividad) "
			+ "INNER JOIN horarios h USING (idHorarios) "
			+ "WHERE r.fecha = ? AND r.idInstalacion = ? AND r.horaInicio = ?" ;
			
			 
			

	private static String SQL = "INSERT INTO reservas VALUES (?,?,?,?,?,?,?,?)" ;

	/*
	private static String SQL2 = "SELECT fecha , idInstalacion , horaInicio , horaFin "
			+ "FROM reservas "		
			+ "WHERE fecha = ?";
	 */

	private static String SQL3 = "SELECT idSocio FROM socios";


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


	public void crearReserva(int idReserva, String fecha, double horaInicio, double horaFinal, int idInstalacion,
			int idActividad){


		try {
			db.executeUpdate(SQL, idReserva,  fecha,  horaInicio,  horaFinal,  idInstalacion, idActividad,  null , 1);
				
		}
		catch(UnexpectedException e){

			JOptionPane.showMessageDialog(
					null, 
					"Se ha producido un error en la inserción SQL! ", 
					"Error",
					JOptionPane.WARNING_MESSAGE ); 		
		}


	}


	public List<ActividadHorariosDTO> getActividad(int idActividad){



		return db.executeQueryPojo(ActividadHorariosDTO.class, SQL2 , idActividad);


		/*
		try {

			return db.executeQueryPojo(ActividadHorariosDTO.class, SQL2 , idActividad);

		}

		catch(UnexpectedException e){

			JOptionPane.showMessageDialog(
				    null, 
				    "Se ha producido un error en la inserción SQL! ", 
				    "Error",
				    JOptionPane.WARNING_MESSAGE ); 
			return null;
		}
		 */


	}


	public List<ActividadDTO> getListaActividades(){

		return db.executeQueryPojo(ActividadDTO.class,SQL1);

	}




	public List<ReservaDTO> getListaReservas(String fecha, int idInstalacion, int horaInicio) {

		
		
		return db.executeQueryPojo(ReservaDTO.class, SQL4, fecha , idInstalacion , horaInicio);

	}





}







