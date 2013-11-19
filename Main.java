import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main extends JFrame
{
    // instance variables - replace the example below with your own
    private ArtPanel mainPanel;
    private Menu menu;
    private JPanel buttonPanel;
    private JButton color;
    private JButton gray;
 
    /**
     * Constructor for objects of class Main
     */
    public Main(){
        this(3);
    }
    
    public Main(int numOfColor)
    {
        // initialise instance variables
        setTitle("Random Art Project");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation((((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)-500
            ,(((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2)-600);
        color = new JButton("Random Color");
        gray = new JButton("Random Gray");
        menu = new Menu();
     
        mainPanel = new ArtPanel(numOfColor);
        buttonPanel = new JPanel();
         
        buttonPanel.setBackground(Color.YELLOW);
        
        color.setToolTipText("Click for ramdom a new color");
        gray.setToolTipText("Click for ramdom a new gray tone");
        color.setForeground(Color.BLUE);
        gray.setForeground(Color.RED);
        
        buttonPanel.add(gray);
        buttonPanel.add(color);
        color.addActionListener(new ColorButtonListener()); 
        gray.addActionListener(new GrayButtonListener()); 
        setVisible(true);
        setJMenuBar(newMenuBar());
        add(mainPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }
    
          
 

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(String[] args){
        new Main();
    }
    
    private JMenuBar newMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Help");
        MenuAbout about = new MenuAbout("About Project");
        MenuMember member = new MenuMember("About Member");
        menuBar.add(menu);
        menu.add(about);
        menu.add(member);
        return menuBar;
    }
    
    //inner class
         private class ColorButtonListener implements ActionListener {
             public void actionPerformed(ActionEvent e){
                 setVisible(false);
                 mainPanel.closePopup();
                 new Main(3);
                 
                }
            }
        
        private class GrayButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                mainPanel.closePopup();
                new Main(1);
            }
        }
        
}
