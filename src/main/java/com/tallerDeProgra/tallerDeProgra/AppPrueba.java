package com.tallerDeProgra.tallerDeProgra;

import java.io.IOException;

import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Controladores.ControladorLogin;

import persistencia.IPersistencia;
import persistencia.Persistencia;
import persistencia.SistemaDTO;
import persistencia.Utils;

public class AppPrueba
{
	public static void main(String[] args)
	{
		IPersistencia persistencia = new Persistencia();

		/*
		 * //Escritura try { persistencia.abrirOutput("Sistema.bin");
		 * System.out.println("Crea archivo escritura");
		 * //persistencia.escribir(Sistema.getInstance());
		 * System.out.println("Sistema grabado correctamente");
		 * persistencia.cerrarOutput(); System.out.println("Archivo cerrado"); }catch
		 * (IOException e) { System.out.println("Error"); }
		 */

		// Lectura
		try
		{
			persistencia.abrirInput("Sistema.bin");
			System.out.println("Archivo abierto");
			SistemaDTO sistemaDTO = (SistemaDTO) persistencia.leer();
			Utils.sistemaFromSistemaDTO(sistemaDTO);
			System.out.println("Sistema recuperado");
			persistencia.cerrarInput();
			System.out.println("Archivo cerrado");
		} catch (IOException | ClassNotFoundException e)
		{
			System.out.println("Error");
		}

		ControladorLogin controlador = new ControladorLogin();
	}
}
