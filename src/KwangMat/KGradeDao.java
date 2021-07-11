package KwangMat;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import KwangMat.Member;

public class KGradeDao {
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
	private final String USER = "kwangmat"; // Trouble 날 가능성 농후
	private final String PW = "kwang";
	
	private Connection conn;
	private PreparedStatement pstmt;
//	private ArrayList<String> list;
	
	/* 생성자 */
	private KGradeDao() { // Connection 객체 얻어옴
		try {
			conn = DriverManager.getConnection(URL, USER, PW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* 싱글턴 패턴 */
	static KGradeDao instance;
	
	public static KGradeDao getInstance() {
		if(instance == null) {
			instance = new KGradeDao();
			return instance;
		} else {
			return instance;
		}
	}
	
	/* 기능 */
	/* 
	 	1. 테이블에 현재 로그인 된 이메일로 평점을 입력받아 평점을 기록
	 	2. 입력 될 때마다 입력된 평점을 업데이트
	 */
	
	/* 평점 넣기 - 인자: 각개 입력 */
	public void setGrade(String rname, String email, double grade) {
		KGrade kgrade = new KGrade(rname, email, grade);
		/* sql문 */
		String sql = "INSERT INTO kgrade VALUES (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rname);
			pstmt.setString(2, email);
			pstmt.setDouble(3, grade);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* 평점 넣기 - 인자: kgrade 객체 받아옴 */
	public void setGrade(KGrade gradeObject) {
		KGrade kgrade = new KGrade(gradeObject.getRname(), gradeObject.getEmail(), gradeObject.getGrade());
		/* sql문 */
		String sql = "INSERT INTO kgrade VALUES (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kgrade.getRname());
			pstmt.setString(2, kgrade.getEmail());
			pstmt.setDouble(3, kgrade.getGrade());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void CreateKGradeTable() { // ECLIPSE 에서 테이블 생성 가능
		String sql = "CREATE TABLE KGRADE ("
				+ "RNAME VARCHAR2(20) NOT NULL,"
				+ "EMAIL VARCHAR2(20) NOT NULL,"
				+ "GRADE FLOAT NOT NULL)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* 해당 식당이름에 해당하는 점수값 모두 가져와서 합 구하기 */
	public double averageKGrade(String rname) {
		String sql = "select grade from KGRADE where rname = ?";
		ResultSet rs = null;
		int count = 0;
		double sum_result = 0.0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sum_result = sum_result + rs.getDouble("grade");
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sum_result/count;
	}
	
	/* Email을 입력받아서 테이블에 기존에 등록된 이메일이 있는지 확인 */
	public ArrayList<String> EmailSelect(String rname) {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select email from KGRADE where rname = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rname);
			rs = pstmt.executeQuery();

			//student = new Student(); 여기에 해주면 X
			while(rs.next()) {
			list.add(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (!pstmt.isClosed() || pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		return list;
	}
}
