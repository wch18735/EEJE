package KwangMat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
 사용자로 부터 삭제할 학생의 id를 입력받아서
 해당학생의 레코드를 삭제! 
 */
public class DeleteResTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "kwangmat";
		String pwd = "kwang";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 식당의 이름을 입력하세요");
		String rname = sc.nextLine();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		try {
			conn = DriverManager.getConnection(url,user,pwd);
			//delete문
			//delete from student where stuid =?
			pstmt = conn.prepareStatement("delete from restaurant where rname =?");
			pstmt.setString(1, rname);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (!conn.isClosed() && conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
