package KwangMat;

import java.util.ArrayList;

public class KGradeService {
	private KGradeDao kdao;

	public KGradeService() {
		KGradeDao kdao = KGradeDao.getInstance();
	}

	/* 소비자 email - KGradeTable 중복확인 */
	public boolean DupliEmailCheck(String rname, String email) { // 이미 평가했다면 true
		kdao = KGradeDao.getInstance(); //해주지 않으면 NullPointExepcion 이 발생한다. Why??
		return kdao.EmailSelect(rname).contains(email);
		}
}
