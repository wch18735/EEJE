package KwangMat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 		1. ����
 		2. ��ȸ (Email, Nickname, Password) ���� ����
 		3. ����
 		4. ���� (���� Nickname �� ���ؼ� ����)
 */

public class KMemberDao { /* Database Access Object: �����ͺ��̽��� �ڹ��� ���� */
	/* �ʵ� ���� */
	private final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
	private final String USER = "kwangmat";
	private final String PW = "kwang";

	private Connection conn;
	private PreparedStatement pstmt;

	private static KMemberDao instance;

	/* ������ */
	private KMemberDao() { // Connection ��ü ����
		try {
			conn = DriverManager.getConnection(URL, USER, PW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* �̱��� ���� */
	public static KMemberDao getInstance() {
		if (instance == null) {
			instance = new KMemberDao();
			return instance;
		} else
			return instance;
	}

	/* ���� */
	public void MemberInsert(Member member) {
		/* ���Թ� */String sql = "INSERT INTO kmember VALUES (?,?,?)";
		try {/* �̸���, �г���, ��й�ȣ */
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getNickname());
			pstmt.setString(3, member.getPassword());
			/* ���� */
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

	public void MemberDelete(String nickname) { //kmember �г����� ��ġ�ϴ� ��� ����
		String sql = "DELETE FROM kmember WHERE nickname = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			/* ���� */
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

	public Member MemberSelect(String nickname) { //kmember ���� �г����� ��ġ�ϴ� Member �̾ƿ�
		String sql = "select * from KMEMBER where nickname = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();

			//student = new Student(); ���⿡ ���ָ� X
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
	/* kmember Email �޾ƿ��� */
	public String EmailSelect(String email) {
		String sql = "select * from KMEMBER where email = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			//student = new Student(); ���⿡ ���ָ� X
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
	/* kemeber Nickname �޾ƿ��� */
	public String NicknameSelect(String nickname) {
		String sql = "select * from KMEMBER where nickname = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();

			//student = new Student(); ���⿡ ���ָ� X
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
	/* kmember Password �޾ƿ��� */
	public String PasswordSelect(String password) {
		String sql = "select * from KMEMBER where password = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			rs = pstmt.executeQuery();

			//student = new Student(); ���⿡ ���ָ� X
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
	/* kmember Password by Email �޾ƿ��� */
	public String PasswordSelectByEmail(String email) {
		String sql = "select * from KMEMBER where email = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			//student = new Student(); ���⿡ ���ָ� X
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