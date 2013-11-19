import java.util.*;

/**
 * Write a description of class Random here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Random
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    private double result;
    private Queue expression;
    private Queue backup;
    private int length ;

    /**
     * Constructor for objects of class Random
     */
    public Random()
    {
        // initialise instance variables
        result = 1.0;
        expression = new LinkedList();
        length = 0;
    }
    
    public double getResult(double x, double y){
        if(expression.size()==0){
            generateExpression();
        }
        return getResultFromQueue(x,y);
    }
    
    private void generateExpression(){
        // do something
        do{
            //gen
            if(length == 0){
                expression.add('x');
            }
            else{
                double tmp = Math.random();
                if(tmp<1.0/6.0){
                    expression.add('x');
                }else if(tmp<1.0/6.0*2.0){
                    expression.add('y');
                }else if(tmp<1.0/6.0*3.0){
                    expression.add('s');
                }else if(tmp<1.0/6.0*4.0){
                    expression.add('c');
                }else if(tmp<1.0/6.0*5.0){
                    expression.add('m');
                    expression.add('x');
                }else {
                    expression.add('a');
                    expression.add('y');
                }
            }
            // chack length
            length = expression.size();
            updateLength();
        }while(length<=4);
        
        for(int i = 0 ; i < 4 ; i++ ){
            if(Math.random()<0.5){
                double tmp = Math.random();
                if(tmp<1.0/6.0){
                    expression.add('x');
                }else if(tmp<1.0/6.0*2.0){
                    expression.add('y');
                }else if(tmp<1.0/6.0*3.0){
                    expression.add('s');
                }else if(tmp<1.0/6.0*4.0){
                    expression.add('c');
                }else if(tmp<1.0/6.0*5.0){
                    expression.add('m');
                    expression.add('y');
                }else {
                    expression.add('a');
                    expression.add('x');
                }
            }
        }
        updateLength();
        backup = new LinkedList(expression);
    }
    
    private double getResultFromQueue(double x,double y){
        while(expression.size() != 0){
            char op = (Character)expression.poll();
            if((Character)op == 'x'){
                result *= x;
            }
            else if((Character)op == 'y'){
                result *= y;
            }
            else if((Character)op == 's'){
                result = sin(result);
            }
            else if((Character)op == 'c'){
                result = cos(result);
            }
            else if((Character)op == 'm'){
                double temp =1.0;
                char nextOp = (Character)expression.poll();
                if(nextOp == 'x'){
                    temp = x;
                }else if(nextOp == 'y'){
                    temp = y;
                }
                result = multiply(result,temp) ;
            }
            else if((Character)op == 'a'){
                double temp =1.0;
                char nextOp = (Character)expression.poll();
                if(nextOp == 'x'){
                    temp = x;
                }else if(nextOp == 'y'){
                    temp = y;
                }
                result = avg(result,temp) ;
            }
        }
        expression = new LinkedList(backup);
        if(x==399&&y==399){
            expression.clear();
            backup.clear();
        }
        double tmp = result;
        result = 1.0;
        return tmp;
    }
    
    private double sin(double num){
        return Math.sin(Math.PI*num);
    }
    
    private double cos(double num){
        return Math.cos(Math.PI*num);
    }
    
    private double multiply(double x,double y){
        return x*y;
    }
    
    private double avg(double x, double y){
        return (x+y)/2;
    }
    
    private void updateLength(){
        for(Object op:expression){
                if((Character)op==(Character)'a'||(Character)op==(Character)'m'){
                    length-=1;
                }
            }
    }
    
    public String toString(){
        String function = "";
        String tmp = "";
        for(Object op : expression){
            if((Character)op == 'x'){
                if(tmp.equals(")")){
                    function += "x"+tmp;
                    tmp = "";
                }else{
                    function = "x("+function+")"+tmp;
                }
            } else if((Character)op == 'y'){
                if(tmp.equals(")")){
                    function += "y"+tmp;
                    tmp = "";
                }else{
                    function = "y("+function+")"+tmp;
                }
            } else if((Character)op == 's'){
                function = "sin(pi*("+function+"))"+tmp;
                tmp = "";
            } else if((Character)op == 'c'){
                function = "cos(pi*("+function+"))"+tmp;
                tmp = "";
            } else if((Character)op == 'm'){
                function = "*"+function+tmp;
                tmp = "";
            } else {
                function = "avg("+function+","+tmp;;
                tmp = ")";
            }
        }
        return function;
    }
}
