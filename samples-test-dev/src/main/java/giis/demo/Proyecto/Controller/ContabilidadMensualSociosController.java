package giis.demo.Proyecto.Controller;

import giis.demo.Proyecto.Model.CancelarReservasSociosModel;
import giis.demo.Proyecto.Model.ContabilidadMensualSociosModel;
import giis.demo.Proyecto.View.CancelarReservasSociosView;
import giis.demo.Proyecto.View.ContabilidadMensualSociosView;
import giis.demo.Proyecto.View.LoginView;
import giis.demo.util.SwingUtil;

public class ContabilidadMensualSociosController {

	private ContabilidadMensualSociosModel model;
	private ContabilidadMensualSociosView view;

	public ContabilidadMensualSociosController(ContabilidadMensualSociosModel model, ContabilidadMensualSociosView view){
		this.model = model;
		this.view = view;
		this.initView();
	}

	public void initView() {
		view.getFrmContabilidadMensualDe().setVisible(true); 
	}

	public void initController() {
		
		view.getBtnContabilidad().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getContabilidad()));
		
	}

	private void getContabilidad() {

		
	}
}
