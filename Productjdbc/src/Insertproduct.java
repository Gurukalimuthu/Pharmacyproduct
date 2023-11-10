import java.sql.*;
public class Insertproduct {
	public static void main(String[] args) throws Exception{
		insert();
	}
	public static void insert() throws Exception{
		String url="jdbc:mysql://127.0.0.1:3306/mani";
		String username="root";
		String password="root";
		String Query="insert into mobile values(?,?,?)";
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pst =con.prepareStatement(Query);
		pst.setInt(1, 1003);
		pst.setString(2, "Realme");
		pst.setInt(3, 30000);
		pst.executeUpdate();
		con.close();
		}
}
