package excepciones;
/**
 * Excepcion que trata datos invalidos en general
 * @author Nahuel
 *
 */
public class DatosIncorrectosException extends Exception{
	public DatosIncorrectosException(String message) {
		super(message);
	}

	public DatosIncorrectosException() {
		// TODO Auto-generated constructor stub
	}
}
