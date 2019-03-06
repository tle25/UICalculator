
public class DivisionOperator extends Operator{
    
       @Override
       public Operand execute( Operand op1, Operand op2 ){
        Operand operands = new Operand(op1.getValue() / op2.getValue());
        return operands;}
       
       @Override
       public int priority(){
               return 3; }
      
    
}
