import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class mainMenu extends JFrame{

    private JButton startGameButton;
    private JButton rulesButton;
    private JButton exitButton;
    private JPanel MainMenu;
    private JPanel buttonsPanel;
    private JPanel titlePanel;
    private JLabel FORCECONNECTORLabel;

    public mainMenu(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainMenu);
        this.pack();
        this.setLocationRelativeTo(null);

        //code for action from pressing "Start Game"
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO request to open the select difficulty menu
                // Should be done by model

                //open the set difficulty menu
                JFrame frame = new selectDifficultyMenu("FORCE CONNECTOR");
                frame.setVisible(true);

                //close the main menu
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();

            }
        });

        //code for action from pressing "Rules"
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO request to open the rules menu
                // Should be done by model

                //open the rules menu
                JFrame frame = new rulesMenu("FORCE CONNECTOR");
                frame.setVisible(true);

                //close the main menu
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();

            }
        });

        //code for action from pressing "Exit"
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO request to close the application
                // should be done by model
                System.exit(0);
            }
        });
    }

    /*public static void main(String[] args) {
        JFrame frame = new mainMenu("FORCE CONNECTOR");
        frame.setVisible(true);
    }*/

}
