package Controlador;

import java.io.FileNotFoundException;

import Repositorio.RepositorioPaises;

public class GestionaPaises {
	static String ruta = "src\\main\\resources\\paises.csv";
	
	public static void main(String[] args) {
		System.out.println("mal1");

		RepositorioPaises rp = new RepositorioPaises();
		try {
			rp.leeFicheroCSV(ruta);
			System.out.println("mal");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
