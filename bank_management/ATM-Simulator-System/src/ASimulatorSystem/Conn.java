package ASimulatorSystem;

import java.sql.*;  

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Method to create the signup table if it doesn't exist
    public void createSignupTable() {
        try {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS signup (" +
                                      "formno VARCHAR(255), " +
                                      "name VARCHAR(255), " +
                                      "fname VARCHAR(255), " +
                                      "dob DATE, " +
                                      "gender VARCHAR(10), " +
                                      "email VARCHAR(255), " +
                                      "marital VARCHAR(20), " +
                                      "address VARCHAR(255), " +
                                      "city VARCHAR(255), " +
                                      "pincode VARCHAR(10), " +
                                      "state VARCHAR(255)" +
                                      ")";
            s.executeUpdate(createTableQuery);
            System.out.println("Table 'signup' created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert signup data using a prepared statement
    public void insertSignup(String formno, String name, String fname, String dob, String gender, String email, String marital, String address, String city, String pincode, String state) {
        try {
            String query = "INSERT INTO signup (formno, name, fname, dob, gender, email, marital, address, city, pincode, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, formno);
            ps.setString(2, name);
            ps.setString(3, fname);
            ps.setDate(4, Date.valueOf(dob));
            ps.setString(5, gender);
            ps.setString(6, email);
            ps.setString(7, marital);
            ps.setString(8, address);
            ps.setString(9, city);
            ps.setString(10, pincode);
            ps.setString(11, state);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Conn conn = new Conn();
        conn.createSignupTable();
    }
}
