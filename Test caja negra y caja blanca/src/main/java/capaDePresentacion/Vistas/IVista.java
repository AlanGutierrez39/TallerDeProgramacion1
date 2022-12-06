package capaDePresentacion.Vistas;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public interface IVista {
	void addActionListener(ActionListener listener);

	void addWindowListener(WindowListener windowListener);
	void cerrar();
	// ----------------------MENU ADMINISTRADOR------------------------//
	static final String INGRESAR = "ingresar";
	static final String ARRANCAR_DIA = "arrancar_dia";
	static final String ASIGNAR_MOZO = "asignar_mozo";
	static final String CONFIGURAR_EMPRESA = "configurar_empresa";
	static final String MOZOS = "mozos";
	static final String MESAS = "mesas";
	static final String OPERARIOS = "operarios";
	static final String PRODUCTO = "producto";
	static final String PROMOCION = "promocion";
	static final String PROMOCION_TEMPORAL = "promocion_temporal";
	static final String VERIFICAR_ESTADISTICAS = "verificar_estadisticas";
	static final String FACTURACION = "facturacion";
	static final String SALIR = "salir";

	// ----------------------ABM OPERARIOS------------------------//
	static final String AGREGAR_OPERARIO = "agregar_operario";
	static final String MODIFICAR_OPERARIO = "modificar_operario";
	static final String ELIMINAR_OPERARIO = "eliminar_operario";
	static final String SALIR_DE_OPERARIO = "salir_de_operario";
	static final String CONFIRMAR_OPERARIO = "confirmar_operario";
	static final String CANCELAR_OPERARIO = "cancelar_operario";
	// ----------------------ABM MESA------------------------//
	static final String AGREGAR_MESA = "agregar_mesa";
	static final String MODIFICAR_MESA = "modificar_mesa";
	static final String ELIMINAR_MESA = "eliminar_mesa";
	static final String SALIR_DE_MESA = "salir_de_mesa";
	static final String CONFIRMAR_MESA = "confirmar_mesa";
	static final String CANCELAR_MESA = "cancelar_mesa";
	// ----------------------ABM MOZO------------------------//
	static final String AGREGAR_MOZO = "agregar_mozo";
	static final String MODIFICAR_MOZO = "modificar_mozo";
	static final String ELIMINAR_MOZO = "eliminar_mozo";
	static final String SALIR_DE_MOZO = "salir_de_mozo";
	static final String CONFIRMAR_MOZO = "confirmar_mozo";
	static final String CANCELAR_MOZO = "cancelar_mozo";
	// ----------------------ABM PRODUCTO------------------------//
	static final String AGREGAR_PRODUCTO = "agregar_producto";
	static final String MODIFICAR_PRODUCTO = "modificar_producto";
	static final String ELIMINAR_PRODUCTO = "eliminar_producto";
	static final String SALIR_DE_PRODUCTO = "salir_de_producto";
	static final String ACTUALIZAR_PRODUCTO = "actualizar_producto";
	static final String CONFIRMAR_PRODUCTO = "confirmar_producto";
	static final String CANCELAR_PRODUCTO = "cancelar_producto";
	// ----------------------ABM PROMOCION------------------------//
	static final String AGREGAR_PROMOCION = "agregar_promocion";
	static final String MODIFICAR_PROMOCION = "modificar_promocion";
	static final String ELIMINAR_PROMOCION = "eliminar_promocion";
	static final String SALIR_DE_PROMOCION = "salir_de_promocion";
	static final String ACTUALIZAR_PROMOCION = "actualizar_promocion";
	static final String CONFIRMAR_PROMOCION = "confirmar_promocion";
	static final String CANCELAR_PROMOCION = "cancelar_promocion";
	// ----------------------ABM PROMOCION TEMPORAL------------------------//
	static final String AGREGAR_PROMOCION_TEMPORAL = "agregar_promocion_temporal";
	static final String MODIFICAR_PROMOCION_TEMPORAL = "modificar_promocion_temporal";
	static final String ELIMINAR_PROMOCION_TEMPORAL = "eliminar_promocion_temporal";
	static final String SALIR_DE_PROMOCION_TEMPORAL = "salir_de_promocion_temporal";
	static final String ACTUALIZAR_PROMOCION_TEMPORAL = "actualizar_promocion_temporal";
	static final String CONFIRMAR_PROMOCION_TEMPORAL = "confirmar_promocion_temporal";
	static final String CANCELAR_PROMOCION_TEMPORAL = "cancelar_promocion_temporal";
	// ----------------------ASIGNAR ESTADOS A LOS MOZOS------------------------//
	static final String GUARDAR_ESTADO_MOZO = "guardar_estado_mozo";
	static final String ATRAS_ESTADO_MOZO = "atras_estado_mozo";
	// ----------------------ESTADISTICAS------------------------//
	static final String MODIFICACION_LISTA_ESTADISTICA= "modificacion_lista_estadistica";
	static final String ATRAS_ESTADISTICAS= "atras_estadisticas";
	// ----------------------CONFIGURACION DE LA EMPRESA------------------------//
	static final String MODIFICAR_NOMBRE_EMPRESA= "modificar_nombre_empresa	";
	static final String MODIFICAR_SUELDO_EMPRESA= "modificar_sueldo_empresa";
	static final String ATRAS_EMPRESA= "atras_empresa";
	// ----------------------FACTURACION Y PEDIDOS------------------------//
	static final String CREAR_COMANDA = "crear_comanda";
	static final String CERRAR_COMANDA = "cerrar_comanda";
	static final String AGREGAR_PEDIDO = "agregar_pedido";
	static final String ATRAS_COMANDA = "atras_comanda";
	// ----------------------ALTA COMANDA------------------------//
	static final String SIGUIENTE_COMANDA = "siguiente_comanda";
	static final String ATRAS_SIGUIENTE_COMANDA = "atras_siguiente_comanda";

	// ----------------------CERRAR COMANDA------------------------//
	static final String CERRAR_COMANDA_CONFIRMACION = "cerrar_comanda_confirmacion";
	// ----------------------ALTA PEDIDO------------------------//
	static final String ATRAS_PEDIDO = "atras_pedido";
	static final String CONFIRMAR_PEDIDO = "confirmar_pedido";
	static final String MODIFICACION_LISTA_PRODUCTOS ="modificacion_lista_productos";
}
