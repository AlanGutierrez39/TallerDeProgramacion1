package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeDatos.Comanda;
import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaCerrarComanda;

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
