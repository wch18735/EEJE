package KwangMat;

public class Restaurant {
	private String rname;
	private String wname;
	private String hpnum;
	private Double grade;
	
	
	public Restaurant(String rname, String wname, String hpnum) {
		super();
		this.rname = rname;
		this.wname = wname;
		this.hpnum = hpnum;
	}

	public Restaurant(String rname, String wname, String hpnum, Double grade) {
		super();
		this.rname = rname;
		this.wname = wname;
		this.hpnum = hpnum;
		this.grade = grade;
	}
	
	public Restaurant() {
		
	}
	
	//getter/setter ����
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getHpnum() {
		return hpnum;
	}
	public void setHpnum(String hpnum) {
		this.hpnum = hpnum;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Restaurant [�Ĵ��̸� : " + rname + ", ��ġ : " + wname + ", ��ȭ��ȣ : "+ hpnum + ", ���� : " + grade + "]";
	}
	
	
	
	
}
