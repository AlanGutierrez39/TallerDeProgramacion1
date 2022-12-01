package capaDeDatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import enums.EstadoComanda;

/**
 * Clase que representa una comanda
 * 
 * @author Nahuel
 *
 */

public class Comanda implements Serializable
{
	private int id;
	private Date fecha;
	private Mesa mesa;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private String estado;
	private static int identificador = 0;

	/**
	 * Constructor vacio para la instanciacion de una comanda
	 */
	public Comanda()
	{
		super();
	}

	// ----------------------------Constructor-------------------------//
	/**
	 * Constructor para generar una Comanda
	 * 
	 * @param fecha   : Fecha de creacion de una comanda
	 * @param mesa    : Mesa de una comanda
	 * @param pedidos : Lista de pedidos de una comanda - fecha != null <br>
	 *                - mesa != null <br>
	 *                - pedidos != null <br>
	 */
	public Comanda(Date fecha, Mesa mesa, ArrayList<Pedido> pedidos)
	{
		super();
		this.identificador += 1;
		this.id = this.identificador;
		this.fecha = fecha;
		this.mesa = mesa;
		this.pedidos = pedidos;
		this.estado = EstadoComanda.ABIERTA.getEstado();
	}

	// ----------------------------Getters y Setters-------------------------//
	/**
	 * 
	 * @return El Id de una comanda
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return La fecha de la comanda
	 */
	public Date getFecha()
	{
		return fecha;
	}

	/**
	 * @param fecha :la fecha de una comanda a modificar - fecha != null <br>
	 *              - fecha != "" <br>
	 */
	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}

	/**
	 * 
	 * @return mesa de la comanda
	 */
	public Mesa getMesa()
	{
		return mesa;
	}

	/**
	 * @param mesa : Mesa a modificar en la comanda - mesa != null <br>
	 */
	public void setMesa(Mesa mesa)
	{
		this.mesa = mesa;
	}

	/**
	 * 
	 * @return Lista de pedidos asociados a la comanda
	 */
	public ArrayList<Pedido> getPedidos()
	{
		return pedidos;
	}

	/**
	 * @param pedidos : Lista a modificar en la comanda - pedidos != null <br>
	 */
	public void setPedidos(ArrayList<Pedido> pedidos)
	{
		this.pedidos = pedidos;
	}

	/**
	 * 
	 * @return Estado de una comanda
	 */
	public String getEstado()
	{
		return estado;
	}

	/**
	 * 
	 * @param estado : Estado a modificar en la comanda
	 */
	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	/**
	 * Metodo toString de la comanda
	 */
	@Override
	public String toString()
	{
		return "Comanda [id=" + id + ", fecha=" + fecha + ", mesa=" + mesa + ", pedidos=" + pedidos + ", estado="
				+ estado + "]";
	}

}
