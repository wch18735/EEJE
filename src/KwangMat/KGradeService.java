package KwangMat;

import java.util.ArrayList;

public class KGradeService {
	private KGradeDao kdao;

	public KGradeService() {
		KGradeDao kdao = KGradeDao.getInstance();
	}

	/* �Һ��� email - KGradeTable �ߺ�Ȯ�� */
	public boolean DupliEmailCheck(String rname, String email) { // �̹� ���ߴٸ� true
		kdao = KGradeDao.getInstance(); //������ ������ NullPointExepcion �� �߻��Ѵ�. Why??
		return kdao.EmailSelect(rname).contains(email);
		}
}
