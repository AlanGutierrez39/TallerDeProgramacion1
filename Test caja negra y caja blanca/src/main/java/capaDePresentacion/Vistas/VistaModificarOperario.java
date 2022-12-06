package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capaDeDatos.Operario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class VistaModificarOperario extends JFrame implements IVista{

	private JPanel contentPane;
	private JLabel lblModificarOperario;
	private JLabel lblNewLabel;
	private JTextField textFieldNombre;
	private JLabel lblNewLabel_1;
	private JTextField textFieldNombreUsuario;
	private JTextField textFieldPassword;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox<Object> comboBoxActivo;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JLabel lblNewLabel_informa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaModificarOperario frame = new VistaModificarOperario();
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
	public VistaModificarOperario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 368);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.lblModificarOperario = new JLabel("Modificar Operario");
		this.lblModificarOperario.setFont(new Font("Tahoma", Font.PLAIN, 22));
		this.lblModificarOperario.setBounds(33, 11, 203, 32);
		this.contentPane.add(this.lblModificarOperario);
		
		this.lblNewLabel = new JLabel("Nombre y apellido");
		this.lblNewLabel.setBounds(10, 66, 95, 23);
		this.contentPane.add(this.lblNewLabel);
		
		this.textFieldNombre = new JTextField();
		this.textFieldNombre.setColumns(10);
		this.textFieldNombre.setBounds(163, 67, 86, 20);
		this.contentPane.add(this.textFieldNombre);
		
		this.lblNewLabel_1 = new JLabel("Nombre usuario");
		this.lblNewLabel_1.setBounds(10, 118, 95, 20);
		this.contentPane.add(this.lblNewLabel_1);
		
		this.textFieldNombreUsuario = new JTextField();
		this.textFieldNombreUsuario.setColumns(10);
		this.textFieldNombreUsuario.setBounds(163, 118, 86, 20);
		this.contentPane.add(this.textFieldNombreUsuario);
		
		this.textFieldPassword = new JTextField();
		this.textFieldPassword.setColumns(10);
		this.textFieldPassword.setBounds(163, 171, 86, 20);
		this.contentPane.add(this.textFieldPassword);
		
		this.lblNewLabel_2 = new JLabel("Password");
		this.lblNewLabel_2.setBounds(10, 174, 46, 14);
		this.contentPane.add(this.lblNewLabel_2);
		
		this.lblNewLabel_3 = new JLabel("Activo");
		this.lblNewLabel_3.setBounds(10, 226, 46, 14);
		this.contentPane.add(this.lblNewLabel_3);
		
		this.comboBoxActivo = new JComboBox<Object>();
		this.comboBoxActivo.setBounds(163, 222, 86, 18);
		this.contentPane.add(this.comboBoxActivo);
		this.comboBoxActivo.addItem((String)"true");
		this.comboBoxActivo.addItem((String)"false");
		
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(16, 283, 89, 23);
		this.contentPane.add(this.btnCancelar);
		
		this.btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.setBounds(160, 283, 89, 23);
		this.contentPane.add(this.btnConfirmar);
		
		this.lblNewLabel_informa = new JLabel("");
		this.lblNewLabel_informa.setForeground(Color.RED);
		this.lblNewLabel_informa.setBounds(20, 252, 229, 20);
		this.contentPane.add(this.lblNewLabel_informa);
		setVisible(true);
	}

	public void setCampos(Operario operario) {
		this.textFieldNombreUsuario.setText(operario.getNombreDeUsuario());
		this.textFieldPassword.setText(operario.getPassword());
	}
	
	public String getNombre() {
		return this.textFieldNombre.getText();
	}
	public String getNombreUsuario() {
		return this.textFieldNombreUsuario.getText();
	}
	public String getPassword() {
		return this.textFieldPassword.getText();
	}
	public boolean getActivo() {
		return this.comboBoxActivo.getSelectedItem().toString().equals("true");
	}

	public void setLabelInforma(String mensaje) {
		this.lblNewLabel_informa.setText(mensaje);
	}
	
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnConfirmar.addActionListener(listener);
		this.btnCancelar.addActionListener(listener);
		this.btnConfirmar.setActionCommand(CONFIRMAR_OPERARIO);
		this.btnCancelar.setActionCommand(CANCELAR_OPERARIO);
	}

	@Override
	public void cerrar() {
		setVisible(false);
	}
}
