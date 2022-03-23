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
	private JTextField textField;
	private JTable table;
	
	//private JButton btnNewButton;
	
	private JScrollPane scrollPane;
	
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
		frame.setBounds(100, 100, 751, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 lblNewLabel = new JLabel("Nombre");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addComponent(btnComprobarReservas)
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(103)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(587, Short.MAX_VALUE)
					.addComponent(btnCancelarReservas)
					.addGap(63))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnComprobarReservas))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(btnCancelarReservas)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Instalacion", "Hora Inicio", "Hora Fin", "Pagado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}