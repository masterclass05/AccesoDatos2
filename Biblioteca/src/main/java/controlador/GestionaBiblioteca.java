
package controlador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GestionaBiblioteca {

	private static final Logger logger = LogManager.getLogger(GestionaBiblioteca.class);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        logger.debug("Mensaje DEBUG");
        logger.info("Mensaje INFO");
        logger.warn("Mensaje WARN");
        logger.error("Mensaje ERROR");
        logger.fatal("Mensaje FATAL");		

	}

}
