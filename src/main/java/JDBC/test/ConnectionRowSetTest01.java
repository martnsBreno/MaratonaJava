package JDBC.test;

import JDBC.Service.ProducerServiceRowSet;
import JDBC.dominio.producer;

import java.util.List;

public class ConnectionRowSetTest01 {
    public static void main(String[] args) {
        producer producertoUpdate = producer.builder().id(2).name("Ufotable").build();
        ProducerServiceRowSet.updatedCachedRowSet(producertoUpdate);
//        System.out.println("-------------------------");
//        System.out.println(ProducerServiceRowSet.findByNameRowSet("Ufo"));


    }
}
