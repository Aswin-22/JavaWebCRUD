import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcConnection {
	
	public static Connection con;
	
	public static void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "root");
			System.out.println("connected.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void save(int id, String name, double salary) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, salary);
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println("SAVED.");
			}else {
				System.out.println("NOT SAVED.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static ResultSet selectValues() {
		try {
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void deleteRows(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from employee where eid="+id);
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println("DELETED.");
			}else {
				System.out.println("NOT DELETED.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void updateMethod(int eid , String ename) {
		try {
			PreparedStatement ps = con.prepareStatement("update employee set ename='"+ename+"' where eid = "+eid);
			int a = ps.executeUpdate();
			if(a>0) {
				System.out.println("Updated.");
			}else{
				System.out.println("Not Updated.");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}