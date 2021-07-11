package KwangMat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 		1. 삽입
 		2. 조회 (Email, Nickname, Password) 각각 따로
 		3. 수정
 		4. 삭제 (받은 Nickname 에 대해서 삭제)
 */

public class KMemberDao { /* Database Access Object: 데이터베이스와 자바의 연결 */
	/* 필드 선언 */
	private final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
	private final String USER = "kwangmat";
	private final String PW = "kwang";

	private Connection conn;
	private PreparedStatement pstmt;

	private static KMemberDao instance;

	/* 생성자 */
	private KMemberDao() { // Connection 객체 얻어옴
		try {
			conn = DriverManager.getConnection(URL, USER, PW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* 싱글턴 패턴 */
	public static KMemberDao getInstance() {
		if (instance == null) {
			instance = new KMemberDao();
			return instance;
		} else
			return instance;
	}

	/* 삽입 */
	public void MemberInsert(Member member) {
		/* 삽입문 */String sql = "INSERT INTO kmember VALUES (?,?,?)";
		try {/* 이메일, 닉네임, 비밀번호 */
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getNickname());
			pstmt.setString(3, member.getPassword());
			/* 실행 */
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!pstmt.isClosed() || pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void MemberDelete(String nickname) { //kmember 닉네임이 일치하는 멤버 삭제
		String sql = "DELETE FROM kmember WHERE nickname = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			/* 실행 */
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!pstmt.isClosed() || pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Member MemberSelect(String nickname) { //kmember 에서 닉네임이 일치하는 Member 뽑아옴
		String sql = "select * from KMEMBER where nickname = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();

			//student = new Student(); 여기에 해주면 X
			while(rs.next()) {
			member.setEmail(rs.getString("email"));
			member.setNickname(rs.getString("nickname"));
			member.setPassword(rs.getString("password"));
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
		return member;
	}
	/* kmember Email 받아오기 */
	public String EmailSelect(String email) {
		String sql = "select * from KMEMBER where email = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			//student = new Student(); 여기에 해주면 X
			while(rs.next()) {
			member.setEmail(rs.getString("email"));
			member.setNickname(rs.getString("nickname"));
			member.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (!pstmt.isClosed() || pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member.getEmail();
	}
	/* kemeber Nickname 받아오기 */
	public String NicknameSelect(String nickname) {
		String sql = "select * from KMEMBER where nickname = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();

			//student = new Student(); 여기에 해주면 X
			while(rs.next()) {
			member.setEmail(rs.getString("email"));
			member.setNickname(rs.getString("nickname"));
			member.setPassword(rs.getString("password"));
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
		return member.getNickname();
	}
	/* kmember Password 받아오기 */
	public String PasswordSelect(String password) {
		String sql = "select * from KMEMBER where password = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			rs = pstmt.executeQuery();

			//student = new Student(); 여기에 해주면 X
			while(rs.next()) {
			member.setEmail(rs.getString("email"));
			member.setNickname(rs.getString("nickname"));
			member.setPassword(rs.getString("password"));
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
		return member.getPassword();
	}
	/* kmember Password by Email 받아오기 */
	public String PasswordSelectByEmail(String email) {
		String sql = "select * from KMEMBER where email = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			//student = new Student(); 여기에 해주면 X
			while(rs.next()) {
			member.setEmail(rs.getString("email"));
			member.setNickname(rs.getString("nickname"));
			member.setPassword(rs.getString("password"));
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
		return member.getPassword();
	}
}