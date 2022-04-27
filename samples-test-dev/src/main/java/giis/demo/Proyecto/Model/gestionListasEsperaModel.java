package giis.demo.Proyecto.Model;

import java.util.*;

import javax.swing.JOptionPane;

import giis.demo.util.Util;
import giis.demo.Proyecto.DTO.*;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;
public class gestionListasEsperaModel {

public Database db=new Database();

private String sql1 = "SELECT idActividad,nombre,plazas,estado,precioSocio from actividades";
private String sql2 = "SELECT idActividad,idSocio,posicion from listaEsperaSocios";
private String sql3 = "SELECT idActividad,idNoSocio,posicion from listaEsperaNoSocios";
private String sql4 = "SELECT idSocio, cuota from socios";

	public List<actividadesDisplayDTO> obtenerActividad(){
		try {
			List<actividadesDisplayDTO> actividad= db.executeQueryPojo(actividadesDisplayDTO.class, sql1);
			return actividad;
			
		}catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en Obtener las actividades.","Error",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	public List<SociosDisplayDTO> obtenerCuotaSocios(){
		try {
			List<SociosDisplayDTO> socios= db.executeQueryPojo(SociosDisplayDTO.class, sql4);
			return socios;
			
		}catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en Obtener la cuota de las actividades.","Error",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	public List<listaEsperaSociosDisplayDTO> obtenerSocios(){
		try {
			List<listaEsperaSociosDisplayDTO> socios= db.executeQueryPojo(listaEsperaSociosDisplayDTO.class, sql2);
			return socios;
			
		}catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en Obtener lista espera de Socios.","Error",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	public List<listaEsperaNoSociosDisplayDTO> obtenerNoSocios(){
		try {
			List<listaEsperaNoSociosDisplayDTO> Nsocios= db.executeQueryPojo(listaEsperaNoSociosDisplayDTO.class, sql3);
			return Nsocios;
			
		}catch(UnexpectedException e) {
			JOptionPane.showMessageDialog(null, "SQL error en Obtener lista espera de no Socios.","Error",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	
	public List<actividadesDisplayDTO> marcarActReservada(String actividad){
		String sql="SELECT tipo, idInstalacion, fechaInicio,fechaFin,precioSocio,precioNoSocio"
				+" from actividades where nombre=?";
		return db.executeQueryPojo(actividadesDisplayDTO.class,sql,actividad);
	}

	
	public List<Object[]> getActividad2() {
		// TODO Auto-generated method stub
		String sql= "SELECT nombre , idActividad from actividades ORDER BY (idInstalacion)";
		return db.executeQueryArray(sql);

	}
	
	public void eliminaSocio(int idActividad,int posicion) {
		db.executeUpdate("DELETE FROM listaEsperaSocios WHERE idActividad = ? AND posicion = ? ",idActividad,posicion);
	}
	public void eliminaNoSocio(int idActividad,int posicion) {
		db.executeUpdate("DELETE FROM listaEsperaNoSocios WHERE idActividad = ? AND posicion = ? ",idActividad, posicion);
	}
	
	public void actualizaSocio(int posicion,int idActividad,int idSocio) {
		db.executeUpdate("UPDATE listaEsperaSocios SET posicion = ? WHERE idActividad = ? AND idSocio = ?",posicion,idActividad,idSocio);
	}
	
	public void actualizaNoSocio(int posicion,int idActividad, int idNoSocio) {
		db.executeUpdate("UPDATE listaEsperaNoSocios SET posicion = ? WHERE idActividad = ? AND idNoSocio = ?",posicion,idActividad,idNoSocio);
	}
	
	public void actualizarPlazas(int idActividad,int plaza) {
		db.executeUpdate("UPDATE actividades SET plazas = ? WHERE idActividad = ?",plaza,idActividad);
	}
	
	public void actualizarCuota(int idSocio,int cuota) {
		db.executeUpdate("UPDATE socios SET cuota = ? WHERE idSocio = ?",cuota,idSocio);
	}
		
}
