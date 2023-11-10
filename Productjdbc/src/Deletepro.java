import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Deletepro {
	public static void main(String[] args) throws Exception{
		delete();
	}
	public static void delete() throws Exception{
		String url="jdbc:mysql://127.0.0.1:3306/mani";
		String username="root";
		String password="root";
		String Query="delete from mobile where id=1003";
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pst=con.prepareStatement(Query);
		pst.executeUpdate();
		con.close();
		}

}
