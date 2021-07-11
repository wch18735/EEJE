package KwangMat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PMemberDaoTest {
   public static void main(String[] args) {
      int num;
      String email;
      String nickname;
      String password;
      String rname;
      Scanner sc = new Scanner(System.in);
      // 모델 클래스로 객체생성
      // 학생 정보를 담기위한 클래스
      do {
         System.out.println("자바 - 데이터베이스 연동 테스트");
         System.out.println("1.삽입   2.삭제    3.삭제(all)  4.갱신   5.조회    6.조회(all)  7.종료");
         System.out.print("원하는 작업:");
         num = sc.nextInt();

         switch (num) {
         case 1: {// 삽입
                  sc.nextLine(); //Enter 치우기
            PMember pmember = new PMember();
            System.out.print("email을 입력하세요:");
            email = sc.nextLine();
            System.out.print("nickname을 입력하세요:");
            nickname = sc.nextLine();
            System.out.print("password를 입력하세요:");
            password = sc.nextLine();
            System.out.print("rname을 입력하세요:");
            rname = sc.nextLine();
            // 대입
            pmember.setEmail(email);
            pmember.setNickname(nickname);
            pmember.setPassword(password);
            pmember.setRname(rname);
            // DB에 모델 클래스 주소만 넘겨준다면 삽입시 편리
            PMemberDao dao = PMemberDao.getInstance();
            dao.MemberInsert(pmember);
            System.out.println();
         }
            break;

         case 2: {// 삭제
                     sc.nextLine(); //Enter 치우기
            System.out.print("nickname을 입력하세요:");
            nickname = sc.nextLine();
            PMemberDao dao = PMemberDao.getInstance();
            dao.MemberDelete(nickname);
            System.out.println();
         }
            break;

         case 3:
            break;

         case 4:
            break;

         case 5: {// 조회
            sc.nextLine();
            System.out.print("조회할 nickname:");
            nickname = sc.nextLine();
            PMemberDao dao = PMemberDao.getInstance();
            PMember pmember = dao.MemberSelect(nickname);
            System.out.println(pmember.toString());
         }
            break;

         case 6:
            break;
         }

      } while (num != 7);

      System.out.println("종료되었습니다");
   }
}
