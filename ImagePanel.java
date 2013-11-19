import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class ImagePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImagePanel extends JPanel
{
    // instance variables - replace the example below with your own
    private String part;
    private Image image;
    private Image image2;
    private int size;

    /**
     * Constructor for objects of class ImagePanel
     */
    public ImagePanel(String part)
    {
        // initialise instance variables
        this.part = part;
        size = 500;
        image = new ImageIcon("aboutProject.jpg").getImage();  
        image2 = new ImageIcon("aboutMember.jpg").getImage();
        setPreferredSize(new Dimension(size,size));
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void paint(Graphics g){
        g.drawImage(image,0,0, this);  
    }
}
