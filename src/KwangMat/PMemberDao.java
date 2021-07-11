package KwangMat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PMemberDao { /* Database Access Object: �����ͺ��̽��� �ڹ��� ���� */
   /* �ʵ� ���� */
   private final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
   private final String USER = "kwangmat";
   private final String PW = "kwang";

   private Connection conn;
   private PreparedStatement pstmt;

   private static PMemberDao instance;

   /* ������ */
   private PMemberDao() { // Connection ��ü ����
      try {
         conn = DriverManager.getConnection(URL, USER, PW);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   /* �̱��� ���� */
   public static PMemberDao getInstance() {
      if (instance == null) {
         instance = new PMemberDao();
         return instance;
      } else
         return instance;
   }

   /* ���� */
   public void MemberInsert(PMember member) {
      /* ���Թ� */String sql = "INSERT INTO pmember VALUES (?,?,?,?)";
      try {/* �̸���, �г���, ��й�ȣ */
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, member.getEmail());
         pstmt.setString(2, member.getNickname());
         pstmt.setString(3, member.getPassword());
         pstmt.setString(4, member.getRname());
         /* ���� */
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if (!pstmt.isClosed() || pstmt != null)
               pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

   public void MemberDelete(String nickname) { //pmember �г����� ��ġ�ϴ� ��� ����
      String sql = "DELETE FROM pmember WHERE nickname = ?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, nickname);
         /* ���� */
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if (!pstmt.isClosed() || pstmt != null)
               pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

   public PMember MemberSelect(String nickname) { //pmember ���� �г����� ��ġ�ϴ� Member �̾ƿ�
      String sql = "select * from pmember where nickname = ?";
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      PMember member = new PMember();
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, nickname);
         rs = pstmt.executeQuery();

         //student = new Student(); ���⿡ ���ָ� X
         while(rs.next()) {
         member.setEmail(rs.getString("email"));
         member.setNickname(rs.getString("nickname"));
         member.setPassword(rs.getString("password"));
         member.setRname(rs.getString("rname"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            if (!pstmt.isClosed() || pstmt != null)
               pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }}
      return member;
   }
   /* pmember Email �޾ƿ��� */
   public String EmailSelect(String email) {
      String sql = "select * from pmember where email = ?";
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      PMember member = new PMember();
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs = pstmt.executeQuery();

         //student = new Student(); ���⿡ ���ָ� X
         while(rs.next()) {
         member.setEmail(rs.getString("email"));
         member.setNickname(rs.getString("nickname"));
         member.setPassword(rs.getString("password"));
         member.setRname(rs.getString("rname"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            if (!pstmt.isClosed() || pstmt != null)
               pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }}
      return member.getEmail();
   }
   /* pmemeber Nickname �޾ƿ��� */
   public String NicknameSelect(String nickname) {
      String sql = "select * from pmember where nickname = ?";
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      PMember member = new PMember();
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, nickname);
         rs = pstmt.executeQuery();

         //student = new Student(); ���⿡ ���ָ� X
         while(rs.next()) {
         member.setEmail(rs.getString("email"));
         member.setNickname(rs.getString("nickname"));
         member.setPassword(rs.getString("password"));
         member.setRname(rs.getString("rname"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            if (!pstmt.isClosed() || pstmt != null)
               pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }}
      return member.getNickname();
   }
   /* pmember Password �޾ƿ��� */
   public String PasswordSelect(String password) {
      String sql = "select * from pmember where password = ?";
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      PMember member = new PMember();
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, password);
         rs = pstmt.executeQuery();

         //student = new Student(); ���⿡ ���ָ� X
         while(rs.next()) {
         member.setEmail(rs.getString("email"));
         member.setNickname(rs.getString("nickname"));
         member.setPassword(rs.getString("password"));
         member.setRname(rs.getString("rname"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            if (!pstmt.isClosed() || pstmt != null)
               pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }}
      return member.getPassword();
   }
  
   
   /* Email�� Password �޾ƿ��� */
   public String PasswordSelectByEmail(String email) {
      String sql = "select * from PMEMBER where email = ?";
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      PMember member = new PMember();
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs = pstmt.executeQuery();

         //student = new Student(); ���⿡ ���ָ� X
         while(rs.next()) {
         member.setEmail(rs.getString("email"));
         member.setNickname(rs.getString("nickname"));
         member.setPassword(rs.getString("password"));
         member.setRname(rs.getString("rname"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            if (!pstmt.isClosed() || pstmt != null)
               pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }}
      return member.getPassword();
   }
}