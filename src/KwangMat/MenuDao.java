package KwangMat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.p;

/*
	DAO(Data Access Object)
	DB�� ����Ǿ� DB���� Ư�����̺��� �����͸�
	insert, update, delete, select�ϴ� ����� ����
*/



public class MenuDao {
	
	private Connection conn; //���ᰴü �ʵ�� ����
	private static MenuDao instance;
	
	//������ ���� ������ ����� ����
	private final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String USER = "kwangmat";
	private final String PWD = "kwang";
	
	//������ : �ʱ�ȭ -> ��ü�� �����ɶ� �ʱ��۾� ����
	public MenuDao() {
		//Connection ��ü�� �� DB�� ����
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* �̱��� ���� */
	public static MenuDao getInstance() {
		if (instance == null) {
			instance = new MenuDao();
			return instance;
		} else
			return instance;
	}
	
	//����
		//�л����� (Student Ŭ����) �ϳ��� �Ű������� �޾Ƽ�
		//student ���̺� ���ڵ� ����
	public void menuInsert(Menu menu) {
		
		/*
		 sql�� �غ� : insert into student values(?,?,?)
		 connection ��ü�� ���� preparedStatemnet ��ü ����
		  ���ڰ� ����
		 sql�� ����
		 preparedStatement ��ü �ݱ�		  
		 */
		String sql = "insert into menu values(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getRname());
			pstmt.setString(2, menu.getFname());
			pstmt.setInt(3, menu.getPrice());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(!pstmt.isClosed() && pstmt != null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	//����
	//�л���ȣ(�ĺ���)�� �Ű������� ����
	//student���̺��� �ش� �л��� ���ڵ带 �ϳ� ����
	public void deleteMenu(String fname) {
		String sql = "delete from menu where fname=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(!pstmt.isClosed() && pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//����
		//�л������� �Ű������� �޾�
		//�л���ȣ�� �ش��ϴ� ���ڵ带 ����
	public void updateMenu(Menu menu) {
		String sql = "update menu set rname = ?, fname=? where price =?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getRname());
			pstmt.setString(2, menu.getFname());
			pstmt.setInt(3, menu.getPrice());
			
			pstmt.executeUpdate();
			System.out.println("���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(!pstmt.isClosed() && pstmt!= null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	//��ȸ - �Ѹ�
		//�л���ȣ�� �ش��ϴ� �л����� ���ڵ带 DB���� ��������
		//�л����� ��ü(student ��Ŭ����)�� ��Ƽ� ����
	public Menu selectOneMenu(String snum) {
		String sql = "select * from menu where rname =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Menu menu = null;		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, snum);
			
			rs = pstmt.executeQuery();
			menu = new Menu();
			while(rs.next()) {				
				menu.setRname(rs.getString("rname"));
				menu.setFname(rs.getString("fname"));
				menu.setPrice(rs.getInt("price"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(!pstmt.isClosed() && pstmt!= null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return menu;
	}
	
	//��ȸ - ���
		//DB�� student���̺��� ��� ���ڵ� ��������
		//Student ��ü : 1��
		//Student ��ü�� ��� : List
	public List<Menu> selectAllMenu(String rname) {
//		List<String> list = new ArrayList<String>();
		System.out.println(rname);
		List<Menu> menuList = new ArrayList<Menu>();
		String sql = "select * from menu where rname = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Menu menu = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,rname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				menu = new Menu();
				menu.setRname(rs.getString("rname"));
				menu.setFname(rs.getString("fname"));
				menu.setPrice(rs.getInt("price"));
				//�л���� ����Ʈ�� DB���� ������ �л����� ���ڵ� ���� ���
				menuList.add(menu);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuList;
		
		
		
		
		
	}
	
}