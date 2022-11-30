package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.tallerDeProgra.capaDeDatos.Comanda;
import com.tallerDeProgra.capaDeDatos.Local;
import com.tallerDeProgra.capaDeDatos.Mesa;
import com.tallerDeProgra.capaDeDatos.Mozo;
import com.tallerDeProgra.capaDeDatos.Operario;
import com.tallerDeProgra.capaDeDatos.OperarioAdministrador;
import com.tallerDeProgra.capaDeDatos.Producto;
import com.tallerDeProgra.capaDeDatos.Promocion;
import com.tallerDeProgra.capaDeDatos.PromocionTemporal;
import com.tallerDeProgra.capaDeDatos.RelacionMesaMozo;
import com.tallerDeProgra.capaDeNegocios.ConfiguracionDeSistema;
import com.tallerDeProgra.capaDeNegocios.GestionDePersonal;
import com.tallerDeProgra.capaDeNegocios.PedidosFacturacionYPromociones;
import com.tallerDeProgra.capaDeNegocios.Sistema;

public class SistemaDTO  implements Serializable{
	private static Sistema instance = null;
	private ArrayList <Mesa> mesas = new ArrayList<Mesa>();
	private ArrayList <Producto> productos= new ArrayList<Producto>();
	private ArrayList <Mozo> mozos= new ArrayList<Mozo>();
	private ArrayList <Promocion> promociones=new ArrayList<Promocion>();
	private ArrayList <PromocionTemporal> promocionesTemporales=new ArrayList<PromocionTemporal>();
	private ArrayList <Operario> operarios = new ArrayList<Operario>();
	private ArrayList <OperarioAdministrador> operariosAdministradores = new ArrayList<OperarioAdministrador>();
	private transient ArrayList <Comanda> comandas = new ArrayList<Comanda>();
	private transient HashMap <Integer ,RelacionMesaMozo>  asignacionesDesdeMesa = new HashMap();
	private transient HashMap <Integer ,RelacionMesaMozo>  asignacionesDesdeMozo = new HashMap();
	private GestionDePersonal zonaGestionDePersonal;
	private PedidosFacturacionYPromociones zonaPedidosYFacturacion;
	private ConfiguracionDeSistema zonaConfiguracionDeSistema;
	private Boolean diaIniciado=false;
	private Local local;
	
	public SistemaDTO(){
		
	}
	
	public ArrayList<Mesa> getMesas() {
		return mesas;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public ArrayList<Mozo> getMozos() {
		return mozos;
	}
	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}
	public ArrayList<PromocionTemporal> getPromocionesTemporales() {
		return promocionesTemporales;
	}
	public ArrayList<Operario> getOperarios() {
		return operarios;
	}
	public ArrayList<OperarioAdministrador> getOperariosAdministradores() {
		return operariosAdministradores;
	}
	public ArrayList<Comanda> getComandas() {
		return comandas;
	}
	public HashMap<Integer, RelacionMesaMozo> getAsignacionesDesdeMesa() {
		return asignacionesDesdeMesa;
	}
	public HashMap<Integer, RelacionMesaMozo> getAsignacionesDesdeMozo() {
		return asignacionesDesdeMozo;
	}
	public GestionDePersonal getZonaGestionDePersonal() {
		return zonaGestionDePersonal;
	}
	public PedidosFacturacionYPromociones getZonaPedidosYFacturacion() {
		return zonaPedidosYFacturacion;
	}
	public ConfiguracionDeSistema getZonaConfiguracionDeSistema() {
		return zonaConfiguracionDeSistema;
	}
	public Boolean getDiaIniciado() {
		return diaIniciado;
	}
	public Local getLocal() {
		return local;
	}
	public static void setInstance(Sistema instance) {
		SistemaDTO.instance = instance;
	}
	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	public void setMozos(ArrayList<Mozo> mozos) {
		this.mozos = mozos;
	}
	public void setPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}
	public void setPromocionesTemporales(ArrayList<PromocionTemporal> promocionesTemporales) {
		this.promocionesTemporales = promocionesTemporales;
	}
	public void setOperarios(ArrayList<Operario> operarios) {
		this.operarios = operarios;
	}
	public void setOperariosAdministradores(ArrayList<OperarioAdministrador> operariosAdministradores) {
		this.operariosAdministradores = operariosAdministradores;
	}
	public void setComandas(ArrayList<Comanda> comandas) {
		this.comandas = comandas;
	}
	public void setAsignacionesDesdeMesa(HashMap<Integer, RelacionMesaMozo> asignacionesDesdeMesa) {
		this.asignacionesDesdeMesa = asignacionesDesdeMesa;
	}
	public void setAsignacionesDesdeMozo(HashMap<Integer, RelacionMesaMozo> asignacionesDesdeMozo) {
		this.asignacionesDesdeMozo = asignacionesDesdeMozo;
	}
	public void setZonaGestionDePersonal(GestionDePersonal zonaGestionDePersonal) {
		this.zonaGestionDePersonal = zonaGestionDePersonal;
	}
	public void setZonaPedidosYFacturacion(PedidosFacturacionYPromociones zonaPedidosYFacturacion) {
		this.zonaPedidosYFacturacion = zonaPedidosYFacturacion;
	}
	public void setZonaConfiguracionDeSistema(ConfiguracionDeSistema zonaConfiguracionDeSistema) {
		this.zonaConfiguracionDeSistema = zonaConfiguracionDeSistema;
	}
	public void setDiaIniciado(Boolean diaIniciado) {
		this.diaIniciado = diaIniciado;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	
	
}
