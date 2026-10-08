package Controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Modelo.Comparador1_8;

public class Boletin1_8 extends Comparador1_8{

    private static final Logger logger = LogManager.getLogger(Boletin1_8.class);

	
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        File userHome = new File(System.getProperty("user.home"));
        File miDirectorio = new File(userHome, "Downloads");
		Boletin1_8 bol = new Boletin1_8();
		
		for (File f : miDirectorio.listFiles()) {
			
		}
	}
}


