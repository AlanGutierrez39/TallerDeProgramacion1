package excepciones;
/**
 * Excepcion que trata contrasenias incorrectas
 * @author Nahuel
 *
 */
public class WrongPasswordException extends Exception{
	public WrongPasswordException(String message) {
		super(message);
	}
}
