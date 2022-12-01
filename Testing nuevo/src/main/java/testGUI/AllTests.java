package testGUI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestVentanaAdmin.class, TestVentanaAdminMuchosMozosDeFranco.class, TestVentanaAdminSinMozos.class,
		TestVentanaAdminSinMozosActivos.class, TestVentanaAdminSinMozosDeFranco.class,
		TestVentanaAdminSinMozosSuficientes.class, TestVentanaLoginAdmin.class,
		TestVentanaLoginContrasenaIncorrecta.class, TestVentanaLoginContrasenaVacia.class,
		TestVentanaLoginOperario.class, TestVentanaLoginPrimerIngreso.class, TestVentanaLoginUsuarioInactivo.class,
		TestVentanaLoginUsuarioIncorrecto.class, TestVentanaLoginUsuarioVacio.class, TestVentanaLoginVacio.class,
		TestVentanaOperario.class, TestVentanaOperarioSinComandas.class })
public class AllTests
{

}
