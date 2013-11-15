import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
class ArtFrame extends JFrame {
    
    private ArtPanel thePanel;
    private JLabel theCurrentExpression;
    
    private static final int EQUATION_FONT_SIZE = 16;
    private static final int UPPER_LEFT_CORNER = 100;

    public ArtFrame(){
        setTitle("CSC 319 - Random Art Project");
        setLocation(UPPER_LEFT_CORNER, UPPER_LEFT_CORNER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
        setJMenuBar(createMenu());

      
        thePanel = new ArtPanel();
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(getButton("New Gray", false));
        buttonPanel.add(getButton("New Color", true));

        
        theCurrentExpression = new JLabel(thePanel.getExpressionAsString());
        theCurrentExpression.setFont(new Font("Serif", Font.PLAIN, EQUATION_FONT_SIZE));


      
        add(thePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(theCurrentExpression, BorderLayout.NORTH);
        pack();
        
    }

    private JMenuBar createMenu() {
        final int NUM_OPTIONS = ArtPanel.NUM_COLOR_OPTIONS;
        JMenuBar menu = new JMenuBar();
        final String label = "Color Option";
        JMenu colorOptions = new JMenu(label);
        menu.add(colorOptions);
    
        for(int i = 0; i < NUM_OPTIONS; i++) {
            JMenuItem temp = colorOptions.add(label + " " + (i + 1));

   
         }
        return menu;
    }

    


    public JButton getButton(String label, final boolean makeColor){
        JButton result = new JButton(label);

   
        
        return result;
    }

    public void start(){
        setVisible(true);
    }
} 



