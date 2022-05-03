package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ContabilidadMensualSociosView {

	private JFrame frmContabilidadMensualDe;
	private JButton btnPasarAFichero;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnMostrarContabilidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContabilidadMensualSociosView window = new ContabilidadMensualSociosView();
					window.frmContabilidadMensualDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrmContabilidadMensualDe() {
		return frmContabilidadMensualDe;
	}

	public void setFrmContabilidadMensualDe(JFrame frmContabilidadMensualDe) {
		this.frmContabilidadMensualDe = frmContabilidadMensualDe;
	}

	public JButton getBtnContabilidad() {
		return btnPasarAFichero;
	}

	public void setBtnContabilidad(JButton btnContabilidad) {
		this.btnPasarAFichero = btnContabilidad;
	}

	/**
	 * Create the application.
	 */
	public ContabilidadMensualSociosView() {
		initialize();
	}

	public JButton getBtnPasarAFichero() {
		return btnPasarAFichero;
	}

	public void setBtnPasarAFichero(JButton btnPasarAFichero) {
		this.btnPasarAFichero = btnPasarAFichero;
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

	public JButton getBtnMostrarContabilidad() {
		return btnMostrarContabilidad;
	}

	public void setBtnMostrarContabilidad(JButton btnMostrarContabilidad) {
		this.btnMostrarContabilidad = btnMostrarContabilidad;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmContabilidadMensualDe = new JFrame();
		frmContabilidadMensualDe.setTitle("Contabilidad Mensual de los Socios");
		frmContabilidadMensualDe.setBounds(100, 100, 436, 315);
		frmContabilidadMensualDe.getContentPane().setLayout(null);

		btnPasarAFichero = new JButton("Pasar a fichero");
		btnPasarAFichero.setBounds(199, 197, 172, 21);
		frmContabilidadMensualDe.getContentPane().add(btnPasarAFichero);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 58, 311, 128);
		frmContabilidadMensualDe.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btnMostrarContabilidad = new JButton("Mostrar Contabilidad");
		btnMostrarContabilidad.setBounds(28, 24, 165, 23);
		frmContabilidadMensualDe.getContentPane().add(btnMostrarContabilidad);
	}
}