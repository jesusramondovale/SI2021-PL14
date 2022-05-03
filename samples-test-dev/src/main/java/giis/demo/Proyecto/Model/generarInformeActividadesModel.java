package giis.demo.Proyecto.Model;

import java.util.*;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.*;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;
public class generarInformeActividadesModel {

public Database db=new Database();

private String sql1 = "SELECT idActividad , idInstalacion , fechaInicio , fechaFin from actividades";
private String sql2 = "SELECT idInstalacion,nombre from instalaciones";
private String sql3 = "SELECT idActividad,idSocio,idNoSocio from inscripciones order by idActividad";
private String sql4 = "SELECT idActividad,idSocio from listaEsperaSocios";
private String sql5 = "SELECT idActividad,idNoSocio from listaEsperaNoSocios";

public List<listaEsperaSociosDisplayDTO> obtenerSocios() {
	try {
		List<listaEsperaSociosDisplayDTO> inscripcion= db.executeQueryPojo(listaEsperaSociosDisplayDTO.class, sql4);
		return inscripcion;
		
	}catch(UnexpectedException e) {
		JOptionPane.showMessageDialog(null, "SQL error en obtener lista espera de socios.","Error",
			    JOptionPane.WARNING_MESSAGE);
		return null;
	}
}

public List<listaEsperaNoSociosDisplayDTO> obtenerNoSocios() {
	try {
		List<listaEsperaNoSociosDisplayDTO> inscripcion= db.executeQueryPojo(listaEsperaNoSociosDisplayDTO.class, sql5);
		return inscripcion;
		
	}catch(UnexpectedException e) {
		JOptionPane.showMessageDialog(null, "SQL error en obtener lista espera de socios.","Error",
			    JOptionPane.WARNING_MESSAGE);
		return null;
	}
}

public List<inscripcionesDisplayDTO> obtenerInscripciones() {
	try {
		List<inscripcionesDisplayDTO> inscripcion= db.executeQueryPojo(inscripcionesDisplayDTO.class, sql3);
		return inscripcion;
		
	}catch(UnexpectedException e) {
		JOptionPane.showMessageDialog(null, "SQL error en obtener nombre de las instalaciones.","Error",
			    JOptionPane.WARNING_MESSAGE);
		return null;
	}
}

public List<InstalacionesDisplayDTO> obtenerInstalacion() {
	try {
		List<InstalacionesDisplayDTO> instalacion= db.executeQueryPojo(InstalacionesDisplayDTO.class, sql2);
		return instalacion;
		
	}catch(UnexpectedException e) {
		JOptionPane.showMessageDialog(null, "SQL error en obtener nombre de las instalaciones.","Error",
			    JOptionPane.WARNING_MESSAGE);
		return null;
	}
}

public List<actividadesDisplayDTO> obtenerfechasActividades() {
	
	
	try {
		List<actividadesDisplayDTO> actividad= db.executeQueryPojo(actividadesDisplayDTO.class, sql1);
		return actividad;
		
	}catch(UnexpectedException e) {
		JOptionPane.showMessageDialog(null, "SQL error en obtener fechas e instalación de actividades.","Error",
			    JOptionPane.WARNING_MESSAGE);
		return null;
	}
	
}

public List<Object[]> getListaActividad(){
	String sql="SELECT nombre from actividades";
	return db.executeQueryArray(sql);
}


public List<InformeActividadDTO> getInformacionInforme(){
	String sql = "SELECT actividades.nombre,actividades.plazas,actividades.idInstalacion, actividades.precioSocio,actividades.precioNoSocio,count(inscripciones.idActividad) as inscritos " + 
			"from inscripciones " + 
			"INNER JOIN actividades USING(idActividad) " + 
			"INNER JOIN periodos USING(idPeriodoInscripcion) " + 
			"GROUP BY idActividad ORDER BY idActividad";
	return db.executeQueryPojo(InformeActividadDTO.class, sql);
}


public List<actividadesDisplayDTO> getDatosActividad(int indiceActividad){
	String sql = "select nombre, plazas from actividades WHERE idActividad = ? ";
	return db.executeQueryPojo(actividadesDisplayDTO.class, sql, indiceActividad);
}
}