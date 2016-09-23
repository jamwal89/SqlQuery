import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Sql {


	PreparedStatement pstmt;
	ResultSet rs=null;


	public void Result(Connection con){
		System.out.println("Enter the Query for the results");
		Scanner scan= new Scanner (System.in);
		String query=scan.nextLine();
		try {
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();

			PrintWriter writer=null;

			try {
				writer = new PrintWriter(new File("/home/oracle/workspace/SQLQuery/src/Data.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ResultSetMetaData rsmd =rs.getMetaData();
			int colcount=rsmd.getColumnCount();
			int counter =0;

			while(rs.next()){
				counter++;
				for(int i = 1; i<=colcount; i++){

					if(counter<=10){
						System.out.print(rs.getString(i)+"\t");	
					}
					writer.print(rs.getString(i)+"\t");
					writer.flush();

				}
				writer.println();
				writer.flush();
				System.out.println();

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
