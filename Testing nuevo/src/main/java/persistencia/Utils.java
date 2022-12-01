package persistencia;

import java.util.ArrayList;
import java.util.HashMap;

import capaDeDatos.Comanda;
import capaDeDatos.Local;
import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.OperarioAdministrador;
import capaDeDatos.Producto;
import capaDeDatos.Promocion;
import capaDeDatos.PromocionTemporal;
import capaDeDatos.RelacionMesaMozo;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.PedidosFacturacionYPromociones;
import capaDeNegocios.Sistema;

public class Utils {
	public static SistemaDTO sistemaDTOFromSistema(){
		SistemaDTO respuesta = new SistemaDTO();
		Sistema sistema = Sistema.getInstance();
		
		ArrayList <Mesa> mesas = sistema.getMesas();
		ArrayList <Producto> productos= sistema.getProductos();
		ArrayList <Mozo> mozos= sistema.getMozos();
		ArrayList <Promocion> promociones= sistema.getPromociones();
		ArrayList <PromocionTemporal> promocionesTemporales= sistema.getPromocionesTemporales();
		ArrayList <Operario> operarios = sistema.getOperarios();
		ArrayList <OperarioAdministrador> operariosAdministradores = sistema.getOperariosAdministradores();
		ArrayList <Comanda> comandas = sistema.getComandas();
		HashMap <Integer ,RelacionMesaMozo>  asignacionesDesdeMesa = new HashMap();
		HashMap <Integer ,RelacionMesaMozo>  asignacionesDesdeMozo = new HashMap();
		GestionDePersonal zonaGestionDePersonal = sistema.getZonaGestionDePersonal();
		PedidosFacturacionYPromociones zonaPedidosYFacturacion = sistema.getZonaPedidosYFacturacion();
		ConfiguracionDeSistema zonaConfiguracionDeSistema = sistema.getZonaConfiguracionDeSistema();
		Boolean diaIniciado=false;
		Local local = sistema.getLocal();
		
		respuesta.setMesas(mesas);
		respuesta.setProductos(productos);
		respuesta.setMozos(mozos);
		respuesta.setPromociones(promociones);
		respuesta.setPromocionesTemporales(promocionesTemporales);
		respuesta.setOperarios(operarios);
		respuesta.setOperariosAdministradores(operariosAdministradores);
		respuesta.setComandas(comandas);
		respuesta.setAsignacionesDesdeMesa(asignacionesDesdeMesa);
		respuesta.setAsignacionesDesdeMozo(asignacionesDesdeMozo);
		respuesta.setZonaGestionDePersonal(zonaGestionDePersonal);
		respuesta.setZonaPedidosYFacturacion(zonaPedidosYFacturacion);
		respuesta.setZonaConfiguracionDeSistema(zonaConfiguracionDeSistema);
		respuesta.setDiaIniciado(diaIniciado);
		respuesta.setLocal(local);
		return respuesta;
	}
	
	public static void sistemaFromSistemaDTO(SistemaDTO sistemaDTO) {
		Sistema sistema = Sistema.getInstance();
		sistema.setMesas(sistemaDTO.getMesas());
		sistema.setProductos(sistemaDTO.getProductos());
		sistema.setMozos(sistemaDTO.getMozos());
		sistema.setPromociones(sistemaDTO.getPromociones());
		sistema.setPromocionesTemporales(sistemaDTO.getPromocionesTemporales());
		sistema.setOperarios(sistemaDTO.getOperarios());
		sistema.setOperariosAdministradores(sistemaDTO.getOperariosAdministradores());
		sistema.setComandas(sistemaDTO.getComandas());
		sistema.setLocal(sistemaDTO.getLocal());
	}
}
