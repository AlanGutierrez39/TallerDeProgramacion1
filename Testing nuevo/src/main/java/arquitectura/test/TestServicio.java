package arquitectura.test;

import arquitectura.servicios.Servicio;
import arquitectura.servicios.ServicioImpl;

import capaDeNegocios.Sistema;

import excepciones.WrongPasswordException;
import excepciones.WrongUserException;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestServicio
{
    public TestServicio()
    {
        super();
    }

    @Test
    public void testLoginAdmin()
    {
        Sistema sistema = mock(Sistema.class);
    try
    {
      when(sistema.login("G", "H")).thenReturn(0);
    }
    catch (WrongPasswordException | WrongUserException e)
    {
      e.printStackTrace();
    }
    Servicio servicio = new ServicioImpl();
    try
    {
      Assert.assertEquals(servicio.login("G", "H"), 0);
    }
    catch (WrongPasswordException | WrongUserException e)
    {
      e.printStackTrace();
    }
  }
  @Test
  public void testLoginOperario()
  {
      Sistema sistema = mock(Sistema.class);
  try
  {
    when(sistema.login("A", "Imanol1")).thenReturn(1);
  }
  catch (WrongPasswordException | WrongUserException e)
  {
    e.printStackTrace();
  }
  Servicio servicio = new ServicioImpl();
  try
  {
    Assert.assertEquals(servicio.login("A", "Imanol1"), 1);
  }
  catch (WrongPasswordException | WrongUserException e)
  {
    e.printStackTrace();
  }
  }
  @Test
  public void testLoginUsuarioIncorrecto()
  {
      Sistema sistema = mock(Sistema.class);
  try
  {
    when(sistema.login("Ximena", "H")).thenReturn(0);
  }
  catch (WrongPasswordException | WrongUserException e)
  {
    e.printStackTrace();
  }
  Servicio servicio = new ServicioImpl();
  try
  {
    int login = servicio.login("Ximena", "H");
  }
  catch (WrongPasswordException | WrongUserException e)
  {
    Assert.assertEquals("Usuario no registrado.", e.getMessage());
  }
  }
  @Test
  public void testLoginContrasenaIncorrecta()
  {
      Sistema sistema = mock(Sistema.class);
  try
  {
    when(sistema.login("G", "h")).thenReturn(0);
  }
  catch (WrongPasswordException | WrongUserException e)
  {
    e.printStackTrace();
  }
  Servicio servicio = new ServicioImpl();
  try
  {
    int login = servicio.login("G", "h");
  }
  catch (WrongPasswordException e1)
  {
    Assert.assertEquals("Password incorrecta.", e1.getMessage());
  }
  catch (WrongUserException e2)
  {
    e2.printStackTrace();
  }
  }
  @Test
  public void testLoginUsuarioInactivo()
  {
      Sistema sistema = mock(Sistema.class);
  try
  {
    when(sistema.login("E", "Imanol1")).thenReturn(0);
  }
  catch (WrongPasswordException | WrongUserException e)
  {
    e.printStackTrace();
  }
  Servicio servicio = new ServicioImpl();
  try
  {
    int login = servicio.login("E", "Imanol1");
  }
  catch (WrongPasswordException | WrongUserException e)
  {
    Assert.assertEquals("Usuario inactivo.", e.getMessage());
  }
  }
  @Test
  public void testLoginAdminPrimerIngreso()
  {
      Sistema sistema = mock(Sistema.class);
  try
  {
    when(sistema.login("ADMIN", "ADMIN1234")).thenReturn(0);
  }
  catch (WrongPasswordException | WrongUserException e)
  {
    e.printStackTrace();
  }
  Servicio servicio = new ServicioImpl();
  try
  {
    Assert.assertEquals(servicio.login("ADMIN", "ADMIN1234"), 0);
  }
  catch (WrongPasswordException | WrongUserException e)
  {
    e.printStackTrace();
  }
  }
  @Test
  public void testLoginSinOperarios()
  {
    Sistema sistema = mock(Sistema.class);
  try
  {
  when(sistema.login("A", "Imanol1")).thenReturn(1);
  }
  catch (WrongPasswordException | WrongUserException e)
  {
  e.printStackTrace();
  }
  Servicio servicio = new ServicioImpl();
  try
  {
    int login = servicio.login("A", "Imanol1");
  }
  catch (WrongPasswordException | WrongUserException e)
  {
    Assert.assertEquals("Usuario no registrado.", e.getMessage());
  }
  }
}
