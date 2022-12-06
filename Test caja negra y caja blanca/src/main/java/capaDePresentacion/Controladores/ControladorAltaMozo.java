package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaAltaMozo;

import excepciones.DatosIncorrectosException;


public class ControladorAltaMozo implements ActionListener{
	private VistaAltaMozo vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorAltaMozo(int tipoOperario) {
		this.vista = new VistaAltaMozo();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		if(e.getActionCommand().equals(IVista.CONFIRMAR_MOZO)) {
			if(!this.vista.getNombreYApel().isEmpty() && !this.vista.getDiaNac().isEmpty() && !this.vista.getMesNac().isEmpty() && !this.vista.getAnioNac().isEmpty() && !this.vista.getCantHijos().isEmpty() && !this.vista.getSueldo().isEmpty()) {
				try {
					this.modelo.getZonaGestionDePersonal().altaMozo(Integer.parseInt(this.vista.getCantHijos()), this.vista.getEstado(), Double.parseDouble(this.vista.getSueldo()), this.vista.getNombreYApel(), Integer.parseInt(this.vista.getAnioNac()), Integer.parseInt(this.vista.getMesNac()), Integer.parseInt(this.vista.getDiaNac()));
					this.vista.cerrar();
					ControladorABMMozo contABMmozo = new ControladorABMMozo(tipoOperario);
				}
				catch(DatosIncorrectosException e1) {
					this.vista.setLblError("Ingrese datos correctamente");
				}
			}
			else
				this.vista.setLblError("Ingrese datos correctamente");
		}
		else if(e.getActionCommand().equals(IVista.CANCELAR_MOZO)) {
			this.vista.cerrar();
			ControladorABMMozo contABMmozo = new ControladorABMMozo(tipoOperario);
		}
	}

	public boolean comparaEdad(int anio, int mes, int dia) {
		LocalDate fechaHoy = LocalDate.now();
		if(anio < fechaHoy.getYear() && mes <= 12 && mes >=1 && dia >= 1 && dia<=31) {
			LocalDate fechaNac = LocalDate.of(anio,mes,dia);
			if(Period.between(fechaNac, fechaHoy).getYears() >= 18) 
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
