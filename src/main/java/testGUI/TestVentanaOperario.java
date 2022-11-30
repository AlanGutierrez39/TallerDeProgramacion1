package testGUI;

import java.awt.Component;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tallerDeProgra.capaDeDatos.Comanda;
import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Controladores.ControladorFacturacionYPedidos;

import persistencia.IPersistencia;
import persistencia.Persistencia;
import persistencia.SistemaDTO;
import persistencia.Utils;

public class TestVentanaOperario
{
	Robot robot;
	ControladorFacturacionYPedidos controlador;
	Sistema sistema;
	Component ventana;
	@Before
	public void setUp() throws Exception {
        robot = new Robot();
        controlador = new ControladorFacturacionYPedidos(0);
        sistema = Sistema.getInstance();
        ventana = (Component) controlador.getVista();
        controlador.setTipoOperario(1);
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
	public void testAgregarPedido()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JComboBox<Comanda> comboBox = (JComboBox<Comanda>) TestUtils.getComponentForName(ventana, "comboBoxComandas");
        JButton btnAgregarPedido = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPedido");
        TestUtils.clickComponent(comboBox, robot);
        robot.delay(TestUtils.getDelay());
        robot.mouseMove(TestUtils.getCentro(comboBox).x, TestUtils.getCentro(comboBox).y+20);
        robot.delay(TestUtils.getDelay());
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(TestUtils.getDelay());
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(TestUtils.getDelay());
        robot.mouseMove(TestUtils.getCentro(btnAgregarPedido).x, TestUtils.getCentro(btnAgregarPedido).y);
        TestUtils.clickComponent(btnAgregarPedido, robot);
        //verifico los resultados
        Assert.assertTrue("Deber\u00eda estar habilitado el bot\u00f3n porque la lista de comandas tiene al menos una comanda.", btnAgregarPedido.isEnabled());
    }
	@Test
	public void testCerrarComanda()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JComboBox<Comanda> comboBox = (JComboBox<Comanda>) TestUtils.getComponentForName(ventana, "comboBoxComandas");
        JButton btnCerrarComanda = (JButton) TestUtils.getComponentForName(ventana, "btnCerrarComanda");
        TestUtils.clickComponent(comboBox, robot);
        robot.delay(TestUtils.getDelay());
        robot.mouseMove(TestUtils.getCentro(comboBox).x, TestUtils.getCentro(comboBox).y+20);
        robot.delay(TestUtils.getDelay());
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(TestUtils.getDelay());
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(TestUtils.getDelay());
        robot.mouseMove(TestUtils.getCentro(btnCerrarComanda).x, TestUtils.getCentro(btnCerrarComanda).y);
        TestUtils.clickComponent(btnCerrarComanda, robot);
        //verifico los resultados
        Assert.assertTrue("Deber\u00eda estar habilitado el bot\u00f3n porque la lista de comandas tiene al menos una comanda.", btnCerrarComanda.isEnabled());
    }
	@Test
	public void testConfeccionarComanda()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton btnConfeccionarComanda = (JButton) TestUtils.getComponentForName(ventana, "btnConfeccionarComanda");
        //lleno los JTextField
        TestUtils.clickComponent(btnConfeccionarComanda, robot);
        robot.delay(100*TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("Deber\u00eda cambiar de ventana", controlador.getVista().isVisible());
    }
	@Test
	public void testAtras()
    {
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton boton = (JButton) TestUtils.getComponentForName(ventana, "btnAtras");
        //lleno los JTextField
        TestUtils.clickComponent(boton, robot);
        //verifico los resultados
        Assert.assertEquals("Deber\u00eda estar en la ventana login", 1, controlador.getTipoOperario());
    }
}