package Modelo;

import java.io.File;
import java.util.Comparator;

public class Comparador1_8 implements Comparator<File>{

	public int compare(File f1, File f2) {
		// TODO Auto-generated method stub
		return (int) (f1.length()-f2.length());
	}
	
}
