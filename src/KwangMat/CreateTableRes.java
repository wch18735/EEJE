package KwangMat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 DBMS���� Ư�� DB�� ������ ���� Connection ��ü ȹ��
  ���� ������ sql���� ���� Statement ��ü ����
 Connection��ü�� Statement ��ü�� ����
 
  create table student(
 	stuid number,
 	sname varchar2(10),
 	grade number
  )
  
 */
public class CreateTableRes {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		//������ DBMS�� �ּ�
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//������ oracle ������̸�, ��й�ȣ
		String user ="kwangmat";
		String pwd ="kwang";
		//����̹� �ε�
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//Connection ��ü ���
			conn = DriverManager.getConnection(url, user, pwd);
			//Statement ��ü ��� (Connection ��ü�� �̿��ؼ�)
			stmt = conn.createStatement();
			//Sql�� �ϼ�
			StringBuilder sb = new StringBuilder();	 	
			String sql = sb.append("create table restaurant(")
							.append("rname varchar2(10),")
							.append("wname varchar2(10),")
							.append("hpnum varchar2(30),")
							.append("grade number)")
							.toString();
			//Statment�� execute �޼ҵ带 �̿��ؼ� ���� ����
			stmt.execute(sql);
			System.out.println("���̺� ���� �Ϸ�");
			/*
			 ������ü�� ������ ���
			 - execute : ���̺� ����, ����, ���� ��� �����ͺ��̽� ���� ���
			 - executeUpdate() : ���ڵ����, ����, ���� ��� ������ ���̽� ���� ���
			 - executeQuery() : ���ڵ� ��ȸ, ���̺� ��ȸ���� ���		  
			 */
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally { //Connection ��ü �ݱ�
			try {
				if(conn!=null && !conn.isClosed() )conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	
	
	
	

}