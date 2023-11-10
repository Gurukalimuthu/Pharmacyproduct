import java.sql.*;
public class PharmacyProject {
	public static void main(String[] args) throws Exception{
		insert();
	}
	public static void insert() throws Exception{
		String url="jdbc:mysql://127.0.0.1:3306/kannan";
		String username="root";
		String password="root";
		String Query="insert into medication values(?,?,?)";
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pst =con.prepareStatement(Query);
		pst.setInt(1, 1001);
		pst.setString(2, "coludact");
		pst.setInt(3, 300);
		pst.executeUpdate();
		String Query1="insert into customer values(?,?,?)";
		Connection con1=DriverManager.getConnection(url,username,password);
		PreparedStatement pst1 =con.prepareStatement(Query1);
		pst1.setInt(1, 1001);
		pst1.setString(2, "Guru");
		pst1.setString(3, "95-957-49795");
		pst1.executeUpdate();
		con1.close();
		}
}