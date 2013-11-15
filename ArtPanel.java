import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.util.Random;
import java.awt.*;
class ArtPanel extends JPanel{
    
   

    public static final int SIZE = 400;
    public static final int NUM_COLOR_OPTIONS = 2;
    Random random = new Random();
   
    
    private RandomExpression exp;
  

    public ArtPanel(){ 
        setPreferredSize(new Dimension(SIZE, SIZE));
        
     
        exp = new RandomExpression("Random Art Project");
        
       
    }
    
    

    public String getExpressionAsString() {
        String result =  "Gray Scale Equation: " + exp.toString();
        
      
        
        return result;
    }


    public void paintComponent(Graphics g) {
     
  
    
      
        super.paintComponent(g);
       Graphics2D g2 = (Graphics2D)g;
      
     
       for(int i=0;i<getWidth()-1&&i<getHeight()-1;i++){
         for(int j=0;j<getWidth()-1&&j<getHeight()-1;j++){
        
      int R = (int)(Math.random()*256);
      int G = (int)(Math.random()*256);
      int B= (int)(Math.random()*256);
    
    Color randomColor = new Color(R, G, B);
         g.setColor(randomColor);
          g2.fillRect(i,j,i,j);
    }
       }
    }
}
        
   