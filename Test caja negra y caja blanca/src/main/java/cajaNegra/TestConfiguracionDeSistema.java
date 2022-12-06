package cajaNegra;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Producto;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.Sistema;
import excepciones.DatosIncorrectosException;

public class TestConfiguracionDeSistema {
	private ConfiguracionDeSistema config = new ConfiguracionDeSistema();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void altaMesaValido() {
		try {
			config.altaMesa(4, "Libre");
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	
	@Test
	void altaMesaEstadoNull() {
		try {
			config.altaMesa(4, null);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaMesaComensalesNegativos() {
		try {
			config.altaMesa(-5, null);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	private void clearColecciones() {
		Sistema.getInstance().getOperarios().clear();
		Sistema.getInstance().getOperariosAdministradores().clear();
		Sistema.getInstance().getMesas().clear();
		Sistema.getInstance().getComandas().clear();
		Sistema.getInstance().getMozos().clear();
	}
	
	
	@Test
	void modificarMesaValido() {
		try {
			Mesa mesa = new Mesa(5,"Libre");
			mesa.setId(3);
			Sistema.getInstance().getMesas().add(mesa);
			config.modificarMesa(mesa, 7, "Ocupada");
			this.clearColecciones();
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	void modificarMesaNull() {
		try {
			config.modificarMesa(null, 7, "Ocupada");
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			this.clearColecciones();
			System.out.println("bien");
		}
	}
	
	@Test
	void modificarMesaComensalesImposibles() {
		try {
			Mesa mesa = new Mesa(5,"Libre");
			mesa.setId(3);
			Sistema.getInstance().getMesas().add(mesa);
			config.modificarMesa(mesa, -3, "Ocupada");
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			this.clearColecciones();
			System.out.println("bien");	
		}
	}
	
	@Test
	void modificarMesaEstadoNull() {
		try {
			Mesa mesa = new Mesa(5,"Libre");
			mesa.setId(3);
			Sistema.getInstance().getMesas().add(mesa);
			config.modificarMesa(mesa, 7, null);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			this.clearColecciones();
			System.out.println("bien");	
		}
	}
	
	@Test
	void eliminarMesaValido() {
		try {
			Mesa mesa = new Mesa(5,"Libre");
			Sistema.getInstance().getMesas().add(mesa);
			config.eliminarMesa(mesa);
			this.clearColecciones();
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	void eliminarMesaNull() {
		try {
			config.eliminarMesa(null);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaProductoValido() {
		try {
			config.altaProducto("Big Mac", 200, 1500, 50);
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	void altaProductoNombreNull() {
		try {
			config.altaProducto(null, 200, 1500, 50);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaProductoCostoNegativo() {
		try {
			config.altaProducto("Big Mac", -519, 1500, 50);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	
	@Test
	void altaProductoVentaNegativo() {
		try {
			config.altaProducto("Big Mac", 200, -917, 50);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void altaProductoVentaMenorCosto() {
		try {
			config.altaProducto("Big Mac", 200, 130, 50);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void actualizarProductoValido() {
		try {
			Producto producto = new Producto("producto",200,300,25);
			Sistema.getInstance().getProductos().add(producto);
			config.actualizarProducto(producto, 20);
			System.out.println("bien");
			this.clearColecciones();
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion "+ e.getMessage());
		}
	}
	
	
	@Test
	void actualizarProductoNull() {
		try {
			config.actualizarProducto(null, 20);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test
	void actualizarProductoInexistente() {   //se rompe y no es precondicion que no exista
		try {
			Producto producto = new Producto("producto",200,300,25);
			config.actualizarProducto(producto, 20);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		} catch (Exception e) {
			Assert.fail("No deberia tirar esta excepcion");
		}
	}
	
	
	@Test
	void modificarProductoValido() {
		try {
			Producto producto = new Producto("producto",200,300,25);
			producto.setId(3);
			Sistema.getInstance().getProductos().add(producto);
			config.modificarProducto(3, "producto", 250, 400, 25);
			System.out.println("bien");
			this.clearColecciones();
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion!! "+ e.getMessage());
		}
	}
	
	@Test
	void modificarProductoCostoNegativo() {
		try {
			Producto producto = new Producto("producto",200,300,25);
			producto.setId(3);
			Sistema.getInstance().getProductos().add(producto);
			config.modificarProducto(3, "producto", -1, 400, 25);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test
	void modificarProductoCostoVentaNegativo() {
		try {
			Producto producto = new Producto("producto",200,300,25);
			producto.setId(3);
			Sistema.getInstance().getProductos().add(producto);
			config.modificarProducto(3, "producto", 250, -555, 25);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test
	void modificarProductoIDInexistente() {     //se rompe y no es precondicion que no exista
		try {
			Producto producto = new Producto("producto",200,300,25);
			producto.setId(3);
			Sistema.getInstance().getProductos().add(producto);
			config.modificarProducto(912, "producto", 200, 400, 25);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		} catch (Exception e) {
			Assert.fail("No deberia tirar esta excepcion");
		}
	}
	
	@Test
	void eliminarProductoValido() {
		try {
			Producto producto = new Producto("producto",200,300,25);
			producto.setId(3);
			Sistema.getInstance().getProductos().add(producto);
			config.eliminarProducto(producto);
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	void eliminarProductoNull() {
		try {
			config.eliminarProducto(null);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	
	}

	@Test
	void promedioValido() {
		try {
			Mozo mozo = new Mozo(3,"Libre",50000,"Pepe",new Date());
			mozo.setAcumulado(0);
			Assert.assertEquals(config.promedio(mozo), 0, 0); //el ultimo 0 representa la diferencia maxima entre ambos valores
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	void promedioMozoNull() {
		try {
			config.promedio(null);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");	
		}
	}
	
	
	
}
