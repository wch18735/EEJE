package KwangMat;

public class PService {
   private PMemberDao memberDao;
   
   public PService() {
      memberDao = PMemberDao.getInstance();
   }
   
   /*소비자 회원가입 중복확인*/
   /*소비자 email 중복확인*/
   public boolean DupliEmailCheck(String email) { // 중복이면 true
      String checkedmail = memberDao.EmailSelect(email);
      if (checkedmail == null)
         return false;
      else
         return true;
   }

   /* 소비자 nickname 중복확인 */
   public boolean DupliNickCheck(String nickname) {
      String checkednickname = memberDao.EmailSelect(nickname);
      if (checkednickname == null)
         return false;
      else
         return true;
   }

   /* 소비자 회원정보 등록 */
   public void join(PMember member) {
      memberDao.MemberInsert(member);
   }

   /* 소비자 회원 로그인 */
   public int login(String email, String password) {
      if(memberDao.EmailSelect(email) == null || 
            memberDao.PasswordSelectByEmail(email) == null) {
         return 1;
      }
      else if (memberDao.EmailSelect(email).equals(email) && 
            memberDao.PasswordSelectByEmail(email).equals(password)) // 문자열 비교는 equals로!!
         return 2;
      else
         return 0;
   }
}