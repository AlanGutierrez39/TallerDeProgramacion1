package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import capaDeDatos.Mozo;
import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaModificarMozo;

import excepciones.DatosIncorrectosException;


public class ControladorModificarMozo implements ActionListener{
	private VistaModificarMozo vista = null;
	private Sistema modelo;
	private Mozo mozo;
	
	public ControladorModificarMozo(Mozo mozo) {
		this.vista = new VistaModificarMozo();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.mozo = mozo;
		this.vista.setCampos(mozo);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		if(e.getActionCommand().equals(IVista.CONFIRMAR_MOZO)) {
			if(!this.vista.getNombreYApel().isEmpty() && !this.vista.getDiaNac().isEmpty() && !this.vista.getMesNac().isEmpty() && !this.vista.getAnioNac().isEmpty() && !this.vista.getCantHijos().isEmpty() && !this.vista.getSueldo().isEmpty()) {
				try {
					this.modelo.getZonaGestionDePersonal().modificarMozo(mozo.getId(), Integer.parseInt(this.vista.getCantHijos()), this.vista.getEstado(), Double.parseDouble(this.vista.getSueldo()), this.vista.getNombreYApel(), Integer.parseInt(this.vista.getAnioNac()),Integer.parseInt(this.vista.getMesNac()), Integer.parseInt(this.vista.getDiaNac()));
					this.vista.cerrar();
					ControladorABMMozo contABMmozo = new ControladorABMMozo(0);
				}
				catch(DatosIncorrectosException e1) {
					this.vista.setLblError("Ingrese datos correctamente");
				}			
			}
			else
				this.vista.setLblError("Ingrese datos correctamente");
		}
		else if (e.getActionCommand().equals(IVista.CANCELAR_MOZO)) {
			this.vista.cerrar();
			ControladorABMMozo contABMMozo = new ControladorABMMozo(0);
		}
	}
}
