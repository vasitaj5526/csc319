import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class AboutPage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AboutProject extends JFrame
{
    // instance variables - replace the example below with your own
    private ImagePanel panel;
    private Image image ;
    /**
     * Constructor for objects of class AboutPage
     */
    public AboutProject()
    {
        // initialise instance variables
        panel = new ImagePanel("aboutProject.jpg");
        setTitle("About Project");
        setLocation((((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)
            ,(((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)-500);
            
        add(panel);
        pack();
        setVisible(true);
        // add code hear var panel is JPanel
    }

   
}
