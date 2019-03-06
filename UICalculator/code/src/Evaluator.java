import java.util.*;

public class Evaluator{
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;

  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/#!() ";
  
  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }

  public int eval( String expression ){
    String token;

    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

    // initialize operator stack - necessary with operator priority schema
    // the priority of any operator in the operator stack other than
    // the usual mathematical operators - "+-*/" - should be less than the priority
    // of the usual operators

    // TODO Operator is abstract - this will need to be fixed:
    // Init operator. This will be the first/begining operator in operatorStack.
    // Its priority will set to 0. 
     operatorStack.push(Operator.operators.get("#"));

    // When is it a good time to add the "!" operator?

    while ( this.tokenizer.hasMoreTokens() && !operatorStack.isEmpty()) {
      // filter out spaces
      if ( !( token = this.tokenizer.nextToken() ).equals( " " )) {
        // check if token is an operand
        if ( Operand.check( token )) {
          operandStack.push( new Operand( token ));
        } else {
          if ( !(Operator.check( token ))) {
            System.out.println( "*****invalid token******" );
            System.exit( 1 );
          }

          // TODO Operator is abstract - these two lines will need to be fixed:
          // The Operator class should contain an instance of a HashMap,
          // and values will be instances of the Operators.  See Operator class
          // skeleton for an example.

          Operator newOperator = Operator.operators.get(token);
          
          // ------EXTRA CREDIT------------
          
          // Factorial will be evaluated priorily when its token is found
          if(token.equals("!"))
          {
              operandStack.push( newOperator.execute( operandStack.peek(), operandStack.pop()));
          }
          
          
          // Since the factorial is execute, we have nothing to do with it.
          if(newOperator.priority() != 1) {
           // Whenever the opening parentheses is found, skil the while loop and push it onto the operatorStack
           if(!token.equals("(")) {
            while ( operatorStack.peek().priority() >= newOperator.priority()){
            // note that when we eval the expression 1 - 2 we will
            // push the 1 then the 2 and then do the subtraction operation
            // This means that the first number to be popped is the
            // second operand, not the first operand - see the following code      
            
            // Pop the closing parentheses when a pair of them are found. 
            if(operatorStack.peek().priority() == 0 && newOperator.priority() == 0){
            operatorStack.pop();
            break;}
                
            Operator oldOpr = operatorStack.pop();
            Operand op2 = operandStack.pop();
            Operand op1 = operandStack.pop();
            operandStack.push( oldOpr.execute( op1, op2 ));  
          } // end while loop
          } // end if statement
          } // end factorial check
          
          // avoid pushing "!" and ")" to the operatorStack because we don't have to use it
          if(newOperator.priority() != 1)
            if(!token.equals(")"))
                operatorStack.push( newOperator );           
             }
        
      }
    }

    // Control gets here when we've picked up all of the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // In order to complete the evaluation we must empty the stacks (except
    // the init operator on the operator stack); that is, we should keep
    // evaluating the operator stack until it only contains the init operator;
    // Suggestion: create a method that takes an operator as argument and
    // then executes the while loop; also, move the stacks out of the main
    // method
        
        // Keep computing the expression until operandStack has only one rammaining solution.
        // When it is done, return it t where it is called 
           while(operandStack.size() > 1){
            Operator operator = operatorStack.pop();
            Operand op2 = operandStack.pop();
            Operand op1 = operandStack.pop();
            operandStack.push( operator.execute( op1, op2 ));      
            } 
         // Clear pound operator when there is nothing to compare. 
         // OperatorStack and operandStack are not empty.
         
         operatorStack.pop();        
         // send result to final_val, then return to the caller
        Operand final_val = operandStack.pop();
     
    return final_val.getValue();
  }
}
