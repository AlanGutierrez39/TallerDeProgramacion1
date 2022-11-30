package com.tallerDeProgra.capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tallerDeProgra.capaDeDatos.OperarioAdministrador;
import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Vistas.IVista;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaABMOperario;

public class ControladorABMOperario implements ActionListener {
	private VistaABMOperario vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorABMOperario(int tipoOperario) {
		this.vista = new VistaABMOperario();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.vista.actualizaComboBoxOperarios(modelo.getOperarios(), modelo.getOperariosAdministradores());
		this.tipoOperario = tipoOperario; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.AGREGAR_OPERARIO)) {
			this.vista.cerrar();
			ControladorAltaOperario controladorAltaOp = new ControladorAltaOperario(this.tipoOperario);
		}
		else if(e.getActionCommand().equals(IVista.MODIFICAR_OPERARIO)) {
			this.vista.cerrar();
			ControladorModificarOperario controladorModifOp = new ControladorModificarOperario(tipoOperario, this.vista.getOperario());
		}
		else if(e.getActionCommand().equals(IVista.ELIMINAR_OPERARIO)) {
			if(this.vista.getOperario().getTipoOperario() == 1)
				modelo.getOperarios().remove(this.vista.getOperario());
			else
				modelo.getOperariosAdministradores().remove(this.vista.getOperario());
			this.vista.actualizaComboBoxOperarios(modelo.getOperarios(), modelo.getOperariosAdministradores());
		}
		else if(e.getActionCommand().equals(IVista.SALIR_DE_OPERARIO)) {
			this.vista.cerrar();
			ControladorMenuOperarioAdministrador contMenu = new ControladorMenuOperarioAdministrador(tipoOperario);
			
		}
	}
}