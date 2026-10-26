package Controlador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import Modelo.Empleado;

public class GestionaPersonas {
	static String rutaJava = "src\\main\\java";
	static String rutaResources = "src\\main\\resources";
	static String ficheroTxt = "src\\main\\java\\Fichero1.txt";
	static String ficheroJson = "src\\main\\resources\\Empleado.json";




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestionaPersonas g = new GestionaPersonas();
		Empleado e1 = new Empleado("id1", "Pepa", 21, "Logitech");
		Empleado e2 = new Empleado("id2", "Juan", 18, "Nike");
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(e1);
		empleados.add(e2);
		g.escribeEmpleados(empleados, rutaResources+"Salida.json");

	}

	public void leeEmpleados(String rutaFichero) {
		FileReader fichero = null;
		try {
			fichero = new FileReader(ficheroJson);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		/*Empleado empleado = gson.fromJson(fichero, Empleado.class);
		System.out.println(empleado);*/
		 Empleado[] empleadosArray = gson.fromJson(fichero,Empleado[].class);
		 List<Empleado> empleados = Arrays.asList(empleadosArray);
		 System.out.println(empleados);
	}
	
	public void escribeEmpleados(List<Empleado> lista, String rutaFicheroSalida) {
		for (Empleado e : lista) {
			escribeEmpleado(e, rutaFicheroSalida);
		}
	}
	
	public void escribeEmpleado(Empleado empleado, String ruta)
	{// Convertir el objeto a JSON
		 Gson gson = new Gson();
		 String json = gson.toJson(empleado);
		 FileWriter fichero = null;
		 try {
			fichero = new FileWriter(ruta);
			fichero.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println("Error al escribir empleado");
				}			}		}	   }

}
