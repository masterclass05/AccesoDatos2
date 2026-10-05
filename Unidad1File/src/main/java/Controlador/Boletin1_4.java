package Controlador;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Boletin1_4 {
    private static final Logger logger = LogManager.getLogger(Boletin1_4.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ruta = ("C:\\Users\\alumno\\Desktop");

		// String userHome = System.getProperty("user.home");
		// Path ruta = Paths.get(userHome, "Desktop");

		Boletin1_4_2 bol = new Boletin1_4_2();
		bol.mostrarInformacion(ruta);
	}

}

class Boletin1_4_2 {
	private static final Logger logger = LogManager.getLogger(Boletin1_4.class);

	public void mostrarInformacion(String nombreFichero) {
		File f = new File(nombreFichero);

		if (f.isDirectory()) {
			
			logger.info("Directorio:" + f.getName());
		
				for (File ficheroHijo : f.listFiles()) {
					mostrarInformacion(ficheroHijo.getAbsolutePath());
				}

		}
		else //caso base es fichero
		{
			logger.info("Fichero:" + f.getName()); // Nombre del archivo
		}
	}

}
