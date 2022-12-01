package cajaNegra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import capaDeNegocios.Sistema;
import excepciones.WrongPasswordException;
import excepciones.WrongUserException;

public class TestSistemaSinDatos {

	private Sistema sistema;
	private EscenariosistemaSinDatos esc = new EscenariosistemaSinDatos();
	
	@BeforeEach
	public void setUp() {
		this.esc.setUp();
		this.sistema=this.esc.getSistema();
	}

	@AfterEach
	public void tearDown() throws Exception {
		this.esc.tearDown();
	}

	@Test
	void testLoginIncorrecto5() {
		try {
			this.sistema.login("pepe", "999");
			Assert.fail("Deberia tirar excepcion");
		} catch (WrongUserException e) {
			System.out.println("bien");
		} catch (WrongPasswordException e) {
			Assert.fail("No deberia tirar esta excepcion");
		}
	}

}
