package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InscribirClientesView {

	private JFrame frmInscribirClientesEn;
	private JTextField tfIDCliente;
	private JTable tableActividades;
	private JScrollPane scrollPaneActividades;
	private JButton btnRefresh;
	private JButton btnInscribir;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscribirClientesView window = new InscribirClientesView();
					window.frmInscribirClientesEn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InscribirClientesView() {
		initialize();
	}

	
	
	
	public JFrame getFrmInscribirClientesEn() {
		return frmInscribirClientesEn;
	}

	public void setFrmInscribirClientesEn(JFrame frmInscribirClientesEn) {
		this.frmInscribirClientesEn = frmInscribirClientesEn;
	}

	public JTextField getTfIDCliente() {
		return tfIDCliente;
	}

	public void setTfIDCliente(JTextField tfIDCliente) {
		this.tfIDCliente = tfIDCliente;
	}

	public JTable getTableActividades() {
		return tableActividades;
	}

	public void setTableActividades(JTable tableActividades) {
		this.tableActividades = tableActividades;
	}

	public JScrollPane getScrollPaneActividades() {
		return scrollPaneActividades;
	}

	public void setScrollPaneActividades(JScrollPane scrollPaneActividades) {
		this.scrollPaneActividades = scrollPaneActividades;
	}

	public JButton getBtnRefresh() {
		return btnRefresh;
	}

	public void setBtnRefresh(JButton btnRefresh) {
		this.btnRefresh = btnRefresh;
	}
	
	

	public JButton getBtnInscribir() {
		return btnInscribir;
	}

	public void setBtnInscribir(JButton btnInscribir) {
		this.btnInscribir = btnInscribir;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInscribirClientesEn = new JFrame();
		frmInscribirClientesEn.setTitle("Inscribir Clientes en Actividades");
		frmInscribirClientesEn.setBounds(100, 100, 324, 352);
		frmInscribirClientesEn.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("#ID del Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 21, 118, 22);
		frmInscribirClientesEn.getContentPane().add(lblNewLabel);
		
		tfIDCliente = new JTextField();
		tfIDCliente.setBounds(148, 21, 110, 20);
		frmInscribirClientesEn.getContentPane().add(tfIDCliente);
		tfIDCliente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Actividades Disponibles");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(18, 71, 177, 22);
		frmInscribirClientesEn.getContentPane().add(lblNewLabel_1);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(205, 70, 89, 23);
		frmInscribirClientesEn.getContentPane().add(btnRefresh);
		
		scrollPaneActividades = new JScrollPane();
		scrollPaneActividades.setBounds(21, 102, 273, 163);
		frmInscribirClientesEn.getContentPane().add(scrollPaneActividades);
		
		tableActividades = new JTable();
		scrollPaneActividades.setViewportView(tableActividades);
		
		btnInscribir = new JButton("Inscribir");
		btnInscribir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnInscribir.setBounds(205, 276, 89, 23);
		frmInscribirClientesEn.getContentPane().add(btnInscribir);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpiar.setBounds(21, 277, 89, 23);
		frmInscribirClientesEn.getContentPane().add(btnLimpiar);
	}
}
