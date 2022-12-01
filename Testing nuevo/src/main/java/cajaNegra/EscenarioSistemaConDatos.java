package cajaNegra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import capaDeDatos.Operario;
import capaDeDatos.OperarioAdministrador;
import capaDeNegocios.Sistema;

public class EscenarioSistemaConDatos {
	private Sistema sistema = new Sistema();
	
    public void setUp(){
		sistema.getOperarios().add(new Operario("def","456",true));
		sistema.getOperariosAdministradores().add(new OperarioAdministrador("abc","123",true));
	}
	
    public void tearDown(){
		sistema.getOperarios().clear();
		sistema.getOperariosAdministradores().clear();
    }


	public Sistema getSistema() {
		return sistema;
	}
	
	
	
	
}
	


