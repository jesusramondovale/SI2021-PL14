package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class gestionListasEsperaView {

	private JFrame frame;
	private JTextField txtLibre;
	private JComboBox <Object> comboBox_actividad;
	private JButton btnInscribir;
	private JButton btnNoInscribir;
	private JButton btnActualizar;
	private JButton btnComprobar;
	private JTable table;
	private JLabel lblTitulo;
	private JLabel lblActividad;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionListasEsperaView window = new gestionListasEsperaView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gestionListasEsperaView() {
		initialize();
	}

	public void actualizaPrecios(){
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 508, 362);
		
		lblTitulo = new JLabel("GESTIÓN DE LAS LISTAS DE ESPERA");
		lblTitulo.setBounds(29, 11, 354, 25);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblActividad = new JLabel("Actividad");
		lblActividad.setBounds(29, 57, 96, 14);
		
		comboBox_actividad = new JComboBox<Object>();
		comboBox_actividad.setBounds(86, 54, 93, 20);
		comboBox_actividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizaPrecios();
				
			}

			
		});
		comboBox_actividad.setModel(new DefaultComboBoxModel<Object>(new String[] {"Tenis"}));
		
		JLabel lblPlazasLibres = new JLabel("Plazas libres: ");
		lblPlazasLibres.setBounds(200, 57, 79, 14);
		
		JLabel lblNewLabel = new JLabel("----------------------------------------------------------------------------------------------------------");
		lblNewLabel.setBounds(26, 85, 749, 14);
		
		txtLibre = new JTextField();
		txtLibre.setBounds(426, 54, 40, 20);
		txtLibre.setEditable(false);
		txtLibre.setColumns(10);
		
		btnInscribir = new JButton("INSCRIBIR");
		btnInscribir.setEnabled(false);
		btnInscribir.setBounds(327, 126, 127, 23);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setEnabled(false);
		btnActualizar.setBounds(327, 209, 127, 23);
		
		btnComprobar = new JButton("COMPROBAR");
		btnComprobar.setBounds(289, 51, 127, 23);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(txtLibre);
		frame.getContentPane().add(btnInscribir);
		frame.getContentPane().add(btnActualizar);
		frame.getContentPane().add(lblTitulo);
		frame.getContentPane().add(lblActividad);
		frame.getContentPane().add(comboBox_actividad);
		frame.getContentPane().add(lblPlazasLibres);
		frame.getContentPane().add(btnComprobar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(26, 123, 275, 157);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Socio", "Socio", "Posicion"
			}
		));
		scrollPane.setViewportView(table);
		
		btnNoInscribir = new JButton("NO INSCRIBIR");
		btnNoInscribir.setEnabled(false);
		btnNoInscribir.setBounds(327, 160, 127, 23);
		frame.getContentPane().add(btnNoInscribir);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtLibre() {
		return txtLibre;
	}

	public void setTxtLibre(JTextField txtLibre) {
		this.txtLibre = txtLibre;
	}

	public JComboBox<Object> getComboBox_actividad() {
		return comboBox_actividad;
	}

	public void setComboBox_actividad(JComboBox<Object> comboBox_actividad) {
		this.comboBox_actividad = comboBox_actividad;
	}

	public JButton getBtnInscribir() {
		return btnInscribir;
	}

	public void setBtnInscribir(JButton btnInscribir) {
		this.btnInscribir = btnInscribir;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnComprobar() {
		return btnComprobar;
	}

	public void setBtnComprobar(JButton btnComprobar) {
		this.btnComprobar = btnComprobar;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnNoInscribir() {
		return btnNoInscribir;
	}

	public void setBtnNoInscribir(JButton btnNoInscribir) {
		this.btnNoInscribir = btnNoInscribir;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblActividad() {
		return lblActividad;
	}

	public void setLblActividad(JLabel lblActividad) {
		this.lblActividad = lblActividad;
	}
	
}
