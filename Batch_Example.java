// public class batch {
    
// }
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;

// public class batch {

//     public static void main(String[] args) {

//         // Database credentials
//         String url = "jdbc:mysql://localhost:3306/batch";
//         String user = "root";
//         String password = "Anubhab@2004";

//         Connection con = null;
//         PreparedStatement ps = null;

//         try {

//             // 1. Load JDBC Driver
//             Class.forName("com.mysql.cj.jdbc.Driver");

//             // 2. Create Connection
//             con = DriverManager.getConnection(url, user, password);

//             // Turn OFF auto commit (important for batch)
//             con.setAutoCommit(false);

//             // 3. Prepare SQL Query
//             String sql = "INSERT INTO students VALUES (?, ?, ?)";
//             ps = con.prepareStatement(sql);

//             // -------- First Record --------
//             ps.setInt(1, 101);
//             ps.setString(2, "Rahul");
//             ps.setInt(3, 85);

//             // Add this set to batch
//             ps.addBatch();

//             // -------- Second Record --------
//             ps.setInt(1, 102);
//             ps.setString(2, "Amit");
//             ps.setInt(3, 90);
//             ps.addBatch();

//             // -------- Third Record --------
//             ps.setInt(1, 103);
//             ps.setString(2, "Sneha");
//             ps.setInt(3, 88);
//             ps.addBatch();

//             // 4. Execute Batch
//             int[] result = ps.executeBatch();

//             // 5. Commit transaction
//             con.commit();

//             System.out.println("Batch executed successfully!");
//             System.out.println("Number of records inserted: " + result.length);

//         } catch (Exception e) {

//             try {
//                 // Rollback if any error occurs
//                 con.rollback();
//             } catch (Exception ex) {
//                 ex.printStackTrace();
//             }

//             e.printStackTrace();
//         }

//         finally {

//             try {
//                 if (ps != null) ps.close();
//                 if (con != null) con.close();
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }


import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch_Example {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/batch";
        String user = "root";
        String password = "Anubhab@2004";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(url, user, password)) {
                con.setAutoCommit(false);

                String sql = "INSERT INTO libarary (bookid,title,author,catogary,price,quantity,status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement ps = con.prepareStatement(sql)) {

                    ps.setInt(1, 1);
                    ps.setString(2, "Atomic Habits");
                    ps.setString(3, "James Clear");
                    ps.setString(4, "Self-Help");
                    ps.setInt(5, 499);
                    ps.setInt(6, 12);
                    ps.setString(7, "Available");
                    ps.addBatch();

                    ps.setInt(1, 2);
                    ps.setString(2, "The Alchemist");
                    ps.setString(3, "Paulo Coelho");
                    ps.setString(4, "Fiction");
                    ps.setInt(5, 399);
                    ps.setInt(6, 10);
                    ps.setString(7, "Available");
                    ps.addBatch();

                    ps.setInt(1, 3);
                    ps.setString(2, "Rich Dad Poor Dad");
                    ps.setString(3, "Robert Kiyosaki");
                    ps.setString(4, "Finance");
                    ps.setInt(5, 450);
                    ps.setInt(6, 8);
                    ps.setString(7, "Available");
                    ps.addBatch();

                    ps.setInt(1, 4);
                    ps.setString(2, "Ikigai");
                    ps.setString(3, "Hector Garcia");
                    ps.setString(4, "Self-Help");
                    ps.setInt(5, 420);
                    ps.setInt(6, 15);
                    ps.setString(7, "Available");
                    ps.addBatch();

                    ps.setInt(1, 5);
                    ps.setString(2, "The Power of Habit");
                    ps.setString(3, "Charles Duhigg");
                    ps.setString(4, "Self-Help");
                    ps.setInt(5, 480);
                    ps.setInt(6, 7);
                    ps.setString(7, "Available");
                    ps.addBatch();

                    int[] result = ps.executeBatch();
                    con.commit();

                    System.out.println("Batch executed successfully. Records inserted: " + result.length);
                } catch (BatchUpdateException bue) {
                    con.rollback();
                    System.err.println("Batch failed, rolled back. Update counts length: " + bue.getUpdateCounts().length);
                    bue.printStackTrace();
                } catch (SQLException se) {
                    con.rollback();
                    throw se;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
