package Controlador;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Excepciones.RutaNoValidaException;


public class Boletin1_1 {
    private static final Logger logger = LogManager.getLogger(Boletin1_1.class);
   
    public static void main(String[] args) throws RutaNoValidaException {
    	Scanner scanner = new Scanner(System.in);
    	
    	logger.info("Dime la ruta del directorio");
    	String ruta = scanner.nextLine();
    	
    	String userHome = System.getProperty("user.home");
        Path rutaDirectorio = Paths.get(userHome, ruta);
        
        File directorio = rutaDirectorio.toFile();

        int contadorD = 0;
        int contadorF = 0;

    	if (directorio.isDirectory() && directorio.exists()) {
    		 for(File f : directorio.listFiles())//Listamos el contenido del directorio
             {
          	   if (f.isFile()) {
      			 System.out.println("[F]"+f.getName());
      			 contadorF++;

			} else if (f.isDirectory()) {
     			 System.out.println("[D]"+f.getName());
     			 contadorD++;
			}else {
     			 System.out.println("[Ni dea]"+f.getName());
			}
             }
    		logger.info("Hay un total de " + contadorD+" directorios y "+contadorF+" ficheros");
		}else {
			throw new RutaNoValidaException("La ruta no existe o no es un directorio");
		}
    	
    	
    	
    	
    }
    
}
