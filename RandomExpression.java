import java.util.Stack;
class RandomExpression {
  private static final String OPERATORS = "SCAM";
  
  private static final String SINGLE_OPERAND_OPERATORS = "SC";
  
  private static final String OPERANDS = "xy";
  
  
  private final double PROBABILITY_OPERAND_IS_EXPRESSION;
  
  private String randExpression;
  
  
  private final int EXPRESSION_COMPLEXITY_LIMIT; 
  
  private static final int DEFAULT_MAX_COMPLEXITY = 10;
  private static final double DEFAULT_PROBABILITY_USE_OPERATOR_FOR_OPERAND = 0.85;
  
  public RandomExpression(){
    this(DEFAULT_MAX_COMPLEXITY, DEFAULT_PROBABILITY_USE_OPERATOR_FOR_OPERAND);
  }
  
  public RandomExpression(int complexity, double deeper){
    EXPRESSION_COMPLEXITY_LIMIT = complexity;
    PROBABILITY_OPERAND_IS_EXPRESSION = deeper;
    do {
      randExpression = createExpression(0);
    } while(!randExpression.contains("x") 
              || !randExpression.contains("y"));
  }
  public RandomExpression(String s){
    EXPRESSION_COMPLEXITY_LIMIT = -1;
    PROBABILITY_OPERAND_IS_EXPRESSION = -1;        
    randExpression = s;
  }
  
  private String createExpression(int currentLevel){
    int op = (int)(Math.random() * OPERATORS.length());
    int oper1 = (int)(Math.random() * 2);
    int oper2 = (int)(Math.random() * 2);
    String result = OPERATORS.substring(op, op + 1);
    boolean deeperFirstOperand = Math.random() < PROBABILITY_OPERAND_IS_EXPRESSION;
    boolean deeperSecondOperand = Math.random() < PROBABILITY_OPERAND_IS_EXPRESSION;
    
    
    if(isSingleOperandOperator(result)){
      
      if(!deeperFirstOperand || currentLevel == EXPRESSION_COMPLEXITY_LIMIT) {
        result = OPERANDS.charAt(oper1) +  result;
      }
      
      else{
        result = createExpression(currentLevel + 1) +  result;
      }
    }
    else{
      if(currentLevel == EXPRESSION_COMPLEXITY_LIMIT || (!deeperFirstOperand && !deeperSecondOperand)){
        result = OPERANDS.charAt(oper1) + "" + OPERANDS.charAt(oper2) + result;
      }
      else if(!deeperFirstOperand){
        result = OPERANDS.charAt(oper1) +  createExpression(currentLevel + 1) + result;
      }
      else if(!deeperSecondOperand){
        result = createExpression(currentLevel + 1) + OPERANDS.charAt(oper2) + result;
      }
      else{
        result = createExpression(currentLevel + 1) + createExpression(currentLevel + 1) + result;
      }
    }
    return result;
  }

    private boolean isSingleOperandOperator(String operator) {
        return SINGLE_OPERAND_OPERATORS.contains(operator);
    }

 
    public double getResult(double x, double y){
        Stack<Double> operands = new Stack<Double>();
        for(int i = 0; i < randExpression.length(); i++){
            char ch = randExpression.charAt(i);
            if(ch == 'x')
                operands.push(x);
            else if(ch == 'y')
                operands.push(y);
            else{
                // operator
                double op1 = operands.pop();
                if(ch == 'S')
                    operands.push(Math.sin(Math.PI * op1));
                else if(ch == 'C')
                    operands.push(Math.cos(Math.PI * op1));
                else if(ch == 'M')
                    operands.push(op1 * operands.pop());
                else if (ch == 'A')
                    operands.push(ave(op1, operands.pop()));
               
            }
        }
        assert operands.size() == 1 : operands.size();
        double result = operands.pop();
        result = (result < -1.0) ? -1.0 : (result > 1.0) ? 1.0 : result;
        assert -1.0 <= result && result <= 1.0 : result;
        return result;
    }

    private static double ave(double x, double y){
        return (x + y) / 2.0;
    }

    public String toString(){
        return randExpression;
    }

    public static double getValExp(double x, double y){
        return Math.sin(Math.PI * Math.sin(Math.PI * Math.sin(Math.PI * (Math.sin(Math.PI * Math.sin(Math.PI * Math.sin(Math.PI * Math.sin(Math.PI * Math.cos(Math.PI * y))))) * Math.cos(Math.PI * Math.sin(Math.PI * Math.cos(Math.PI * ave(Math.sin(Math.PI * y), (x * x)))))))));
    }


    public static double getValueHardCoded(double x, double y){
        double pi = Math.PI;
        return Math.sin(pi * Math.cos(pi * Math.cos(pi * Math.sin(pi * ave(Math.cos(pi * y),y) * Math.sin(pi * x * y )))));
    } 
}

