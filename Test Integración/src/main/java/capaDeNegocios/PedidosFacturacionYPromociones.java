package capaDeNegocios;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import capaDeDatos.Comanda;
import capaDeDatos.Factura;
import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Pedido;
import capaDeDatos.Producto;
import capaDeDatos.Promocion;
import capaDeDatos.PromocionPadre;
import capaDeDatos.PromocionTemporal;
import enums.Dias;
import enums.Estado;
import enums.EstadoComanda;
import enums.EstadosMesa;
import excepciones.DatosIncorrectosException;
/**
 * Clase que representa una de las subclases del patron facade de la clase Sistema
 * @author Nahuel
 *
 */
public class PedidosFacturacionYPromociones implements Serializable{
	private static PedidosFacturacionYPromociones instance = null;
	/**
	 * Constructor privado del sistema debido a que se utiliza el patron Singleton
	 */
	public PedidosFacturacionYPromociones() {
		
	}
	/**
	 * Metodo estatico para instanciar una clase por unica vez
	 * @return Devuelve la instancia de clase PedidosFacturacionYPromociones
	 */
	public static PedidosFacturacionYPromociones getInstance() {
		if (PedidosFacturacionYPromociones.instance == null) {
			PedidosFacturacionYPromociones.instance = new PedidosFacturacionYPromociones();
		}
		return instance;
	}
	
	/**
	 * Agrega una comanda al sistema
	 * @param comanda :Parametro que contiene la comanda a agregar al sistema
	 * @throws DatosIncorrectosException :Se lanza si la comanda es nula
	 * post: <br>
	 * - Se agrega una nueva comanda<br>
	 * - La mesa correspondiente se ocupo
	 */
	public void altaComanda(Comanda comanda) throws DatosIncorrectosException {
		Mozo mozoAsociado;
		int i=0;
		boolean haymesaLibre=false;
		Producto producto;
		if(comanda==null) //1 
			throw new DatosIncorrectosException("Parametros invalidos."); //2
		for(Mesa mesa: Sistema.getInstance().getMesas()) {  //3
			if(mesa.getEstado().equals(EstadosMesa.LIBRE.getEstado())){ //4
				haymesaLibre=true; //4.1
			} //5 
		} //6
		if(!haymesaLibre)  //7
			throw new DatosIncorrectosException("No hay mesas libres en el restaurante"); //8
		
		
		if(comanda.getMesa().getEstado().equals(EstadosMesa.OCUPADA.getEstado()) ) //9
			throw new DatosIncorrectosException("La mesa esta ocupada, debe elegir una mesa activa."); //10
		
		mozoAsociado =Sistema.getInstance().getAsignacionesDesdeMesa().get(comanda.getMesa().getId()).getMozo();
		
		if( mozoAsociado==null || !mozoAsociado.getEstado().equals(Estado.ACTIVO.getEstado())) //11
			throw new DatosIncorrectosException("El mozo asociado no existe o no se encuentra disponible."); //12
		
		/*De aca para abajo controla que haya al menos dos promociones activas*/
		ArrayList<Promocion> promociones=Sistema.getInstance().getPromociones();
		if(promociones==null) //13
			throw new DatosIncorrectosException("No hay promociones activas."); //14

		while(i<promociones.size() && !promociones.get(i).isActiva()) { //15     la condicion aqui estaba mal
			i++; //16
	}
		if(i<promociones.size()) //17
			producto=promociones.get(i).getProducto(); //18 
		else //19
			throw new DatosIncorrectosException("No hay promociones activas."); //20

		i++;
  /*21*/ while(i<promociones.size() && !promociones.get(i).isActiva() && producto.getId()!=promociones.get(i).getProducto().getId()) //21
			i++; //22
		if(!(i<promociones.size())) //23      
		/*24*/	throw new DatosIncorrectosException("No hay suficientes promociones activas. Se necesitan al menos dos promociones de dos productos distintos");//24
		
		ArrayList<Mesa> mesas= Sistema.getInstance().getMesas();
		for(Mesa mesa: mesas) { //25
			if(comanda.getMesa().getId()== mesa.getId()) //26
				mesa.setEstado(EstadosMesa.OCUPADA.getEstado()); //26.1
		}//27
		
		
		Sistema.getInstance().getComandas().add(comanda);
		
		
	} //28
	/**
	 * Elimina una comanda del sistema
	 * @param comanda :Parametro que contiene la comanda a eliminar del sistema
	 * @throws DatosIncorrectosException :Se lanza si la comanda es nula
	 */
	public void bajaComanda(Comanda comanda) throws DatosIncorrectosException {
		if(comanda==null)
			throw new DatosIncorrectosException("Parametros invalidos.");
		Sistema.getInstance().getComandas().remove(comanda);
		
	}

	/**
	 * Crea y agrega una promocion a la lista de promociones del sistema
	 * @param producto :Parametro que representa el producto al cual se le aplicara la promocion creada
	 * @param diasDePromo :Parametro de tipo lista que contiene los dias de la semana en los cuales se aplica la promocion
	 * @param aplicaDosporuno : Parametro booleano que indica si una promocion tiene 2 x 1 en productos
	 * @param aplicaDescCantidadMinima : Parametro booleano que indica si una promocion aplica descuento por cantidad minimoa
	 * @param cantidadMinima :Parametro que indica la cantidad minima a aplicar descuento
	 * @param precioUnitario : Parametro que indica el precio unitario con descuento para el producto de la promocion
	 * @throws DatosIncorrectosException se lanza si producto es nulo, si diasDePromo es nulo o vacio y si aplicaDosporuno y aplicaDESCcANTIDADminima son false simultaneamente
	 */
		
	public void altaPromocion(Producto producto, ArrayList<String> diasDePromo, boolean aplicaDosporuno,
			boolean aplicaDescCantidadMinima, int cantidadMinima, float precioUnitario) throws DatosIncorrectosException {
		
		if(producto == null || diasDePromo == null )
			throw new DatosIncorrectosException("Parametros invalidos.");
		if( diasDePromo.size()==0 )
			throw new DatosIncorrectosException("Seleccione al menos un dia de la semana");
		if(aplicaDosporuno== false && aplicaDescCantidadMinima==false)
			throw new DatosIncorrectosException("Al menos tiene que aplicar algun tipo de descuento.");
		Promocion promocion= new Promocion();
		promocion.setProducto(producto);
		promocion.setDiasPromocion(diasDePromo);
		promocion.setAplicaDosXUno(aplicaDosporuno);
		promocion.setAplicaDescXCantMin(aplicaDescCantidadMinima);
		promocion.setDescXCantMin(cantidadMinima);
		promocion.setDescXCantXPrecioUnitario(precioUnitario);
		promocion.setActiva(true);
		Sistema.getInstance().getPromociones().add(promocion);
	}
	
	/**
	 * Crea y agrega una promocion temporal a la lista de promociones del sistema
	 * @param nombre : Parametro que representa el nombre de la promocion temporal
	 * @param formaDePago : Parametro que representa la forma de pago de la promocion temporal
	 * @param porcentajeDesc : Parametro que representa el porcentaje de la promocion temporal
	 * @param diasDePromo : Parametro de tipo lista que contiene los dias de la semana en los cuales se aplica la promocion
	 * @param esAcumulable : Parametro de tipo booleano que determina si la promocion temporal es acumulable con una promocion no temporal
	 * @throws DatosIncorrectosException  Se lanza si el nombre o forma de pago es nulo, si diasDePromo es nulo o vacio,
	 *  - porcentajeDesc != null
	 *  - esAcumulable != null
	 */

	public void altaPromocionTemporal(String nombre, String formaDePago, int porcentajeDesc, ArrayList<String> diasDePromo,
			boolean esAcumulable) throws DatosIncorrectosException {
		if(nombre==null || formaDePago==null ||diasDePromo==null)
			throw new DatosIncorrectosException("Parametros invalidos.");
		if( diasDePromo.size()==0 )
			throw new DatosIncorrectosException("Seleccione al menos un dia de la semana");
		PromocionTemporal promocionT= new PromocionTemporal();
		promocionT.setNombre(nombre);
		promocionT.setFormaDePago(formaDePago);
		promocionT.setPorcentajeDescuento(porcentajeDesc);
		promocionT.setDiasPromocion(diasDePromo);
		promocionT.setAcumulable(esAcumulable);
		promocionT.setActivo(true);
		Sistema.getInstance().getPromocionesTemporales().add(promocionT);
	}
	/**
	 * Elimina una promocion del sistema, verifica que la promocion no sea nula
	 * @param comanda :Parametro que contiene la promocion a eliminar del sistema
	 * @throws DatosIncorrectosException :Se lanza si la promocion es nula
	 */
	public void bajaPromocion(Promocion promocion) throws DatosIncorrectosException {
		if (promocion==null)
			throw new DatosIncorrectosException("Parametros invalidos.");
		Sistema.getInstance().getPromociones().remove(promocion);
		
	}
	/**
	 * Elimina una promocion temporal del sistema. Verifica que la promocion temporal no sea nula
	 * @param comanda :Parametro que contiene la promocion temporal a eliminar del sistema
	 * @throws DatosIncorrectosException :Se lanza si la promocion temporal es nula
	 */
	public void bajaPromocionTemporal(PromocionTemporal promocionTemporal) throws DatosIncorrectosException {
		if (promocionTemporal==null)
			throw new DatosIncorrectosException("Parametros invalidos.");
		Sistema.getInstance().getPromocionesTemporales().remove(promocionTemporal);
		
	}
	/**
	 * Crea y agrega un pedido a una comanda,actualiza el stock del producto, verifica que los parametros no sean nulos, verifica que la cantidad no sea menor o igual a 0 y verifica que la cantidad en stock sea suficiente para abastecer el pedido
	 * @param comanda Parametro que determina la comanda a la cual agregar el producto
	 * @param producto :Parametro que determina el producto que utiliza el pedido
	 * @param cantidad :Parametro que determina la cantidad del producto en el pedido
	 * @throws DatosIncorrectosException :Se lanza si comanda o producto son nulos, si la cantidad de productos es menor o igual a 0 y si la cantidad de productos supera la cantidad de productos en stock.
	 * precioUnitario != null
	 * cantidadMinima != null
	 */
	
	public void altaPedido(Comanda comanda, Producto producto, int cantidad) throws DatosIncorrectosException {
		
		if(comanda==null || producto == null )
			throw new DatosIncorrectosException("Parametros invalidos.");
		if(cantidad<=0)
			throw new DatosIncorrectosException("La cantidad no puede ser menor o igual a 0.");
		if(cantidad-producto.getStock()>=0)
			throw new DatosIncorrectosException("No hay suficiente cantidad de productos en el stock");
		producto.setStock(producto.getStock()-cantidad);
		ArrayList<Comanda> comandas= Sistema.getInstance().getComandas();
		Pedido pedido=new Pedido();
		pedido.setCantidad(cantidad);
		pedido.setFecha(new Date());
		pedido.setProducto(producto);
		for(Comanda i:comandas) {
			if(i==comanda)
				i.getPedidos().add(pedido);
		}
		
	}
	/**
	 *  Cierra una comanda, cambiandole el estado a cerrado. Calcula los descuentos para todas las promociones que deban aplicarse y crea una factura con la informacion de la comanda y los descuentos aplicados. Al finalizar elimina la comanda.
	 * @param comanda : Parametro que representa la comanda a cerrar
	 * @param metodoPago : Parametro que representa el metodo de pago con el que se abonara la comanda
	 * @throws DatosIncorrectosException : Se lanza si la comanda o el metodo de pago es nulo
	 * comanda.estado != null
	 */

	
	public void cerrarComanda(Comanda comanda, String metodoPago) throws DatosIncorrectosException {
		ArrayList<PromocionPadre> listaPromos= new ArrayList<PromocionPadre>();
		ArrayList<Promocion> promociones = Sistema.getInstance().getPromociones();
		ArrayList<PromocionTemporal> promocionesTemporales= Sistema.getInstance().getPromocionesTemporales();
		Double total=0., totalPedido;
		LocalDate date = LocalDate.now();
	    boolean aplica;
	    boolean aplicaPromocionNoTemporal=false;
	    int productos2x1;
	    if(comanda==null || metodoPago == null )
			throw new DatosIncorrectosException("Parametros invalidos.");
	    if(comanda.getEstado().equals(EstadoComanda.CERRADA.getEstado()) )
			throw new DatosIncorrectosException("La comanda ya fue cerrada");
	    else
		comanda.setEstado(EstadoComanda.CERRADA.getEstado());
	    for(Pedido pedido: comanda.getPedidos()) {
	    	totalPedido=0.;
			for(Promocion promo:promociones) {//recorro las promociones comunes
				aplica=false;
				if(promo.isActiva()) {
					if(promo.getProducto()==pedido.getProducto()) { //Si es el producto de la promo
						for(String dia: promo.getDiasPromocion()) { //Revisa si el dia actual coincide con el dia de la promo
							String diaPromo= intToStringDayOfWEEK(date.getDayOfWeek().getValue());
							if(dia.equals(diaPromo)) { //Si coincide el dia con el dia de la promo
								if(promo.isAplicaDescXCantMin() && promo.getDescXCantMin()<=pedido.getCantidad()) { //Aplica descuento por cantidad
									aplica=true;
									totalPedido+= pedido.getCantidad()*promo.getDescXCantXPrecioUnitario();
								}
								if(promo.isAplicaDosXUno()) { //Aplica dos por uno
									productos2x1=pedido.getCantidad()/2; //Castea hacia abajo por los impares
									if(aplica) //Si hubo descuento por cantidad minima
										totalPedido-=productos2x1*promo.getDescXCantXPrecioUnitario();
									else {
										totalPedido=(double) (pedido.getCantidad()*pedido.getProducto().getPrecioVenta());
										totalPedido-=productos2x1*pedido.getProducto().getPrecioVenta();   //Resta al total el descuento
									}
									aplica=true;
								}
							}
						}
					}
					if(aplica) {
						listaPromos.add(promo);
						total+=totalPedido; //suma con descuentos
						aplicaPromocionNoTemporal=true;
					}
					else
						total+=(double) (pedido.getCantidad()*pedido.getProducto().getPrecioVenta());// suma sin descuentos
				}
			}
	    }
	    
		for(PromocionTemporal promoT:promocionesTemporales) { //Recorro las promociones temporales
			aplica=false;
			if(promoT.isActivo()) {
				if(promoT.getFormaDePago().equals(metodoPago)) {
					for(String dia: promoT.getDiasPromocion()) { //Revisa si el dia actual coincide con el dia de la promo
						String diaPromo= intToStringDayOfWEEK(date.getDayOfWeek().getValue());
						if(dia.equals(diaPromo)) { //Si coincide el dia con el dia de la promo
							if(promoT.isAcumulable() || (!promoT.isAcumulable() && !aplicaPromocionNoTemporal)) { //Aplico promocion
								aplica= true;
								total-= total*promoT.getPorcentajeDescuento()/100;
							}
						}
					}
				}
			}
			if(aplica) {//aplica promocion
				listaPromos.add(promoT);
			}
		}
		
		Factura factura= new Factura();
		factura.setFecha(new Date());
		factura.setMesa(comanda.getMesa());
		factura.setMetodoDePago(metodoPago);
		factura.setProductos(comanda.getPedidos());
		factura.setPromociones(listaPromos);
		factura.setTotal(total);
		
		ArrayList<Mesa> mesas= Sistema.getInstance().getMesas();
		for(Mesa mesa: mesas)
			if(comanda.getMesa().getId()== mesa.getId())
				mesa.setEstado(EstadosMesa.LIBRE.getEstado());
		
		
		Mozo mozo=Sistema.getInstance().getAsignacionesDesdeMesa().get(comanda.getMesa().getId()).getMozo();
		mozo.setAcumulado_mesas(mozo.getAcumulado_mesas()+1);
		mozo.setAcumulado(mozo.getAcumulado() + total);
		Sistema.getInstance().getFacturas().add(factura);
		Sistema.getInstance().getComandas().remove(comanda);
		
	}
	
	String intToStringDayOfWEEK(int numDia) {
		if(numDia==1)
			return Dias.LUNES.getDia();
		if(numDia==2)
			return Dias.MARTES.getDia();
		if(numDia==3)
			return Dias.MIERCOLES.getDia();
		if(numDia==4)
			return Dias.JUEVES.getDia();
		if(numDia==5)
			return Dias.VIERNES.getDia();
		if(numDia==6)
			return Dias.SABADO.getDia();
		if(numDia==7)
			return Dias.DOMINGO.getDia();
		
		return null;
			
	}
	
	
	

}
