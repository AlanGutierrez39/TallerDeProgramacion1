package arquitectura.servicios;

import excepciones.WrongPasswordException;
import excepciones.WrongUserException;

public interface Servicio
{
  public int login(String nombreUsuario, String password) throws WrongUserException, WrongPasswordException;

}
