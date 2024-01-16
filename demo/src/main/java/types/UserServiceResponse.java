package types;

import java.util.ArrayList;

public class  UserServiceResponse {
   String message;
   ArrayList<String> errors;;
   public UserServiceResponse() {
     init();
   }
   private void init() {
     errors = new ArrayList<String>();
   }
   public ArrayList<String> getResults() {
      return errors;
   }
   public void setResults(ArrayList<String> results) {
      this.errors = results;
   }
   public String getMessage() {
      return message;
   }
   public void setMessage(String message) {
      this.message = message;
   }

}
