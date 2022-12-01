package testGUI;

import java.awt.Component;
import java.awt.Robot;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Controladores.ControladorLogin;

public class TestVentanaLoginPrimerIngreso
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
        TestUtils.tipeaTexto("ADMIN", robot);
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("ADMIN1234", robot);
        TestUtils.clickComponent(aceptarLog, robot);
        //verifico los resultados
        Assert.assertEquals("El nombre ingresado debe ser de un admin.", 0, controladorLogin.getTipoOperario());
    }
}