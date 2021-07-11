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
	private final String USER = "kwangmat"; // Trouble �� ���ɼ� ����
	private final String PW = "kwang";
	
	private Connection conn;
	private PreparedStatement pstmt;
//	private ArrayList<String> list;
	
	/* ������ */
	private KGradeDao() { // Connection ��ü ����
		try {
			conn = DriverManager.getConnection(URL, USER, PW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* �̱��� ���� */
	static KGradeDao instance;
	
	public static KGradeDao getInstance() {
		if(instance == null) {
			instance = new KGradeDao();
			return instance;
		} else {
			return instance;
		}
	}
	
	/* ��� */
	/* 
	 	1. ���̺� ���� �α��� �� �̸��Ϸ� ������ �Է¹޾� ������ ���
	 	2. �Է� �� ������ �Էµ� ������ ������Ʈ
	 */
	
	/* ���� �ֱ� - ����: ���� �Է� */
	public void setGrade(String rname, String email, double grade) {
		KGrade kgrade = new KGrade(rname, email, grade);
		/* sql�� */
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
	
	/* ���� �ֱ� - ����: kgrade ��ü �޾ƿ� */
	public void setGrade(KGrade gradeObject) {
		KGrade kgrade = new KGrade(gradeObject.getRname(), gradeObject.getEmail(), gradeObject.getGrade());
		/* sql�� */
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
	
	public void CreateKGradeTable() { // ECLIPSE ���� ���̺� ���� ����
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
	
	/* �ش� �Ĵ��̸��� �ش��ϴ� ������ ��� �����ͼ� �� ���ϱ� */
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
	
	/* Email�� �Է¹޾Ƽ� ���̺� ������ ��ϵ� �̸����� �ִ��� Ȯ�� */
	public ArrayList<String> EmailSelect(String rname) {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select email from KGRADE where rname = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rname);
			rs = pstmt.executeQuery();

			//student = new Student(); ���⿡ ���ָ� X
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
