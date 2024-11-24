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
import java.util.*;
import java.text.SimpleDateFormat;

public class Agenda2 {
    private Connection conn;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public Agenda2() {
        this.conn = DatabaseConnection.getConnection();
    }
    
    public List<Agenda> getAllAgendas() {
        List<Agenda> agendas = new ArrayList<>();
        String query = "SELECT * FROM agenda ORDER BY date";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setId(rs.getInt("id"));
                agenda.setTitle(rs.getString("title"));
                agenda.setDescription(rs.getString("description"));
                agenda.setDate(sdf.parse(rs.getString("date")));
                agendas.add(agenda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agendas;
    }
    
    public boolean insertAgenda(Agenda agenda) {
        String query = "INSERT INTO agenda (title, description, date) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, agenda.getTitle());
            pstmt.setString(2, agenda.getDescription());
            pstmt.setString(3, sdf.format(agenda.getDate()));
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateAgenda(Agenda agenda) {
        String query = "UPDATE agenda SET title=?, description=?, date=? WHERE id=?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, agenda.getTitle());
            pstmt.setString(2, agenda.getDescription());
            pstmt.setString(3, sdf.format(agenda.getDate()));
            pstmt.setInt(4, agenda.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteAgenda(int id) {
        String query = "DELETE FROM agenda WHERE id=?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}