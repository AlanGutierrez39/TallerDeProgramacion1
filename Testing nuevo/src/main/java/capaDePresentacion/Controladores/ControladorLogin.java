package capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import capaDeNegocios.Sistema;
import capaDePresentacion.Vistas.IVista;
import capaDePresentacion.Vistas.IVistaLogin;
import capaDePresentacion.Vistas.VistaLogin;

import excepciones.WrongPasswordException;
import excepciones.WrongUserException;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import persistencia.Utils;

public class ControladorLogin implements ActionListener, WindowListener
{
	private VistaLogin vista = new VistaLogin();;
	private Sistema modelo = Sistema.getInstance();
	private int tipoOperario;

	public ControladorLogin()
	{
		this.vista.addActionListener(this);
		this.vista.addWindowListener(this);
	}

	public VistaLogin getVista()
	{
		return vista;
	}

	public void setVista(VistaLogin vista)
	{
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals(IVista.INGRESAR))
		{
			try
			{

				tipoOperario = modelo.login(this.vista.getNombreUsuario(), this.vista.getPassword());
				if (tipoOperario == 0)
				{
					ControladorMenuOperarioAdministrador controladorMenu = new ControladorMenuOperarioAdministrador(
							tipoOperario); // Abre menu en caso de logeo exitoso
					this.vista.cerrar();
				} else if (tipoOperario == 1)
				{
					ControladorFacturacionYPedidos controladorMenuFact = new ControladorFacturacionYPedidos(
							tipoOperario); // Abre menu en caso de logeo exitoso
					this.vista.cerrar();
				}

			} catch (WrongUserException e1)
			{
				this.vista.usuarioIncorrecto("Usuario incorrecto");
				this.vista.passwordIncorrecto("");
			} catch (WrongPasswordException e2)
			{
				this.vista.usuarioIncorrecto("");
				this.vista.passwordIncorrecto("Password incorrecta");
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		// Escritura
		IPersistencia persistencia = new Persistencia();

		try
		{
			persistencia.abrirOutput("Sistema.bin");
			System.out.println("Crea archivo escritura");
			persistencia.escribir(Utils.sistemaDTOFromSistema());
			System.out.println("Sistema grabado correctamente");
			persistencia.cerrarOutput();
			System.out.println("Archivo cerrado");
		} catch (IOException e1)
		{
			System.out.println("Error, no se pudo persistir el archivo.");
		}
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

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
