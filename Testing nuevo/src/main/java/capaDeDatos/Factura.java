package capaDeDatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 * Clase que representa una factura
 * 
 * @author Nahuel
 *
 */
public class Factura implements Serializable{
	private int id;
	private Date fecha;
	private Mesa mesa;
	private ArrayList<Pedido> pedidos;
	private double total;
	private String metodoDePago;
	private ArrayList<PromocionPadre> promociones;
	private static int identificador=0;
	
	
	
	
	
	//----------------------------Constructor-------------------------//
	public Factura(int id, Date fecha, Mesa mesa, ArrayList<Pedido> pedidos, float total, String metodoDePago,
			ArrayList<PromocionPadre> promociones) {
		super();
		this.identificador+=1;
		this.id = this.identificador;
		this.fecha = fecha;
		this.mesa = mesa;
		this.pedidos = pedidos;
		this.total = total;
		this.metodoDePago = metodoDePago;
		this.promociones = promociones;
	}
	

	public Factura() {
		super();
		this.identificador+=1;
		this.id = this.identificador;
	}

	
	//----------------------------Getters y Setters-------------------------//

	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	/**
	 * fecha != null 
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Mesa getMesa() {
		return mesa;
	}
	/**
	 * mesa != null 
	 * @param mesa
	 */
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public ArrayList<Pedido> getProductos() {
		return pedidos;
	}
	/**
	 * productos != null
	 * productos no vacia
	 * @param productos
	 */
	public void setProductos(ArrayList<Pedido> productos) {
		this.pedidos = productos;
	}
	public double getTotal() {
		return total;
	}
	/**
	 * total != null
	 * @param total
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	public String getMetodoDePago() {
		return metodoDePago;
	}
	/**
	 * metodoPago != null
	 * @param metodoDePago
	 */
	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}
	public ArrayList<PromocionPadre> getPromociones() {
		return promociones;
	}
	/**
	 * promociones != null
	 * @param promociones
	 */
	public void setPromociones(ArrayList<PromocionPadre> promociones) {
		this.promociones = promociones;
	}
	
	
	
	
	
}
