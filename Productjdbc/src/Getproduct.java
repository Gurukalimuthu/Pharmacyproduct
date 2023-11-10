import java.sql.*;

public class Getproduct {
	public static void main(String[] args) throws Exception{
		get();
	}
	public static void get() throws Exception{
		String url="jdbc:mysql://127.0.0.1:3306/mani";
		String username="root";
		String password="root";
		String Query="select * from mobile where id=1001";
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(Query);
		while(rs.next()) {
		System.out.println("id is:" +rs.getInt(1));
		System.out.println("productName is:" +rs.getString(2));
		System.out.println("price is:" +rs.getInt(3));
		}
		con.close();
		}

}
