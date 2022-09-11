package JDBC.repository;

import JDBC.Listener.CustomRowSetListener;
import JDBC.conn.ConnectionFactory;
import JDBC.dominio.producer;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepoRowSet {
    public static List<producer> findByNameJdbcRowSet(String nameGotFromInput) {
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        List<producer> producers = new ArrayList<>();

        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setString(1, nameGotFromInput);
            jrs.execute();
            while (jrs.next()) {
                producer producer = JDBC.dominio.producer.builder()
                        .id(jrs.getInt("idproducer"))
                        .name(jrs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }

//    public static void updateJdbcRowSet(producer producer) {
//        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
//        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
//            jrs.setCommand(sql);
//            jrs.setString(1, producer.getName());
//            jrs.setInt(2, producer.getId());
//            jrs.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    public static void updateJdbcRowSet(producer producer) {
        String sqlUpdate = "SELECT * FROM anime_store.producer WHERE (`idproducer` = ?);";
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sqlUpdate);
            jrs.setInt(1, producer.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("name", producer.getName());
            jrs.updateRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateCachedRowSet(producer producer) {
        String sqlUpdate = "SELECT * FROM producer WHERE (`idproducer` = ?);";
        try (CachedRowSet crs = ConnectionFactory.getCachedRowSet();
             Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);
            crs.setCommand(sqlUpdate);
            crs.setInt(1, producer.getId());
            crs.execute(connection);
            if (!crs.next()) return;
            crs.updateString("name", producer.getName());
            crs.updateRow();
            crs.acceptChanges();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
