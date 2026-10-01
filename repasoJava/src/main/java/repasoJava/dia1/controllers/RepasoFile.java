package repasoJava.dia1.controllers;

import java.io.File;
import java.io.IOException;


public class RepasoFile {
	
	
	public static void main(String[] args) {
		String rutaDirectorio = "C:\\soraya";
		File directorio = new File(rutaDirectorio);
		// Referencio a un fichero dentro del directorio soraya
		File fichero = new File(directorio, "fichero.txt");
		try {
			boolean creado = fichero.createNewFile(); // Aquí Sí creo fichero
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al crear fichero:" + e.getMessage());
		}

	}
}
