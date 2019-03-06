
    public class FactorialOperator extends Operator{
     @Override
       public Operand execute( Operand op1, Operand op2 ){
            int val = 1;

           for(int i = 1; i <= op1.getValue(); i++)
           {
               val = val*i;
           }
        Operand operands = new Operand(val);
        return operands;
       }
       
       
     @Override
       public int priority(){
               return 1; } 
      
}

