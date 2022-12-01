package prueba;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import capaDeDatos.Local;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.OperarioAdministrador;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Sistema;
import capaDePresentacion.Controladores.ControladorABMOperario;
import capaDePresentacion.Controladores.ControladorLogin;
import enums.Estado;
import enums.EstadosMesa;

import excepciones.DatosIncorrectosException;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import persistencia.SistemaDTO;
import persistencia.Utils;

public class App
{
	public static void main(String[] args)
	{
		IPersistencia persistencia = new Persistencia();

		// Lectura
		 try
		{
			persistencia.abrirInput("Sistema.bin");
			System.out.println("Archivo abierto");
			SistemaDTO sistemaDTO = (SistemaDTO) persistencia.leer();
			Utils.sistemaFromSistemaDTO(sistemaDTO);
			System.out.println("Sistema recuperado");
			persistencia.cerrarInput();
			System.out.println("Archivo cerrado"); 
		} catch (IOException | ClassNotFoundException e)
		{
			System.out.println("Error");
		}

	/*	Date fecha = new Date(80, 5, 3); 
		Local local = new Local("Coca Cola Company", (float) 500.0);
		Sistema.getInstance().setLocal(local);
		Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador("G", "H", true);
		Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador("H", "G", true);
		Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador("g", "h", true);
		Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador("h", "g", true);
		Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador("I", "J", true);
		Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador("K", "L", true);
		try
		{
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaProducto("CocaCola", 30, 50, 10);
		} catch (DatosIncorrectosException e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try
		{
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario("A", "Imanol1", true);
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario("C", "Imanol1", true);
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario("E", "Imanol1", true);
		} catch (DatosIncorrectosException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaMesa(5, EstadosMesa.LIBRE.getEstado());
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaMesa(2, EstadosMesa.LIBRE.getEstado());
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaMesa(3, EstadosMesa.OCUPADA.getEstado());
		} catch (DatosIncorrectosException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} */
		/* try
		{
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(1, Estado.ACTIVO.getEstado(), 200, "Mozo 4", 80,
					5, 3);
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(2, Estado.ACTIVO.getEstado(), 200, "Mozo 5",
					80, 5, 3);
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(0, Estado.ACTIVO.getEstado(), 200, "Mozo 6", 80,
					5, 3);
		} catch (DatosIncorrectosException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		

		/*
		 * try { System.out.println(Sistema.getInstance().login("Y", "B")); } catch
		 * (WrongUserException e) { System.out.println(e.getMessage()); }
		 * catch(WrongPasswordException e) { System.out.println(e.getMessage()); }
		 */
		ControladorLogin controlador = new ControladorLogin();
		// ControladorABMOperario controlador = new ControladorABMOperario();

	}
}