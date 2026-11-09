package services;

import java.util.List;

import models.Combinaciones;

public interface ICombinacionService {
	public List<Combinaciones> listarCombinacioens();
	public String estrellaRepetida();
	public String combinacionMasFrecuente();
}
