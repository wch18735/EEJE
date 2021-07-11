package KwangMat;

public class MenuDaoTest {
	public static void main(String[] args) {
		MenuDao dao = new MenuDao();
		Menu menu = new Menu();
		menu.setRname("ÇÏ´ÃÇª¸§");
		menu.setFname("ÆÄ¹Ý¹Ýµ·±î½º");
		menu.setPrice(5500);
		dao.menuInsert(menu);
		System.out.println(dao.selectAllMenu("ÀÛÀºÁý"));
		System.out.println("---------------------");
		System.out.println(dao.selectAllMenu("À±½ºÄî").get(0).getFname());
		System.out.println(dao.selectAllMenu("À±½ºÄî").get(0).getPrice());
	}
}



