package Controlador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Excepciones.RutaNoValidaException;

public class Boletin1_2 {
    private static final Logger logger = LogManager.getLogger(Boletin1_2.class);

	public static void main(String[] args) throws RutaNoValidaException, IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
    	
    	logger.info("Introduce la ruta del directorio");
    	String ruta = scanner.nextLine();
    
	
    	Boletin1_2_2 bol = new Boletin1_2_2();
    	bol.mostrarInformacion(ruta);
        
	}
	
}

class Boletin1_2_2{
    private static final Logger logger = LogManager.getLogger(Boletin1_2.class);

	public void mostrarInformacion(String ruta) throws IOException{
    	String userHome = System.getProperty("user.home"); 
        Path rutaDirectorio = Paths.get(userHome, ruta);
        
        File directorio = rutaDirectorio.toFile();
        
        logger.info("Nombre: "+directorio.getName());
      //Rutas
        logger.info("Ruta tal como se ha escrito: "+ruta);
        logger.info("Ruta absoluta: "+ directorio.getAbsolutePath());
        logger.info("Ruta canónica: "+ directorio.getCanonicalPath());  
        //Directorio Padre
        logger.info("Directorio padre: "+directorio.getParent());
        if (directorio.isDirectory()) {
			logger.info("Es un directorio");
		}else {
			logger.info("Es un fichero");
		}
        //Permisos
        logger.info("Permiso Lectura: "+directorio.canRead());
        logger.info("Permiso de Escritura: "+directorio.canWrite());
        logger.info("Permiso de Ejecución: "+directorio.canExecute());
        //Oculto
        logger.info("Esta oculto: "+directorio.isHidden());
        //Tamaño en bytes
        logger.info("Tamaño en bytes: "+directorio.length());
        //Nº de elementos
        logger.info("Número de elementos: "+directorio.list().length);
        //Fecha de última modificación
        logger.info("Fecha de ultima modificación: "+ directorio.lastModified());
	}
}
