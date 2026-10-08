package Controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Boletin1_7 {

    private static final Logger logger = LogManager.getLogger(Boletin1_7.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        File userHome = new File(System.getProperty("user.home"));
        File miDirectorio = new File(userHome, "Desktop");
		Boletin1_7_2 bol = new Boletin1_7_2();
		
		List<File> ficheros = bol.buscar(miDirectorio, "Psp2");
		for (File f : ficheros) {
			logger.info(f.getName());
		}

	}

}


class Boletin1_7_2{
	
	
	 
	
	List<File> buscar(File f, String nombre){
		List<File> ficheros = new ArrayList<File>();
		
		if (f.isFile()) {
			if (f.getName().toLowerCase().contains(nombre.toLowerCase())) {
				ficheros.add(f); 	
			}
		}else {
			if (f.getName().toLowerCase().contains(nombre.toLowerCase())) {
				ficheros.add(f); 	
			}
			for (File ficheroHijo : f.listFiles()) {
				ficheros.addAll( buscar(ficheroHijo,nombre));
			}
		}
		
		
		return ficheros;
		
	}
	
}
