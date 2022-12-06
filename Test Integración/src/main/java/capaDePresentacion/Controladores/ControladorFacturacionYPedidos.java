package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeDatos.Comanda;
import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaAsignarEstadoMozo;
import capaDePresentacion.Vistas.VistaFacturacionYPedidos;
import enums.EstadoComanda;

public class ControladorFacturacionYPedidos implements ActionListener{
	private VistaFacturacionYPedidos vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	
	public ControladorFacturacionYPedidos(int tipoOperario) {
		this.vista = new VistaFacturacionYPedidos();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		if(modelo.getComandas()!=null)
			this.vista.actualizaComboBoxComandas(modelo.getComandas());
		this.tipoOperario = tipoOperario;
		if(modelo.getComandas()==null || modelo.getComandas().isEmpty()) {
			this.vista.habilitarCerrarComanda(false);
			this.vista.habilitarPedido(false);
		}
	}
	
	public VistaFacturacionYPedidos getVista()
	{
		return vista;
	}

	public Sistema getModelo()
	{
		return modelo;
	}

	public int getTipoOperario()
	{
		return tipoOperario;
	}

	public void setTipoOperario(int tipoOperario)
	{
		this.tipoOperario = tipoOperario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.MODIFICACION_LISTA_PRODUCTOS)) {
			
		}
		if(e.getActionCommand().equals(IVista.CREAR_COMANDA)) {
			ControladorAltaComanda controladorAltacom= new ControladorAltaComanda(tipoOperario);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.CERRAR_COMANDA)) {
			ControladorCerrarComanda controladorComanda= new ControladorCerrarComanda(tipoOperario,this.vista.getComanda());
			
		}
		if(e.getActionCommand().equals(IVista.AGREGAR_PEDIDO)) {
			ControladorAltaPedido controladorAltaPedido= new ControladorAltaPedido(tipoOperario, this.vista.getComanda(),false);	
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.ATRAS_COMANDA)) {
			ControladorMenuOperarioAdministrador controladorMenu = null;
			ControladorLogin controladorLogin = null;
			if (this.tipoOperario==0)
				controladorMenu = new ControladorMenuOperarioAdministrador(tipoOperario); 
			else
				controladorLogin = new ControladorLogin();
			this.vista.cerrar();
		}
	}
}
