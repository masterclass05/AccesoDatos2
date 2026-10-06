package Controlador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClaseFile {

    private static final Logger logger = LogManager.getLogger(ClaseFile.class);

    public static void main(String[] args) {
        // Obtenemos la ruta del escritorio de forma multiplataforma usando la carpeta personal del usuario actual
        String userHome = System.getProperty("user.home");
        Path rutaDirectorio = Paths.get(userHome, "Desktop", "Prueba");

        File directorio = rutaDirectorio.toFile();

        if (directorio.exists() && directorio.isDirectory()) {
            for(File f : directorio.listFiles())//Listamos el contenido del directorio
            {
         	   System.out.println(f.getName());
            }
         } else {
             System.out.println("El directorio no existe o no es un directorio.");
         }

        // 1. Comprobación y creación de la ruta si no existe
        if (!directorio.exists()) {
            boolean carpetaCreada = directorio.mkdirs(); // Crea la carpeta y subcarpetas si no existen
            if (carpetaCreada) {
                logger.info("Directorio creado correctamente: " + directorio.getAbsolutePath());
            } else {
                logger.error("No se pudo crear el directorio: " + directorio.getAbsolutePath());
                return; // Finalizamos la ejecución si no se puede crear la carpeta
            }
        }

        // 2. Definición del fichero dentro del directorio comprobado
        File fichero = new File(directorio, "fichero.txt");

        try {
            // Intentamos crear el fichero
            boolean creado = fichero.createNewFile();
            if (creado) {
                logger.info("El fichero fue creado con éxito en: " + fichero.getAbsolutePath());
            } else {
                logger.info("El fichero ya existía en la ruta especificada.");
            }
        } catch (IOException e) {
            logger.error("Error al crear el fichero: " + e.getMessage(), e);
        }
        
        
        //Listar el contenido de un fichero
        if (directorio.exists() && directorio.isDirectory()) {
            File[] ficheros = directorio.listFiles();

            if (ficheros != null) {
                for (File f : ficheros) {
                    // Comprobamos que sea un archivo y no una subcarpeta
                    if (f.isFile()) {
                        System.out.println("=== Contenido de " + f.getName() + " ===");
                        try {
                            // Leemos todas las líneas del fichero
                            List<String> lineas = Files.readAllLines(f.toPath());
                            
                            for (String linea : lineas) {
                                System.out.println(linea);
                            }
                        } catch (IOException e) {
                            System.out.println("Error al leer el fichero: " + e.getMessage());
                        }
                        System.out.println(); // Línea en blanco para separar ficheros
                    }
                }
            }
        } else {
            System.out.println("El directorio no existe o no es un directorio.");
        }
    }
}