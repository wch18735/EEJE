package KwangMat;

public class Menu {
	private String rname;
	private String fname;
	private int price;
	
	
	public Menu(String rname, String fname, int price) {
		super();
		this.rname = rname;
		this.fname = fname;
		this.price = price;
	}
	
	public Menu() {
	}
	//getter/setter 생성
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Menu [식당이름 : " + rname + ", 메뉴이름 : " + fname + ", 가격 : " + price + "]";
	}
	
	
	
	
}
