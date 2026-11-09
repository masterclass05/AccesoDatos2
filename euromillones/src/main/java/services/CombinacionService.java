package services;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import models.Combinaciones;
import repositories.CombinacionRepository;
import repositories.ICombinacionRepository;

public class CombinacionService implements ICombinacionService {
	ICombinacionRepository rp;
	List<Combinaciones> combinaciones;
	
	public CombinacionService(String ruta) {
		this.rp = new CombinacionRepository(ruta);
		this.combinaciones = this.listarCombinacioens();
	}

	@Override
	public String estrellaRepetida() {
		String estrellaRepetida = "No hay estrellas";
		if (this.combinaciones != null && this.combinaciones.size() != 0) {
			Map<String, Integer> map = new TreeMap<String, Integer>();
			
			for (Combinaciones combinacion : this.combinaciones) {
				for (String estrella : combinacion.getEstrellas()) {
					if (map.containsKey(estrella)) {
						map.put(estrella, map.get(estrella) + 1);
					}
					else {
						map.put(estrella, 1);
					}
				}
			}
			String estrella = "";
			int total = 0;
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				String key = entry.getKey();
				Integer val = entry.getValue();
				if (val > total) {
					estrella = key;
					total = val;
				}
			}
			estrellaRepetida = "La estrella " + estrella + " es la mas repetida: " + total + " veces";
		}
		return estrellaRepetida;
	}

	@Override
	public String combinacionMasFrecuente() {
		String combinacionMasFrecuente = "No hay combinaciones";
		if (this.combinaciones != null || this.combinaciones.size() != 0) {
			Map<String, Integer> map = new TreeMap<String, Integer>();
			for (Combinaciones combinacion : this.combinaciones) {
				String combinacionGanadora = combinacion.getCombinacionGanadora();
				
				if (map.containsKey(combinacionGanadora)) {
					map.put(combinacionGanadora, map.get(combinacionGanadora) + 1);
				}
				else {
					map.put(combinacionGanadora, 1);
				}
			}
			
			String combinacion = "";
			int total = 0;
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				String key = entry.getKey();
				Integer val = entry.getValue();
				
				if (val > total) {
					combinacion = key;
					total = val;
				}
			}
			
			combinacionMasFrecuente = "La combinacion " + combinacion + " es la mas repetida: " + total + " veces";
		}
		return combinacionMasFrecuente;
	}

	@Override
	public List<Combinaciones> listarCombinacioens() {
		if(this.combinaciones == null || this.combinaciones.size() == 0) {
			this.combinaciones = this.rp.findAll();
		}
		return this.combinaciones;
	}

}
