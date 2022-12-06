package testPersistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import capaDeDatos.Operario;

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


public class testPersistenciaOperario {
private  IPersistencia persistencia = new Persistencia();
private ArrayList<Operario> operarios = new ArrayList<Operario>();

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
	public void testEscrituraOperariosVacio() {
		 try {
	         persistencia.abrirOutput("DatosPrueba.bin");
	         persistencia.escribir(this.operarios);
	         persistencia.cerrarOutput();
	     } catch (IOException e) {
	         Assert.fail("Error en la escritura vacia");
	     }
	}
	
	@Test
	public void testEscrituraConOperarios() {
		try {
	         persistencia.abrirOutput("DatosPrueba.bin");
	         this.completaConOperarios();
	         persistencia.escribir(this.operarios);
	         persistencia.cerrarOutput();
	     } catch (IOException e) {
	         Assert.fail("Error en la escritura de operarios");
	     }
	}
	
	@Test
	public void despersistirSinArchivo() {
		try {
			persistencia.abrirInput("Datooz.bin");
            this.operarios = (ArrayList<Operario>) persistencia.leer();
            Assert.fail("Deberia tirar error porque no existe el archivo");
        } catch (Exception e) {        
        }
	}

	@Test
	public void despersistirConArchivo() {
		try {
            persistencia.abrirInput("DatosPrueba.bin");
            this.operarios = (ArrayList<Operario>) persistencia.leer();
            persistencia.cerrarInput();
        } catch (Exception e) {
           Assert.fail("No deberia tirar error porque el archivo ya existe");
        }
	}
	
	@Test
	public void completaConOperarios() {
		try {
			this.operarios.add(new Operario(null, null, false));
			this.operarios.add(new Operario(null, null, false));
		}catch (Exception e) {
			Assert.fail("No deberia lanzar esta exepcion");
		}	
	}
	
}