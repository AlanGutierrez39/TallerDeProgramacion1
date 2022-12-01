package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaAltaPromocionTemporal;

import excepciones.DatosIncorrectosException;

public class ControladorAltaPromocionTemporal implements ActionListener{
	private VistaAltaPromocionTemporal vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorAltaPromocionTemporal(int tipoOperario) {
		this.vista = new VistaAltaPromocionTemporal();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.AGREGAR_PROMOCION_TEMPORAL)) {
			try {
				this.modelo.getZonaPedidosYFacturacion().altaPromocionTemporal(vista.getNombre(),vista.getFormaDePago(),Integer.parseInt(vista.getPorcentajeDescuento()),vista.getDiasDePromo(),vista.getEsAcumulable());
			} catch (NumberFormatException | DatosIncorrectosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ControladorABMPromocionTemporal controladorMenu = new ControladorABMPromocionTemporal(tipoOperario); 
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.CANCELAR_PROMOCION_TEMPORAL)) {
			ControladorABMPromocionTemporal controladorMenu = new ControladorABMPromocionTemporal(tipoOperario); 
			this.vista.cerrar();
		}
		
	}
}
