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
            PMember pmember = new PMember();
            System.out.print("email�� �Է��ϼ���:");
            email = sc.nextLine();
            System.out.print("nickname�� �Է��ϼ���:");
            nickname = sc.nextLine();
            System.out.print("password�� �Է��ϼ���:");
            password = sc.nextLine();
            System.out.print("rname�� �Է��ϼ���:");
            rname = sc.nextLine();
            // ����
            pmember.setEmail(email);
            pmember.setNickname(nickname);
            pmember.setPassword(password);
            pmember.setRname(rname);
            // DB�� �� Ŭ���� �ּҸ� �Ѱ��شٸ� ���Խ� ��
            PMemberDao dao = PMemberDao.getInstance();
            dao.MemberInsert(pmember);
            System.out.println();
         }
            break;

         case 2: {// ����
                     sc.nextLine(); //Enter ġ���
            System.out.print("nickname�� �Է��ϼ���:");
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

         case 5: {// ��ȸ
            sc.nextLine();
            System.out.print("��ȸ�� nickname:");
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

      System.out.println("����Ǿ����ϴ�");
   }
}
