package KwangMat;

public class RandP {
   private String email;
   private String rname;
   
   /* »ý¼ºÀÚ */
   public RandP(String email, String rname) {
      super();
      this.email = email;
      this.rname = rname;
   }
   
   public RandP() {
      
   }
   /* Getter & Setter */

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getRname() {
      return rname;
   }

   public void setRname(String rname) {
      this.rname = rname;
   }
}