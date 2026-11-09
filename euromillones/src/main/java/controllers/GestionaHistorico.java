package controllers;

import services.CombinacionService;
import services.ICombinacionService;

public class GestionaHistorico {

	public static void main(String[] args) {
		ICombinacionService sv = new CombinacionService("src/main/resources/euromillones.csv");
		
		System.out.println(sv.listarCombinacioens());
		System.out.println(sv.estrellaRepetida());
		System.out.println(sv.combinacionMasFrecuente());

	}

}
