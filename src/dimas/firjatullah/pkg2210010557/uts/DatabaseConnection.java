/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dimas.firjatullah.pkg2210010557.uts;

/**
 *
 * @author Dimas Firjatullah
 * 2210010557
 */
import java.sql.*;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:agenda.db";
    private static Connection conn = null;
    
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(DB_URL);
                createTableIfNotExists();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    
    private static void createTableIfNotExists() {
        String sql = """
            CREATE TABLE IF NOT EXISTS agenda (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                description TEXT,
                date DATE NOT NULL
            )
        """;
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

