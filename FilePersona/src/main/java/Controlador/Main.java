package Controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Execption.RepositorioException;
import Modelo.Persona;
import Repositorio.RepositorioPersonasJson;

public class Main {

    public static void main(String[] args) {

        String ruta = "src\\main\\resources\\Fichero1.json";

        File fichero = new File(ruta);

        List<Persona> personas = new ArrayList<>();

        RepositorioPersonasJson repositorio =
                new RepositorioPersonasJson(fichero, personas);

        try {

            System.out.println("=== PERSONAS LEÍDAS DEL JSON ===");

            List<Persona> personasLeidas = repositorio.findAll();

            for (Persona p : personasLeidas) {
                System.out.println(p);
            }

            System.out.println("\n=== GUARDAR MANUEL ===");

            List<Double> notasManuel = new ArrayList<>();
            notasManuel.add(7.5);
            notasManuel.add(8.0);
            notasManuel.add(9.25);

            Persona manuel = new Persona("Manuel", notasManuel);

            repositorio.save(manuel);

            System.out.println("Guardada: " + manuel);
            System.out.println("Total personas: " + repositorio.count());

            System.out.println("\n=== PERSONAS DESPUÉS DE GUARDAR ===");

            for (Persona p : repositorio.getPersonas()) {
                System.out.println(p);
            }

             repositorio.deleteById("Manuel");
             
             System.out.println("\n=== PERSONAS DESPUÉS DE BORRAR ===");

             
             for (Persona p : repositorio.getPersonas()) {
                 System.out.println(p);
             }

        } catch (RepositorioException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}