package KwangMat;

public class MenuDaoTest {
	public static void main(String[] args) {
		MenuDao dao = new MenuDao();
		Menu menu = new Menu();
		menu.setRname("�ϴ�Ǫ��");
		menu.setFname("�Ĺݹݵ��");
		menu.setPrice(5500);
		dao.menuInsert(menu);
		System.out.println(dao.selectAllMenu("������"));
		System.out.println("---------------------");
		System.out.println(dao.selectAllMenu("������").get(0).getFname());
		System.out.println(dao.selectAllMenu("������").get(0).getPrice());
	}
}



