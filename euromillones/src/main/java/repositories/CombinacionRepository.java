package repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Combinaciones;

public class CombinacionRepository implements ICombinacionRepository {
	private List<Combinaciones> combinaciones;
	private File bdd;
	
	public CombinacionRepository(String ruta) {
		this.combinaciones = new ArrayList<Combinaciones>();
		this.bdd = new File(ruta);
	}
	
	private List<Combinaciones> leerFichero() {
		try {
			FileReader fr = new FileReader(this.bdd);
			BufferedReader bf = new BufferedReader(fr);
			
			bf.readLine();
			String linea = bf.readLine();
			List<String> listaLineas = new ArrayList<String>();
			while(linea != null) {
				listaLineas.add(linea);
				linea = bf.readLine();
			}
			
			for (String l : listaLineas) {
				String [] lineaPorComas = l.split(",");
				String combinacion = "";
				List<String> estrellas = new ArrayList<String>();
				boolean separacionEstrellas = false;
				for (int i = 1; i < lineaPorComas.length; i++) {
					String actual = lineaPorComas[i];
					if (actual.equals("")) {
						separacionEstrellas = true;
					}
					else {
						if (separacionEstrellas) {
							estrellas.add(actual);
						}
						else {
							combinacion += actual + " ";
						}
					}
				}
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				try {
					date = format.parse(lineaPorComas[0]);
				} catch (ParseException e) {
					System.out.println(e.getMessage());
				}
				this.combinaciones.add(new Combinaciones(date, combinacion, estrellas));
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return this.combinaciones;
	}
	
	@Override
	public List<Combinaciones> findAll() {
		if (this.combinaciones == null || this.combinaciones.size() == 0) {
			this.combinaciones = this.leerFichero();
		}
		return this.combinaciones;
	}

}
