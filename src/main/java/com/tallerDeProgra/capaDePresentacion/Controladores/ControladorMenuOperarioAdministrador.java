package com.tallerDeProgra.capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Vistas.IVista;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaMenuOperarioAdministrador;

import excepciones.CantidadInsuficienteActivosException;
import excepciones.DemasiadosMozosDeFrancoException;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import persistencia.Utils;

public class ControladorMenuOperarioAdministrador implements ActionListener, WindowListener{
	private VistaMenuOperarioAdministrador vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	public ControladorMenuOperarioAdministrador(int tipoOperario) {
		this.vista = new VistaMenuOperarioAdministrador();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.vista.addWindowListener(this);
		this.tipoOperario=tipoOperario;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.ARRANCAR_DIA)) {
			try {
				modelo.ArrancarDia();
				this.vista.habilitarFacturacion();
			} catch (DemasiadosMozosDeFrancoException | CantidadInsuficienteActivosException e1) {
				this.vista.lanzarExcepcionInicioDia(e1.getMessage());
			}
		}
		if(e.getActionCommand().equals(IVista.ASIGNAR_MOZO)) {
			ControladorAsignarEstadoMozo controladorAsignarEstadoMozo= new ControladorAsignarEstadoMozo(tipoOperario);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.VERIFICAR_ESTADISTICAS)) {
			ControladorEstadisticas controladorestadisticas= new ControladorEstadisticas(tipoOperario);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.CONFIGURAR_EMPRESA)) {
			ControladorConfiguracionEmpresa controladorConfiguracion= new ControladorConfiguracionEmpresa(tipoOperario);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.OPERARIOS)) {
			ControladorABMOperario controladorABMOp= new ControladorABMOperario(tipoOperario);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.MESAS)) {
			ControladorABMMesa controladorABMmesas = new ControladorABMMesa(tipoOperario);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.PRODUCTO)) {
			ControladorABMProducto controladorABMProd = new ControladorABMProducto(tipoOperario);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.PROMOCION)) {
			ControladorABMPromocion controladorABMprom= new ControladorABMPromocion(tipoOperario);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.PROMOCION_TEMPORAL)) {
			ControladorABMPromocionTemporal controladorABMpromtemp= new ControladorABMPromocionTemporal(tipoOperario);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.MOZOS)) {
			ControladorABMMozo controladorABMMozo = new ControladorABMMozo(tipoOperario);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.FACTURACION)) {
			ControladorFacturacionYPedidos controladorFacturacion= new ControladorFacturacionYPedidos(tipoOperario);
			this.vista.cerrar();		
		}
		if(e.getActionCommand().equals(IVista.SALIR)) {
			ControladorLogin controladorLogin= new ControladorLogin();
			this.vista.cerrar();
		}
		
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		//Escritura
		IPersistencia persistencia = new Persistencia();
		
		try {
			persistencia.abrirOutput("Sistema.bin");
			System.out.println("Crea archivo escritura");
			persistencia.escribir(Utils.sistemaDTOFromSistema());
			System.out.println("Sistema grabado correctamente");
			persistencia.cerrarOutput();
			System.out.println("Archivo cerrado");
		}catch (IOException e1) {
			System.out.println("Error, no se pudo persistir el archivo.");
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public VistaMenuOperarioAdministrador getVista()
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
	
}
