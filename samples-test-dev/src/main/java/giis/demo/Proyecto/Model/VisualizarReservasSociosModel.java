package giis.demo.Proyecto.Model;

import giis.demo.util.Database;
import java.util.*;
import javax.swing.JOptionPane;

import giis.demo.util.Util;
import giis.demo.Proyecto.DTO.*;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;

public class VisualizarReservasSociosModel {

	public Database db=new Database();

	public List<Object[]> getListaInstalaciones(){

		String sql = "SELECT nombre from instalaciones order by idInstalacion";
		return db.executeQueryArray(sql);

	}
	
	public List<SociosDisplayDTO> getNumeroSocio(String dni) {

		String sql="SELECT * "
				+" from socios"
				+ " where dni=? ";

		return db.executeQueryPojo(SociosDisplayDTO.class, sql,dni);
	}
}
