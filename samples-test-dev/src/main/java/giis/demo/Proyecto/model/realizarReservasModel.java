package giis.demo.Proyecto.model;

import java.util.*;

import giis.demo.util.Util;
import giis.demo.Proyecto.DTO.*;
import giis.demo.util.Database;
public class realizarReservasModel {

public Database db=new Database();

	
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

	public List<Object[]>getFechasReservas(Date fecha, float horaInicio, float horaFin){
		String sql="SELECT fecha, horaInicio, horaFin"
				+ " from reservas where fecha=?";
		String f=Util.dateToIsoString(fecha);
		return db.executeQueryArray(sql, f);
	}
	
	
	public int conflictosReservasInstalacionActividad(Date fechaInicio, float horaInicio, float horaFin){
		String sql="SELECT COUNT(*)"
				+ " from reservas where Fecha=? and horaInicio=? and horaFin=?";
		String fI=Util.dateToIsoString(fechaInicio);
		//String fF=Util.dateToIsoString(fechaFin);
		List<Object[]>row= db.executeQueryArray(sql, fI,horaInicio,horaFin);
		return (int)row.get(0)[0];
	}

	
	public List<Object[]> getInfoSocio(int numSocio){
		String sql="SELECT nombre,apellido1, apellido2 from socios where idSocio=?";
		return db.executeQueryArray(sql,numSocio);
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

	
	public void realizarReserva(int idUsuario, int idActividad, int idInstalacion, Date fechaInicioReserva,
			float horaInicioReserva, float horaFinReserva, int estado) {
		String sql="INSERT into reservas (idSocio,idActividad,idInstalacion,fecha,horaInicio,horaFin, estado)"
				+ " values (?,?,?,?,?,?, ?)";
		//String fechaInicio=Util.dateToIsoString(fechaInicioReserva);
		db.executeUpdate(sql, idUsuario,null,idInstalacion,fechaInicioReserva,horaInicioReserva,horaFinReserva, estado);
	}
	
	public List<Object[]> getInstalacion() {
		// TODO Auto-generated method stub
		String sql= "SELECT nombre from instalaciones";
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
