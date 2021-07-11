package KwangMat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.net.aso.p;

/*
 커넥션 객체를 확득
 구문객체(Statement)를 생성
 구문객체에 학생정보 추가 (사용자의 입력을 받아서 / 임의로 설정)
 적절한 insert sql문을 구문객체를 이용해서 보내기
 
 executeUpdate()를 사용
*/
public class InsertRestaurantTest {
	public static void main(String[] args) {
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null; //준비된 구문객체 선언

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "kwangmat";
		String pwd = "kwang";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("식당 이름을 입력하세요");
		String rname = sc.nextLine();
		System.out.println("식당 위치를 입력하세요");
		//sc.nextLine();
		String wname = sc.nextLine();
		System.out.println("식당 전화번호를 입력하세요");
		String hpnum = sc.nextLine();
		System.out.println("식당 평점을 입력하세요");
		float grade=0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} 
		try {
			//insert into student values (1,'홍길동',90)
			conn = DriverManager.getConnection(url,user,pwd);
//			stmt = conn.createStatement();
//			stmt.executeUpdate("insert into student values(" 
//								+id + ",'" + name+ "'," + grade + ")");		
			/*
			 sql 구문을 편리하게 도와주는 statement객체
			 PreparedStatement 객체 : 인자값 맵핑을 편리하게 도와주는 객체
			 */
			pstmt = conn.prepareStatement("insert into restaurant values(?,?,?,?)");
			pstmt.setString(1, rname);
			pstmt.setString(2, wname);
			pstmt.setString(3, hpnum);
			pstmt.setFloat(4, grade);
			
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
