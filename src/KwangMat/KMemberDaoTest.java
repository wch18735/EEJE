package KwangMat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KMemberDaoTest {
	public static void main(String[] args) {
		int num;
		String email;
		String nickname;
		String password;
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
				Member member = new Member();
				System.out.print("email을 입력하세요:");
				email = sc.nextLine();
				System.out.print("nickname을 입력하세요:");
				nickname = sc.nextLine();
				System.out.print("password를 입력하세요:");
				password = sc.nextLine();
				// 대입
				member.setEmail(email);
				member.setNickname(nickname);
				member.setPassword(password);
				// DB에 모델 클래스 주소만 넘겨준다면 삽입시 편리
				KMemberDao dao = KMemberDao.getInstance();
				dao.MemberInsert(member);
				System.out.println();
			}
				break;

			case 2: {// 삭제
							sc.nextLine(); //Enter 치우기
				System.out.print("nickname을 입력하세요:");
				nickname = sc.nextLine();
				KMemberDao dao = KMemberDao.getInstance();
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
				KMemberDao dao = KMemberDao.getInstance();
				Member member = dao.MemberSelect(nickname);
				System.out.println(member.toString());
			}
				break;

			case 6:
				break;
			}

		} while (num != 7);

		System.out.println("종료되었습니다");
	}
}
