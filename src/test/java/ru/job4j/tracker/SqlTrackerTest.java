package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItemAndFindByIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        tracker.replace(item.getId(), new Item("replace"));
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("replace");
    }

    @Test
    public void whenDeleteItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenFindAllItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        assertThat(tracker.findAll()).isEqualTo(List.of(item1, item2, item3));
    }

    @Test
    public void whenFindByNameItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        Item item4 = tracker.add(new Item("item2"));
        assertThat(tracker.findByName("item2")).isEqualTo(List.of(item2, item4));
    }

}