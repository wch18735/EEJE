package KwangMat;

import java.util.ArrayList;

public class KGradeTest {
	public static void main(String[] args) {
		KGradeDao kdao = KGradeDao.getInstance();
//		kdao.CreateKGradeTable(); // �� �� ������ ���� �ּ�ó��
		
		
//		KGrade kgrade = new KGrade("�ж�","wch18735@naver.com",5.0);
//		kdao.setGrade(kgrade);
		
		System.out.println(kdao.averageKGrade("�ж�"));
		
		ArrayList<String> list = kdao.EmailSelect("�ж�");
		System.out.println(list.toString());
	}
}
