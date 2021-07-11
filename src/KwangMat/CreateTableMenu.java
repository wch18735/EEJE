package KwangMat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTableMenu {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		//연결할 DBMS의 주소
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//접속할 oracle 사용자이름, 비밀번호
		String user ="kwangmat";
		String pwd ="kwang";
		//드라이버 로딩
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//Connection 객체 얻기
			conn = DriverManager.getConnection(url, user, pwd);
			//Statement 객체 얻기 (Connection 객체를 이용해서)
			stmt = conn.createStatement();
			//Sql문 완성
			StringBuilder sb = new StringBuilder();	 	
			String sql = sb.append("create table menu(")
					        .append("rname varchar2(20),")
							.append("fname varchar2(20),")
							.append("price number)")
							.toString();
			//Statment의 execute 메소드를 이용해서 쿼리 실행
			stmt.execute(sql);
			System.out.println("테이블 생성 완료");
			/*
			 구문객체를 보내는 방법
			 - execute : 테이블 생성, 수정, 삭제 등등 데이터베이스 관리 명령
			 - executeUpdate() : 레코드삽입, 수정, 삭제 등등 데이터 베이스 조작 명령
			 - executeQuery() : 레코드 조회, 테이블 조회등의 명령		  
			 */
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally { //Connection 객체 닫기
			try {
				if(conn!=null && !conn.isClosed() )conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	
	
	
	

}