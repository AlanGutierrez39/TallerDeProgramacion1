package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import capaDeDatos.Operario;
import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.VistaAltaOperario;
import capaDePresentacion.Vistas.VistaModificarOperario;

import excepciones.DatosIncorrectosException;

public class ControladorModificarOperario implements ActionListener {
	private VistaModificarOperario vista = null;
	private Sistema modelo;
	private int tipoOperario;
	private Operario operario;
	
	public ControladorModificarOperario(int tipoOperario, Operario operario) {
		this.vista = new VistaModificarOperario();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.tipoOperario = tipoOperario;
		this.operario = operario;
		this.vista.setCampos(operario);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.CONFIRMAR_OPERARIO)) {
			if(!this.vista.getNombre().isEmpty() && !this.vista.getNombreUsuario().isEmpty() && !this.vista.getPassword().isEmpty()) {
				try {
					modelo.getZonaGestionDePersonal().modificacionOperario(operario.getNombreDeUsuario(), this.vista.getNombreUsuario(), this.vista.getPassword(), this.vista.getActivo());
					this.vista.cerrar();
					ControladorABMOperario contABMOperario = new ControladorABMOperario(0);	//si llega a este punto siempre es operarioAdmin -> tipoOperario = 0
				}catch(DatosIncorrectosException e1) {
					this.vista.setLabelInforma("Complete los datos correctamente");
				}
			}else {
				this.vista.setLabelInforma("Complete los datos correctamente");
			}
		}
		else if(e.getActionCommand().equals(IVista.CANCELAR_OPERARIO)) {
			this.vista.cerrar();
			ControladorABMOperario contABMOperario = new ControladorABMOperario(0);	//si llega a este punto siempre es operarioAdmin -> tipoOperario = 0
		}
	}
}
