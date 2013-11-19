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
    private JButton function;
    private PopUp popup;
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
        function = new JButton("Function");
        menu = new Menu();
        mainPanel = new ArtPanel(numOfColor);
        buttonPanel = new JPanel();
        color.setToolTipText("Click for ramdom a new color");
        gray.setToolTipText("Click for ramdom a new gray tone");
        function.setToolTipText("Show the function of random");
        color.setForeground(Color.RED);
        gray.setForeground(Color.MAGENTA);
        function.setForeground(Color.MAGENTA);
        
         buttonPanel.setBackground(Color.PINK);
        buttonPanel.add(gray);
        buttonPanel.add(color);
        buttonPanel.add(function);
        color.addActionListener(new ColorButtonListener()); 
        gray.addActionListener(new GrayButtonListener()); 
        function.addActionListener(new FunctionButtonListener()); 
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
        menuBar.setBackground(new Color(255,152,204));
        menu.setForeground(new Color(0,0,0));
        return menuBar;
    }
    
    //inner class
         private class ColorButtonListener implements ActionListener {
             public void actionPerformed(ActionEvent e){
                 setVisible(false);
                 if(popup != null)popup.closePopup();
                 new Main(3);
                 //mainPanel = new ArtPanel(1);
                 //add(mainPanel,BorderLayout.CENTER);
                 //mainPanel.repaint();
                 
                }
            }
        
        private class GrayButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                if(popup != null)popup.closePopup();
                new Main(1);
                //mainPanel = new ArtPanel(1);
                //mainPanel.repaint();
            }
        }
        
        private class FunctionButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e){
                popup = new PopUp(mainPanel.getFunction());
            }
        }
        
}
