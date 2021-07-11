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
	DB와 연결되어 DB안의 특정테이블의 데이터를
	insert, update, delete, select하는 기능을 수행
*/

public class RestaurantDao {

	private Connection conn; // 연결객체 필드로 선언
	private static RestaurantDao instance;

	// 연결을 위한 정보를 상수로 정의
	private final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String USER = "kwangmat";
	private final String PWD = "kwang";

	// 생성자 : 초기화 -> 객체가 생성될때 초기작업 정의
	private RestaurantDao() {
		// Connection 객체를 얻어서 DB에 연결
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* 싱글턴 패턴 */
	public static RestaurantDao getInstance() {
		if (instance == null) {
			instance = new RestaurantDao();
			return instance;
		} else
			return instance;
	}

	// 삽입
	// 학생정보 (Student 클래스) 하나를 매개변수로 받아서
	// student 테이블에 레코드 삽입
	public void restaurantInsert(Restaurant restaurant) {

		/*
		 * sql문 준비 : insert into student values(?,?,?) connection 객체로 부터
		 * preparedStatemnet 객체 얻음 인자값 매핑 sql문 실행 preparedStatement 객체 닫기
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

	// 삭제
	// 학생번호(식별자)를 매개변수로 받음
	// student테이블에서 해당 학생의 레코드를 하나 지움
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

	// 갱신
	// 학생정보를 매개변수로 받아
	// 학생번호에 해당하는 레코드를 수정
	public void updateRestaurant(Restaurant restaurant) {
		String sql = "update restaurant set wname=?, hpnum=? where rname = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, restaurant.getWname());
			pstmt.setString(2, restaurant.getHpnum());
			pstmt.setString(3, restaurant.getRname());

			pstmt.executeUpdate();
			System.out.println("갱신 성공");
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

	// 조회 - 한명만
	// 학생번호에 해당하는 학생정보 레코드를 DB에서 가져오기
	// 학생정보 객체(student 모델클래스)에 담아서 리턴
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

	// 조회 - 모두
	// DB의 student테이블의 모든 레코드 가져오기
	// Student 객체 : 1명
	// Student 객체의 목록 : List
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
				// 학생목록 리스트에 DB에서 가져온 학생정보 레코드 내용 담기
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
				// 학생목록 리스트에 DB에서 가져온 학생정보 레코드 내용 담기
				restaurantList.add(restaurant);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restaurantList;
	}

}