package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.modelmbean.ModelMBeanOperationInfo;

import capaDeDatos.Operario;
import capaDeDatos.OperarioAdministrador;
import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaAltaOperario;
import capaDePresentacion.Vistas.VistaAsignarEstadoMozo;

import excepciones.DatosIncorrectosException;

public class ControladorAsignarEstadoMozo implements ActionListener{
	private VistaAsignarEstadoMozo vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorAsignarEstadoMozo(int tipoOperario) {
		this.vista = new VistaAsignarEstadoMozo();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario;
		this.vista.actualizaComboBoxOperarios(modelo.getMozos());
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.GUARDAR_ESTADO_MOZO)) {
			try {
				this.modelo.getZonaGestionDePersonal().cambiarEstadoMozo(this.vista.getMozo(), this.vista.getEstado());
			} catch (DatosIncorrectosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.vista.actualizaComboBoxOperarios(modelo.getMozos());
		}
		if(e.getActionCommand().equals(IVista.ATRAS_ESTADO_MOZO)) {
			ControladorMenuOperarioAdministrador controladorMenu = new ControladorMenuOperarioAdministrador(tipoOperario); //Abre menu en caso de logeo exitoso
			this.vista.cerrar();
		}
	}

}
