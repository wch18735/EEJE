package KwangMat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
  student 테이블에 담겨있는 모든 학생정보 가져오기 
 */
public class SelectAllRestaurantTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null; //?가 될 부분이 없음
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "kwangmat";
		String pwd = "kwang";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String sql = "select * from restaurant";
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			//학생전체를 가져오기 위한 sql문
			//select * from student
			rs = pstmt.executeQuery();
			//select문 실행후 얻은 결과(레코드 집합/result set) rs 참조변수에 연결
			while(rs.next()) {
				System.out.println("식당이름 : " + rs.getString("RNAME"));
				System.out.println("위치 : " + rs.getString("WNAME"));
				System.out.println("전화번호 : " + rs.getString("HPNUM"));
				System.out.println("평점 : " +  rs.getFloat("GRADE"));
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
