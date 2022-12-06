package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaConfiguracionEmpresa;

public class ControladorConfiguracionEmpresa implements ActionListener{
	private VistaConfiguracionEmpresa vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	
	public ControladorConfiguracionEmpresa(int tipoOperario) {
		this.vista = new VistaConfiguracionEmpresa();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario=tipoOperario;
		this.vista.setSueldo(modelo.getLocal().getSueldo().toString());
		this.vista.setNombre(modelo.getLocal().getNombre());
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.MODIFICAR_SUELDO_EMPRESA)) {
			this.modelo.getLocal().setSueldo(this.vista.getSueldo());
			this.vista.setSueldo(modelo.getLocal().getSueldo().toString());
		}
		if(e.getActionCommand().equals(IVista.MODIFICAR_NOMBRE_EMPRESA)) {
			this.modelo.getLocal().setNombre(this.vista.getNombre());
			this.vista.setNombre(modelo.getLocal().getNombre());
			
		}
		if(e.getActionCommand().equals(IVista.ATRAS_EMPRESA)) {
			ControladorMenuOperarioAdministrador controladorMenu = new ControladorMenuOperarioAdministrador(tipoOperario); //Abre menu en caso de logeo exitoso
			this.vista.cerrar();
		}
	}

}
