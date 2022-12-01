package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaABMPromocionTemporal;

import excepciones.DatosIncorrectosException;

public class ControladorABMPromocionTemporal implements ActionListener{
	
	private VistaABMPromocionTemporal vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorABMPromocionTemporal(int tipoOperario) {
		this.vista = new VistaABMPromocionTemporal();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario; 
		this.vista.actualizaComboBoxPromocionTemporal(modelo.getPromocionesTemporales());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.AGREGAR_PROMOCION_TEMPORAL)) {
			ControladorAltaPromocionTemporal controladorAltaProm = new ControladorAltaPromocionTemporal(this.tipoOperario);
			this.vista.cerrar();
		}
		else if(e.getActionCommand().equals(IVista.ELIMINAR_PROMOCION_TEMPORAL)) {
			try {
				modelo.getZonaPedidosYFacturacion().bajaPromocionTemporal(vista.getPromocionTemporal());
			} catch (DatosIncorrectosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.vista.actualizaComboBoxPromocionTemporal(modelo.getPromocionesTemporales());
		}
		else if(e.getActionCommand().equals(IVista.SALIR_DE_PROMOCION_TEMPORAL)) {
			ControladorMenuOperarioAdministrador controladorMenu = new ControladorMenuOperarioAdministrador(tipoOperario); //Abre menu en caso de logeo exitoso
			this.vista.cerrar();
		}
		
	}

}
