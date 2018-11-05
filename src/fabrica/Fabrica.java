package fabrica;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Fabrica {
	private static EntityManagerFactory fabrica;
	public static EntityManagerFactory getFabrica(){
		
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("Sistema_CantinaPU");
		}
		return fabrica;

	}
}
