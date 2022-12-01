package cajaBlanca;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import capaDeDatos.Comanda;
import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Producto;
import capaDeDatos.Promocion;
import capaDeDatos.PromocionTemporal;
import capaDeDatos.RelacionMesaMozo;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.PedidosFacturacionYPromociones;
import capaDeNegocios.Sistema;
import enums.Estado;
import enums.EstadosMesa;
import excepciones.DatosIncorrectosException;

public class TestAltaComanda {
	private PedidosFacturacionYPromociones ped = new PedidosFacturacionYPromociones();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	//profe en esta clase y algunas otras no armé escenarios porque todo dependía de la clase Sistema,
	//y aquí estamos testeando la clas PedidosFacturacionYPromociones, por ende esta me pareció la mejor manera de solucionarlo
	
	@Test
	void camino1() {
		try {
			ped.altaComanda(null);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void camino2() {
		try {
			Comanda comanda = new Comanda();
			Mesa mesa =new Mesa(5,EstadosMesa.LIBRE.getEstado());
			comanda.setMesa(mesa);
			Sistema.getInstance().getMesas().clear();
			ped.altaComanda(comanda);	
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test
	void camino3() {
		try {
			Comanda comanda = new Comanda();
			Mesa mesa =new Mesa(5,EstadosMesa.LIBRE.getEstado());
			comanda.setMesa(mesa);
			Sistema.getInstance().getMesas().add(new Mesa(3,EstadosMesa.OCUPADA.getEstado()));
			ped.altaComanda(comanda);	
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test
	void camino4() {
		try {
			Comanda comanda = new Comanda();
			Mesa mesa =new Mesa(5,EstadosMesa.OCUPADA.getEstado());
			comanda.setMesa(mesa);
			Sistema.getInstance().getMesas().add(new Mesa(3,EstadosMesa.LIBRE.getEstado()));
			ped.altaComanda(comanda);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test
	void camino5() {
		try {
			Comanda comanda = new Comanda();
			Mesa mesa =new Mesa(5,EstadosMesa.LIBRE.getEstado());
			comanda.setMesa(mesa);
			Sistema.getInstance().getMesas().add(mesa);
			Sistema.getInstance().getAsignacionesDesdeMesa().put(mesa.getId(), new RelacionMesaMozo(comanda.getMesa(), null));
			ped.altaComanda(comanda);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test 
	void camino6() {
		try {
			Comanda comanda = new Comanda();
			Mesa mesa =new Mesa(5,EstadosMesa.LIBRE.getEstado());
			comanda.setMesa(mesa);
			Sistema.getInstance().getAsignacionesDesdeMesa().put(mesa.getId(), new RelacionMesaMozo(mesa, new Mozo(0, Estado.ACTIVO.getEstado(), 0, null, null)));
			
			Sistema.getInstance().getMesas().add(new Mesa(3,EstadosMesa.LIBRE.getEstado()));
			Sistema.getInstance().setPromociones(null);
			Sistema.getInstance().setPromocionesTemporales(null);
			ped.altaComanda(comanda); 
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			Sistema.getInstance().setPromociones(new ArrayList<Promocion>());
			Sistema.getInstance().setPromocionesTemporales(new ArrayList<PromocionTemporal>());
			this.clearColecciones();
		}
	}
	
	@Test
	void camino7() {
		try {
			Comanda comanda = new Comanda();
			Mesa mesa =new Mesa(5,EstadosMesa.LIBRE.getEstado());
			comanda.setMesa(mesa);
			Sistema.getInstance().getAsignacionesDesdeMesa().put(mesa.getId(), new RelacionMesaMozo(comanda.getMesa(), new Mozo(0, Estado.ACTIVO.getEstado(), 0, null, null)));
			Sistema.getInstance().getMesas().add(new Mesa(3,EstadosMesa.LIBRE.getEstado()));
			Sistema.getInstance().getPromociones().clear();
			Sistema.getInstance().getPromocionesTemporales().clear();
			ped.altaComanda(comanda);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test
	void camino8() {
		try {
			Comanda comanda = new Comanda();
			Mesa mesa =new Mesa(5,EstadosMesa.LIBRE.getEstado());
			comanda.setMesa(mesa);
			Sistema.getInstance().getAsignacionesDesdeMesa().put(mesa.getId(), new RelacionMesaMozo(comanda.getMesa(), new Mozo(0, Estado.ACTIVO.getEstado(), 0, null, null)));
			Sistema.getInstance().getMesas().add(new Mesa(3,EstadosMesa.LIBRE.getEstado()));
			Promocion promo = new Promocion();
			Promocion promo2 = new Promocion();
			promo.setProducto(new Producto("Pochoclo", 30, 40, 50));
			promo.setActiva(true);
			promo2.setProducto(new Producto("Maiz",10,20,30));
			promo2.setActiva(false);
			
			Sistema.getInstance().getPromociones().add(promo2);
			Sistema.getInstance().getPromociones().add(promo);
			
			ped.altaComanda(comanda);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test
	void camino9() {
		try {
			Comanda comanda = new Comanda();
			Mesa mesa =new Mesa(5,EstadosMesa.LIBRE.getEstado());
			comanda.setMesa(mesa);
			Sistema.getInstance().getAsignacionesDesdeMesa().put(mesa.getId(), new RelacionMesaMozo(comanda.getMesa(), new Mozo(0, Estado.ACTIVO.getEstado(), 0, null, null)));
			Sistema.getInstance().getMesas().add(new Mesa(10,EstadosMesa.LIBRE.getEstado()));
			Promocion promo = new Promocion();
			Promocion promo2 = new Promocion();
			Promocion promo3 = new Promocion();
			promo.setProducto(new Producto("Pochoclo", 30, 40, 50));
			promo.setActiva(true);
			Sistema.getInstance().getPromociones().add(promo);
			promo2.setProducto(new Producto("Jugo de naranja",5,30,150));
			promo2.setActiva(true);
			promo3.setProducto(new Producto("Pepsi",10,20,30));
			promo3.setActiva(false);
			Sistema.getInstance().getPromociones().add(promo3);
			Sistema.getInstance().getPromociones().add(promo2);
			ped.altaComanda(comanda);
			System.out.println("bien");
			this.clearColecciones();
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion "+ e.getMessage());
		}
	}
	
	
	@Test
	void camino10() {
		try {
			Comanda comanda = new Comanda();
			Mesa mesa =new Mesa(5,EstadosMesa.LIBRE.getEstado());
			comanda.setMesa(mesa);
			Sistema.getInstance().getAsignacionesDesdeMesa().put(mesa.getId(), new RelacionMesaMozo(comanda.getMesa(), new Mozo(0, Estado.ACTIVO.getEstado(), 0, null, null)));
			Sistema.getInstance().getMesas().add(mesa);
			Promocion promo = new Promocion();
			Promocion promo2 = new Promocion();
			promo.setProducto(new Producto("Pochoclo", 30, 40, 50));
			promo.setActiva(true);
			Sistema.getInstance().getPromociones().add(promo);
			promo2.setProducto(new Producto("Jugo de naranja",5,30,150));
			promo2.setActiva(true);
			Sistema.getInstance().getPromociones().add(promo2);
			ped.altaComanda(comanda);
			System.out.println("bien");
			this.clearColecciones();
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	private void clearColecciones() {
		Sistema.getInstance().getMesas().clear();
		Sistema.getInstance().getAsignacionesDesdeMesa().clear();
		Sistema.getInstance().getAsignacionesDesdeMozo().clear();
		Sistema.getInstance().getMozos().clear();
		Sistema.getInstance().getPromociones().clear();
		Sistema.getInstance().getPromocionesTemporales().clear();
	}

}
