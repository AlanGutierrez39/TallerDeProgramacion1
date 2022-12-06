package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.Estado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;

public class VistaAltaMozo extends JFrame implements IVista{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textFieldNombreYApel;
	private JLabel lblNewLabel_1;
	private JTextField textFieldDiaNac;
	private JLabel lblNewLabel_2;
	private JTextField textFieldCantHijos;
	private JLabel lblNewLabel_3;
	private JComboBox comboBoxEstado;
	private JLabel lblNewLabel_4;
	private JTextField textFieldSueldo;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textFieldMesNac;
	private JLabel lblNewLabel_8;
	private JTextField textFieldAnioNac;
	private JLabel lblError;


	/**
	 * Create the frame.
	 */
	public VistaAltaMozo() {
		setTitle("Alta mozo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 358);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		this.lblNewLabel = new JLabel("Nombre y apellido");
		this.lblNewLabel.setBounds(27, 47, 110, 14);
		this.contentPane.add(this.lblNewLabel);
		
		this.textFieldNombreYApel = new JTextField();
		this.textFieldNombreYApel.setBounds(130, 45, 104, 17);
		this.contentPane.add(this.textFieldNombreYApel);
		this.textFieldNombreYApel.setColumns(10);
		
		this.lblNewLabel_1 = new JLabel("Fecha nacimiento");
		this.lblNewLabel_1.setBounds(27, 88, 93, 14);
		this.contentPane.add(this.lblNewLabel_1);
		
		this.textFieldDiaNac = new JTextField();
		this.textFieldDiaNac.setBounds(139, 86, 19, 16);
		this.contentPane.add(this.textFieldDiaNac);
		this.textFieldDiaNac.setColumns(10);
		
		this.lblNewLabel_2 = new JLabel("Cantidad hijos");
		this.lblNewLabel_2.setBounds(27, 133, 93, 14);
		this.contentPane.add(this.lblNewLabel_2);
		
		this.textFieldCantHijos = new JTextField();
		this.textFieldCantHijos.setBounds(130, 131, 49, 17);
		this.contentPane.add(this.textFieldCantHijos);
		this.textFieldCantHijos.setColumns(10);
		
		this.lblNewLabel_3 = new JLabel("Estado");
		this.lblNewLabel_3.setBounds(27, 218, 46, 14);
		this.contentPane.add(this.lblNewLabel_3);
		
		this.comboBoxEstado = new JComboBox();
		this.comboBoxEstado.setBounds(130, 214, 104, 22);
		this.contentPane.add(this.comboBoxEstado);
		this.comboBoxEstado.addItem((String) Estado.ACTIVO.getEstado());
		this.comboBoxEstado.addItem((String) Estado.AUSENTE.getEstado());
		this.comboBoxEstado.addItem((String) Estado.DE_FRANCO.getEstado());
		
		
		this.lblNewLabel_4 = new JLabel("Sueldo");
		this.lblNewLabel_4.setBounds(27, 176, 46, 14);
		this.contentPane.add(this.lblNewLabel_4);
		
		this.textFieldSueldo = new JTextField();
		this.textFieldSueldo.setBounds(130, 174, 104, 17);
		this.contentPane.add(this.textFieldSueldo);
		this.textFieldSueldo.setColumns(10);
		
		this.btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.setBounds(130, 265, 89, 23);
		this.contentPane.add(this.btnConfirmar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(27, 265, 89, 23);
		this.contentPane.add(this.btnCancelar);
		
		this.lblNewLabel_5 = new JLabel("Alta mozo");
		this.lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_5.setBounds(81, 11, 153, 25);
		this.contentPane.add(this.lblNewLabel_5);
		
		this.lblNewLabel_6 = new JLabel("dd/MM/yyyy");
		this.lblNewLabel_6.setBounds(149, 101, 70, 18);
		this.contentPane.add(this.lblNewLabel_6);
		
		this.lblNewLabel_7 = new JLabel("/");
		this.lblNewLabel_7.setBounds(160, 88, 4, 14);
		this.contentPane.add(this.lblNewLabel_7);
		
		this.textFieldMesNac = new JTextField();
		this.textFieldMesNac.setBounds(168, 86, 19, 17);
		this.contentPane.add(this.textFieldMesNac);
		this.textFieldMesNac.setColumns(10);
		
		this.lblNewLabel_8 = new JLabel("/");
		this.lblNewLabel_8.setBounds(190, 88, 11, 14);
		this.contentPane.add(this.lblNewLabel_8);
		
		this.textFieldAnioNac = new JTextField();
		this.textFieldAnioNac.setBounds(197, 86, 34, 17);
		this.contentPane.add(this.textFieldAnioNac);
		this.textFieldAnioNac.setColumns(10);
		
		this.lblError = new JLabel("");
		this.lblError.setForeground(Color.RED);
		this.lblError.setBounds(37, 240, 197, 14);
		this.contentPane.add(this.lblError);
		
		setVisible(true);
	}


	@Override
	public void addActionListener(ActionListener listener) {
		this.btnCancelar.addActionListener(listener);
		this.btnCancelar.setActionCommand(IVista.CANCELAR_MOZO);
		this.btnConfirmar.addActionListener(listener);
		this.btnConfirmar.setActionCommand(IVista.CONFIRMAR_MOZO);
	}
	@Override
	public void cerrar() {
		setVisible(false);
	}
	
	public String getNombreYApel() {
		return this.textFieldNombreYApel.getText();
	}
	public String getDiaNac() {
		return this.textFieldDiaNac.getText();
	}
	public String getMesNac() {
		return this.textFieldMesNac.getText();
	}
	public String getAnioNac() {
		return this.textFieldAnioNac.getText();
	}
	public String getCantHijos() {
		return this.textFieldCantHijos.getText();
	}
	public String getSueldo() {
		return this.textFieldSueldo.getText();
	}
	public String getEstado() {
		return this.comboBoxEstado.getSelectedItem().toString();
	}
	public void setLblError(String msg) {
		this.lblError.setText(msg);
	}
}
