import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class playerWinsLoses extends JFrame{


    private BufferedImage background;

    private void loadImages(boolean won){
        try{
            if(won){background = ImageIO.read(getClass().getResource("fireworksExploding.gif"));}
            else{background = ImageIO.read(getClass().getResource("sadFace.png"));}

        }catch(IOException ioe){System.out.println("Unable to open file");}
    }

    public void closePlayerWinsLoses(ActionEvent e){
        //close game interface
        JComponent comp = (JComponent) e.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }

    private JPanel playerWinsLosesPanel;
    private JLabel playerWonLabel;
    private JLabel playerLostLabel;
    private JLabel winCounter;
    private JButton seeBoardButton;

    private void closeWinsLoses(){
        this.setVisible(false);
    }

    public playerWinsLoses(boolean won){
        //super(title);

        loadImages(won);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(playerWinsLosesPanel);
        this.setUndecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);

        //Displays message if player won or lost
        playerWonLabel.setVisible(won);
        winCounter.setVisible(won);
        playerLostLabel.setVisible(!won);

        seeBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWinsLoses();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        playerWinsLosesPanel = new JPanel(){
            @Override public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(background, 0, 0, 500, 300, null);
            }
        };
    }
}
