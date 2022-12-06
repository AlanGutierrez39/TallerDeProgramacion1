package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeDatos.Producto;
import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaAltaProducto;

import excepciones.DatosIncorrectosException;

public class ControladorAltaProducto implements ActionListener{
	private VistaAltaProducto vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorAltaProducto(int tipoOperario) {
		this.vista = new VistaAltaProducto();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.CONFIRMAR_PRODUCTO)) {
			if(!this.vista.getNombre().isEmpty() && !this.vista.getPrecioCosto().isEmpty() && !this.vista.getPrecioVenta().isEmpty() && !this.vista.getStock().isEmpty()) {
				try {
					modelo.getZonaConfiguracionDeSistema().altaProducto(this.vista.getNombre(), Float.parseFloat(this.vista.getPrecioCosto()), Float.parseFloat(this.vista.getPrecioVenta()), Integer.parseInt(this.vista.getStock()));
					this.vista.cerrar();
					ControladorABMProducto contABMProd = new ControladorABMProducto(tipoOperario);
				}catch(DatosIncorrectosException e1) {
					this.vista.setLblError("Ingrese los datos correctamente.");
				}
			}else {
				this.vista.setLblError("Ingrese los datos correctamente.");
			}
		}
		else if(e.getActionCommand().equals(IVista.CANCELAR_PRODUCTO)) {
			this.vista.cerrar();
			ControladorABMProducto contABMProd = new ControladorABMProducto(tipoOperario);
		}
	}
}
