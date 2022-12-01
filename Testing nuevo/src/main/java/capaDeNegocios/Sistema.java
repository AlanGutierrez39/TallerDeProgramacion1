package capaDeNegocios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import capaDeDatos.*;
import enums.Estado;
import excepciones.CantidadInsuficienteActivosException;
import excepciones.DemasiadosMozosDeFrancoException;
import excepciones.WrongPasswordException;
import excepciones.WrongUserException;

/**
 * Sistema es la clase principal de la clase de la capa de negocios. Almacena
 * toda la informacion del sistema e implementa un patron facade con 3 subclases
 * 
 * @author Nahuel
 *
 */

public class Sistema
{
	private static Sistema instance = null;
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private ArrayList<Mozo> mozos = new ArrayList<Mozo>();
	private ArrayList<Promocion> promociones = new ArrayList<Promocion>();
	private ArrayList<PromocionTemporal> promocionesTemporales = new ArrayList<PromocionTemporal>();
	private ArrayList<Operario> operarios = new ArrayList<Operario>();
	private ArrayList<OperarioAdministrador> operariosAdministradores = new ArrayList<OperarioAdministrador>();
	private ArrayList<Comanda> comandas = new ArrayList<Comanda>();
	private ArrayList<Factura> facturas = new ArrayList<Factura>();
	private HashMap<Integer, RelacionMesaMozo> asignacionesDesdeMesa = new HashMap();
	private HashMap<Integer, RelacionMesaMozo> asignacionesDesdeMozo = new HashMap();
	private GestionDePersonal zonaGestionDePersonal;
	private PedidosFacturacionYPromociones zonaPedidosYFacturacion;
	private ConfiguracionDeSistema zonaConfiguracionDeSistema;
	private Boolean diaIniciado = false;
	private Local local;

	// ----------------------------Singletone-------------------------//
	public static Sistema getInstance()
	{
		if (Sistema.instance == null)
		{
			Sistema.instance = new Sistema();
		}
		return instance;
	}

	public void setZonaGestionDePersonal(GestionDePersonal zonaGestionDePersonal)
	{
		this.zonaGestionDePersonal = zonaGestionDePersonal;
	}

	public void setZonaPedidosYFacturacion(PedidosFacturacionYPromociones zonaPedidosYFacturacion)
	{
		this.zonaPedidosYFacturacion = zonaPedidosYFacturacion;
	}

	public void setZonaConfiguracionDeSistema(ConfiguracionDeSistema zonaConfiguracionDeSistema)
	{
		this.zonaConfiguracionDeSistema = zonaConfiguracionDeSistema;
	}

	public void setDiaIniciado(Boolean diaIniciado)
	{
		this.diaIniciado = diaIniciado;
	}

	public Sistema()
	{
		super();
		this.zonaGestionDePersonal = GestionDePersonal.getInstance();
		this.zonaPedidosYFacturacion = PedidosFacturacionYPromociones.getInstance();
		this.zonaConfiguracionDeSistema = ConfiguracionDeSistema.getInstance();
	}
	// ----------------------------GETTERS Y SETTERS-------------------------//

	public ArrayList<Operario> getOperarios()
	{
		return operarios;
	}

	public ArrayList<Mesa> getMesas()
	{
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesas)
	{
		this.mesas = mesas;
	}

	public ArrayList<Producto> getProductos()
	{
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos)
	{
		this.productos = productos;
	}

	public ArrayList<Comanda> getComandas()
	{
		return comandas;
	}

	public void setComandas(ArrayList<Comanda> comandas)
	{
		this.comandas = comandas;
	}

	public ArrayList<Mozo> getMozos()
	{
		return mozos;
	}

	public HashMap<Integer, RelacionMesaMozo> getAsignacionesDesdeMesa()
	{
		return asignacionesDesdeMesa;
	}

	public void setAsignacionesDesdeMesa(HashMap<Integer, RelacionMesaMozo> asignacionesDesdeMesa)
	{
		this.asignacionesDesdeMesa = asignacionesDesdeMesa;
	}

	public HashMap<Integer, RelacionMesaMozo> getAsignacionesDesdeMozo()
	{
		return asignacionesDesdeMozo;
	}

	public void setAsignacionesDesdeMozo(HashMap<Integer, RelacionMesaMozo> asignacionesDesdeMozo)
	{
		this.asignacionesDesdeMozo = asignacionesDesdeMozo;
	}

	public ArrayList<Factura> getFacturas()
	{
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas)
	{
		this.facturas = facturas;
	}

	public Local getLocal()
	{
		return local;
	}

	public void setLocal(Local local)
	{
		this.local = local;
	}

	public void setMozos(ArrayList<Mozo> mozos)
	{
		this.mozos = mozos;
	}

	public ArrayList<Promocion> getPromociones()
	{
		return promociones;
	}

	public void setPromociones(ArrayList<Promocion> promociones)
	{
		this.promociones = promociones;
	}

	public ArrayList<PromocionTemporal> getPromocionesTemporales()
	{
		return promocionesTemporales;
	}

	public void setPromocionesTemporales(ArrayList<PromocionTemporal> promocionesTemporales)
	{
		this.promocionesTemporales = promocionesTemporales;
	}

	public void setOperarios(ArrayList<Operario> operarios)
	{
		this.operarios = operarios;
	}

	public void setOperariosAdministradores(ArrayList<OperarioAdministrador> operariosAdministradores)
	{
		this.operariosAdministradores = operariosAdministradores;
	}

	public ArrayList<OperarioAdministrador> getOperariosAdministradores()
	{
		return operariosAdministradores;
	}

	public GestionDePersonal getZonaGestionDePersonal()
	{
		return zonaGestionDePersonal;
	}

	public PedidosFacturacionYPromociones getZonaPedidosYFacturacion()
	{
		return zonaPedidosYFacturacion;
	}

	public ConfiguracionDeSistema getZonaConfiguracionDeSistema()
	{
		return zonaConfiguracionDeSistema;
	}

	// ----------------------------METODOS-------------------------//

	/**
	 * Verifica que la contrasenia y el nombre de usuario se encuentren en el
	 * sistema y que no sean nulos
	 * 
	 * @param nombreUsuario: Parametro de tipo String que representa el nombre de
	 *                       usuario de una cuenta
	 * @param password:      Parametro de tipo String que representa la contrasenia
	 *                       de una cuenta
	 * @return Devuelve un entero "0" si el tipo de usuario es Operario
	 *         Administrador o "1" si el tipo de usuario es Operario
	 * @throws WrongUserException     : Se lanza en el caso que el usuario no se
	 *                                encuentre registrado
	 * @throws WrongPasswordException : Se lanza en el caso que la contrasenia
	 *                                asociada al nombre de usuario no coincida
	 */
	public int login(String nombreUsuario, String password) throws WrongUserException, WrongPasswordException
	{
		int i = 0;
		if (nombreUsuario == null || password == null)
			throw new WrongPasswordException("Complete los campos vacios.");
		while (i < this.operariosAdministradores.size()
				&& !this.operariosAdministradores.get(i).getNombreDeUsuario().equals(nombreUsuario))
			i++;

		if (i < this.operariosAdministradores.size())
		{
			if (this.operariosAdministradores.get(i).isActivo()
					&& this.operariosAdministradores.get(i).getPassword().equals(password))
				return 0;
			else
				throw new WrongPasswordException("Password incorrecta.");
		} else
		{
			i = 0;
			while (i < this.operarios.size() && !this.operarios.get(i).getNombreDeUsuario().equals(nombreUsuario))
				i++;
			if (i < this.operarios.size())
			{
				if (this.operarios.get(i).isActivo() && this.operarios.get(i).getPassword().equals(password))
					return 1;
				else
					throw new WrongPasswordException("Password incorrecta.");
			} else
				throw new WrongUserException("Usuario no registrado.");
		}
	}

	/**
	 * Realiza la asignacion de mozos a cada una de las mesas. <b>Post: </b> Se
	 * realizan las asignaciones de mozos a todas las mesas<br>
	 * 
	 * @throws DemasiadosMozosDeFrancoException     : Se lanza en caso de que no
	 *                                              haya dos mozos de franco
	 * @throws CantidadInsuficienteActivosException : Se lanza en caso de que no
	 *                                              haya al menos un mozo activo
	 */
	public void ArrancarDia() throws DemasiadosMozosDeFrancoException, CantidadInsuficienteActivosException
	{
		ArrayList<Mozo> lista = Sistema.getInstance().getMozos();
		int contFranco = 0, contActivos = 0;

		for (Mozo i : lista)
		{
			if (i.getEstado().equals(Estado.DE_FRANCO.getEstado()))
				contFranco++;
			if (i.getEstado().equals(Estado.ACTIVO.getEstado()))
				contActivos++;
		}
		if (contFranco != 2)
		{
			throw new DemasiadosMozosDeFrancoException("Se necesitan 2 mozos de franco para iniciar el dia.");
		} else if (contActivos < 1)
			throw new CantidadInsuficienteActivosException(
					"Se necesita al menos 1 mozo en estado activo para iniciar el dia");
		else
		{
			crearAsignaciones();
		}
	}

	/**
	 * Recorre las colecciones de mozos y mesas y realiza la asignacion de mozos a
	 * cada una de las mesas.
	 * 
	 */
	private void crearAsignaciones()
	{
		int i = 0;
		Mozo mozo;
		RelacionMesaMozo relacion;
		for (Mesa mesa : mesas)
		{
			if (i < mozos.size())
			{
				mozo = mozos.get(i);
				i++;
			} else
			{
				mozo = mozos.get(0);
				i = 0;
			}
			relacion = new RelacionMesaMozo(mesa, mozo);
			asignacionesDesdeMesa.put(mesa.getId(), relacion);
			asignacionesDesdeMozo.put(mozo.getId(), relacion);
		}

	}

	public void bajaMozo(Mozo mozo)
	{
		Sistema.getInstance().getMozos().remove(mozo);
	}

	public void modificarMozo(int id, int cantHijos, String estado, double sueldo, String nombreYApel, Date fechaNac)
	{
		Sistema modelo = Sistema.getInstance();
		int i = 0;

		while (i < modelo.getMozos().size() && modelo.getMozos().get(i).getId() != id)
			i++;

		modelo.getMozos().get(i).setCantHijos(cantHijos);
		modelo.getMozos().get(i).setEstado(estado);
		modelo.getMozos().get(i).setNacimiento(fechaNac);
		modelo.getMozos().get(i).setNombreYApellido(nombreYApel);
		modelo.getMozos().get(i).setSueldo(sueldo);
	}

	public void altaMozo(int cantHijos, String estado, double sueldo, String nombre, Date fecha)
	{
		Sistema.getInstance().getMozos().add(new Mozo(cantHijos, estado, sueldo, nombre, fecha));

	}

}
