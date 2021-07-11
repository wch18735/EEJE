package KwangMat;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class KService {
	private KMemberDao kmemberDao;

	public KService() {
		kmemberDao = KMemberDao.getInstance();
	}

	/* 소비자 회원가입 중복확인 */
	/* 소비자 email 중복확인 */
	public boolean DupliEmailCheck(String email) { // 중복이면 true
		String checkedmail = kmemberDao.EmailSelect(email);
		if (checkedmail == null)
			return false;
		else
			return true;
	}

	/* 소비자 nickname 중복확인 */
	public boolean DupliNickCheck(String nickname) {
		String checkednickname = kmemberDao.NicknameSelect(nickname);
		if (checkednickname == null)
			return false;
		else
			return true;
	}

	/* 소비자 회원정보 등록 */
	public void join(Member member) {
		kmemberDao.MemberInsert(member);
	}

	/* 소비자 회원 로그인 */
	public int login(String email, String password) {
	      if(kmemberDao.EmailSelect(email) == null || 
	            kmemberDao.PasswordSelectByEmail(email) == null) {
	         return 1;
	      }
	      else if (kmemberDao.EmailSelect(email).equals(email) && 
	            kmemberDao.PasswordSelectByEmail(email).equals(password)) // 문자열 비교는 equals로!!
	         return 2;
	      else
	         return 0;
	   }

	/* 검색 by 식당이름 */
	public ArrayList<String> RList(String rname){
		ArrayList<String> rlist = new ArrayList<String>();
		return rlist;
	}
}
