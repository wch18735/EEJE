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

public class RestaurantDao {

	private Connection conn; // ���ᰴü �ʵ�� ����
	private static RestaurantDao instance;

	// ������ ���� ������ ����� ����
	private final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String USER = "kwangmat";
	private final String PWD = "kwang";

	// ������ : �ʱ�ȭ -> ��ü�� �����ɶ� �ʱ��۾� ����
	private RestaurantDao() {
		// Connection ��ü�� �� DB�� ����
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* �̱��� ���� */
	public static RestaurantDao getInstance() {
		if (instance == null) {
			instance = new RestaurantDao();
			return instance;
		} else
			return instance;
	}

	// ����
	// �л����� (Student Ŭ����) �ϳ��� �Ű������� �޾Ƽ�
	// student ���̺� ���ڵ� ����
	public void restaurantInsert(Restaurant restaurant) {

		/*
		 * sql�� �غ� : insert into student values(?,?,?) connection ��ü�� ����
		 * preparedStatemnet ��ü ���� ���ڰ� ���� sql�� ���� preparedStatement ��ü �ݱ�
		 */
		String sql = "insert into restaurant values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, restaurant.getRname());
			pstmt.setString(2, restaurant.getWname());
			pstmt.setString(3, restaurant.getHpnum());
			pstmt.setDouble(4, restaurant.getGrade());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (!pstmt.isClosed() && pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// ����
	// �л���ȣ(�ĺ���)�� �Ű������� ����
	// student���̺��� �ش� �л��� ���ڵ带 �ϳ� ����
	public void deleteRestaurant(String rname) {
		String sql = "delete from restaurant where rname=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (!pstmt.isClosed() && pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// ����
	// �л������� �Ű������� �޾�
	// �л���ȣ�� �ش��ϴ� ���ڵ带 ����
	public void updateRestaurant(Restaurant restaurant) {
		String sql = "update restaurant set wname=?, hpnum=? where rname = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, restaurant.getWname());
			pstmt.setString(2, restaurant.getHpnum());
			pstmt.setString(3, restaurant.getRname());

			pstmt.executeUpdate();
			System.out.println("���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (!pstmt.isClosed() && pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ��ȸ - �Ѹ�
	// �л���ȣ�� �ش��ϴ� �л����� ���ڵ带 DB���� ��������
	// �л����� ��ü(student ��Ŭ����)�� ��Ƽ� ����
	public Restaurant selectOneRestaurant(String snum) {
		String sql = "select * from restaurant where rname =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Restaurant restaurant = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, snum);

			rs = pstmt.executeQuery();
			restaurant = new Restaurant();
			while (rs.next()) {
				restaurant.setRname(rs.getString("rname"));
				restaurant.setWname(rs.getString("wname"));
				restaurant.setHpnum(rs.getString("hpnum"));
				restaurant.setGrade(rs.getDouble("grade"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (!pstmt.isClosed() && pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return restaurant;
	}

	// ��ȸ - ���
	// DB�� student���̺��� ��� ���ڵ� ��������
	// Student ��ü : 1��
	// Student ��ü�� ��� : List
	public List<Restaurant> selectAllRestaurant(String rname) {
//		List<String> list = new ArrayList<String>();
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		String sql = "select * from restaurant where rname like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Restaurant restaurant = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+rname+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				restaurant = new Restaurant();
				restaurant.setRname(rs.getString("rname"));
				restaurant.setWname(rs.getString("wname"));
				restaurant.setHpnum(rs.getString("hpnum"));
				restaurant.setGrade(rs.getDouble("grade"));
				// �л���� ����Ʈ�� DB���� ������ �л����� ���ڵ� ���� ���
				restaurantList.add(restaurant);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restaurantList;
	}

	public List<Restaurant> selectAllRestaurant() {
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		String sql = "select * from restaurant";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Restaurant restaurant = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				restaurant = new Restaurant();
				restaurant.setRname(rs.getString("rname"));
				restaurant.setWname(rs.getString("wname"));
				restaurant.setHpnum(rs.getString("hpnum"));
				restaurant.setGrade(rs.getDouble("grade"));
				// �л���� ����Ʈ�� DB���� ������ �л����� ���ڵ� ���� ���
				restaurantList.add(restaurant);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restaurantList;
	}

}