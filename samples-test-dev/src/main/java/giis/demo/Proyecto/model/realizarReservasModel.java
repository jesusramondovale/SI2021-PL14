package giis.demo.Proyecto.model;

import java.util.*;

import javax.swing.JOptionPane;

import giis.demo.util.Util;
import giis.demo.Proyecto.DTO.*;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;
public class realizarReservasModel {

public Database db=new Database();

private String sql = "INSERT INTO reservas VALUES (?,?,?,?,?,?,?,?)";
private String sql2 = "SELECT idSocio FROM socios";
private String sql3 = "SELECT precioHora FROM instalaciones";
private String sql4 = "SELECT idReserva from reservas";
private String sql5 = "SELECT fecha,horaInicio,horaFin,idInstalacion from reservas"; 
private String sql6 = "SELECT nombre from actividades";

	public void insertaReserva(int idReserva,int idsocio, String fecha,float horaInicio,
			float horaFin, int idInstalacion, int idActividad, int estado) {
		try {
		db.executeUpdate(sql,idReserva,idsocio, fecha,horaInicio,
				horaFin, idInstalacion, idActividad, estado);
		JOptionPane.showMessageDialog(null, "SQL correcto","Correcto",
			    JOptionPane.INFORMATION_MESSAGE);
		}catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error de la reserva.","Error",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public List<actividadesDisplayDTO> obtenerActividad(){
		try {
			List<actividadesDisplayDTO> actividad= db.executeQueryPojo(actividadesDisplayDTO.class, sql6);
			return actividad;
			
		}catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en Obtener la fecha de la reserva reserva.","Error",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	public List<reservasDisplayDTO> obtenerHorarioReserva(){
		try {
			List<reservasDisplayDTO> reserva= db.executeQueryPojo(reservasDisplayDTO.class, sql5);
			return reserva;
			
		}catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en Obtener la fecha de la reserva reserva.","Error",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	public List<reservasDisplayDTO> obtenerReserva(){
		try {
			List<reservasDisplayDTO> reserva= db.executeQueryPojo(reservasDisplayDTO.class, sql4);
			/*
			 * JOptionPane.showMessageDialog(null, "SQL correcto","Correcto",
			 * JOptionPane.INFORMATION_MESSAGE);
			 */
			return reserva;
			
		}catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en Obtener ID reserva.","Error",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	public List<SociosDisplayDTO> obtenerSocio() {
		try {
			List<SociosDisplayDTO> socios= db.executeQueryPojo(SociosDisplayDTO.class, sql2);
			JOptionPane.showMessageDialog(null, "SQL correcto","Correcto",
				    JOptionPane.INFORMATION_MESSAGE);
			return socios;
			
		}catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en Obtener socio.","Error",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	public List<InstalacionesDisplayDTO> obtenerInstalaciones() {
		try {
			List<InstalacionesDisplayDTO> precioInstalaciones=  db.executeQueryPojo(InstalacionesDisplayDTO.class, sql3);
			
			/*
			JOptionPane.showMessageDialog(null, "SQL correcto","Correcto",
				    JOptionPane.INFORMATION_MESSAGE);
		    */
			
			return precioInstalaciones;
			
		}catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en obtenerInstalaciones().","Error",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}

	
	public List<InstalacionesDisplayDTO> getListaInstalacionesArray(int numInst,Date fecha, float horaInicio,float horaFin) {
		System.out.println("Inicio consulta");
		String sql="SELECT instalaciones.idInstalacion, nombre, fecha,horaInicio,horaFin,"
				+"case when ?=fecha and ?=horaInicio and ?>=horaFin then '(Reservada)' "
				+" when ?=fecha and ?=horaInicio and ?<=horaFin then '(Reservada)'"
				+" when ?=fecha and ?<=horaInicio and ?=horaFin then '(Reservada)'"
				+" when ?=fecha and ?<=horaInicio and ?=horaFin then '(Reservada)'"
				+" else '(Libre)'"
				+" end as estado"
				+" from instalaciones inner join reservas on instalaciones.idInstalacion=reservas.idInstalacion "
				+" where ?=instalaciones.idInstalacion AND ?=fecha order by instalaciones.idInstalacion";
		numInst++;
		String f=Util.dateToIsoString(fecha);
		return db.executeQueryPojo(InstalacionesDisplayDTO.class,sql,f,horaInicio,horaFin,f,horaInicio,horaFin,f,horaInicio,horaFin,f,horaInicio,horaFin,numInst,f);
	}
	
	
	public int conflictosReservasInstalacionActividad(Date fechaInicio, float horaInicio, float horaFin){
		String sql="SELECT COUNT(*)"
				+ " from reservas where Fecha=? and horaInicio=? and horaFin=?";
		String fI=Util.dateToIsoString(fechaInicio);
		//String fF=Util.dateToIsoString(fechaFin);
		List<Object[]>row= db.executeQueryArray(sql, fI,horaInicio,horaFin);
		return (int)row.get(0)[0];
	}

	
	public List<SociosDisplayDTO> getInfoSocio(int numSocio){
		String sql="SELECT nombre,apellido1, apellido2 from socios where idSocio=?";
		return db.executeQueryPojo(SociosDisplayDTO.class,sql,numSocio);
	}
	
	public List<Object[]>getInfoSocioDNI(String DNI){
		String sql="SELECT idSocio,nombre,apellido1,apellido2,corrientePago from socios where dni=?";
		return db.executeQueryArray(sql, DNI);
	}
	
	public List<reservasDisplayDTO> comprobarInstalacion(int idInst, Date fechaInicio, Date fechaFin, float horaInicio, float horaFin){
		String sql="SELECT reservas.idInstalacion,instalaciones.nombre,fecha,reservas.horaInicio,reservas.horaFin, "
				+" case "
				+" when reservas.idInstalacion!=? then '(Libre)'"				
				+" when ?>=fecha and reservas.idInstalacion=? then '(Libre)'"
				+" when ?<=fecha and ?=reservas.idInstalacion then '(Libre)'"
				+" else '(Reservada)'"
				+" end as estado"
				+" from reservas inner join instalaciones on reservas.idInstalacion=instalaciones.idInstalacion"
				+" where reservas.idInstalacion=? ";
		String fI=Util.dateToIsoString(fechaInicio);
		//String fF=Util.dateToIsoString(fechaFin);
		return db.executeQueryPojo(reservasDisplayDTO.class,sql,idInst,fI,idInst,fI,idInst,idInst);

	}
	public List<Object[]> disponibilidadInstalacion(int idInst, Date fechaInicio, float horaInicio, float horaFin){
		String sql="SELECT reservas.idInstalacion,"
				+" case "
				+" when reservas.idInstalacion!=? then '(Reservada)'"				
				+" when ?>=fecha and reservas.idInstalacion=? then '(Libre)'"
				+" when ?<=fecha and ?=reservas.idInstalacion then '(Libre)'"
				+" else '(Reservada)'"
				+" end as estado"
				+" from reservas inner join instalaciones on reservas.idInstalacion=instalaciones.idInstalacion"
				+" where reservas.idInstalacion=? ";
		String fI=Util.dateToIsoString(fechaInicio);
		//String fF=Util.dateToIsoString(fechaFin);
		return db.executeQueryArray(sql,idInst,fI,idInst,fI,idInst,idInst);

	}
	
	public List<actividadesDisplayDTO> marcarActReservada(String actividad){
		String sql="SELECT tipo, idInstalacion, fechaInicio,fechaFin,precioSocio,precioNoSocio"
				+" from actividades where nombre=?";
		return db.executeQueryPojo(actividadesDisplayDTO.class,sql,actividad);
	}
	/*
	public List<Object []> horarioActividad(int idActividad){
		String sql="SELECT dia,horaInicio,horaFin from horarioActividad where idActividad=? ";
		return db.executeQueryArray(sql, idActividad);
	}*/

	
	public void realizarReserva(int idReserva, int idUsuario, int idActividad, int idInstalacion, String fecha,
			float horaInicioReserva, float horaFinReserva, int estado) {
		String sql="INSERT into reservas (idReserva, idSocio,idActividad,idInstalacion,fecha,horaInicio,horaFin, estado)"
				+ " values (?,?,?,?,?,?,?, ?)";
		//String fechaInicio=Util.dateToIsoString(fechaInicioReserva);

		try{
			db.executeUpdate(sql, idReserva, idUsuario,idActividad,idInstalacion,fecha,horaInicioReserva,horaFinReserva, estado);
			SwingUtil.showMessage("Reserva realizada con éxito!", "Éxito", 3);

		}
		catch (UnexpectedException e){
			SwingUtil.showMessage("Nº de reserva ya utilizado", "Error", 0);

		}

	}
	
	public List<InstalacionesDisplayDTO> getInstalacion() {
		// TODO Auto-generated method stub
		String sql= "SELECT idInstalacion , precioHora from instalaciones ORDER BY (idInstalacion)";
		return db.executeQueryPojo(InstalacionesDisplayDTO.class, sql);

	}
	
	public List<Object[]> getInstalacion2() {
		// TODO Auto-generated method stub
		String sql= "SELECT nombre , idInstalacion from instalaciones ORDER BY (idInstalacion)";
		return db.executeQueryArray(sql);

	}
	
	public List<Object[]> getActividad2() {
		// TODO Auto-generated method stub
		String sql= "SELECT nombre , idActividad from actividades ORDER BY (idInstalacion)";
		return db.executeQueryArray(sql);

	}
	
	public List<actividadesDisplayDTO> getActividad() {
		// TODO Auto-generated method stub
		String sql= "SELECT nombre from actividades";
		return db.executeQueryPojo(actividadesDisplayDTO.class, sql);

	}
	
	public List<actividadesDisplayDTO> getTipoActividad() {
		// TODO Auto-generated method stub
		String sql= "SELECT tipo from actividades";
		return db.executeQueryPojo(actividadesDisplayDTO.class, sql);

	}
	
	public List<Object[]> getPrecioInstalacion(int idInstalacion){
		String sql="SELECT precioHora from instalaciones where idInstalacion=?";
		return db.executeQueryArray(sql, idInstalacion);
	}
	
	public List <Object[]> getInfoReserva(){
		String sql="SELECT idSocio from reservass";
		return db.executeQueryArray(sql);
	}
	
	
	
}
