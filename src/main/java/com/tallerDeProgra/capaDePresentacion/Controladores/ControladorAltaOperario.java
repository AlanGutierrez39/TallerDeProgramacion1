package com.tallerDeProgra.capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tallerDeProgra.capaDeDatos.Operario;
import com.tallerDeProgra.capaDeDatos.OperarioAdministrador;
import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Vistas.IVista;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaAltaOperario;

import excepciones.DatosIncorrectosException;

public class ControladorAltaOperario implements ActionListener {
	private VistaAltaOperario vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorAltaOperario(int tipoOperario) {
		this.vista = new VistaAltaOperario();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.CONFIRMAR_OPERARIO)) {
			if(!this.vista.getNombre().isEmpty() && !this.vista.getNombreUsuario().isEmpty() && !this.vista.getPassword().isEmpty()) {
					try {
						modelo.getZonaGestionDePersonal().altaOperario(this.vista.getNombreUsuario(), this.vista.getPassword(), this.vista.getActivo());
						this.vista.cerrar();
						ControladorABMOperario contABMOperario = new ControladorABMOperario(0);	//si llega a este punto siempre es operarioAdmin -> tipoOperario = 0
					} catch (DatosIncorrectosException e1) {
						this.vista.setLabelInforma("Complete los datos correctamente");
					}
			}else {
				this.vista.setLabelInforma("Complete los datos correctamente");
			}
		}
		else if(e.getActionCommand().equals(IVista.CANCELAR_OPERARIO)) {
			this.vista.cerrar();
			ControladorABMOperario contABMOperario = new ControladorABMOperario(0);	//si llega a este punto siempre es operarioAdmin -> tipoOperario = 0
		}
	}
}
