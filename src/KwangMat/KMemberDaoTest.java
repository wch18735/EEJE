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
		// �� Ŭ������ ��ü����
		// �л� ������ ������� Ŭ����
		do {
			System.out.println("�ڹ� - �����ͺ��̽� ���� �׽�Ʈ");
			System.out.println("1.����   2.����    3.����(all)  4.����   5.��ȸ    6.��ȸ(all)  7.����");
			System.out.print("���ϴ� �۾�:");
			num = sc.nextInt();

			switch (num) {
			case 1: {// ����
						sc.nextLine(); //Enter ġ���
				Member member = new Member();
				System.out.print("email�� �Է��ϼ���:");
				email = sc.nextLine();
				System.out.print("nickname�� �Է��ϼ���:");
				nickname = sc.nextLine();
				System.out.print("password�� �Է��ϼ���:");
				password = sc.nextLine();
				// ����
				member.setEmail(email);
				member.setNickname(nickname);
				member.setPassword(password);
				// DB�� �� Ŭ���� �ּҸ� �Ѱ��شٸ� ���Խ� ��
				KMemberDao dao = KMemberDao.getInstance();
				dao.MemberInsert(member);
				System.out.println();
			}
				break;

			case 2: {// ����
							sc.nextLine(); //Enter ġ���
				System.out.print("nickname�� �Է��ϼ���:");
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

			case 5: {// ��ȸ
				sc.nextLine();
				System.out.print("��ȸ�� nickname:");
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

		System.out.println("����Ǿ����ϴ�");
	}
}
