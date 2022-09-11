package JDBC.test;

import JDBC.Service.ProducerService;
import JDBC.conn.ConnectionFactory;
import JDBC.dominio.producer;
import JDBC.repository.ProducerRepository;

import java.util.List;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {

//        producer producer1 = producer.builder().name("Sudio").build();
//        ProducerService.save(producer1);
//        ProducerService.delete(4);
//        ProducerService.delete(7);
//        ProducerService.delete(8);
//        producer producertoUpdate = producer.builder().id(3).name("MADHOUSE").build();
//        ProducerService.update(producertoUpdate);
//        List<producer> producerList = ProducerService.findAll();
//        System.out.println(producerList);
//        ProducerService.findByName("MAD");
//        ProducerService.getProducerMetaData();
//        ProducerService.getDriverMetaData();
//        ProducerService.findByNameAndUpdateToUpperCase("Ufo");
//        ProducerService.findByNameAndInsertWhenNotFound("Studio Perriot");
//        List<producer> producers = ProducerService.findByNamePreparedStatement("Ufotable");
//        System.out.println("Producers found " + producers);

//        producer producertoUpdate = producer.builder().id(10).name("Nanatsu Studio").build();
//        ProducerService.updatePreparedStatement(producertoUpdate);

        List<producer> producers = ProducerService.findByNameCallable("sasasa");
        System.out.println(producers);
    }
}
