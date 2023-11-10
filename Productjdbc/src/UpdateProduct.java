import java.sql.*;
public class UpdateProduct {
	public static void main(String[] args) throws Exception{
		update();
	}
	public static void update() throws Exception{
		String url="jdbc:mysql://127.0.0.1:3306/mani";
		String username="root";
		String password="root";
		String Query="update mobile set productName='iphone' where id=1002";
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pst=con.prepareStatement(Query);
		pst.executeUpdate();
		con.close();
		}


}
