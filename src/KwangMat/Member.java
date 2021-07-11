package KwangMat;

public class Member {
	/* �ʵ� ���� */
	private String email;
	private String nickname;
	private String password;

	/* ������ */
	public Member(String email, String nickname, String password) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.password = password;
	}

	public Member() {

	}

	/* �޼ҵ� ���� */
	@Override
	public String toString() {
		return "Member [email=" + email + ", nickname=" + nickname + ", password=" + password + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
