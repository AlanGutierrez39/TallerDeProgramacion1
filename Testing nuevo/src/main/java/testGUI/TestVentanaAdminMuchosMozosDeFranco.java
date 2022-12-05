package testGUI;

import java.awt.Component;
import java.awt.Robot;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeNegocios.Sistema;
import capaDePresentacion.Controladores.ControladorMenuOperarioAdministrador;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import persistencia.SistemaDTO;
import persistencia.Utils;

public class TestVentanaAdminMuchosMozosDeFranco
{
	Robot robot;
	ControladorMenuOperarioAdministrador controlador;
	Sistema sistema;
	Component ventana;
	@Before
	public void setUp() throws Exception {
        robot = new Robot();
        controlador = new ControladorMenuOperarioAdministrador(0);
        sistema = Sistema.getInstance();
        ventana = (Component) controlador.getVista();
    }
	@Before
	public void testPersistencia()
    {
		IPersistencia persistencia = new Persistencia();
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
    }
	@After
    public void tearDown() throws Exception
    {
        controlador.getVista().setVisible(false);
    }
	@Test
	public void testArrancarDia()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton arrancarDia = (JButton) TestUtils.getComponentForName(ventana, "btnArrancarDia");
        JButton facturacion = (JButton) TestUtils.getComponentForName(ventana, "btnFacturacion");
        JLabel lblExcepcionInicioDia = (JLabel) TestUtils.getComponentForName(ventana, "lblExcepcionInicioDia");
        TestUtils.clickComponent(arrancarDia, robot);
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda estar deshabilitado el bot\u00f3n porque no hay mozos activos.", facturacion.isEnabled());
        Assert.assertEquals("Se necesitan 2 mozos de franco para iniciar el dia.", lblExcepcionInicioDia.getText());
    }
}