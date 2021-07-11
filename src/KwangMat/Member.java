package KwangMat;

public class Member {
	/* 琶球 識情 */
	private String email;
	private String nickname;
	private String password;

	/* 持失切 */
	public Member(String email, String nickname, String password) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.password = password;
	}

	public Member() {

	}

	/* 五社球 識情 */
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
