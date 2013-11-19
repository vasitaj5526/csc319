import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class ArtPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArtPanel extends JPanel
{
    // instance variables - replace the example below with your own
    private Random redColor;
    private Random greenColor;
    private Random blueColor;
    private Random grayColor;
    private int color;
    private boolean printFunc;
    private JFrame popup;
    private int size;

    /**
     * Constructor for objects of class ArtPanel
     */
    public ArtPanel(int color)
    {
        // initialise instance variables
        this.color = color;
        size = 400;
        setPreferredSize(new Dimension(size,size));
        printFunc = false;
        if(color == 3){
            redColor = new Random();
            greenColor = new Random();
            blueColor = new Random();
        }
        else{
            grayColor = new Random();
        }
    }
    
    public void paint(Graphics g){
        
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
               double x = ((i+1)/(size/2.0))-1;
               double y = ((j+1)/(size/2.0))-1;
               if(color == 3){
                   double red = redColor.getResult(x,y);
                   double green = greenColor.getResult(x,y);
                   double blue = blueColor.getResult(x,y);
                   g.setColor(new Color((int)((red+1)*255/2),(int)((green+1)*255/2),(int)((blue+1)*255/2)));
                   if(!printFunc){
                       popup = new PopUp(("red : "+redColor.toString()),
                        ("green : "+greenColor.toString()),
                        ("blue : "+blueColor.toString()));
                        printFunc = true;
                    }
                }else {
                   double gray = grayColor.getResult(x,y);
                   g.setColor(new Color((int)((gray+1)*255/2),(int)((gray+1)*255/2),(int)((gray+1)*255/2)));
                    if(!printFunc){
                        popup = new PopUp("gray : "+grayColor.toString());
                        printFunc = true;
                    }
                }
            g.fillRect(i,j,1,1);
        }
        }
    }
    
    public void closePopup(){
        popup.setVisible(false);
    }
}
