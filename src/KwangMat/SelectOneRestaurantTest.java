package KwangMat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 	조회하고싶은 학생의 id를 입력받아서 해당학생의 정보를 출력
 */
public class SelectOneRestaurantTest {
	public static void main(String[] args) {
		Connection conn = null;
//		Statement stmt = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "kwangmat";
		String pwd = "kwang";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 식당 이름 입력:");
		String rname = sc.nextLine();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url,user,pwd);
			//학생 한명를 가져오기 위한 sql문
			//select * from student where stuid = ?
			String sql = "select * from restaurant where rname = ?";
			pstmt = conn.prepareStatement(sql);
			//인자값 맵핑
			pstmt.setString(1, rname);
			rs = pstmt.executeQuery();
			
			//select문 실행후 얻은 결과(레코드 집합/result set) rs 참조변수에 연결
			
			while(rs.next()) {
//				System.out.println("stuid : " +  rs.getInt(1));
//				System.out.println("stuname : " + rs.getString(2));
//				System.out.println("grade : " +  rs.getInt(3));
				System.out.println(rs.getString("rname"));
				System.out.println(rs.getString("wname"));
				System.out.println(rs.getString("hpnum"));
				System.out.println(rs.getFloat("grade"));
				
				System.out.println("----------------------------");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(!conn.isClosed() && conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}