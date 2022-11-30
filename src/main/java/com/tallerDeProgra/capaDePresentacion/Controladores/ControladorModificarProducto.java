package com.tallerDeProgra.capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tallerDeProgra.capaDeDatos.Operario;
import com.tallerDeProgra.capaDeDatos.Producto;
import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Vistas.IVista;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaModificarOperario;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaModificarProducto;

import excepciones.DatosIncorrectosException;

public class ControladorModificarProducto implements ActionListener {
	private VistaModificarProducto vista = null;
	private Sistema modelo;
	private int tipoOperario;
	private Producto producto;
	
	public ControladorModificarProducto(int tipoOperario, Producto producto) {
		this.vista = new VistaModificarProducto();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario;
		this.producto = producto;
		this.vista.setCampos(producto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.CONFIRMAR_PRODUCTO)) {
			if(!this.vista.getNombre().isEmpty() && !this.vista.getPrecioCosto().isEmpty() && !this.vista.getPrecioVenta().isEmpty() && !this.vista.getStock().isEmpty()) {
				try {
					modelo.getZonaConfiguracionDeSistema().modificarProducto(producto.getId(), this.vista.getNombre(), Float.parseFloat(this.vista.getPrecioCosto()), Float.parseFloat(this.vista.getPrecioVenta()), Integer.parseInt(this.vista.getStock()));
					this.vista.cerrar();
					ControladorABMProducto contABMProducto = new ControladorABMProducto(0);
				}
				catch(DatosIncorrectosException e1){
					this.vista.setLblError("Ingrese los datos correctamente.");
				}
			}else {
				this.vista.setLblError("Ingrese los datos correctamente.");
			}
		}
		else if(e.getActionCommand().equals(IVista.CANCELAR_PRODUCTO)) {
			this.vista.cerrar();
			ControladorABMProducto contABMProducto = new ControladorABMProducto(tipoOperario);	
		}
	}	
}
