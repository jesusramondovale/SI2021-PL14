package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancelarReservasSociosView {

	private JFrame frame;
	private JTextField textFieldNombre;
	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	private JTable table;
	
	//private JButton btnNewButton;
	
	private JScrollPane scrollPane;
	
	public JFrame getframe() {
		return frame;
	}

	public void setframe(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextField() {
		return textFieldNombre;
	}

	public void setTextField(JTextField textField) {
		this.textFieldNombre = textField;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JButton getBtnComprobarReservas() {
		return btnComprobarReservas;
	}

	public void setBtnComprobarReservas(JButton btnComprobarReservas) {
		this.btnComprobarReservas = btnComprobarReservas;
	}

	public JButton getBtnCancelarReservas() {
		return btnCancelarReservas;
	}

	public void setBtnCancelarReservas(JButton btnCancelarReservas) {
		this.btnCancelarReservas = btnCancelarReservas;
	}

	private JLabel lblNewLabel;
	
	private  JButton btnComprobarReservas;
	
	private JButton btnCancelarReservas ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelarReservasSociosView window = new CancelarReservasSociosView();
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
	public CancelarReservasSociosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cancelar Reservas Socios");
		frame.setBounds(100, 100, 751, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 lblNewLabel = new JLabel("Nombre");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		
		btnComprobarReservas = new JButton("Comprobar reserva");
		btnComprobarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		 scrollPane = new JScrollPane();
		
		btnCancelarReservas = new JButton("Cancelar Reserva");
		btnCancelarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addComponent(btnComprobarReservas)
					.addContainerGap(175, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(555, Short.MAX_VALUE)
					.addComponent(btnCancelarReservas)
					.addGap(63))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(103)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(107, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnComprobarReservas))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(btnCancelarReservas)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"", "", "", "", "", ""
			}
		));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
