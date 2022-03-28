package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RealizarReservasView {

	private JFrame frmRealizarReserva;
	private JTable tableAnteriores;
	

	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxInstalacion = new JComboBox();
	
	private JButton btnBorrar;
	private JButton btnCrearReserva;
	private JButton btnActualizar;	
	private JScrollPane scrollPaneAnteriores ;
	private JScrollPane scrollPanePosteriores;
	
	


	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JFrame getFrmRealizarReserva() {
		return frmRealizarReserva;
	}

	public void setFrmRealizarReserva(JFrame frmRealizarReserva) {
		this.frmRealizarReserva = frmRealizarReserva;
	}

	

	public JTable getTableAnteriores() {
		return tableAnteriores;
	}

	public void setTableAnteriores(JTable tableAnteriores) {
		this.tableAnteriores = tableAnteriores;
	}

	public JComboBox getComboBoxInstalacion() {
		return comboBoxInstalacion;
	}

	public void setComboBoxInstalacion(JComboBox comboBoxInstalacion) {
		this.comboBoxInstalacion = comboBoxInstalacion;
	}

	

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnCrearReserva() {
		return btnCrearReserva;
	}

	public void setBtnCrearReserva(JButton btnCrearReserva) {
		this.btnCrearReserva = btnCrearReserva;
	}

	public JScrollPane getScrollPaneAnteriores() {
		return scrollPaneAnteriores;
	}

	public void setScrollPaneAnteriores(JScrollPane scrollPaneAnteriores) {
		this.scrollPaneAnteriores = scrollPaneAnteriores;
	}

	public JScrollPane getScrollPanePosteriores() {
		return scrollPanePosteriores;
	}

	public void setScrollPanePosteriores(JScrollPane scrollPanePosteriores) {
		this.scrollPanePosteriores = scrollPanePosteriores;
	}

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarReservasView window = new RealizarReservasView();
					window.frmRealizarReserva.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RealizarReservasView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRealizarReserva = new JFrame();
		frmRealizarReserva.setTitle("Realizar Reserva");
		frmRealizarReserva.setBounds(100, 100, 375, 273);
		
		btnCrearReserva = new JButton("Crear Reserva");
		btnCrearReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblActividad = new JLabel("Actividades");
		lblActividad.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		JScrollPane scrollPaneAnteriores = new JScrollPane();
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmRealizarReserva.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBorrar)
								.addComponent(lblActividad, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(41)
									.addComponent(btnCrearReserva))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(65)
									.addComponent(btnActualizar))))
						.addComponent(scrollPaneAnteriores, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblActividad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnActualizar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPaneAnteriores, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrar)
						.addComponent(btnCrearReserva))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		
		tableAnteriores = new JTable();
		tableAnteriores.setSize(scrollPaneAnteriores.getSize());
		
		scrollPaneAnteriores.setViewportView(tableAnteriores);
		frmRealizarReserva.getContentPane().setLayout(groupLayout);
	}
}
