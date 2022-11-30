package com.tallerDeProgra.capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Vistas.IVista;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaEstadisticas;

import excepciones.DatosIncorrectosException;

public class ControladorEstadisticas implements ActionListener{
	private VistaEstadisticas vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorEstadisticas(int tipoOperario) {
		this.vista = new VistaEstadisticas();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario=tipoOperario;
		try {
			this.vista.setLabelMayor(modelo.getZonaConfiguracionDeSistema().mayorVolumen());
		} catch (DatosIncorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.vista.setLabelMenor(modelo.getZonaConfiguracionDeSistema().menorVolumen());
		} catch (DatosIncorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.vista.actualizaComboBoxOperarios(modelo.getMozos());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Float promedio = null;
		if(e.getActionCommand().equals(IVista.MODIFICACION_LISTA_ESTADISTICA)) {
			try {
				promedio= modelo.getZonaConfiguracionDeSistema().promedio(this.vista.getMozo());
			} catch (DatosIncorrectosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.vista.setLabelPromedio(promedio.toString());
		}
		if(e.getActionCommand().equals(IVista.ATRAS_ESTADISTICAS)) {
			ControladorMenuOperarioAdministrador controladorMenu = new ControladorMenuOperarioAdministrador(tipoOperario); //Abre menu en caso de logeo exitoso
			this.vista.cerrar();
		}
	}

}
