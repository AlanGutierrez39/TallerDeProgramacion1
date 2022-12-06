package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaAltaMesa;

import excepciones.DatosIncorrectosException;

public class ControladorAltaMesa implements ActionListener{
	private VistaAltaMesa vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorAltaMesa(int tipoOperario) {
		this.vista = new VistaAltaMesa();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.CONFIRMAR_MESA)) {
			if(!this.vista.getCantComensales().isEmpty()) {
				try{
					this.modelo.getZonaConfiguracionDeSistema().altaMesa(Integer.parseInt(this.vista.getCantComensales()), this.vista.getEstado());
					this.vista.cerrar();
					ControladorABMMesa contABMMesa = new ControladorABMMesa(tipoOperario);
				}
				catch(DatosIncorrectosException e1) {
					this.vista.setLblError(e1.getMessage());
				}
			}
		}
		else if(e.getActionCommand().equals(IVista.CANCELAR_MESA)) {
			this.vista.cerrar();
			ControladorABMMesa contABMMesa = new ControladorABMMesa(tipoOperario);
		}		
	}
}
