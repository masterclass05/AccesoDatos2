package Boletin2;

import java.io.File;
import java.util.Collection;

public class DiffFolder {
	
	private File dir1;
	private File dir2;
	
	
	public DiffFolder() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public DiffFolder(String ruta1, String ruta2) throws DiffFolderException {
		super();
		this.dir1 = new File(ruta1);
		this.dir2 = new File(ruta2);
	
		if (dir1!=null & dir2!= null & dir1.isDirectory() & dir2.isDirectory()) {
			setFolders(dir1, dir2);
		}else {
			throw new DiffFolderException("No es una carpeta");
		}

	}




	public void setFolders (File d1, File d2){
		this.dir1 = d1;
		this.dir2 = d2;
				
	}
	
	
	public File getDir1() {
		return dir1;
	}


	public File getDir2() {
		return dir2;
	}



	public Collection<ResultadoComparacion> comparame(){
		Collection<ResultadoComparacion> coleccion = null;
		int cantidad1 = dir1.listFiles().length;
		int cantidad2 = dir1.listFiles().length;
		return coleccion;
	}
}
