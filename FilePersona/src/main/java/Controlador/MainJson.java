package Controlador;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Modelo.Empleado;

public class MainJson {

    public static void main(String[] args) {

        String rutaEmpleado = "src\\main\\resources\\empleado.json";

        String rutaEmpleados ="src\\main\\resources\\empleados.json";

        // 1. Leer un único empleado
        Empleado empleado = fromJsonToEmpleado(rutaEmpleado);

        if (empleado != null) {
            System.out.println("Empleado leído: " + empleado);
        }

        // 2. Leer un array de empleados
        leeEmpleados(rutaEmpleados);

        // 3. Escribir un empleado nuevo
        Empleado empleadoNuevo = new Empleado(
                "empleado23",
                "Laura García",
                30,
                "Nueva Empresa"
        );

        escribeEmpleado(
                empleadoNuevo,"src\\main\\resources\\empleadoNuevo.json"
        );
        
     // 4. Escribir un array de empleados nuevo
        Empleado[] listaNuevosEmpleados = {
            new Empleado("empleado24", "Ana Gómez", 28, "Empresa A"),
            new Empleado("empleado25", "Carlos Ruiz", 35, "Empresa B")
        };

        escribeEmpleados(
                listaNuevosEmpleados, "src\\main\\resources\\empleadosNuevos.json"
        );
    }

    public static Empleado fromJsonToEmpleado(String rutaFichero) {

        File fichero = new File(rutaFichero);

        if (!fichero.exists()) {
            System.out.println("El fichero no existe: " + fichero.getAbsolutePath());
            return null;
        }

        Empleado empleado = null;

        try {

            Gson gson = new Gson();

            FileReader lector = new FileReader(fichero);

            empleado = gson.fromJson(lector, Empleado.class);

            lector.close();

        } catch (Exception e) {
            System.out.println("Error al leer el empleado: " + e.getMessage());
        }

        return empleado;
    }

    public static void leeEmpleados(String rutaFichero) {

        File fichero = new File(rutaFichero);

        if (!fichero.exists()) {
            System.out.println("El fichero no existe: " + fichero.getAbsolutePath());
            return;
        }

        try {

            Gson gson = new Gson();

            FileReader lector = new FileReader(fichero);

            Empleado[] empleadosArray = gson.fromJson(lector, Empleado[].class);

            List<Empleado> empleados = Arrays.asList(empleadosArray);

            System.out.println("\n=== LISTA DE EMPLEADOS ===");
            System.out.println(empleados);

            lector.close();

        } catch (Exception e) {
            System.out.println("Error al leer empleados: " + e.getMessage());
        }
    }

    public static void escribeEmpleado(Empleado empleado, String ruta) {

        Gson gson = new Gson();

        String json = gson.toJson(empleado);

        FileWriter fichero = null;

        try {
            fichero = new FileWriter(ruta);
            fichero.write(json);

        } catch (IOException e) {
            System.out.println("Error al escribir empleado: " + e.getMessage());

        } finally {

            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el fichero: " + e.getMessage());
                }
            }
        }
    }
    
    
    public static void escribeEmpleados(Empleado[] empleados, String ruta) {

        // Usamos GsonBuilder para darle formato bonito (pretty printing)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(empleados);

        FileWriter fichero = null;

        try {
            fichero = new FileWriter(ruta);
            fichero.write(json);
            System.out.println("Array de empleados escrito correctamente en: " + ruta);

        } catch (IOException e) {
            System.out.println("Error al escribir empleados: " + e.getMessage());

        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el fichero: " + e.getMessage());
                }
            }
        }
    }
}