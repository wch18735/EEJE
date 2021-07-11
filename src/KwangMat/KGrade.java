package KwangMat;

public class KGrade {
	private String rname;
	private String email;
	private double grade;
	
	/* »ý¼ºÀÚ */
	public KGrade(String rname, String email, double grade) {
		super();
		this.rname = rname;
		this.email = email;
		this.grade = grade;
	}
	
	public KGrade() {
		
	}
	
	/* Setter and Getter */
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	
}
