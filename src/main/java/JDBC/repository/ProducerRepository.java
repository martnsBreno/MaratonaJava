package JDBC.repository;

import JDBC.conn.ConnectionFactory;
import JDBC.dominio.producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    public static void save(producer producer) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConnection(); Statement smt = conn.createStatement()) {
            int rowsChanged = smt.executeUpdate(sql);
//            log.info("Database rows affected {}", rowsChanged);
            System.out.println("Columns changed " + rowsChanged + " value added to database: " + producer.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveTransaction(List<producer> producers) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false);
            preparedStatementSaveTransaction(conn, producers);
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void preparedStatementSaveTransaction(Connection connection, List<producer> producers) throws SQLException {
        String sql1 = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ( ? );";
        boolean shouldRollBack = false;
        for (producer p :
                producers) {
            System.out.println("Salvando :" + p.getName());
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql1)){
                preparedStatement.setString(1, p.getName());
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                shouldRollBack = true;
            }
        }
        if (shouldRollBack) connection.rollback();
    }


    public static void delete(int idproducer) {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`idproducer` = '%d');".formatted(idproducer);
        try (Connection conn = ConnectionFactory.getConnection(); Statement smt = conn.createStatement()) {
            int rowsChanged = smt.executeUpdate(sql);
            System.out.println("Columns deleted " + rowsChanged);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(producer producer) {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE (`idproducer` = '%d');".formatted(producer.getName(), producer.getId());
        try (Connection conn = ConnectionFactory.getConnection(); Statement smt = conn.createStatement()) {
            int rowsChanged = smt.executeUpdate(sql);
            System.out.println("Columns update " + rowsChanged);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updatePreparedStatment(producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement smt = preparedStatementUpdate(conn, producer)) {
            int rowsAffected = smt.executeUpdate();
            System.out.println(rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement preparedStatementUpdate(Connection connection, producer producer) throws SQLException {
        String sql1 = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`idproducer` = ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setString(1, producer.getName());
        preparedStatement.setInt(2, producer.getId());
        return preparedStatement;
    }

    public static List<producer> findAll() {
        return findByNamme("");
    }

    public static List<producer> findByNamme(String name) {
        String sql = "SELECT * FROM anime_store.producer where name like '%s';".formatted("%" + name + "%");
        List<producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection(); Statement smt = conn.createStatement(); ResultSet rs = smt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("idproducer");
                String name1 = rs.getString("name");
                JDBC.dominio.producer producer = getProducer(producers, id, name1);
                System.out.println("Result returned got with" + " findByName" + producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static List<producer> findByNamePreparedStatement(String name) {
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        List<producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement smt = preparedStatementFindByName(conn, sql, name)) {
            smt.setString(1, name);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idproducer");
                String name1 = rs.getString("name");
                JDBC.dominio.producer producer = getProducer(producers, id, name1);
                System.out.println("Result returned got with" + " findByNamePreparedStatement" + producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static List<producer> findByNameCallableStatement(String name) {
        List<producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement smt = callableStatementFindByName(conn, name)) {
            smt.setString(1, name);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idproducer");
                String name1 = rs.getString("name");
                producers.add(getProducer(producers, id, name1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }

    private static PreparedStatement callableStatementFindByName(Connection connection, String name) throws SQLException {
        String sqlCallable = "CALL `anime_store`.`sp_get_producer_by_name`(?);";
        PreparedStatement preparedStatement = connection.prepareCall(sqlCallable);
        preparedStatement.setString(1, name);
        return preparedStatement;
    }

    private static PreparedStatement preparedStatementFindByName(Connection connection, String sql, String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        return preparedStatement;
    }

    public static void getProducerMetaData() {
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConnection(); Statement smt = conn.createStatement(); ResultSet rs = smt.executeQuery(sql)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("Column count: " + columnCount);
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("Table name: %s\n", metaData.getTableName(i));
                System.out.printf("Column name: %s\n", metaData.getColumnName(i));
                System.out.printf("Column size: %s\n", metaData.getColumnDisplaySize(i));
                System.out.printf("Column size: %s\n", metaData.getColumnTypeName(i));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getDriverMetaData() {
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            if (metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.println("Supports type foward only");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.printf("Supports concur updatable");
                }
            }
            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("Supports type scroll insensitive");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.printf("Supports concur updatable");
                }
            }
            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("Supports type scroll insensitive");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.print("Supports concur updatable");
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static List<producer> findByNameAndUpdateToUpperCase(String name) {
        String sql = "SELECT * FROM anime_store.producer where name like '%s';".formatted("%" + name + "%");
        List<producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection(); Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); ResultSet rs = smt.executeQuery(sql)) {
            while (rs.next()) {
                rs.updateString("name", rs.getString("name").toUpperCase());
                rs.updateRow();
                int id = rs.getInt("idproducer");
                String name1 = rs.getString("name");
                producer producer = JDBC.dominio.producer.builder().id(id).name(name1).build();
                producers.add(producer);
                System.out.println("Result of the update to uppercase" + producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static List<producer> findByNameAndInsertWhenNotFound(String name) {
        String sql = "SELECT * FROM anime_store.producer where name like '%s';".formatted("%" + name + "%");
        List<producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection(); Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); ResultSet rs = smt.executeQuery(sql)) {
            if (!rs.next()) {
                rs.moveToInsertRow();
                rs.updateString("name", name);
                rs.insertRow();
            }
            getProducer(producers, rs.getInt("idproducer"), rs.getString("name"));
            System.out.println(producers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }

    private static producer getProducer(List<producer> producers, int id, String name1) {
        producer producer = JDBC.dominio.producer.builder().id(id).name(name1).build();
        producers.add(producer);
        return producer;
    }


}
