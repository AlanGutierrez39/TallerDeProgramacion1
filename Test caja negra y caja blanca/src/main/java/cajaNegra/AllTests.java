package cajaNegra;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@SelectClasses({TestConfiguracionDeSistema.class,TestGestionDePersonal.class,TestPedidosFacturacionYPromociones.class,
		TestSistemaConDatos.class,TestSistemaSinDatos.class})
@Suite
public class AllTests
{
}
