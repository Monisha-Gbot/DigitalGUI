package queueSystem;
	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DBConnection {
	    public static Connection getConnection() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/queue_system",
	                "root",
	                "Root@12345678"
	            );
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	}
	
