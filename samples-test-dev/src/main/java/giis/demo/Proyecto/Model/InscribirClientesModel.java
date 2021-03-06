package giis.demo.Proyecto.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.ActividadPeriodoDTO;
import giis.demo.Proyecto.DTO.SociosDTO;
import giis.demo.Proyecto.DTO.inscripcionesDisplayDTO;
import giis.demo.Proyecto.DTO.noSociosDisplayDTO;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;
import giis.demo.util.Util;

public class InscribirClientesModel {


	private Database db = new Database();



	/*
	 * Obtiene la lista de Actividades en las que los SOCIOS
	 * todavían pueden inscribirse
	 */
	public List<ActividadPeriodoDTO> getActividadesSocios(){


		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0); 

		Date fechaHoy = today.getTime();



		String SQL = "SELECT a.idActividad , a.nombre , p.inicioInscrSocios , p.finInscrSocios "
				+ "FROM actividades a "
				+ "INNER JOIN periodos p "
				+ "USING (idPeriodoInscripcion) "
				+ "WHERE a.estado == 'Vigente' " ;

		
		
		
		
		try {
			List<ActividadPeriodoDTO> rawList= db.executeQueryPojo(ActividadPeriodoDTO.class, SQL );

			List <ActividadPeriodoDTO> list = new ArrayList();

			for (ActividadPeriodoDTO element : rawList) {

				if (Util.isoStringToDate(element.getInicioInscrSocios()).before(fechaHoy) && 
					(Util.isoStringToDate(element.getFinInscrSocios()).after(fechaHoy))) {

					list.add(element);

				}

			}


			return list;


		}

		catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en Obtener Actividades.","Error",
					JOptionPane.WARNING_MESSAGE);
			return null;
		}
		

	}




	/*
	 * Obtiene la lista de Actividades en las que los NO SOCIOS
	 * todavían pueden inscribirse
	 */
	public List<ActividadPeriodoDTO> getActividadesNoSocios(){


		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0); 

		Date fechaHoy = today.getTime();



		String SQL = "SELECT a.idActividad , a.nombre , p.inicioInscrSocios , p.finInscrNoSocios "
				+ "FROM actividades a "
				+ "INNER JOIN periodos p "
				+ "USING (idPeriodoInscripcion) "
				+ "WHERE a.estado == 'Vigente' ";


		try {
			List<ActividadPeriodoDTO> rawList= db.executeQueryPojo(ActividadPeriodoDTO.class, SQL);

			List <ActividadPeriodoDTO> list = new ArrayList();

			for (ActividadPeriodoDTO element : rawList) {

				if (
						Util.isoStringToDate(element.getInicioInscrSocios()).before(fechaHoy) 
						   && 
						Util.isoStringToDate(element.getFinInscrNoSocios()).after(fechaHoy)) {

					list.add(element);

				}

			}

			return list;

		}

		catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en Obtener Actividades (No socios).","Error",
					JOptionPane.WARNING_MESSAGE);
			return null;
		}

	}



	/*
	 * Inscribe un SOCIO en la Actividad indicada
	 *   **NO REALIZA NINGUNA RESERVA DE PISTA,
	 *  ÚNICAMENTE ACTUALIZA LA TABLA INSCRIPCIONES
	 */
	public void InscribeSocio(int idActividad , int idSocio) {


		String SQL = "INSERT INTO inscripciones "
				+ "VALUES ( ? , ? , NULL)"  ;

		
		
		try {
			db.executeUpdate(SQL, idActividad , idSocio);

		}

		catch(UnexpectedException e) {
			SwingUtil.showMessage("Se ha producido algún error inscribiendo al socio en la actividad" , "Vaya!", 0);


		}
		


	}


	/*
	 * Inscribe un no SOCIO en la Actividad indicada
	 *   **NO REALIZA NINGUNA RESERVA DE PISTA,
	 *  ÚNICAMENTE ACTUALIZA LA TABLA INSCRIPCIONES
	 */
	public void InscribeNoSocios(int idActividad , int idNoSocio) {


		String SQL = "INSERT INTO inscripciones "
				+ "VALUES ( ? , NULL , ? )"  ;

		try {
			db.executeUpdate(SQL, idActividad , idNoSocio);

		}

		catch(UnexpectedException e) {
			SwingUtil.showMessage("Se ha producido algún error inscribiendo al no-socio en la actividad" , "Vaya!", 0);


		}


	}

	

	/*
	 * Devuelve TRUE si el Socio existe, 
	 * FALSE en caso contrario 
	 */
	public boolean isSocio(int id){


		String SQL = "SELECT idSocio , nombre "
				+ "FROM socios "
				+ "WHERE idSocio = ? ";
		try {
			List<SociosDTO> list= db.executeQueryPojo(SociosDTO.class, SQL , id);
			return !(list.isEmpty());


		}

		catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en is Socio.","Error",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}


	}


	
	/*
	 * Devuelve TRUE si el No Socio existe, 
	 * FALSE en caso contrario 
	 */
	public boolean isNoSocio(int id){


		String SQL = "SELECT idNoSocio , nombre "
				+ "FROM noSocios "
				+ "WHERE idNoSocio = ? ";
		try {
			List<noSociosDisplayDTO> list= db.executeQueryPojo(noSociosDisplayDTO.class, SQL , id);
			return !(list.isEmpty());


		}

		catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en is No Socio.","Error",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}


	}


	public boolean yaInscrito(int idCliente , int idActividad) {
		
		
		
		if(isSocio(idCliente)) {
			
			String SQL = "SELECT idActividad , idSocio "
				+ "FROM inscripciones "
				+ "WHERE idSocio = ? "
				+ "AND idActividad = ? ";
			
			
			try {
				List<inscripcionesDisplayDTO> list= db.executeQueryPojo(inscripcionesDisplayDTO.class, SQL , idCliente , idActividad);
				return !(list.isEmpty());


			}

			catch(UnexpectedException e) {
				JOptionPane.showMessageDialog(null, "Se ha producido algún error","Error",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}
			
		}
		
		
		
		
		else {
	
			
			String SQL = "SELECT idActividad , idNoSocio "
					+ "FROM inscripciones "
					+ "WHERE idNoSocio = ? "
					+ "AND idActividad = ? ";
				
				
				try {
					List<inscripcionesDisplayDTO> list= db.executeQueryPojo(inscripcionesDisplayDTO.class, SQL , idCliente , idActividad);
					return !(list.isEmpty());


				}

				catch(UnexpectedException e) {
					JOptionPane.showMessageDialog(null, "Se ha producido algún error","Error",
							JOptionPane.WARNING_MESSAGE);
					return false;
				}
			
			
		}
			
		
	}
	
}