package KwangMat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 	��ȸ�ϰ���� �л��� id�� �Է¹޾Ƽ� �ش��л��� ������ ���
 */
public class SelectOneMenuTest {
	public static void main(String[] args) {
		Connection conn = null;
//		Statement stmt = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "kwangmat";
		String pwd = "kwang";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȸ�� �Ĵ� �̸� �Է�:");
		String rname = sc.nextLine();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url,user,pwd);
			//�л� �Ѹ� �������� ���� sql��
			//select * from student where stuid = ?
			pstmt = conn.prepareStatement("select * from menu where rname = ?");
			//���ڰ� ����
			pstmt.setString(1, rname);
			rs = pstmt.executeQuery();
			
			//select�� ������ ���� ���(���ڵ� ����/result set) rs ���������� ����
			
			while(rs.next()) {
//				System.out.println("stuid : " +  rs.getInt(1));
//				System.out.println("stuname : " + rs.getString(2));
//				System.out.println("grade : " +  rs.getInt(3));
				
				System.out.println(rs.getString("rname"));
				System.out.println(rs.getString("fname"));
				System.out.println(rs.getInt("price"));
				
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