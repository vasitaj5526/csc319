import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class AboutPage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AboutMember extends JFrame
{
    // instance variables - replace the example below with your own
    private ImagePanel panel;
    private Image image;
    /**
     * Constructor for objects of class AboutPage
     */
    public AboutMember()
    {
        // initialise instance variables
        panel = new ImagePanel("aboutMember.jpg");
        setTitle("About Member");
        setLocation((((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)
            ,(((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)-500);
            
        add(panel);
        pack();
        setVisible(true);
        // add code hear var panel is JPanel
    }

   
}
