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
    private String[] function;

    /**
     * Constructor for objects of class PopUp
     */
    public PopUp(String[] function){
        // initialise instance variables
        setTitle("Function");
        listFunc = new JList();
        listFunc.setListData(function);
        add(listFunc);
        pack();
        setLocation((((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)
            ,(((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)-600);
        setVisible(true);
    }
    
    public void closePopup(){
        setVisible(false);
        //this = null;
    }
}
