import java.sql.*;

public class JDBCInsert {
    public static void main(String[] args) {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "password"
            );

            // SQL query to insert values
            String sql = "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            // Set values
            ps.setInt(1, 1);
            ps.setString(2, "Rahul");
            ps.setInt(3, 20);

            // Execute query
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record inserted successfully!");
            }

            // Close resources
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
