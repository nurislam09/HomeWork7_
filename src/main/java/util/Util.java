package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Util {

    public static EntityManager getConnection() {
        return Persistence.createEntityManagerFactory("peaksoft").createEntityManager();
    }
}
