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
	private JButton btnNewButton_CancelarActividad;
	private JButton btnNewButton_BuscarActvidad;

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
		frmCancelarActividades.setBounds(100, 100, 906, 548);
		frmCancelarActividades.getContentPane().setLayout(null);
		
		btnNewButton_BuscarActvidad = new JButton("Buscar Actividades");
		btnNewButton_BuscarActvidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_BuscarActvidad.setBounds(43, 41, 150, 23);
		frmCancelarActividades.getContentPane().add(btnNewButton_BuscarActvidad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 93, 772, 324);
		frmCancelarActividades.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		btnNewButton_CancelarActividad = new JButton("Cancelar Actividad");
		btnNewButton_CancelarActividad.setBounds(712, 458, 123, 23);
		frmCancelarActividades.getContentPane().add(btnNewButton_CancelarActividad);
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
		return btnNewButton_CancelarActividad;
	}

	public void setBtnNewButton_CancelarActividad(JButton btnNewButton_CancelarActividad) {
		this.btnNewButton_CancelarActividad = btnNewButton_CancelarActividad;
	}

	public JButton getBtnNewButton_BuscarActvidad() {
		return btnNewButton_BuscarActvidad;
	}

	public void setBtnNewButton_BuscarActvidad(JButton btnNewButton_BuscarActvidad) {
		this.btnNewButton_BuscarActvidad = btnNewButton_BuscarActvidad;
	}
}
