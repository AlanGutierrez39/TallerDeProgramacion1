package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaAltaPromocion;

import excepciones.DatosIncorrectosException;

public class ControladorAltaPromocion implements ActionListener{
	private VistaAltaPromocion vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorAltaPromocion(int tipoOperario) {
		this.vista = new VistaAltaPromocion();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario; 
		this.vista.actualizaComboBoxProductos(modelo.getProductos());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.AGREGAR_PROMOCION)) {
			try {
				this.modelo.getZonaPedidosYFacturacion().altaPromocion(vista.getProducto(),vista.getDiasDePromo(),vista.getAplicaDosporuno(),vista.getAplicaDescCantidadMinima(),Integer.parseInt(vista.getCantidadMinima()),Float.parseFloat(vista.getPrecioUnitario()));
			} catch (NumberFormatException | DatosIncorrectosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ControladorABMPromocion controladorMenu = new ControladorABMPromocion(tipoOperario); //Abre menu en caso de logeo exitoso
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.CANCELAR_PROMOCION)) {
			ControladorABMPromocion controladorMenu = new ControladorABMPromocion(tipoOperario); //Abre menu en caso de logeo exitoso
			this.vista.cerrar();
		}
		
	}
}
