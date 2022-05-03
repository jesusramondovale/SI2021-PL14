package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class generarInformeActividadesView extends JFrame {

	private JPanel contentPane;
	private JDateChooser fechaIni;
	private JDateChooser fechaFin;
	private JButton btnGenerarInforme;
	private JButton btnMostrar;
	private JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generarInformeActividadesView frame = new generarInformeActividadesView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public generarInformeActividadesView() {
		setBounds(100, 100, 420, 486);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		fechaIni = new JDateChooser();
		fechaIni.setBounds(68, 68, 134, 20);
		contentPane.add(fechaIni);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Periodo:");
		lblNewLabel.setBounds(10, 74, 58, 14);
		contentPane.add(lblNewLabel);
		
		fechaFin = new JDateChooser();
		fechaFin.setBounds(246, 68, 134, 20);
		contentPane.add(fechaFin);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 105, 370, 285);
		contentPane.add(textArea);
		
		btnGenerarInforme = new JButton("GENERAR INFORME");
		btnGenerarInforme.setBounds(246, 401, 134, 23);
		contentPane.add(btnGenerarInforme);
		
		btnMostrar = new JButton("MOSTRAR");
		btnMostrar.setBounds(106, 401, 120, 23);
		contentPane.add(btnMostrar);
		
		JLabel lblNewLabel_1 = new JLabel("GENERAR INFORME DE ACTIVIDADES");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 11, 363, 36);
		contentPane.add(lblNewLabel_1);
	}
	

	public JFrame getFrame() { return this; }

	public JDateChooser getFechaIni() {
		return fechaIni;
	}

	public JDateChooser getFechaFin() {
		return fechaFin;
	}

	public JButton getBtnGenerarInforme() {
		return btnGenerarInforme;
	}

	public JButton getBtnMostrar() {
		return btnMostrar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}
	
	public void setTextArea(String textArea) {
		this.textArea.setText(textArea);
	}
	
	
}