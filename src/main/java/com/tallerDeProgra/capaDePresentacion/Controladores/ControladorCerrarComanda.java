package com.tallerDeProgra.capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tallerDeProgra.capaDeDatos.Comanda;
import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Vistas.IVista;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaCerrarComanda;

import excepciones.DatosIncorrectosException;
public class ControladorCerrarComanda implements ActionListener{
	private VistaCerrarComanda vista = null;
	private Sistema modelo;
	private int tipoOperario;
	private Comanda comanda;
	
	public ControladorCerrarComanda(int tipoOperario, Comanda comanda) {
		this.vista = new VistaCerrarComanda();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario=tipoOperario;
		this.comanda=comanda;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.CERRAR_COMANDA)) {
			try {
				modelo.getZonaPedidosYFacturacion().cerrarComanda(comanda,vista.getFormaDePago());
			} catch (DatosIncorrectosException e1) {
				e1.printStackTrace();
			}
		}
	}

}
