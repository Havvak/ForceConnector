import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rulesMenu extends JFrame {

    private JPanel rulesMenu;
    private JPanel titlePanel;
    private JLabel FORCECONNECTORLabel;
    private JPanel rulesAndButtonsPanel;
    private JButton backButton;
    private JButton startGameButton;
    private JTextPane rulesPlacePiecesInTextPane;
    private JPanel writtenRulesPanel;
    private JPanel buttonsPanel;

    public rulesMenu(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(rulesMenu);
        this.pack();
        this.setLocationRelativeTo(null);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO request to go back to main menu
                // should be done by model
                JFrame frame = new mainMenu("FORCE CONNECTOR");
                frame.setVisible(true);
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
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
    }
}
