package cajaBlanca;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@SelectClasses({TestAltaMesa.class,TestModificarMesa.class,TestAltaComanda.class})
@Suite
public class AllTests
{
}
