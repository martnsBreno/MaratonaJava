package JDBC.Service;

import JDBC.dominio.producer;
import JDBC.repository.ProducerRepository;

import java.util.List;

public class ProducerService {
    public static void save(producer producer) {
        ProducerRepository.save(producer);
    }

    public static void saveTransaction(List<producer> producers) {
        ProducerRepository.saveTransaction(producers);
    }

    public static void delete(int id) {
        ProducerRepository.delete(id);
    }

    public static void update(producer producer) {
        ProducerRepository.update(producer);
    }

    public static void updatePreparedStatement(producer producer) {
        ProducerRepository.updatePreparedStatment(producer);
    }


    public static List<producer> findAll() {
        return ProducerRepository.findAll();
    }

    public static List<producer> findByName(String name) {
        return ProducerRepository.findByNamme(name);
    }

    public static List<producer> findByNameCallable(String name) {
        return ProducerRepository.findByNameCallableStatement(name);
    }


    public static void getProducerMetaData() {
        ProducerRepository.getProducerMetaData();
    }

    public static void getDriverMetaData() {
        ProducerRepository.getDriverMetaData();
    }

    public static List<producer> findByNameAndUpdateToUpperCase(String name) {
        return ProducerRepository.findByNameAndUpdateToUpperCase(name);
    }

    public static List<producer> findByNameAndInsertWhenNotFound(String name) {
        return ProducerRepository.findByNameAndInsertWhenNotFound(name);
    }


    public static List<producer> findByNamePreparedStatement(String name) {
        return ProducerRepository.findByNamePreparedStatement(name);
    }
}
