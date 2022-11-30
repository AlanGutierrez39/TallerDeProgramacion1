package com.tallerDeProgra.capaDePresentacion.Vistas;

public interface IVistaLogin extends IVista{
	String getNombreUsuario();
	String getPassword();
	void usuarioIncorrecto(String texto);
	void passwordIncorrecto(String texto);
	
}
