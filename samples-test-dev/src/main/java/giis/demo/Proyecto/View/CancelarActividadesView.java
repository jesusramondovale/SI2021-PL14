package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CancelarActividadesView {

	private JFrame frmCancelarActividades;
	private JTable table;
	private JButton btn_CancelarActividad;
	private JButton btn_BuscarActvidad;
	private JScrollPane scrollPane;
	

	public JButton getBtn_CancelarActividad() {
		return btn_CancelarActividad;
	}

	public void setBtn_CancelarActividad(JButton btn_CancelarActividad) {
		this.btn_CancelarActividad = btn_CancelarActividad;
	}

	public JButton getBtn_BuscarActvidad() {
		return btn_BuscarActvidad;
	}

	public void setBtn_BuscarActvidad(JButton btn_BuscarActvidad) {
		this.btn_BuscarActvidad = btn_BuscarActvidad;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelarActividadesView window = new CancelarActividadesView();
					window.frmCancelarActividades.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CancelarActividadesView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCancelarActividades = new JFrame();
		frmCancelarActividades.setTitle("Cancelar Actividades");
		frmCancelarActividades.setBounds(100, 100, 827, 436);
		frmCancelarActividades.getContentPane().setLayout(null);
		
		btn_BuscarActvidad = new JButton("Buscar Actividades");
		btn_BuscarActvidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_BuscarActvidad.setBounds(43, 41, 150, 23);
		frmCancelarActividades.getContentPane().add(btn_BuscarActvidad);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 93, 696, 220);
		frmCancelarActividades.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btn_CancelarActividad = new JButton("Cancelar Actividad");
		btn_CancelarActividad.setBounds(597, 338, 150, 23);
		frmCancelarActividades.getContentPane().add(btn_CancelarActividad);
	}

	public JFrame getFrmCancelarActividades() {
		return frmCancelarActividades;
	}

	public void setFrmCancelarActividades(JFrame frmCancelarActividades) {
		this.frmCancelarActividades = frmCancelarActividades;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnNewButton_CancelarActividad() {
		return btn_CancelarActividad;
	}

	public void setBtnNewButton_CancelarActividad(JButton btnNewButton_CancelarActividad) {
		this.btn_CancelarActividad = btnNewButton_CancelarActividad;
	}

	public JButton getBtnNewButton_BuscarActvidad() {
		return btn_BuscarActvidad;
	}

	public void setBtnNewButton_BuscarActvidad(JButton btnNewButton_BuscarActvidad) {
		this.btn_BuscarActvidad = btnNewButton_BuscarActvidad;
	}
}
