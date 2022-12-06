package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeDatos.Mesa;
import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaModificarMesa;

import excepciones.DatosIncorrectosException;

public class ControladorModificarMesa implements ActionListener{
	private VistaModificarMesa vista = null;
	private Sistema modelo;
	private int tipoOperario;
	private Mesa mesa;
	
	public ControladorModificarMesa(int tipoOperario, Mesa mesa) {
		this.vista = new VistaModificarMesa();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario;
		this.mesa = mesa;
		this.vista.setCampos(mesa);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.CONFIRMAR_MESA)) {
			if(!this.vista.getCantComensales().isEmpty()) {
				try{
					this.modelo.getZonaConfiguracionDeSistema().modificarMesa(this.mesa, Integer.parseInt(this.vista.getCantComensales()), this.vista.getEstado());
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
