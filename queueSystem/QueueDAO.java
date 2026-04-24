package queueSystem;

	import java.sql.*;
	import java.util.*;

	public class QueueDAO {

	    public void addCustomer(String name, String service, int token) {
	        try {
	            Connection con = DBConnection.getConnection();
	            String query = "INSERT INTO queue(name, service, token_number, status) VALUES (?, ?, ?, 'WAITING')";
	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setString(1, name);
	            ps.setString(2, service);
	            ps.setInt(3, token);

	            ps.executeUpdate();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public List<String[]> getQueue() {
	        List<String[]> list = new ArrayList<>();

	        try {
	            Connection con = DBConnection.getConnection();
	            String query = "SELECT * FROM queue";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);

	            while (rs.next()) {
	                list.add(new String[]{
	                    rs.getString("id"),
	                    rs.getString("name"),
	                    rs.getString("service"),
	                    rs.getString("token_number"),
	                    rs.getString("status")
	                });
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	    public void serveNext() {
	        try {
	            Connection con = DBConnection.getConnection();
	            String query = "UPDATE queue SET status='SERVED' WHERE status='WAITING' ORDER BY token_number LIMIT 1";
	            Statement st = con.createStatement();
	            st.executeUpdate(query);
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public int getNextToken() {
	        int token = 1;

	        try {
	            Connection con = DBConnection.getConnection();
	            String query = "SELECT MAX(token_number) FROM queue";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);

	            if (rs.next()) {
	                token = rs.getInt(1) + 1;
	            }

	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return token;
	    }
	}


