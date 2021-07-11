package KwangMat;

import java.util.ArrayList;

public class KGradeTest {
	public static void main(String[] args) {
		KGradeDao kdao = KGradeDao.getInstance();
//		kdao.CreateKGradeTable(); // 茄 锅 角青茄 促澜 林籍贸府
		
		
//		KGrade kgrade = new KGrade("切动","wch18735@naver.com",5.0);
//		kdao.setGrade(kgrade);
		
		System.out.println(kdao.averageKGrade("切动"));
		
		ArrayList<String> list = kdao.EmailSelect("切动");
		System.out.println(list.toString());
	}
}
