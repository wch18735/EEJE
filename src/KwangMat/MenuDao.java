package KwangMat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.p;

/*
	DAO(Data Access Object)
	DB와 연결되어 DB안의 특정테이블의 데이터를
	insert, update, delete, select하는 기능을 수행
*/



public class MenuDao {
	
	private Connection conn; //연결객체 필드로 선언
	private static MenuDao instance;
	
	//연결을 위한 정보를 상수로 정의
	private final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String USER = "kwangmat";
	private final String PWD = "kwang";
	
	//생성자 : 초기화 -> 객체가 생성될때 초기작업 정의
	public MenuDao() {
		//Connection 객체를 얻어서 DB에 연결
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* 싱글턴 패턴 */
	public static MenuDao getInstance() {
		if (instance == null) {
			instance = new MenuDao();
			return instance;
		} else
			return instance;
	}
	
	//삽입
		//학생정보 (Student 클래스) 하나를 매개변수로 받아서
		//student 테이블에 레코드 삽입
	public void menuInsert(Menu menu) {
		
		/*
		 sql문 준비 : insert into student values(?,?,?)
		 connection 객체로 부터 preparedStatemnet 객체 얻음
		  인자값 매핑
		 sql문 실행
		 preparedStatement 객체 닫기		  
		 */
		String sql = "insert into menu values(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getRname());
			pstmt.setString(2, menu.getFname());
			pstmt.setInt(3, menu.getPrice());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(!pstmt.isClosed() && pstmt != null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	//삭제
	//학생번호(식별자)를 매개변수로 받음
	//student테이블에서 해당 학생의 레코드를 하나 지움
	public void deleteMenu(String fname) {
		String sql = "delete from menu where fname=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(!pstmt.isClosed() && pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//갱신
		//학생정보를 매개변수로 받아
		//학생번호에 해당하는 레코드를 수정
	public void updateMenu(Menu menu) {
		String sql = "update menu set rname = ?, fname=? where price =?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getRname());
			pstmt.setString(2, menu.getFname());
			pstmt.setInt(3, menu.getPrice());
			
			pstmt.executeUpdate();
			System.out.println("갱신 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(!pstmt.isClosed() && pstmt!= null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	//조회 - 한명만
		//학생번호에 해당하는 학생정보 레코드를 DB에서 가져오기
		//학생정보 객체(student 모델클래스)에 담아서 리턴
	public Menu selectOneMenu(String snum) {
		String sql = "select * from menu where rname =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Menu menu = null;		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, snum);
			
			rs = pstmt.executeQuery();
			menu = new Menu();
			while(rs.next()) {				
				menu.setRname(rs.getString("rname"));
				menu.setFname(rs.getString("fname"));
				menu.setPrice(rs.getInt("price"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(!pstmt.isClosed() && pstmt!= null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return menu;
	}
	
	//조회 - 모두
		//DB의 student테이블의 모든 레코드 가져오기
		//Student 객체 : 1명
		//Student 객체의 목록 : List
	public List<Menu> selectAllMenu(String rname) {
//		List<String> list = new ArrayList<String>();
		System.out.println(rname);
		List<Menu> menuList = new ArrayList<Menu>();
		String sql = "select * from menu where rname = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Menu menu = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,rname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				menu = new Menu();
				menu.setRname(rs.getString("rname"));
				menu.setFname(rs.getString("fname"));
				menu.setPrice(rs.getInt("price"));
				//학생목록 리스트에 DB에서 가져온 학생정보 레코드 내용 담기
				menuList.add(menu);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuList;
		
		
		
		
		
	}
	
}