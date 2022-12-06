package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaConfiguracionEmpresa extends JFrame implements IVista, KeyListener{

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldSueldo;

	private JLabel lblNombre = new JLabel("New label");
	private JLabel lblSueldo = new JLabel("New label");
	private JButton btnCambiarSueldo = new JButton("Cambiar");
	private JButton btnCambiarNombre = new JButton("Cambiar");
	private final JButton btnAtras = new JButton("Atras");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaConfiguracionEmpresa frame = new VistaConfiguracionEmpresa();
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
	public VistaConfiguracionEmpresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Configuracion de la empresa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(106, 11, 273, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la empresa:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(28, 56, 160, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sueldo basico: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(28, 156, 131, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNombre.setBounds(214, 59, 210, 14);
		contentPane.add(lblNombre);
		
		lblSueldo.setBounds(214, 159, 183, 14);
		contentPane.add(lblSueldo);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(152, 103, 86, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldSueldo = new JTextField();
		textFieldSueldo.setBounds(152, 200, 86, 20);
		contentPane.add(textFieldSueldo);
		textFieldSueldo.setColumns(10);
		
		btnCambiarNombre.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCambiarNombre.setBounds(248, 102, 86, 20);
		contentPane.add(btnCambiarNombre);
		btnCambiarNombre.setEnabled(false);
		btnCambiarSueldo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCambiarSueldo.setBounds(248, 199, 86, 20);
		btnCambiarSueldo.setEnabled(false);
		contentPane.add(btnCambiarSueldo);
		btnAtras.setBounds(324, 230, 89, 23);
		this.setVisible(true);
		contentPane.add(btnAtras);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnCambiarNombre.addActionListener(listener);
		this.btnCambiarNombre.setActionCommand(MODIFICAR_NOMBRE_EMPRESA);
		this.btnCambiarSueldo.addActionListener(listener);
		this.btnCambiarSueldo.setActionCommand(MODIFICAR_SUELDO_EMPRESA);
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(ATRAS_EMPRESA);
		this.textFieldNombre.addKeyListener(this);
		this.textFieldSueldo.addKeyListener(this);
	}

	@Override
	public void cerrar() {
		this.setVisible(false);
		
	}
	
	public void setNombre(String text) {
		this.lblNombre.setText(text);
	}

	public void setSueldo(String text) {
		this.lblSueldo.setText(text);
	}
	public String getNombre() {
		return this.textFieldNombre.getText();
	}

	public Float getSueldo() {
		return Float.valueOf(this.textFieldSueldo.getText());
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(this.textFieldNombre.getText().isEmpty()) 
			this.btnCambiarNombre.setEnabled(false);
		else
			this.btnCambiarNombre.setEnabled(true);
		if(this.textFieldSueldo.getText().isEmpty()) 
			this.btnCambiarSueldo.setEnabled(false);
		else
			this.btnCambiarSueldo.setEnabled(true);
		
	}
}
