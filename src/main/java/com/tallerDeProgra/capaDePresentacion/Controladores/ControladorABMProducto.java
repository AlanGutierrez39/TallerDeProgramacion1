package com.tallerDeProgra.capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Vistas.IVista;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaABMProducto;

import excepciones.DatosIncorrectosException;

public class ControladorABMProducto implements ActionListener {
	private VistaABMProducto vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorABMProducto(int tipoOperario) {
		this.vista = new VistaABMProducto();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.vista.actualizaComboBoxProductos(modelo.getProductos());
		this.tipoOperario = tipoOperario; 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.AGREGAR_PRODUCTO)) {
			this.vista.cerrar();
			ControladorAltaProducto contAltaProducto = new ControladorAltaProducto(tipoOperario);
		}
		else if(e.getActionCommand().equals(IVista.ELIMINAR_PRODUCTO)) {
			modelo.getProductos().remove(this.vista.getProducto());
			try {
				modelo.getZonaConfiguracionDeSistema().eliminarProducto(this.vista.getProducto());
			} catch (DatosIncorrectosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			this.vista.actualizaComboBoxProductos(modelo.getProductos());
		}
		else if(e.getActionCommand().equals(IVista.MODIFICAR_PRODUCTO)) {
			this.vista.cerrar();
			//ControladorModificarProducto contModificarProducto = new ControladorModificarProducto(tipoOperario);
			ControladorModificarProducto contModificarProducto = new ControladorModificarProducto(tipoOperario,this.vista.getProducto());
		}
		else if(e.getActionCommand().equals(IVista.SALIR_DE_PRODUCTO)) {
			this.vista.cerrar();
			ControladorMenuOperarioAdministrador contMenu = new ControladorMenuOperarioAdministrador(tipoOperario);
		}
		else if(e.getActionCommand().equals(IVista.ACTUALIZAR_PRODUCTO)) {
			try {
				Sistema.getInstance().getZonaConfiguracionDeSistema().actualizarProducto(this.vista.getProducto(),Integer.parseInt(this.vista.getCantActualizar()));
			} catch (NumberFormatException | DatosIncorrectosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.vista.actualizaComboBoxProductos(modelo.getProductos());
			if(!this.vista.getCantActualizar().isEmpty()) {
				try {
					Sistema.getInstance().getZonaConfiguracionDeSistema().actualizarProducto(this.vista.getProducto(), Integer.parseInt(this.vista.getCantActualizar()));
				} catch (NumberFormatException | DatosIncorrectosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.vista.actualizaComboBoxProductos(modelo.getProductos());
			}
		}
	}
}