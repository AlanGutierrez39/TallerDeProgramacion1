package cajaNegra;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Sistema;
import excepciones.DatosIncorrectosException;

public class TestGestionDePersonal {
	private GestionDePersonal gestionDP = new GestionDePersonal();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAltaOpeCorrecto() {
		try {
			gestionDP.altaOperario("abc", "BlackBox1!", true);
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	void testAltaOpeUsernameNull() {
		try {
			gestionDP.altaOperario(null, "BlackBox1!", true);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void testAltaOpePasswordNull() {
		try {
			gestionDP.altaOperario("abc", null, true);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void testAltaOpePasswordLarga() {
		try {
			gestionDP.altaOperario("abc", "Abcdefghijklmopq123!", true);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void testAltaOpePasswordCorta() {
		try {
			gestionDP.altaOperario("abc", "aB!3", true);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void testAltaOpePasswordSinDigitos() {
		try {
			gestionDP.altaOperario("abc", "BlackBox!", true);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	
	@Test
	void testAltaOpePasswordSinMayus() {
		try {
			gestionDP.altaOperario("abc", "blackbox1!", true);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void passwordCumpleValido() {
		Assert.assertTrue(gestionDP.passwordCumple("BlackBox1!"));
		System.out.println("bien");
	}
	
	@Test
	void passwordCumpleNull() {
		Assert.assertTrue(!gestionDP.passwordCumple(null));
		System.out.println("bien");
	}
	
	@Test
	void passwordCumpleLarga() {
		Assert.assertTrue(!gestionDP.passwordCumple("Abcdefghijklmopq123!"));
		System.out.println("bien");
	}
	
	
	@Test
	void passwordCumpleCorta() {
		Assert.assertTrue(!gestionDP.passwordCumple("aB!3"));
		System.out.println("bien");
	}
	
	@Test
	void passwordCumpleSinDigito() {
		Assert.assertTrue(!gestionDP.passwordCumple("BlackBox!"));
		System.out.println("bien");
	}
	
	@Test
	void passwordCumpleSinMayus() {
		Assert.assertTrue(!gestionDP.passwordCumple("blackbox1!"));
		System.out.println("bien");
	}
	
	@Test
	void cambiarEstadoMozoValido() {
		try {
			gestionDP.cambiarEstadoMozo(new Mozo(1,"Ocupado",300,"Pepe", new Date()), "Libre");
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	void cambiarEstadoMozoNull() {
		try {
			gestionDP.cambiarEstadoMozo(null, "Libre");
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void cambiarEstadoMozoEstadoNull() {
		try {
			gestionDP.cambiarEstadoMozo(new Mozo(1,"Ocupado",300,"Pepe", new Date()), null);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void AltaMozoValido() {
		try {
			gestionDP.altaMozo(0, "Libre", 70000, "Pepe", 1984, 07, 21);
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debería tirar excepción");
		}
	}
	
	@Test
	void AltaMozoHijosNegativos() {
		try {
			gestionDP.altaMozo(-4, "Libre", 70000, "Pepe", 1984, 07, 21);
			Assert.fail("Debería tirar excepción");
		} catch (DatosIncorrectosException e) {	
			System.out.println("bien");
		}
	}
	
	@Test
	void AltaMozoEstadoNull() {
		try {
			gestionDP.altaMozo(0, null, 70000, "Pepe", 1984, 07, 21);
			Assert.fail("Debería tirar excepción");
		} catch (DatosIncorrectosException e) {	
			System.out.println("bien");
		}
	}
	
	@Test
	void AltaMozoSueldoNegativo() { //deberia testear esto? no esta en la srs pero es logico... no contempla sueldo negativo
		try {
			gestionDP.altaMozo(0, "Libre", -7500, "Pepe", 1984, 07, 21);
			Assert.fail("Debería tirar excepción");
		} catch (DatosIncorrectosException e) {	
			System.out.println("bien");
		}
	}
	
	@Test
	void AltaMozoValidoNombreNull() {
		try {
			gestionDP.altaMozo(0, "Libre", 70000, null, 1984, 07, 21);
			Assert.fail("Debería tirar excepción");
		} catch (DatosIncorrectosException e) {	
			System.out.println("bien");
		}
	}
	
	@Test
	void AltaMozoAnioImposible() {
		try {
			gestionDP.altaMozo(0, "Libre", 70000, "Pepe", 2024, 07, 21);
			Assert.fail("Debería tirar excepción");
		} catch (DatosIncorrectosException e) {	
			System.out.println("bien");
		}
	}
	
	@Test
	void AltaMozoMesImposibleMayor() {
		try {
			gestionDP.altaMozo(0, "Libre", 70000, "Pepe", 1984, 21, 21);
			Assert.fail("Debería tirar excepción");
		} catch (DatosIncorrectosException e) {	
			System.out.println("bien");
		}
	}
	
	
	@Test
	void AltaMozoMesImposibleMenor() {
		try {
			gestionDP.altaMozo(0, "Libre", 70000, "Pepe", 1984, -10, 21);
			Assert.fail("Debería tirar excepción");
		} catch (DatosIncorrectosException e) {	
			System.out.println("bien");
		}
	}
	
	@Test
	void AltaMozoDiaImposibleMenor() {
		try {
			gestionDP.altaMozo(0, "Libre", 70000, "Pepe", 1984, 07, -17);
			Assert.fail("Debería tirar excepción");
		} catch (DatosIncorrectosException e) {	
			System.out.println("bien");
		}
	}
	
	@Test
	void AltaMozoDiaImposibleMayor() {
		try {
			gestionDP.altaMozo(0, "Libre", 70000, "Pepe", 1984, 07, 45);
			Assert.fail("Debería tirar excepción");
		} catch (DatosIncorrectosException e) {	
			System.out.println("bien");
		}
	}
	
	@Test
	void bajaMozoNull() { //no hice escenarios para estos métodos pues las colecciones están en otra clase
		//y estos métodos invocan a la instancia Singleton de dicha clase
		try {
           gestionDP.bajaMozo(null);
           Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	
	@Test
	void bajaMozoValido() { //no hice escenarios para estos métodos pues las colecciones están en otra clase
		//y estos métodos invocan a la instancia Singleton de dicha clase
		try {
            Mozo mozo = new Mozo(3,"Ocupado",20000,"Pepe",new Date());
			Sistema.getInstance().getMozos().add(mozo);
			gestionDP.bajaMozo(mozo);
			Sistema.getInstance().getMozos().clear();
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion "+ e.getMessage());
		}
	}
	
	@Test
	void modificarMozoValido() { //no hice escenarios para estos métodos pues las colecciones están en otra clase
		//y estos métodos invocan a la instancia Singleton de dicha clase
		try {
            Mozo mozo = new Mozo(3,"Ocupado",20000,"Pepe",new Date());
            mozo.setId(3);
			Sistema.getInstance().getMozos().add(mozo);
			gestionDP.modificarMozo(3, 3, "Libre", 25000, "Pepe", 1960, 10, 03);
			Sistema.getInstance().getMozos().clear();
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion "+ e.getMessage());
		}
	}
	
	@Test
	void modificarMozoValidoColeccionVacia() { //no contempla coleccion vacia y no es precondicion
		try {
			Sistema.getInstance().getMozos().clear();
			gestionDP.modificarMozo(3, 3, "Libre", 25000, "Pepe", 1960, 10, 03);
			System.out.println("bien");
		} catch (Exception e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	void modificarMozoHijosNegativos() {
		try {
            Mozo mozo = new Mozo(3,"Ocupado",20000,"Pepe",new Date());
            mozo.setId(3);
            Sistema.getInstance().getMozos().clear();
			Sistema.getInstance().getMozos().add(mozo);
			gestionDP.modificarMozo(3, -4, "Libre", 25000, "Pepe", 1960, 10, 03);

			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	@Test
	void modificarMozoEstadoNull() {
		try {
            Mozo mozo = new Mozo(3,"Ocupado",20000,"Pepe",new Date());
            mozo.setId(3);
            Sistema.getInstance().getMozos().clear();
			Sistema.getInstance().getMozos().add(mozo);
			gestionDP.modificarMozo(3, 3, null, 25000, "Pepe", 1960, 10, 03);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	

	@Test
	void modificarMozoNombreNull() {
		try {
            Mozo mozo = new Mozo(3,"Ocupado",20000,"Pepe",new Date());
            mozo.setId(3);
            Sistema.getInstance().getMozos().clear();
			Sistema.getInstance().getMozos().add(mozo);
			gestionDP.modificarMozo(3, 3, "Libre", 25000, null, 1960, 10, 03);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	

	@Test
	void modificarMozoAnioImposible() {
		try {
            Mozo mozo = new Mozo(3,"Ocupado",20000,"Pepe",new Date());
            mozo.setId(3);
            Sistema.getInstance().getMozos().clear();
			Sistema.getInstance().getMozos().add(mozo);
			gestionDP.modificarMozo(3, 3, "Libre", 25000, "Pepe", 2024, 10, 03);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien ");
		}
	}
	
	

	@Test
	void modificarMozoMesImposibleMayor() {
		try {
            Mozo mozo = new Mozo(3,"Ocupado",20000,"Pepe",new Date());
            mozo.setId(3);
            Sistema.getInstance().getMozos().clear();
			Sistema.getInstance().getMozos().add(mozo);
			gestionDP.modificarMozo(3, 3, "Libre", 25000, "Pepe", 1960, 21, 03);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}


	@Test
	void modificarMozoMesImposibleMenor() {
		try {
            Mozo mozo = new Mozo(3,"Ocupado",20000,"Pepe",new Date());
            mozo.setId(3);
            Sistema.getInstance().getMozos().clear();
			Sistema.getInstance().getMozos().add(mozo);
			gestionDP.modificarMozo(3, 3, "Libre", 25000, "Pepe", 1960, -10, 03);

			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	
	

	@Test
	void modificarMozoDiaImposibleMayor() {
		try {
            Mozo mozo = new Mozo(3,"Ocupado",20000,"Pepe",new Date());
            mozo.setId(3);
            Sistema.getInstance().getMozos().clear();
			Sistema.getInstance().getMozos().add(mozo);
			gestionDP.modificarMozo(3, 3, "Libre", 25000, "Pepe", 1960, 10, 45);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	

	@Test
	void modificarMozoDiaImposibleMenor() {
		try {
            Mozo mozo = new Mozo(3,"Ocupado",20000,"Pepe",new Date());
            mozo.setId(3);
            Sistema.getInstance().getMozos().clear();
			Sistema.getInstance().getMozos().add(mozo);
			gestionDP.modificarMozo(3, 3, "Libre", 25000, "Pepe", 1960, 10, -17);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		}
	}
	

	@Test
	void modificarMozoIdInexistente() {  //si es un mozo con id inexistente se rompe y no es precondicion
		try {
            Mozo mozo = new Mozo(3,"Ocupado",20000,"Pepe",new Date());
            mozo.setId(3);
            Sistema.getInstance().getMozos().clear();
			Sistema.getInstance().getMozos().add(mozo);
			gestionDP.modificarMozo(845, 3, "Libre", 25000, "Pepe", 1960, 10, 03);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
		} catch (Exception e) {
			Assert.fail("No deberia tirar esta excepcion");
		}
	}
	

	@Test
	void comparaEdadValido() {
		Assert.assertTrue(gestionDP.comparaEdad(1984, 3, 2));
	}
	
	
	@Test
	void comparaEdadAnioImposible() {
		Assert.assertTrue(!gestionDP.comparaEdad(2053, 3, 2));
	}
	
	@Test
	void comparaEdadMesImposibleMayor() {
		Assert.assertTrue(!gestionDP.comparaEdad(1984, 39, 2));
	}
	
	@Test
	void comparaEdadMesImposibleMenor() {
		Assert.assertTrue(!gestionDP.comparaEdad(1984, -56, 2));
	}
	
	
	@Test
	void comparaEdadDiaImposibleMayor() {
		Assert.assertTrue(!gestionDP.comparaEdad(1984, 3, 860));
	}
	
	@Test
	void comparaEdadDiaImposibleMenor() {
		Assert.assertTrue(!gestionDP.comparaEdad(1984, 3, -568));
	}
	
	@Test
	void comparaEdadDiaImposibleMenorDe18() {
		Assert.assertTrue(!gestionDP.comparaEdad(2016, 3, 2));
	}
	
	private void agregaOpe(String username, String password, boolean estado) {
		Sistema.getInstance().getOperarios().add(new Operario(username,password,estado));
	}
	
	private void clearColecciones() {
		Sistema.getInstance().getOperarios().clear();
		Sistema.getInstance().getOperariosAdministradores().clear();
		Sistema.getInstance().getMesas().clear();
		Sistema.getInstance().getComandas().clear();
		Sistema.getInstance().getMozos().clear();
	}
	
	@Test 
	void modificacionOperariovalido() {
		try {
			this.agregaOpe("abc","123",true); 
			gestionDP.modificacionOperario("abc", "manolo123", "Pochoclo123!", true);
			this.clearColecciones();
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test 
	void modificacionOperarioValidoInexistente() {
		try {
			this.clearColecciones();
			gestionDP.modificacionOperario("abc", "manolo123", "Pochoclo123!", true);
			System.out.println("bien");
		} catch (DatosIncorrectosException e) {
			Assert.fail("No deberia tirar excepcion");
		}
	}
	
	@Test 
	void modificacionOperarioUsernameNull() {
		try {
			this.agregaOpe("abc","123",true); 
			gestionDP.modificacionOperario("abc", null, "Pochoclo123!", true);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test 
	void modificacionOperarioPasswordNull() {
		try {
			this.agregaOpe("abc","123",true); 
			gestionDP.modificacionOperario("abc", "manolo123", null, true);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test 
	void modificacionOperarioPasswordLarga() {
		try {
			this.agregaOpe("abc","123",true); 
			gestionDP.modificacionOperario("abc", "manolo123", "Pochoclo12345678910!", true);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test 
	void modificacionOperarioPasswordCorta() {
		try {
			this.agregaOpe("abc","123",true); 
			gestionDP.modificacionOperario("abc", "manolo123", "Poc1", true);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	
	@Test 
	void modificacionOperarioPasswordSinMayus() {
		try {
			this.agregaOpe("abc","123",true); 
			gestionDP.modificacionOperario("abc", "manolo123", "pochoclo123!", true);
			Assert.fail("Deberia tirar excepcion");
		} catch (DatosIncorrectosException e) {
			System.out.println("bien");
			this.clearColecciones();
		}
	}
	

	

}
