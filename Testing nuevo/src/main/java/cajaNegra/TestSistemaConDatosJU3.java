package cajaNegra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import capaDeNegocios.Sistema;
import excepciones.WrongPasswordException;
import excepciones.WrongUserException;

public class TestSistemaConDatosJU3 {
	private Sistema sistema;
	private EscenarioSistemaConDatos esc = new EscenarioSistemaConDatos();
	
	@Before
	public void setUp() {
		this.esc.setUp();
		this.sistema=this.esc.getSistema();
	}

	@After
	public void tearDown() throws Exception {
		this.esc.tearDown();
	}

	@Test
	public void testLoginOperarioCorrecto() {
		try {
			Assert.assertEquals(this.sistema.login("abc", "123"), 0);	
			System.out.println("bien");
		} catch (WrongUserException e) {
			Assert.fail("No deberia lanzarse excepcion");
		} catch (WrongPasswordException e) {
			Assert.fail("No deberia lanzarse excepcion");
		}
	}
	
	@Test
	public void testLoginOperarioAdminCorrecto() {
		try {
			Assert.assertEquals(this.sistema.login("def", "456"), 1);	
			System.out.println("bien");
		} catch (WrongUserException e) {
			Assert.fail("No deberia lanzarse excepcion");
		} catch (WrongPasswordException e) {
			Assert.fail("No deberia lanzarse excepcion");
		}
	}
	
	@Test
	public void testLoginIncorrecto1() {
		try {
			this.sistema.login(null, null);
			Assert.fail("No deberia continuar la ejecucion");
		} catch (WrongUserException e) {
			Assert.fail("No deberia lanzarse excepcion");
		} catch (WrongPasswordException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	public void testLoginIncorrecto2() {
		try {
			this.sistema.login("def", "incorrecta");
			Assert.fail("No deberia continuar la ejecucion");
		} catch (WrongUserException e) {
			Assert.fail("No deberia lanzarse excepcion");
		} catch (WrongPasswordException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	public void testLoginIncorrecto3() {
		try {
			this.sistema.login("abc", "incorrecta");
			Assert.fail("No deberia continuar la ejecucion");
		} catch (WrongUserException e) {
			Assert.fail("No deberia lanzarse excepcion");
		} catch (WrongPasswordException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	public void testLoginIncorrecto4() {
		try {
			this.sistema.login("pepe", "999");
			Assert.fail("No deberia continuar la ejecucion");
		} catch (WrongUserException e) {
			System.out.println("bien");
		} catch (WrongPasswordException e) {
			Assert.fail("No deberia lanzarse excepcion");
		}
	}
	
	

}
