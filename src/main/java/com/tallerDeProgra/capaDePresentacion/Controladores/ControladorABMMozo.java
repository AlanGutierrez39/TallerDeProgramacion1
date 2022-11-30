package com.tallerDeProgra.capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Vistas.IVista;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaABMMozo;

import excepciones.DatosIncorrectosException;


public class ControladorABMMozo implements ActionListener{
	private VistaABMMozo vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorABMMozo(int tipoOperario) {
		this.vista = new VistaABMMozo();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.vista.actualizaComboBoxMozos(modelo.getMozos());
		this.tipoOperario = tipoOperario; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.AGREGAR_MOZO)) {
			this.vista.cerrar();
			ControladorAltaMozo controladorAltaMozo = new ControladorAltaMozo(this.tipoOperario);
		}
		else if(e.getActionCommand().equals(IVista.MODIFICAR_MOZO)) {
			this.vista.cerrar();
			ControladorModificarMozo controladorModifMozo = new ControladorModificarMozo(this.vista.getMozo());
		}
		else if(e.getActionCommand().equals(IVista.ELIMINAR_MOZO)) {
			try {
				modelo.getZonaGestionDePersonal().bajaMozo(this.vista.getMozo());
			} catch (DatosIncorrectosException e1) {
				e1.printStackTrace();
			}
			this.vista.actualizaComboBoxMozos(modelo.getMozos());
		}
		else if(e.getActionCommand().equals(IVista.SALIR_DE_MOZO)) {
			this.vista.cerrar();
			ControladorMenuOperarioAdministrador contMenu = new ControladorMenuOperarioAdministrador(tipoOperario);
		}
	}
}
