package KwangMat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
 ����ڷ� ���� ������ �л��� id�� �Է¹޾Ƽ�
 �ش��л��� ���ڵ带 ����! 
 */
public class DeleteResTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "kwangmat";
		String pwd = "kwang";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Ĵ��� �̸��� �Է��ϼ���");
		String rname = sc.nextLine();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε�����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		try {
			conn = DriverManager.getConnection(url,user,pwd);
			//delete��
			//delete from student where stuid =?
			pstmt = conn.prepareStatement("delete from restaurant where rname =?");
			pstmt.setString(1, rname);
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
