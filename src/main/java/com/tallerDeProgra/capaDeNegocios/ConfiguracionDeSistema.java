package com.tallerDeProgra.capaDeNegocios;

import java.io.Serializable;
import java.util.ArrayList;

import com.tallerDeProgra.capaDeDatos.Mesa;
import com.tallerDeProgra.capaDeDatos.Mozo;
import com.tallerDeProgra.capaDeDatos.Producto;

import excepciones.DatosIncorrectosException;
/**
 * Clase que representa una de las subclases del patron facade de la clase Sistema
 * @author Nahuel
 *
 */
public class ConfiguracionDeSistema implements Serializable{
	private static ConfiguracionDeSistema instance = null;
	/**
	 * Constructor privado del sistema debido a que se utiliza el patron Singleton
	 */
	private ConfiguracionDeSistema() {
		
	}
	/**
	 * Metodo estatico para instanciar una clase por unica vez
	 * @return Devuelve la instancia de clase ConfiguracionDeSistema
	 */
	protected static ConfiguracionDeSistema getInstance() {
		if (ConfiguracionDeSistema.instance == null) {
			ConfiguracionDeSistema.instance = new ConfiguracionDeSistema();
		}
		return instance;
	}
	/**
	 * Crea y agrega una nueva mesa al sistema al final del arreglo de mesas
	 * @param cantComensales : Parametro que representa la cantidad de comensales que quieren utilizar una mesa
	 * @param estado : Parametro que representa el estado de la mesa a crear
	 * @throws DatosIncorrectosException : Se lanza si el estado es nulo o la cantidad de comensales es menor a 2
	 * Pre:
	 * - cantComensales != null
	 * Pos:
	 * -  mesa.id = 1 mas que la mesa anteriormente agregada, en caso de que sea la primera mesa, el id valdra 1
	 * - mesa.estado = estado 
	 * - mesa.cantComnesales = cantComensales
	 */
	public void altaMesa(int cantComensales, String estado) throws DatosIncorrectosException {
		if(estado==null)
			throw new DatosIncorrectosException("Estado nulo.");
		if(Sistema.getInstance().getMesas().size() >= 1) {
			if(cantComensales >= 2) {
				Sistema.getInstance().getMesas().add(new Mesa(cantComensales,estado));
			}
			else 
				throw new DatosIncorrectosException("Cantidad de comensales debe ser mayor a 1.");
		}
		else
			Sistema.getInstance().getMesas().add(new Mesa(cantComensales,estado));
	}
	
	/**
	 * Modifica los datos de una mesa. Verifica que la cantidad de comensales sea menor a 2 en las mesas con id mayor a 0.
	 * @param mesa : Parametro de tipo mesa que representa la mesa a modificar. 
	 * @param cantComensales : Parametro que representa la cantidad de comensales para actualizar
	 * @param estado : Parametro que representa el estado de la mesa a actualizar
	 * @throws DatosIncorrectosException : Se lanza si la mesa es nula o no se encuentra, si el estado es nulo o si la cantidad de comensales es menor a 2
	 * - cantComensales != null
	 */
	
	public void modificarMesa(Mesa mesa, int cantComensales, String estado) throws DatosIncorrectosException {
		if( mesa==null || estado==null)
			throw new DatosIncorrectosException("Parametros invalidos.");
		if(mesa.getId() >= 1) {
			if(cantComensales >= 2) {
				int i = 0;
				ArrayList<Mesa> mesas = Sistema.getInstance().getMesas();
				while(i < mesas.size() && mesas.get(i).getId() != mesa.getId())
					i++;
				mesas.get(i).setCantComensales(cantComensales);
				mesas.get(i).setEstado(estado);
			}
			else
				throw new DatosIncorrectosException("Cantidad de comensales debe ser mayor a 1.");
		}
		else{
			int i = 0;
			ArrayList<Mesa> mesas = Sistema.getInstance().getMesas();
			while(i < mesas.size() && mesas.get(i).getId() != mesa.getId())
				i++;
			mesas.get(i).setCantComensales(cantComensales);
			mesas.get(i).setEstado(estado);
		}
	}
	
	/**
	 * Elimina una mesa del sistema
	 * @param mesa : parametro de tipo mesa que indica la mesa a eliminar
	 * @throws DatosIncorrectosException : Se lanza si la mesa es un objeto nulo.
	 * - mesa en el sistema
	 */
	
	public void eliminarMesa(Mesa mesa) throws DatosIncorrectosException  {
		if(mesa==null)
			throw new DatosIncorrectosException("Parametros invalidos.");
		Sistema.getInstance().getMesas().remove(mesa);
	}
	
	/**
	 * Crea y agrega un producto a la lista del sistema
	 * @param nombre : Parametro que representa el nombre del producto a agregar
	 * @param precioCosto : Parametro que representa el precio de costo del producto a agregar
	 * @param precioVenta : Parametro que representa el precio de venta del producto a agregar
	 * @param stockInicial : Parametro que representa el stock inicial del producto a agregar
	 * @throws DatosIncorrectosException : Se lanza si el nombre es nulo, si el precio de costo y de venta son menores que 0 y si el precio de venta es menor al precio de costo
	 * - precioCosto != null
	 * - precioVenta != null
	 * - stockInicial != null
	 */
	public void altaProducto(String nombre, float precioCosto, float precioVenta, int stockInicial) throws DatosIncorrectosException {
		if(nombre!= null && precioVenta > 0 && precioCosto > 0 && precioVenta >= precioCosto) 
			Sistema.getInstance().getProductos().add(new Producto(nombre, precioCosto, precioVenta, stockInicial));
		else
			throw new DatosIncorrectosException("Ingrese datos correctamente.");
	}
	
	/**
	 * Actualiza la cantidad en stock de un producto
	 * @param producto : Parametro que representa el producto a cambiar
	 * @param cantStock : Parametro que representa la cantidad a cambiar
	 * @throws DatosIncorrectosException : Se lanza si el producto es nulo o no se encuentra
	 * - cantStock != null
	 */
	public void actualizarProducto(Producto producto, int cantStock) throws DatosIncorrectosException {
		int i = 0;
		if(producto==null)
			throw new DatosIncorrectosException("Parametros invalidos.");
		ArrayList <Producto> productos = Sistema.getInstance().getProductos();
		while (i<0 && productos.get(i).getId() != producto.getId())
		while (i<productos.size() && productos.get(i).getId() != producto.getId())
			i++;
		if(productos.get(i).getId()!= producto.getId())
			throw new DatosIncorrectosException("No se encuentra el producto.");
		productos.get(i).setStock(productos.get(i).getStock() + cantStock);
	}
	/**
	 * 
	 * Modifica los valores de un producto
	 * @param id : Parametro que representa el id del producto a modificar
	 * @param nombre : Parametro que representa el nuevo nombre del producto a modificar
	 * @param precioCosto : Parametro que representa el nuevo precio de costo del producto a modificar
	 * @param precioVenta : Parametro que representa el nuevo precio de venta del producto a modificar
	 * @param cantStock : Parametro que representa el nuevo stock del producto a modificar 
	 * @throws DatosIncorrectosException : Se lanza si el precio de costo y de venta son menores que 0 y si el precio de venta es menor al precio de costo. Tambien se lanza si el producto no se encuentra
	 * - precioCosto != null
	 * - precioVenta != null
	 * - stockInicial != null
	 * - id != null
	 * - nombre != null
	 */
	public void modificarProducto(int id, String nombre, float precioCosto, float precioVenta, int cantStock) throws DatosIncorrectosException {
		int i = 0;

		if(precioVenta > 0 && precioCosto > 0 && precioVenta >= precioCosto) {
			ArrayList <Producto> productos = Sistema.getInstance().getProductos();
			while (i<productos.size() && productos.get(i).getId() != id)
				i++;
			if(productos.get(i).getId()!=id)
				throw new DatosIncorrectosException("No se encuentra el producto.");
			productos.get(i).setNombre(nombre);
			productos.get(i).setPrecioCosto(precioCosto);
			productos.get(i).setPrecioVenta(precioVenta);
			productos.get(i).setStock(cantStock);
		}
		else
			throw new DatosIncorrectosException("Ingrese datos correctamente.");
	}
	
	/**
	 * Elimina un producto de la lista de productos del sistema
	 * @param producto : Parametro que representa el producto a eliminar
	 * @throws DatosIncorrectosException : Se lanza si el producto es nulo
	 */
	public void eliminarProducto(Producto producto) throws DatosIncorrectosException {
		if(producto==null)
			throw new DatosIncorrectosException("Parametros invalidos.");
		Sistema.getInstance().getProductos().remove(producto);
	}
	
	/**
	 * Calcula el promedio de facturacion por mesa de un mozo
	 * @param mozo : Parametro que representa el mozo del cual obtener el promedio 
	 * @return Devuelve el promedio de facturacion por mesa de un mozo. Devuelve 0 si no tuvo mesas facturadas.
	 * @throws DatosIncorrectosException
	 */
	
	public float promedio(Mozo mozo) throws DatosIncorrectosException {
		if(mozo==null)
			throw new DatosIncorrectosException("Parametros invalidos.");
		if (mozo.getAcumulado()==0)
			return 0;
		else {
			return (float) (mozo.getAcumulado()/mozo.getAcumulado_mesas());
		}
	}
	
	/**
	 * Calcula el mozo con mayor volumen de ventas
	 * @return Devuelve un string con el nombre del mozo que mas vendio y la cantidad de mesas que facturo
	 * @throws DatosIncorrectosException :Se lanza si no hay mozos en el local
	 */
	public String mayorVolumen() throws DatosIncorrectosException {
		ArrayList<Mozo> mozos= Sistema.getInstance().getMozos();
		if(!mozos.isEmpty()) {
			Mozo mozo=mozos.get(0);
			for(Mozo i: mozos) {
				if (i.getAcumulado()>mozo.getAcumulado());
					mozo=i;
			}
			return mozo.getNombreYApellido() + " con un volumen de " + mozo.getAcumulado_mesas();
		}
		else
			throw new DatosIncorrectosException("No hay mozos en el local.");	
	}
	/**
	 * Calcula el mozo con menor volumen de ventas
	 * @return Devuelve un string con el nombre del mozo que menos vendio y la cantidad de mesas que facturo
	 * @throws DatosIncorrectosException :Se lanza si no hay mozos en el local
	 */
	public String menorVolumen() throws DatosIncorrectosException {
		ArrayList<Mozo> mozos= Sistema.getInstance().getMozos();
		if(!mozos.isEmpty()) {
			Mozo mozo=mozos.get(0);
			for(Mozo i: mozos) {
				if (i.getAcumulado()<mozo.getAcumulado());
					mozo=i;
			}
			return mozo.getNombreYApellido() + " con un volumen de " + mozo.getAcumulado_mesas();
		}
		else
			throw new DatosIncorrectosException("No hay mozos en el local.");
		
	}
}	