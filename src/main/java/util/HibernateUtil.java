package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	public static EntityManagerFactory emf = null;

	static {
		init();
	}

	private static void init() {
		try {

			if (emf == null) {
				emf = Persistence.createEntityManagerFactory("pos-java-hibernate");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();/* Prover a parte de persistencia */
	}

	public static Object getPrimaryKey(Object entity) {// Retorna a chave primaria
		return emf.getPersistenceUnitUtil().getIdentifier(entity);
	}
}
