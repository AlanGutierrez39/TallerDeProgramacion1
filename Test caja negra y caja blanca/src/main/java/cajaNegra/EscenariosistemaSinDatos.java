package cajaNegra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import capaDeDatos.Operario;
import capaDeDatos.OperarioAdministrador;
import capaDeNegocios.Sistema;

public class EscenariosistemaSinDatos {

private Sistema sistema = new Sistema();
	
    public void setUp(){
		sistema.getOperarios().clear();
		sistema.getOperariosAdministradores().clear();
	}
	
    public void tearDown(){
		sistema.getOperarios().clear();
		sistema.getOperariosAdministradores().clear();
    }


	public Sistema getSistema() {
		return sistema;
	}
	
}
