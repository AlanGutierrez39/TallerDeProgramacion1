package arquitectura.servicios;

import com.tallerDeProgra.capaDeNegocios.Sistema;

import excepciones.WrongPasswordException;
import excepciones.WrongUserException;

public class ServicioImpl implements Servicio
{
    public ServicioImpl()
    {
        super();
    }

    @Override
  public int login(String nombreUsuario, String password) throws WrongUserException, WrongPasswordException
  {
          int i = 0;
          if (nombreUsuario == null || password == null)
                  throw new WrongPasswordException("Complete los campos vacios.");
          while (i < Sistema.getInstance().getOperariosAdministradores().size()
                          && !Sistema.getInstance().getOperariosAdministradores().get(i).getNombreDeUsuario().equals(nombreUsuario))
                  i++;

          if (i < Sistema.getInstance().getOperariosAdministradores().size())
          {
                  if (Sistema.getInstance().getOperariosAdministradores().get(i).isActivo()
                                  && Sistema.getInstance().getOperariosAdministradores().get(i).getPassword().equals(password))
                          return 0;
                  else
                          throw new WrongPasswordException("Password incorrecta.");
          } else
          {
                  i = 0;
                  while (i < Sistema.getInstance().getOperarios().size() && !Sistema.getInstance().getOperarios().get(i).getNombreDeUsuario().equals(nombreUsuario))
                          i++;
                  if (i < Sistema.getInstance().getOperarios().size())
                  {
                          if (Sistema.getInstance().getOperarios().get(i).isActivo() && Sistema.getInstance().getOperarios().get(i).getPassword().equals(password))
                                  return 1;
                          else
                                  throw new WrongPasswordException("Password incorrecta.");
                  } else
                          throw new WrongUserException("Usuario no registrado.");
          }
  }
}
