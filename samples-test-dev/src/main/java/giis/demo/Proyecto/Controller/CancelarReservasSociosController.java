package giis.demo.Proyecto.Controller;

import giis.demo.Proyecto.Model.CancelarReservasSociosModel;
import giis.demo.Proyecto.Model.visualizarReservasInstalacionesModel;
import giis.demo.Proyecto.View.CancelarReservasSociosView;
import giis.demo.Proyecto.View.visualizaReservasInstalacionesView;

public class CancelarReservasSociosController {

	private CancelarReservasSociosModel model;
	private CancelarReservasSociosView view;
	private int pos;

	public CancelarReservasSociosController(CancelarReservasSociosModel model, CancelarReservasSociosView view) {
		this.model = model;
		this.view = view;
		this.initView();
	}

	public void initView() {
		view.getframe().setVisible(true);
	}
	
	

}
