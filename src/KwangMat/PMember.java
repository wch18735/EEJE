package KwangMat;

public class PMember {
   /* 琶球 識情 */
   private String email;
   private String nickname;
   private String password;
   private String rname;

   /* 持失切 */
   public PMember(String email, String nickname, String password,String rname) {
      super();
      this.email = email;
      this.nickname = nickname;
      this.password = password;
      this.rname = rname;
   }

   public PMember() {
   }

   /* 五社球 識情 */
   @Override
   public String toString() {
      return "Member [email=" + email + ", nickname=" + nickname + ", password=" + password +",rname"+rname+ "]";
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
   public String getRname() {
      return rname;
   }

   public void setRname(String rname) {
      this.rname = rname;
   }
}