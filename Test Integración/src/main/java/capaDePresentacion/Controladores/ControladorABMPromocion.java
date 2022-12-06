package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaABMPromocion;

import excepciones.DatosIncorrectosException;

public class ControladorABMPromocion implements ActionListener{
	private VistaABMPromocion vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorABMPromocion(int tipoOperario) {
		this.vista = new VistaABMPromocion();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.vista.actualizaComboBoxPromocion(modelo.getPromociones());
		this.tipoOperario = tipoOperario; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.AGREGAR_PROMOCION)) {
			ControladorAltaPromocion controladorAltaProm = new ControladorAltaPromocion(this.tipoOperario);
			this.vista.cerrar();
			
		}
		else if(e.getActionCommand().equals(IVista.ELIMINAR_PROMOCION)) {
			try {
				modelo.getZonaPedidosYFacturacion().bajaPromocion(vista.getPromocion());
			} catch (DatosIncorrectosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.vista.actualizaComboBoxPromocion(modelo.getPromociones());
		}
		else if(e.getActionCommand().equals(IVista.SALIR_DE_PROMOCION)) {
			ControladorMenuOperarioAdministrador controladorMenu = new ControladorMenuOperarioAdministrador(tipoOperario); 
			this.vista.cerrar();
		}
		
	}

}
