import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectDifficultyMenu extends JFrame{
    private JPanel RulesMenu;
    private JPanel titlePanel;
    private JLabel FORCECONNECTORLabel;
    private JButton backButton;
    private JButton playButton;
    private JPanel selectDifficultyPanel;
    private JPanel radioButtonPanel;
    private JRadioButton easyRadioButton;
    private JRadioButton hardRadioButton;
    private JPanel difficultyLabelPanel;
    private JLabel selectDifficultyLabel;

    public selectDifficultyMenu(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(RulesMenu);
        this.pack();
        this.setLocationRelativeTo(null);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO request to go back to main menu
                // should be done by model

                // go back to main menu
                JFrame frame = new mainMenu("FORCE CONNECTOR");
                frame.setVisible(true);
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
        easyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO request to set AI to easy difficulty
                //if selected, player() color will be black
                //player.setColor(black)
                //because black goes first
                GameBoard.get().setDifficulty('e');

                //ai.setColor(red)
                //TODO enable play button when difficulty is selected
                // should be done by model
                playButton.setEnabled(true);
            }
        });
        hardRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO request to set AI to hard difficulty
                //if selected, player() color will be red
                //player.setColor(red)
                //because red goes second
                GameBoard.get().setDifficulty('h');

                //ai.setColor(black)
                //TODO enable play button when difficulty is selected
                // should be done by model
                playButton.setEnabled(true);
            }
        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO request to go to game interface
                // should be done by model

                //open the game interface
                JFrame frame = gameInterface.get();
                frame.setVisible(true);

                //close the select difficulty menu
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();

                //reset the backend board and UI board
                gameInterface.get().initGameInterfaceBoard();
                GameBoard.get().initEmptyBoard();
            }
        });
    }
}
