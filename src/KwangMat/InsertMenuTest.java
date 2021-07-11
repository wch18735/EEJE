package KwangMat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.net.aso.p;


public class InsertMenuTest {
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
		System.out.println("메뉴 이름을 입력하세요");
		String fname = sc.nextLine();
		System.out.println("메뉴 가격을 입력하세요");
		int price = sc.nextInt();
		
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
			pstmt = conn.prepareStatement("insert into menu"
					+ " values(?,?,?)");
			pstmt.setString(1, rname);
			pstmt.setString(2, fname);
			pstmt.setInt(3, price);
			
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
