package cajaNegra;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import capaDeDatos.Comanda;
import capaDeDatos.Producto;
import capaDeNegocios.PedidosFacturacionYPromociones;
import excepciones.DatosIncorrectosException;

public class TestPedidosFacturacionYPromociones {
	private PedidosFacturacionYPromociones ped = new PedidosFacturacionYPromociones();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void cerrarComandaValido() {
		try {
			Comanda comanda = new Comanda();
			comanda.setEstado("Ocupada");
			ped.cerrarComanda(comanda, "Efectivo");
			System.out.println("bien");
		} catch (Exception e) {
			Assert.fail("No deberia tirar excepcion");
		} 
	}
	
	@Test
	void cerrarComandaNull() {
		try {
			ped.cerrarComanda(null, "Efectivo");
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void cerrarComandaMetodoNull() {
		try {
			ped.cerrarComanda(new Comanda(), null);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaComandaValido() {
		try {
			ped.altaComanda(new Comanda());
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion "+ e.getMessage());
		}
	}
	

	@Test
	void altaComandaNull() {
		try {
			ped.altaComanda(null);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaPromocionValido() {
		ArrayList<String> dias = new ArrayList<String>();
		dias.add("Lunes");
		try {
			ped.altaPromocion(new Producto("Arroz",50,100,35), dias, true, false, 10, 50);
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	void altaPromocionProductoNull() {
		ArrayList<String> dias = new ArrayList<String>();
		dias.add("Lunes");
		try {
			ped.altaPromocion(null, dias, true, false, 10, 50);
			Assert.fail("Dberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaPromocionArrayNull() {
		try {
			ped.altaPromocion(new Producto("Arroz",50,100,35), null, true, false, 10, 50);
			Assert.fail("Dberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaPromocionArrayVacio() {
		ArrayList<String> dias = new ArrayList<String>();
		try {
			ped.altaPromocion(new Producto("Arroz",50,100,35), dias, true, false, 10, 50);
			Assert.fail("Dberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	
	@Test
	void altaPromocionSinPromocion() {
		ArrayList<String> dias = new ArrayList<String>();
		dias.add("Lunes");
		try {
			ped.altaPromocion(new Producto("Arroz",50,100,35), dias, false, false, 10, 50);
			Assert.fail("Dberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaPedidoValido() {
		try {
			ped.altaPedido(new Comanda(), new Producto("Arroz",50,100,50), 5);
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	void altaPedidoComandaNull() {
		try {
			ped.altaPedido(null, new Producto("Arroz",50,100,50), 5);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaPedidoProductoNull() {
		try {
			ped.altaPedido(new Comanda(), null, 5);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaPedidoCantNegativa() {
		try {
			ped.altaPedido(new Comanda(), new Producto("Arroz",50,100,50), -10);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaPedidoCantMayorAStock() {
		try {
			ped.altaPedido(new Comanda(), new Producto("Arroz",50,100,50), 75);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	
	
}
