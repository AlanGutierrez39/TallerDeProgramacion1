package testGUI;

import java.awt.Component;
import java.awt.Robot;
import java.io.IOException;

import javax.swing.JButton;

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

public class TestVentanaAdmin
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
        TestUtils.clickComponent(arrancarDia, robot);
        //verifico los resultados
        Assert.assertTrue("Deber\u00eda estar habilitado el bot\u00f3n si hay un mozo activo y 2 de Franco.", facturacion.isEnabled());
    }
	@Test
	public void testAsignarMozosA()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton asignarMozosA = (JButton) TestUtils.getComponentForName(ventana, "btnAsignarMozosA");
        TestUtils.clickComponent(asignarMozosA, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
	@Test
	public void testConfigurarEmpresa()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton configurarEmpresa = (JButton) TestUtils.getComponentForName(ventana, "btnConfigurarEmpresa");
        TestUtils.clickComponent(configurarEmpresa, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
	@Test
	public void testFacturacion()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
		JButton arrancarDia = (JButton) TestUtils.getComponentForName(ventana, "btnArrancarDia");
		JButton facturacion = (JButton) TestUtils.getComponentForName(ventana, "btnFacturacion");
        TestUtils.clickComponent(arrancarDia, robot);
        robot.delay(100*TestUtils.getDelay());
        TestUtils.clickComponent(facturacion, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
	@Test
	public void testMenuMozos()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton boton = (JButton) TestUtils.getComponentForName(ventana, "btnMenuMozos");
        TestUtils.clickComponent(boton, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
	@Test
	public void testMesas()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton boton = (JButton) TestUtils.getComponentForName(ventana, "btnMesas");
        TestUtils.clickComponent(boton, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
	@Test
	public void testOperarios()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton boton = (JButton) TestUtils.getComponentForName(ventana, "btnOperarios");
        TestUtils.clickComponent(boton, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
	@Test
	public void testProducto()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton boton = (JButton) TestUtils.getComponentForName(ventana, "btnProducto");
        TestUtils.clickComponent(boton, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
	@Test
	public void testPromocion()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton boton = (JButton) TestUtils.getComponentForName(ventana, "btnPromocion");
        TestUtils.clickComponent(boton, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
	@Test
	public void testPromocionTemporal()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton boton = (JButton) TestUtils.getComponentForName(ventana, "btnPromocionTemporal");
        TestUtils.clickComponent(boton, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
	@Test
	public void testVerificarEstadisticas()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton boton = (JButton) TestUtils.getComponentForName(ventana, "btnVerificarEstadisticas");
        TestUtils.clickComponent(boton, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
	@Test
	public void testSalir()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton salir = (JButton) TestUtils.getComponentForName(ventana, "btnSalir");
        TestUtils.clickComponent(salir, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
}