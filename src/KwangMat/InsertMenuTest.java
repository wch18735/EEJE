package KwangMat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.net.aso.p;


public class InsertMenuTest {
	public static void main(String[] args) {
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null; //�غ�� ������ü ����

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "kwangmat";
		String pwd = "kwang";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�Ĵ� �̸��� �Է��ϼ���");
		String rname = sc.nextLine();
		System.out.println("�޴� �̸��� �Է��ϼ���");
		String fname = sc.nextLine();
		System.out.println("�޴� ������ �Է��ϼ���");
		int price = sc.nextInt();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε�����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} 
		try {
			//insert into student values (1,'ȫ�浿',90)
			conn = DriverManager.getConnection(url,user,pwd);
//			stmt = conn.createStatement();
//			stmt.executeUpdate("insert into student values(" 
//								+id + ",'" + name+ "'," + grade + ")");		
			/*
			 sql ������ ���ϰ� �����ִ� statement��ü
			 PreparedStatement ��ü : ���ڰ� ������ ���ϰ� �����ִ� ��ü
			 */
			pstmt = conn.prepareStatement("insert into menu"
					+ " values(?,?,?)");
			pstmt.setString(1, rname);
			pstmt.setString(2, fname);
			pstmt.setInt(3, price);
			
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
