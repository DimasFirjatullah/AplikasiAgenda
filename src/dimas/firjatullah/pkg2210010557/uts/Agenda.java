/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dimas.firjatullah.pkg2210010557.uts;
import java.util.Date;
/**
 *
 * @author Dimas Firjatullah
 * 2210010557
 */
 public class Agenda {
    private int id;
    private String title;
    private String description;
    private Date date;
    
    public Agenda() {}
    
    public Agenda(int id, String title, String description, Date date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}