package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class EstadoCuentasView {

	private JFrame frmEstadoDeLas;
	private JTable tableActividades;
	private JTable tableInstalaciones;
	private JLabel lblNewLabel;
	private JLabel lblListaDeReservas;
	private JButton btnActualizarActividades;
	private JButton btnActualizarInstalaciones;
	private JScrollPane scrollPaneActividades;
	private JScrollPane scrollPaneInstalaciones;

	
	
	
	
	
	public JFrame getFrmEstadoDeLas() {
		return frmEstadoDeLas;
	}

	public void setFrmEstadoDeLas(JFrame frmEstadoDeLas) {
		this.frmEstadoDeLas = frmEstadoDeLas;
	}

	public JTable getTableActividades() {
		return tableActividades;
	}

	public void setTableActividades(JTable tableActividades) {
		this.tableActividades = tableActividades;
	}

	public JTable getTableInstalaciones() {
		return tableInstalaciones;
	}

	public void setTableInstalaciones(JTable tableInstalaciones) {
		this.tableInstalaciones = tableInstalaciones;
	}

	public JButton getBtnActualizarActividades() {
		return btnActualizarActividades;
	}

	public void setBtnActualizarActividades(JButton btnActualizarActividades) {
		this.btnActualizarActividades = btnActualizarActividades;
	}

	public JButton getBtnActualizarInstalaciones() {
		return btnActualizarInstalaciones;
	}

	public void setBtnActualizarInstalaciones(JButton btnActualizarInstalaciones) {
		this.btnActualizarInstalaciones = btnActualizarInstalaciones;
	}

	public JScrollPane getScrollPaneActividades() {
		return scrollPaneActividades;
	}

	public void setScrollPaneActividades(JScrollPane scrollPaneActividades) {
		this.scrollPaneActividades = scrollPaneActividades;
	}

	public JScrollPane getScrollPaneInstalaciones() {
		return scrollPaneInstalaciones;
	}

	public void setScrollPaneInstalaciones(JScrollPane scrollPaneInstalaciones) {
		this.scrollPaneInstalaciones = scrollPaneInstalaciones;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadoCuentasView window = new EstadoCuentasView();
					window.frmEstadoDeLas.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EstadoCuentasView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEstadoDeLas = new JFrame();
		frmEstadoDeLas.setTitle("Estado de las Cuentas");
		frmEstadoDeLas.setBounds(100, 100, 342, 470);
		frmEstadoDeLas.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Lista de Actividades ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(25, 22, 166, 14);
		frmEstadoDeLas.getContentPane().add(lblNewLabel);
		
		lblListaDeReservas = new JLabel("Lista de Reservas ");
		lblListaDeReservas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListaDeReservas.setBounds(25, 245, 147, 14);
		frmEstadoDeLas.getContentPane().add(lblListaDeReservas);
		
		btnActualizarActividades = new JButton("Actualizar");
		btnActualizarActividades.setBounds(159, 20, 115, 23);
		frmEstadoDeLas.getContentPane().add(btnActualizarActividades);
		
		btnActualizarInstalaciones = new JButton("Actualizar");
		btnActualizarInstalaciones.setBounds(162, 241, 115, 23);
		frmEstadoDeLas.getContentPane().add(btnActualizarInstalaciones);
		
		scrollPaneActividades = new JScrollPane();
		scrollPaneActividades.setBounds(25, 52, 248, 158);
		frmEstadoDeLas.getContentPane().add(scrollPaneActividades);
		
		tableActividades = new JTable();
		scrollPaneActividades.setViewportView(tableActividades);
		
		scrollPaneInstalaciones = new JScrollPane();
		scrollPaneInstalaciones.setBounds(25, 270, 252, 149);
		frmEstadoDeLas.getContentPane().add(scrollPaneInstalaciones);
		
		tableInstalaciones = new JTable();
		scrollPaneInstalaciones.setViewportView(tableInstalaciones);
	}
}