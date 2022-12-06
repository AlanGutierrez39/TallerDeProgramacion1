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

public class TestModificarMesa {
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
			config.modificarMesa(null, 3, null);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void camino2() {
		try {
			Mesa mesa = new Mesa(4,"Libre");
			mesa.setId(4);
			config.modificarMesa(mesa, 0, "Libre");
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void camino3() {
		try {
			Mesa mesa = new Mesa(4,"Libre");
			mesa.setId(4);
			Sistema.getInstance().getMesas().clear();
			Sistema.getInstance().getMesas().add(mesa);
			config.modificarMesa(mesa, 3, "Libre");
			Sistema.getInstance().getMesas().clear();
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No Deberia tirar la excepcion "+ e.getMessage());	
		}
	}
	
	@Test
	void camino4() {
		try {
			Mesa mesa = new Mesa(4,"Libre");
			mesa.setId(0);
			Sistema.getInstance().getMesas().add(mesa);
			config.modificarMesa(mesa, 3, "Libre");
			Sistema.getInstance().getMesas().clear();
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No Deberia tirar excepcion");	
		}
	}
	

	
	@Test
	void camino5() {
		try {
			Sistema.getInstance().getMesas().add(new Mesa(3,"Libre"));
			Sistema.getInstance().getMesas().add(new Mesa(3,"Libre"));
			Sistema.getInstance().getMesas().add(new Mesa(3,"Libre"));
			
			Mesa mesa = new Mesa(4,"Libre");
			mesa.setId(5);
			Sistema.getInstance().getMesas().add(mesa);
			config.modificarMesa(mesa, 3, "Libre");
			Sistema.getInstance().getMesas().clear();
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No Deberia tirar excepcion");	
		}
	}
	
	@Test
	void camino6() {
		try {
			Sistema.getInstance().getMesas().add(new Mesa(3,"Libre"));
			Sistema.getInstance().getMesas().add(new Mesa(3,"Libre"));
			Sistema.getInstance().getMesas().add(new Mesa(3,"Libre"));
			
			Mesa mesa = new Mesa(4,"Libre");
			mesa.setId(0);
			Sistema.getInstance().getMesas().add(mesa);
			config.modificarMesa(mesa, 3, "Libre");
			Sistema.getInstance().getMesas().clear();
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No Deberia tirar excepcion");	
		}
	}
}
