package JDBC.Service;

import JDBC.dominio.producer;
import JDBC.repository.ProducerRepoRowSet;

import java.util.List;

public class ProducerServiceRowSet {
    public static List<producer> findByNameRowSet(String name) {
        return ProducerRepoRowSet.findByNameJdbcRowSet(name);
    }

    public static void updateJdbcRowSet(producer producer) {
        ProducerRepoRowSet.updateJdbcRowSet(producer);
    }

    public static void updatedCachedRowSet(producer producer) {
        ProducerRepoRowSet.updateCachedRowSet(producer);
    }

}
