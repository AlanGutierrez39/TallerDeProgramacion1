package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeDatos.Comanda;
import capaDeDatos.Mesa;
import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.VistaAltaPedido;

import excepciones.DatosIncorrectosException;

import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaAltaOperario;

public class ControladorAltaPedido implements ActionListener {
	
	private VistaAltaPedido vista = null;
	private Sistema modelo;
	private int tipoOperario;
	private Comanda comanda;
	private boolean nuevaComanda;
	public ControladorAltaPedido(int tipoOperario, Comanda comanda, boolean nuevaComanda) {
		this.vista = new VistaAltaPedido();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario;
		this.vista.actualizaComboBoxProductos(modelo.getProductos());
		this.comanda=comanda;
		this.nuevaComanda=nuevaComanda;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.CONFIRMAR_PEDIDO)) {
			try {
				modelo.getZonaPedidosYFacturacion().altaPedido(this.comanda,vista.getProducto(),Integer.parseInt(vista.getCantidad()));
			} catch (NumberFormatException | DatosIncorrectosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ControladorFacturacionYPedidos controladorFacturacion= new ControladorFacturacionYPedidos(tipoOperario);
			this.vista.cerrar();	
		}
		if(e.getActionCommand().equals(IVista.ATRAS_PEDIDO)) {
			if(nuevaComanda) {
				try {
					modelo.getZonaPedidosYFacturacion().bajaComanda(comanda);
				} catch (DatosIncorrectosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ControladorAltaComanda controladorAltaComanda= new ControladorAltaComanda(tipoOperario);
			}
			else {
				ControladorFacturacionYPedidos controladorFacturacion= new ControladorFacturacionYPedidos(tipoOperario);
			}
			this.vista.cerrar();	
		}
	}

}
