import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Sql sq = new Sql();
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
		
		sq.Result(con);
		
		

	}

}
