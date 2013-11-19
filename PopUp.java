import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class PopUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopUp extends JFrame
{
    // instance variables - replace the example below with your own
    private JList listFunc;

    /**
     * Constructor for objects of class PopUp
     */
    public PopUp(String gray){
        // initialise instance variables
        setTitle("Function");
        String[] output = {gray};
        listFunc = new JList();
        listFunc.setListData(output);
        add(listFunc);
        pack();
        setLocation((((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)
            ,(((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)-600);
        setVisible(true);
    }
    
    public PopUp(String red,String green, String blue){
        // initialise instance variables
        setTitle("Function");
        String[] output = {red,green,blue};
        listFunc = new JList();
        listFunc.setListData(output);
        add(listFunc);
        pack();
        setLocation((((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)
            ,(((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)-600);
        setVisible(true);
    }

}
