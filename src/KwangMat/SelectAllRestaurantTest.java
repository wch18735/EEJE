package KwangMat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
  student ���̺� ����ִ� ��� �л����� �������� 
 */
public class SelectAllRestaurantTest {
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
			String sql = "select * from restaurant";
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			//�л���ü�� �������� ���� sql��
			//select * from student
			rs = pstmt.executeQuery();
			//select�� ������ ���� ���(���ڵ� ����/result set) rs ���������� ����
			while(rs.next()) {
				System.out.println("�Ĵ��̸� : " + rs.getString("RNAME"));
				System.out.println("��ġ : " + rs.getString("WNAME"));
				System.out.println("��ȭ��ȣ : " + rs.getString("HPNUM"));
				System.out.println("���� : " +  rs.getFloat("GRADE"));
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
