package testPersistencia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testPersistenciaMesa.class, testPersistenciaMozo.class, testPersistenciaOperario.class })
public class AllTests {

}
