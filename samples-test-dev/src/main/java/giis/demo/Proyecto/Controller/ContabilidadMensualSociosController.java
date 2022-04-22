package giis.demo.Proyecto.Controller;

import java.time.LocalDateTime;
import java.util.List;

import giis.demo.Proyecto.Model.ContabilidadMensualSociosModel;
import giis.demo.Proyecto.View.ContabilidadMensualSociosView;
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
		List<Object[]> pagosPendientes = null;
		List<Object[]> pagosRealizados = null;
		
		pagosPendientes=model.getPagosPendientes();
		pagosRealizados=model.getPagosRealizados();
		
		List socios = (List) model.getSocios();
		
		
		
	}
	
	private void fechaActual() {
		LocalDateTime.now().getDayOfYear();
	}
}
