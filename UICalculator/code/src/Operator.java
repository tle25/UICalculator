
import java.util.HashMap;
import java.util.regex.Pattern;


public abstract class Operator {
  // The Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.

  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  // HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() ); 
   
  public abstract int priority();
  public abstract Operand execute( Operand op1, Operand op2 );
      
  // Check all valid operators , "+-*/!#()"
  public static boolean check( String token ) {
    
      switch (token) {
          case "+":
              return true;
          case "-":
              return true;
          case "*":
              return true;
          case "^":
              return true;
          case "/":
              return true;
          case "#":
              return true;
          case "!":
              return true;
          case "(":
              return true;
          case ")":
              return true;
          default:
              return false; 

      }
  }
    // Create HashMap that uses a key to access the subclass operator. 
    public final static HashMap<String, Operator> operators = new HashMap<>();
    
    static {
        operators.put("#", new PoundOperator());
        operators.put("+" , new AdditionOperator());
        operators.put("-", new SubtractionOperator());  
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivisionOperator());
        operators.put("^", new ExponentOperator());
        operators.put("!", new FactorialOperator());
        operators.put("(", new Parentheses());
        operators.put(")", new Parentheses());

    }
 
}


 
