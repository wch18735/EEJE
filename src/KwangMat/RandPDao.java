package KwangMat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import KwangMat.Restaurant;
import KwangMat.RestaurantDao;

public class RandPDao {
   private final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
   private final String USER = "kwangmat";
   private final String PW = "kwang"; 
   private static RandPDao instance;
   private Connection conn;
   
   
   /* 생성자 */
   private RandPDao() {
      try {
         conn = DriverManager.getConnection(URL, USER, PW);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   /* 싱글턴 패턴 */
   public static RandPDao getInstance() {
      if(instance == null) {
         instance = new RandPDao();
         return instance;
      } else {
         return instance;
      }
   }
   
   /* 메소드 */
   /* 테이블에 추가 */
   public void Insert(String email, String rname) {
      String sql = "insert into randp values (?,?)";
      PreparedStatement pstmt = null;
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, rname);
         pstmt.setString(2, email);
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   /* 테이블에서 삭제 */
   public void Delete(String email, String rname) {
      String sql = "delete from randp where email = ? and rname = ?";
      PreparedStatement pstmt =null;
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         pstmt.setString(2, rname);
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   /* 테이블에서 검색 */
   public ArrayList<String> RnameSelect(String email) {
	  PreparedStatement pstmt = null;
      String sql = "select rname from randp where email = ?";
      ResultSet rs = null;
      ArrayList<String> RList = new ArrayList<String>();
      try {
         pstmt =  conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            RList.add(rs.getString("rname"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return RList;
   }
   
   /* 테이블에서 받아오기 */
   public ArrayList<Restaurant> RestaurantSelect(ArrayList<String> RList){
      ArrayList<Restaurant> RestList = new ArrayList<Restaurant>();
      RestaurantDao restdao = RestaurantDao.getInstance();
      for (int i = 0; i < RList.size(); i++) {
         RestList.add(restdao.selectOneRestaurant(RList.get(i)));
      }
      return RestList;
   }
   
   public boolean CheckRname(String email, String rname) { //입력받은 rname이 있는지 확인
	      String sql = "select rname from randp where email = ?";
	      ArrayList<String> rnamelist = new ArrayList<String>();
	      ResultSet rs = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, email);
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            rnamelist.add(rs.getString("rname"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return rnamelist.contains(rname);
	   }
}