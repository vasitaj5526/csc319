import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class MenuAbout here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuMember extends JMenuItem
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class MenuAbout
     */
    public MenuMember(String name)
    {
        // initialise instance variables
        super(name);
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new AboutMember();
            }
        });
    }

}
