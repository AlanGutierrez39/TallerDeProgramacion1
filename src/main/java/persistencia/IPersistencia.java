package persistencia;

import java.io.IOException;
import java.io.Serializable;

/**
 *  
 *<br>
 *Interfaz que representa los m�todos para lograr la persistencia.
 */
public interface IPersistencia
{
	/**
	 * M�todo que permite abrir un archivo para su lectura.<br>
	 * <b>Pre: </b> El par�metro debe ser distinto de null.<br>
	 * @param nombre: Par�metro de tipo String que representa el nombre del archivo a abrir.
	 */
	void abrirInput(String nombre) throws IOException;

	/**
	 * M�todo que permite abrir un archivo para su escritura.<br>
	 * <b>Pre: </b> El par�metro debe ser distinto de null.<br>
	 * @param nombre: Par�metro de tipo String que representa el nombre del archivo a abrir.
	 */
    void abrirOutput(String nombre) throws IOException;

    /**
	 * M�todo que permite cerrar un archivo abierto previamente para su escritura.<br>
	 */
    void cerrarOutput() throws IOException;

    /**
	 * M�todo que permite cerrar un archivo abierto previamente para su lectura.<br>
	 */
    void cerrarInput() throws IOException;

    /**
	 * M�todo que permite serializar un objeto de tipo Serializable.<br>
	 * <b>Pre: </b> El par�metro debe ser distinto de null.<br>
	 * <b>Post: </b> Serializar� la clase enviada por par�metro en el archivo abierto.<br>
	 * @param p: Par�metro de tipo Serializable que representa el objeto a serializar.
	 */
    void escribir(Serializable p) throws IOException;

    /**
	 * M�todo que permite deserializar un objeto.<br>
	 */
    Serializable leer() throws IOException, ClassNotFoundException;
}
