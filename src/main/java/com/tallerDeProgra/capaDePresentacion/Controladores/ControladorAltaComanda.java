package com.tallerDeProgra.capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import com.tallerDeProgra.capaDeDatos.Comanda;
import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Vistas.IVista;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaAltaComanda;

import excepciones.DatosIncorrectosException;

public class ControladorAltaComanda implements ActionListener{
	private VistaAltaComanda vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorAltaComanda(int tipoOperario) {
		this.vista = new VistaAltaComanda();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.vista.actualizaComboBoxMesas(modelo.getMesas());
		this.tipoOperario = tipoOperario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Comanda comanda= new Comanda();
		if(e.getActionCommand().equals(IVista.SIGUIENTE_COMANDA)) {
			comanda.setMesa(this.vista.getMesa());
			comanda.setFecha(new Date());
			try {
				modelo.getZonaPedidosYFacturacion().altaComanda(comanda);
			} catch (DatosIncorrectosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ControladorAltaPedido controladorAltapedido= new ControladorAltaPedido(tipoOperario,comanda,true);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.ATRAS_SIGUIENTE_COMANDA)) {
			ControladorFacturacionYPedidos controladorFacturacion= new ControladorFacturacionYPedidos(tipoOperario);
			
			this.vista.cerrar();

		}
	}
	
}
