package cajaBlanca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import capaDeDatos.Mesa;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.Sistema;
import excepciones.DatosIncorrectosException;

public class TestAltaMesa {
	private ConfiguracionDeSistema config = ConfiguracionDeSistema.getInstance();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void camino1() {
		try {
			config.altaMesa(3, null);
			Sistema.getInstance().getMesas().clear();
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			Sistema.getInstance().getMesas().clear();
			System.out.println("bien");
		}
	}

	@Test
	void camino2() {
		try {
			Sistema.getInstance().getMesas().clear();
			config.altaMesa(3, "Libre");
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Sistema.getInstance().getMesas().clear();
			Assert.fail("No Deberia tirar excepcion");
		}
	}
	
	@Test
	void camino3() {
		try {
			Sistema.getInstance().getMesas().add(new Mesa(4,"Libre"));
			config.altaMesa(3, "Libre");
			System.out.println("bien");
			Sistema.getInstance().getMesas().clear();
		} catch (DatosIncorrectosException e) {
			Sistema.getInstance().getMesas().clear();
			Assert.fail("No Deberia tirar excepcion");
		}
	}
	
	@Test
	void camino4() {
		try {
			Sistema.getInstance().getMesas().add(new Mesa(4,"Libre"));
			config.altaMesa(0, "Libre");
			Sistema.getInstance().getMesas().clear();
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			Sistema.getInstance().getMesas().clear();
			
		}
	}
	
	
}
