package KwangMat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.net.aso.p;

/*
 Ŀ�ؼ� ��ü�� Ȯ��
 ������ü(Statement)�� ����
 ������ü�� �л����� �߰� (������� �Է��� �޾Ƽ� / ���Ƿ� ����)
 ������ insert sql���� ������ü�� �̿��ؼ� ������
 
 executeUpdate()�� ���
*/
public class InsertRestaurantTest {
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
		System.out.println("�Ĵ� ��ġ�� �Է��ϼ���");
		//sc.nextLine();
		String wname = sc.nextLine();
		System.out.println("�Ĵ� ��ȭ��ȣ�� �Է��ϼ���");
		String hpnum = sc.nextLine();
		System.out.println("�Ĵ� ������ �Է��ϼ���");
		float grade=0;
		
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
			pstmt = conn.prepareStatement("insert into restaurant values(?,?,?,?)");
			pstmt.setString(1, rname);
			pstmt.setString(2, wname);
			pstmt.setString(3, hpnum);
			pstmt.setFloat(4, grade);
			
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
