package com.tallerDeProgra.capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Vistas.IVista;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaABMMesa;

import excepciones.DatosIncorrectosException;

public class ControladorABMMesa implements ActionListener{
	private VistaABMMesa vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorABMMesa(int tipoOperario) {
		this.vista = new VistaABMMesa();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.vista.actualizaComboBoxMesas(modelo.getMesas());
		this.tipoOperario = tipoOperario; 
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.AGREGAR_MESA)) {
			ControladorAltaMesa contAltaMesa = new ControladorAltaMesa(tipoOperario);
			this.vista.cerrar();
		}
		else if(e.getActionCommand().equals(IVista.MODIFICAR_MESA)) {
			ControladorModificarMesa contModificarMesa = new ControladorModificarMesa(tipoOperario, this.vista.getMesa());
			this.vista.cerrar();
		}
		else if(e.getActionCommand().equals(IVista.ELIMINAR_MESA)) {
			try {
				this.modelo.getZonaConfiguracionDeSistema().eliminarMesa(this.vista.getMesa());
			} catch (DatosIncorrectosException e1) {
				e1.printStackTrace();
			}
			this.vista.actualizaComboBoxMesas(this.modelo.getMesas());
		}
		else if(e.getActionCommand().equals(IVista.SALIR_DE_MESA)) {
			this.vista.cerrar();
			ControladorMenuOperarioAdministrador contMenuOpAdmin = new ControladorMenuOperarioAdministrador(tipoOperario);
		}
	}

}
