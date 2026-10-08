package Controlador;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Boletin1_3 {

    private static final Logger logger = LogManager.getLogger(Boletin1_3.class);

    public static void main(String[] args) {
        // 1. Obtener directorio del usuario y crear miDirectorio con new File(padre, hijo)
        File userHome = new File(System.getProperty("user.home"));
        File miDirectorio = new File(userHome, "miDirectorio");

        if (miDirectorio.exists() || miDirectorio.mkdir()) {
            logger.info("Directorio creado: " + miDirectorio.getAbsolutePath());
        } else {
            logger.error("No se pudo crear el directorio: " + miDirectorio.getAbsolutePath());
            
        }

        // 2. Crear los ficheros lectura.txt y normal.txt
        File fLectura = new File(miDirectorio, "lectura.txt");
        File fNormal = new File(miDirectorio, "normal.txt");

        try {
            if (fLectura.createNewFile()) {
                logger.info("Fichero creado: " + fLectura.getName());
            } else {
                logger.info("El fichero ya existía: " + fLectura.getName());
            }
        } catch (IOException e) {
            logger.error("Error al crear el fichero " + fLectura.getName() + ": " + e.getMessage());
        }

        try {
            if (fNormal.createNewFile()) {
                logger.info("Fichero creado: " + fNormal.getName());
            } else {
                logger.info("El fichero ya existía: " + fNormal.getName());
            }
        } catch (IOException e) {
            logger.error("Error al crear el fichero " + fNormal.getName() + ": " + e.getMessage());
        }

        // 3. Marcar lectura.txt como solo lectura
        if (fLectura.setReadOnly()) {
            logger.info("lectura.txt marcado como solo lectura");
        } else {
            logger.error("No se pudo marcar lectura.txt como solo lectura");
        }

     // 4. Muestra los permisos de lectura, escritura y ejecución 
        File[] ficheros = { fLectura, fNormal };

        for (File f : ficheros) {
            String r = "no";
            if (f.canRead()) {
                r = "sí";
            }

            String w = "no";
            if (f.canWrite()) {
                w = "sí";
            }

            String x = "no";
            if (f.canExecute()) {
                x = "sí";
            }

            logger.info(f.getName() + " -> lectura: " + r + " | escritura: " + w + " | ejecución: " + x);
        }
        // 5. Renombrar normal.txt a renombrado.txt
        File fRenombrado = new File(miDirectorio, "renombrado.txt");
        if (fNormal.renameTo(fRenombrado)) {
            logger.info("normal.txt renombrado a renombrado.txt");
        } else {
            logger.error("No se pudo renombrar normal.txt");
        }

        // 6. Intentar borrar lectura.txt (si falla, quitar solo lectura y reintentar)
        if (fLectura.delete()) {
            logger.info("lectura.txt borrado");
        } else {
            logger.error("No se ha podido borrar lectura.txt");
            if (fLectura.setWritable(true)) {
                logger.info("Permiso de escritura restaurado en lectura.txt");
                if (fLectura.delete()) {
                    logger.info("lectura.txt borrado");
                } else {
                    logger.error("No se pudo borrar lectura.txt tras restaurar permisos");
                }
            } else {
                logger.error("No se pudo cambiar el permiso de escritura en lectura.txt");
            }
        }

        // 7. Muestra el contenido final de miDirectorio
        logger.info("Contenido final de miDirectorio:");
        File[] contenido = miDirectorio.listFiles();
        if (contenido != null) {
            for (File f : contenido) {
                logger.info(f.getName());
            }
        }
    }
}