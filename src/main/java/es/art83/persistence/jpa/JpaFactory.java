package es.art83.persistence.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class JpaFactory {
    private static final String PERSISTENCE_UNIT = "JEE";

    private static EntityManagerFactory entityManagerFactory = null;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return entityManagerFactory;
    }

    public static void prepareFactoryWithDropAndCreateTables() {
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:mysql://localhost:3306/JEE");
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
    }

}
