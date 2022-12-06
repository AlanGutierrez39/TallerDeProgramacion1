package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.FormaDePago;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VistaCerrarComanda extends JFrame implements IVista{

	private JPanel contentPane;
	private JButton btnCerrarComanda = new JButton("CerrarComanda");
	private JComboBox <String>comboBoxMedios = new JComboBox<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCerrarComanda frame = new VistaCerrarComanda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaCerrarComanda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccionar metodo de pago");
		lblNewLabel.setBounds(135, 11, 223, 44);
		contentPane.add(lblNewLabel);
		
		comboBoxMedios.setBounds(112, 89, 192, 29);
		contentPane.add(comboBoxMedios);
		
		btnCerrarComanda.setBounds(125, 177, 148, 23);
		contentPane.add(btnCerrarComanda);
		this.comboBoxMedios.addItem(FormaDePago.CUENTADNI.getText());
		this.comboBoxMedios.addItem(FormaDePago.EFECTIVO.getText());
		this.comboBoxMedios.addItem(FormaDePago.MERCPAGO.getText());
		this.comboBoxMedios.addItem(FormaDePago.TARJETA.getText());
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnCerrarComanda.addActionListener(listener);
		this.btnCerrarComanda.setActionCommand(CERRAR_COMANDA_CONFIRMACION);
	}
	
	public String getFormaDePago() {
		return (String) this.comboBoxMedios.getSelectedItem();
	}

	@Override
	public void cerrar() {
		this.setVisible(false);
		
	}
}
