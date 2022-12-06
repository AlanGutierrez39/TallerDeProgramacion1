package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capaDeDatos.Operario;
import capaDeDatos.Producto;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class VistaModificarProducto extends JFrame implements IVista{

	private JPanel contentPane;
	private JPanel contentPane_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textFieldNombre;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textFieldPrecioCosto;
	private JTextField textFieldPrecioVenta;
	private JTextField textFieldStock;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JLabel lblError;

	

	/**
	 * Create the frame.
	 */
	public VistaModificarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 249, 318);
		setTitle("Modificar producto");
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.contentPane_1 = new JPanel();
		this.contentPane_1.setLayout(null);
		this.contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane_1.setBounds(10, 0, 223, 279);
		this.contentPane.add(this.contentPane_1);
		
		this.lblNewLabel = new JLabel("Nombre");
		this.lblNewLabel.setBounds(35, 60, 58, 14);
		this.contentPane_1.add(this.lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("Modificar producto");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_1.setBounds(25, 11, 164, 23);
		this.contentPane_1.add(this.lblNewLabel_1);
		
		this.textFieldNombre = new JTextField();
		this.textFieldNombre.setColumns(10);
		this.textFieldNombre.setBounds(103, 57, 86, 20);
		this.contentPane_1.add(this.textFieldNombre);
		
		this.lblNewLabel_2 = new JLabel("Precio costo");
		this.lblNewLabel_2.setBounds(35, 103, 86, 14);
		this.contentPane_1.add(this.lblNewLabel_2);
		
		this.lblNewLabel_3 = new JLabel("Precio venta");
		this.lblNewLabel_3.setBounds(35, 146, 86, 14);
		this.contentPane_1.add(this.lblNewLabel_3);
		
		this.lblNewLabel_4 = new JLabel("Stock");
		this.lblNewLabel_4.setBounds(35, 188, 46, 14);
		this.contentPane_1.add(this.lblNewLabel_4);
		
		this.textFieldPrecioCosto = new JTextField();
		this.textFieldPrecioCosto.setColumns(10);
		this.textFieldPrecioCosto.setBounds(103, 100, 86, 20);
		this.contentPane_1.add(this.textFieldPrecioCosto);
		
		this.textFieldPrecioVenta = new JTextField();
		this.textFieldPrecioVenta.setColumns(10);
		this.textFieldPrecioVenta.setBounds(103, 143, 86, 20);
		this.contentPane_1.add(this.textFieldPrecioVenta);
		
		this.textFieldStock = new JTextField();
		this.textFieldStock.setColumns(10);
		this.textFieldStock.setBounds(103, 185, 86, 20);
		this.contentPane_1.add(this.textFieldStock);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(10, 230, 89, 23);
		this.contentPane_1.add(this.btnCancelar);
		
		this.btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.setBounds(109, 230, 89, 23);
		this.contentPane_1.add(this.btnConfirmar);
		
		this.lblError = new JLabel("");
		this.lblError.setForeground(Color.RED);
		this.lblError.setBounds(10, 213, 203, 14);
		this.contentPane_1.add(this.lblError);
	
		setVisible(true);
	}



	@Override
	public void addActionListener(ActionListener listener) {
		this.btnCancelar.addActionListener(listener);
		this.btnCancelar.setActionCommand(IVista.CANCELAR_PRODUCTO);
		this.btnConfirmar.addActionListener(listener);
		this.btnConfirmar.setActionCommand(IVista.CONFIRMAR_PRODUCTO);
	}

	@Override
	public void cerrar() {
		setVisible(false);		
	}
	
	public void setCampos(Producto producto) {
		this.textFieldNombre.setText(producto.getNombre());
		this.textFieldPrecioCosto.setText(Float.toString(producto.getPrecioCosto()));
		this.textFieldPrecioVenta.setText(Float.toString(producto.getPrecioVenta()));
		this.textFieldStock.setText(Integer.toString(producto.getStock()));
	}
	
	public String getNombre() {
		return this.textFieldNombre.getText();
	}
	public String getPrecioCosto() {
		return this.textFieldPrecioCosto.getText();
	}
	public String getPrecioVenta() {
		return this.textFieldPrecioVenta.getText();
	}
	public String getStock() {
		return this.textFieldStock.getText();
	}
	
	public void setLblError(String message) {
		this.lblError.setText(message);
	}
}
