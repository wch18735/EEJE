package KwangMat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
  student ���̺� ����ִ� ��� �л����� �������� 
 */
public class SelectAllMenuTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null; //?�� �� �κ��� ����
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "kwangmat";
		String pwd = "kwang";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String sql = "select * from menu";
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			//�л���ü�� �������� ���� sql��
			//select * from student
			rs = pstmt.executeQuery();
			//select�� ������ ���� ���(���ڵ� ����/result set) rs ���������� ����
			while(rs.next()) {
				System.out.println("�Ĵ��̸� : " + rs.getString("RNAME"));
				System.out.println("�޴��̸� : " + rs.getString("FNAME"));
				System.out.println("���� : " +  rs.getInt("PRICE"));
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
