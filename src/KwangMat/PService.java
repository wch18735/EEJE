package KwangMat;

public class PService {
   private PMemberDao memberDao;
   
   public PService() {
      memberDao = PMemberDao.getInstance();
   }
   
   /*�Һ��� ȸ������ �ߺ�Ȯ��*/
   /*�Һ��� email �ߺ�Ȯ��*/
   public boolean DupliEmailCheck(String email) { // �ߺ��̸� true
      String checkedmail = memberDao.EmailSelect(email);
      if (checkedmail == null)
         return false;
      else
         return true;
   }

   /* �Һ��� nickname �ߺ�Ȯ�� */
   public boolean DupliNickCheck(String nickname) {
      String checkednickname = memberDao.EmailSelect(nickname);
      if (checkednickname == null)
         return false;
      else
         return true;
   }

   /* �Һ��� ȸ������ ��� */
   public void join(PMember member) {
      memberDao.MemberInsert(member);
   }

   /* �Һ��� ȸ�� �α��� */
   public int login(String email, String password) {
      if(memberDao.EmailSelect(email) == null || 
            memberDao.PasswordSelectByEmail(email) == null) {
         return 1;
      }
      else if (memberDao.EmailSelect(email).equals(email) && 
            memberDao.PasswordSelectByEmail(email).equals(password)) // ���ڿ� �񱳴� equals��!!
         return 2;
      else
         return 0;
   }
}