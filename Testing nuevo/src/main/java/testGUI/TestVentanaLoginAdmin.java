package testGUI;

import java.awt.Component;
import java.awt.Robot;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeNegocios.Sistema;
import capaDePresentacion.Controladores.ControladorLogin;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import persistencia.SistemaDTO;
import persistencia.Utils;

public class TestVentanaLoginAdmin
{
	Robot robot;
	ControladorLogin controladorLogin;
	Sistema sistema;
	@Before
	public void setUp() throws Exception {
        robot = new Robot();
        controladorLogin = new ControladorLogin();
        sistema = Sistema.getInstance(); 
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
        controladorLogin.getVista().setVisible(false);
    }
	@Test
	public void testLogin()
    {
		Component ventana = (Component) controladorLogin.getVista();
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "textField_Nombre");
        JTextField contrasena = (JTextField) TestUtils.getComponentForName(ventana, "textField_Contrasenia");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(ventana, "btnIngresar");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("G", robot);
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("H", robot);
        TestUtils.clickComponent(aceptarLog, robot);
        //verifico los resultados
        Assert.assertEquals("El nombre ingresado debe ser de un admin.", 0, controladorLogin.getTipoOperario());
    }
}