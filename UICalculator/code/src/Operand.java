
public class Operand{
    private int value;
   
  public Operand( String token ) {
      this.value = Integer.parseInt(token);
  }

  public Operand( int value ) {
      this.value = value;
  }

  public int getValue() {
      return value;
  }
  
// Check token whether it is a valid integer or not 
  public static boolean check( String token ) {
     return token.matches("[0-9]+");
    }
}