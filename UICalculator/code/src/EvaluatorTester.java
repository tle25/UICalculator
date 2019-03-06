public class EvaluatorTester {
  public static void main(String[] args) {
    Evaluator evaluator = new Evaluator();
   /* 
  for ( String arg : args ) {
      //System.out.format( "%s = %d\n", arg, evaluator.eval( arg ) );
       System.out.println( arg + " = " + evaluator.eval( arg ) );
    }
    
    */
  // assign val to any expression you want.
  // val will be 25 after executed
   String val = "2+3-5*((2-3)*2-5*2+3*(2-3-5-5*6)+4/2)*2-9"; 
    //String val = "";
    evaluator.eval(val);
    System.out.println( val + " = " + evaluator.eval(val) );



  }
}
