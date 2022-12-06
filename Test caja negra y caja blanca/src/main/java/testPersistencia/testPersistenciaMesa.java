package testPersistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import capaDeDatos.Mesa;

import  org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistencia.IPersistencia;
import persistencia.Persistencia;

public class testPersistenciaMesa {
private  IPersistencia persistencia = new Persistencia();
private ArrayList<Mesa> mesas = new ArrayList<Mesa>();

	@Before
	public void setUp() throws Exception     {
        File archivo = new File("DatosPrueba.bin");
        if (archivo.exists())
            archivo.delete();
    }

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrearArchivo() {
		try {
			persistencia.abrirOutput("DatosPrueba.bin");
			File archivo = new File("DatosPrueba.bin");
			Assert.assertTrue("El archivo deberia existir",archivo.exists());
		} catch (IOException e) {
		Assert.fail("No debe fallar: "+e.getMessage());
		}
	}
	
	@Test
	public void testEscrituraMesasVacio() {
		 try {
	         persistencia.abrirOutput("DatosPrueba.bin");
	         persistencia.escribir(this.mesas);
	         persistencia.cerrarOutput();
	     } catch (IOException e) {
	         Assert.fail("Error en la escritura vacia");
	     }
	}
	
	@Test
	public void testEscrituraConMesas() {
		try {
	         persistencia.abrirOutput("DatosPrueba.bin");
	         this.completaConMesasCorrectas();
	         persistencia.escribir(this.mesas);
	         persistencia.cerrarOutput();
	     } catch (IOException e) {
	         Assert.fail("Error en la escritura de mesas");
	     }
	}
	
	@Test
	public void despersistirSinArchivo() {
		try {
			persistencia.abrirInput("Datooz.bin");
            this.mesas = (ArrayList<Mesa>) persistencia.leer();
            Assert.fail("Deberia tirar error porque no existe el archivo");
        } catch (Exception e) {        
        }
	}

	@Test
	public void despersistirConArchivo() {
		try {
            persistencia.abrirInput("DatosPrueba.bin");
            this.mesas = (ArrayList<Mesa>) persistencia.leer();
            persistencia.cerrarInput();
        } catch (Exception e) {
           Assert.fail("No deberia tirar error porque el archivo ya existe");
        }
	}

	@Test
	public void completaConMesasCorrectas() {
			this.mesas.add( new Mesa(3, "Libre"));
			this.mesas.add( new Mesa(5, "Ocupada"));
	}
	

	
}