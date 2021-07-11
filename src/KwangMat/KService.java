package KwangMat;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class KService {
	private KMemberDao kmemberDao;

	public KService() {
		kmemberDao = KMemberDao.getInstance();
	}

	/* �Һ��� ȸ������ �ߺ�Ȯ�� */
	/* �Һ��� email �ߺ�Ȯ�� */
	public boolean DupliEmailCheck(String email) { // �ߺ��̸� true
		String checkedmail = kmemberDao.EmailSelect(email);
		if (checkedmail == null)
			return false;
		else
			return true;
	}

	/* �Һ��� nickname �ߺ�Ȯ�� */
	public boolean DupliNickCheck(String nickname) {
		String checkednickname = kmemberDao.NicknameSelect(nickname);
		if (checkednickname == null)
			return false;
		else
			return true;
	}

	/* �Һ��� ȸ������ ��� */
	public void join(Member member) {
		kmemberDao.MemberInsert(member);
	}

	/* �Һ��� ȸ�� �α��� */
	public int login(String email, String password) {
	      if(kmemberDao.EmailSelect(email) == null || 
	            kmemberDao.PasswordSelectByEmail(email) == null) {
	         return 1;
	      }
	      else if (kmemberDao.EmailSelect(email).equals(email) && 
	            kmemberDao.PasswordSelectByEmail(email).equals(password)) // ���ڿ� �񱳴� equals��!!
	         return 2;
	      else
	         return 0;
	   }

	/* �˻� by �Ĵ��̸� */
	public ArrayList<String> RList(String rname){
		ArrayList<String> rlist = new ArrayList<String>();
		return rlist;
	}
}
