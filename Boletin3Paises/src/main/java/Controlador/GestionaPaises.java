package Controlador;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Repositorio.RepositorioPaises;

public class GestionaPaises {
	static String ruta = "src\\main\\resources\\paises.csv";
    private static final Logger logger = LogManager.getLogger(GestionaPaises.class);

	
	
	public static void main(String[] args) {

		RepositorioPaises rp = new RepositorioPaises();
		try {
			rp.leeFicheroCSV(ruta);
			boolean borrado = rp.borrarPais("Brasil");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
