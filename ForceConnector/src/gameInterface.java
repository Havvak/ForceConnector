import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class gameInterface extends JFrame{

    private static gameInterface instance = null;
    public static gameInterface get() {
        if (instance == null) {
            instance = new gameInterface("FORCE CONNECT");
        }
        return instance;
    }
    private BufferedImage background;
    private ImageIcon empireSymbol;
    private ImageIcon rebellionSymbol;
    private ImageIcon blankSpace;
    GameManager gamemanager = GameManager.get();

    private void loadImages(){
        try{
            background = ImageIO.read(getClass().getResource("connect 4 board.gif"));
            empireSymbol = new ImageIcon("empireSymbol.gif");
            rebellionSymbol = new ImageIcon("rebellionSymbol.gif");
            blankSpace = new ImageIcon("blankSpace.gif");
        }catch(IOException ioe){System.out.println("Unable to open file");}
    }

    private JPanel gameInterface;
    private JPanel columnSelectionPanel;
    private JPanel gameBoardPanel;
    private JPanel buttonsPanel;
    private JButton exitToMenuButton;
    private JButton playAgainButton;
    private JButton column1Button;
    private JButton column2Button;
    private JButton column3Button;
    private JButton column4Button;
    private JButton column5Button;
    private JButton column6Button;
    private JButton column7Button;
    private JPanel column1Panel;
    private JPanel col1row1Panel;
    private JPanel col1row2Panel;
    private JPanel col1row3Panel;
    private JPanel col1row4Panel;
    private JPanel col1row5Panel;
    private JPanel col1row6Panel;
    private JLabel col1row1Label;
    private JLabel col1row2Label;
    private JLabel col1row3Label;
    private JLabel col1row4Label;
    private JLabel col1row6Label;
    private JLabel col1row5Label;
    private JPanel gameBoardPlaySpacePanel;
    private JLabel col2row1Label;
    private JLabel col2row2Label;
    private JLabel col2row3Label;
    private JLabel col2row4Label;
    private JLabel col2row5Label;
    private JLabel col2row6Label;
    private JLabel col3row1Label;
    private JLabel col3row2Label;
    private JLabel col3row3Label;
    private JLabel col3row4Label;
    private JLabel col3row5Label;
    private JLabel col3row6Label;
    private JLabel col4row1Label;
    private JLabel col4row2Label;
    private JLabel col4row3Label;
    private JLabel col4row4Label;
    private JLabel col4row5Label;
    private JLabel col4row6Label;
    private JLabel col5row1Label;
    private JLabel col5row2Label;
    private JLabel col5row3Label;
    private JLabel col5row4Label;
    private JLabel col5row5Label;
    private JLabel col5row6Label;
    private JLabel col6row1Label;
    private JLabel col6row2Label;
    private JLabel col6row3Label;
    private JLabel col6row4Label;
    private JLabel col6row5Label;
    private JLabel col6row6Label;
    private JLabel col7row1Label;
    private JLabel col7row2Label;
    private JLabel col7row3Label;
    private JLabel col7row4Label;
    private JLabel col7row5Label;
    private JLabel col7row6Label;
    
    public static synchronized void playPieceClickSound() {
        try {
            File yourFile = new File("plasticClick.wav");
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;

            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        }
        catch (Exception e) {
            //this is not the right way to do this
        }
    }

    //*****
    //Logic that handles displaying a placed game piece.
    //NOTE: it can place a piece incorrectly so the proper parameters need to be passed.
    //The code for this is really ugly and might be able to be made more concise.
    //*****
    public void addPieceToBoard(int col, int row, char color){

        //Color b is black. Black is empire placement
        if(color == 'b'){
            playPieceClickSound();
            if(col == 1){
                if(row == 1){col1row1Label.setIcon(empireSymbol);}
                else if(row == 2){col1row2Label.setIcon(empireSymbol);}
                else if(row == 3){col1row3Label.setIcon(empireSymbol);}
                else if(row == 4){col1row4Label.setIcon(empireSymbol);}
                else if(row == 5){col1row5Label.setIcon(empireSymbol);}
                else if(row == 6){col1row6Label.setIcon(empireSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 2){
                if(row == 1){col2row1Label.setIcon(empireSymbol);}
                else if(row == 2){col2row2Label.setIcon(empireSymbol);}
                else if(row == 3){col2row3Label.setIcon(empireSymbol);}
                else if(row == 4){col2row4Label.setIcon(empireSymbol);}
                else if(row == 5){col2row5Label.setIcon(empireSymbol);}
                else if(row == 6){col2row6Label.setIcon(empireSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 3){
                if(row == 1){col3row1Label.setIcon(empireSymbol);}
                else if(row == 2){col3row2Label.setIcon(empireSymbol);}
                else if(row == 3){col3row3Label.setIcon(empireSymbol);}
                else if(row == 4){col3row4Label.setIcon(empireSymbol);}
                else if(row == 5){col3row5Label.setIcon(empireSymbol);}
                else if(row == 6){col3row6Label.setIcon(empireSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 4){
                if(row == 1){col4row1Label.setIcon(empireSymbol);}
                else if(row == 2){col4row2Label.setIcon(empireSymbol);}
                else if(row == 3){col4row3Label.setIcon(empireSymbol);}
                else if(row == 4){col4row4Label.setIcon(empireSymbol);}
                else if(row == 5){col4row5Label.setIcon(empireSymbol);}
                else if(row == 6){col4row6Label.setIcon(empireSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 5){
                if(row == 1){col5row1Label.setIcon(empireSymbol);}
                else if(row == 2){col5row2Label.setIcon(empireSymbol);}
                else if(row == 3){col5row3Label.setIcon(empireSymbol);}
                else if(row == 4){col5row4Label.setIcon(empireSymbol);}
                else if(row == 5){col5row5Label.setIcon(empireSymbol);}
                else if(row == 6){col5row6Label.setIcon(empireSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 6){
                if(row == 1){col6row1Label.setIcon(empireSymbol);}
                else if(row == 2){col6row2Label.setIcon(empireSymbol);}
                else if(row == 3){col6row3Label.setIcon(empireSymbol);}
                else if(row == 4){col6row4Label.setIcon(empireSymbol);}
                else if(row == 5){col6row5Label.setIcon(empireSymbol);}
                else if(row == 6){col6row6Label.setIcon(empireSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 7){
                if(row == 1){col7row1Label.setIcon(empireSymbol);}
                else if(row == 2){col7row2Label.setIcon(empireSymbol);}
                else if(row == 3){col7row3Label.setIcon(empireSymbol);}
                else if(row == 4){col7row4Label.setIcon(empireSymbol);}
                else if(row == 5){col7row5Label.setIcon(empireSymbol);}
                else if(row == 6){col7row6Label.setIcon(empireSymbol);}
                else{/*TODO: error catching*/}
            }
            else{/*TODO: error catching*/}
        }
        ///Color r is red. Red is rebellion placement
        else if (color == 'r'){
            playPieceClickSound();
            if(col == 1){
                if(row == 1){col1row1Label.setIcon(rebellionSymbol);}
                else if(row == 2){col1row2Label.setIcon(rebellionSymbol);}
                else if(row == 3){col1row3Label.setIcon(rebellionSymbol);}
                else if(row == 4){col1row4Label.setIcon(rebellionSymbol);}
                else if(row == 5){col1row5Label.setIcon(rebellionSymbol);}
                else if(row == 6){col1row6Label.setIcon(rebellionSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 2){
                if(row == 1){col2row1Label.setIcon(rebellionSymbol);}
                else if(row == 2){col2row2Label.setIcon(rebellionSymbol);}
                else if(row == 3){col2row3Label.setIcon(rebellionSymbol);}
                else if(row == 4){col2row4Label.setIcon(rebellionSymbol);}
                else if(row == 5){col2row5Label.setIcon(rebellionSymbol);}
                else if(row == 6){col2row6Label.setIcon(rebellionSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 3){
                if(row == 1){col3row1Label.setIcon(rebellionSymbol);}
                else if(row == 2){col3row2Label.setIcon(rebellionSymbol);}
                else if(row == 3){col3row3Label.setIcon(rebellionSymbol);}
                else if(row == 4){col3row4Label.setIcon(rebellionSymbol);}
                else if(row == 5){col3row5Label.setIcon(rebellionSymbol);}
                else if(row == 6){col3row6Label.setIcon(rebellionSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 4){
                if(row == 1){col4row1Label.setIcon(rebellionSymbol);}
                else if(row == 2){col4row2Label.setIcon(rebellionSymbol);}
                else if(row == 3){col4row3Label.setIcon(rebellionSymbol);}
                else if(row == 4){col4row4Label.setIcon(rebellionSymbol);}
                else if(row == 5){col4row5Label.setIcon(rebellionSymbol);}
                else if(row == 6){col4row6Label.setIcon(rebellionSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 5){
                if(row == 1){col5row1Label.setIcon(rebellionSymbol);}
                else if(row == 2){col5row2Label.setIcon(rebellionSymbol);}
                else if(row == 3){col5row3Label.setIcon(rebellionSymbol);}
                else if(row == 4){col5row4Label.setIcon(rebellionSymbol);}
                else if(row == 5){col5row5Label.setIcon(rebellionSymbol);}
                else if(row == 6){col5row6Label.setIcon(rebellionSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 6){
                if(row == 1){col6row1Label.setIcon(rebellionSymbol);}
                else if(row == 2){col6row2Label.setIcon(rebellionSymbol);}
                else if(row == 3){col6row3Label.setIcon(rebellionSymbol);}
                else if(row == 4){col6row4Label.setIcon(rebellionSymbol);}
                else if(row == 5){col6row5Label.setIcon(rebellionSymbol);}
                else if(row == 6){col6row6Label.setIcon(rebellionSymbol);}
                else{/*TODO: error catching*/}
            }
            else if(col == 7){
                if(row == 1){col7row1Label.setIcon(rebellionSymbol);}
                else if(row == 2){col7row2Label.setIcon(rebellionSymbol);}
                else if(row == 3){col7row3Label.setIcon(rebellionSymbol);}
                else if(row == 4){col7row4Label.setIcon(rebellionSymbol);}
                else if(row == 5){col7row5Label.setIcon(rebellionSymbol);}
                else if(row == 6){col7row6Label.setIcon(rebellionSymbol);}
                else{/*TODO: error catching*/}
            }
            else{/*TODO: error catching*/}
        }
        //Color is 0, blank space
        else if(color == '0'){
            if(col == 1){
                if(row == 1){col1row1Label.setIcon(blankSpace);}
                else if(row == 2){col1row2Label.setIcon(blankSpace);}
                else if(row == 3){col1row3Label.setIcon(blankSpace);}
                else if(row == 4){col1row4Label.setIcon(blankSpace);}
                else if(row == 5){col1row5Label.setIcon(blankSpace);}
                else if(row == 6){col1row6Label.setIcon(blankSpace);}
                else{/*TODO: error catching*/}
            }
            else if(col == 2){
                if(row == 1){col2row1Label.setIcon(blankSpace);}
                else if(row == 2){col2row2Label.setIcon(blankSpace);}
                else if(row == 3){col2row3Label.setIcon(blankSpace);}
                else if(row == 4){col2row4Label.setIcon(blankSpace);}
                else if(row == 5){col2row5Label.setIcon(blankSpace);}
                else if(row == 6){col2row6Label.setIcon(blankSpace);}
                else{/*TODO: error catching*/}
            }
            else if(col == 3){
                if(row == 1){col3row1Label.setIcon(blankSpace);}
                else if(row == 2){col3row2Label.setIcon(blankSpace);}
                else if(row == 3){col3row3Label.setIcon(blankSpace);}
                else if(row == 4){col3row4Label.setIcon(blankSpace);}
                else if(row == 5){col3row5Label.setIcon(blankSpace);}
                else if(row == 6){col3row6Label.setIcon(blankSpace);}
                else{/*TODO: error catching*/}
            }
            else if(col == 4){
                if(row == 1){col4row1Label.setIcon(blankSpace);}
                else if(row == 2){col4row2Label.setIcon(blankSpace);}
                else if(row == 3){col4row3Label.setIcon(blankSpace);}
                else if(row == 4){col4row4Label.setIcon(blankSpace);}
                else if(row == 5){col4row5Label.setIcon(blankSpace);}
                else if(row == 6){col4row6Label.setIcon(blankSpace);}
                else{/*TODO: error catching*/}
            }
            else if(col == 5){
                if(row == 1){col5row1Label.setIcon(blankSpace);}
                else if(row == 2){col5row2Label.setIcon(blankSpace);}
                else if(row == 3){col5row3Label.setIcon(blankSpace);}
                else if(row == 4){col5row4Label.setIcon(blankSpace);}
                else if(row == 5){col5row5Label.setIcon(blankSpace);}
                else if(row == 6){col5row6Label.setIcon(blankSpace);}
                else{/*TODO: error catching*/}
            }
            else if(col == 6){
                if(row == 1){col6row1Label.setIcon(blankSpace);}
                else if(row == 2){col6row2Label.setIcon(blankSpace);}
                else if(row == 3){col6row3Label.setIcon(blankSpace);}
                else if(row == 4){col6row4Label.setIcon(blankSpace);}
                else if(row == 5){col6row5Label.setIcon(blankSpace);}
                else if(row == 6){col6row6Label.setIcon(blankSpace);}
                else{/*TODO: error catching*/}
            }
            else if(col == 7){
                if(row == 1){col7row1Label.setIcon(blankSpace);}
                else if(row == 2){col7row2Label.setIcon(blankSpace);}
                else if(row == 3){col7row3Label.setIcon(blankSpace);}
                else if(row == 4){col7row4Label.setIcon(blankSpace);}
                else if(row == 5){col7row5Label.setIcon(blankSpace);}
                else if(row == 6){col7row6Label.setIcon(blankSpace);}
                else{/*TODO: error catching*/}
            }
            else{/*TODO: error catching*/}
        }
        else{/*TODO: error catching*/}
    }

    private void testEveryPlacement(){
        //Test every placement
        char color = 'b';
        for(int row = 1; row < 7; row++){
            for(int col = 7; col > 0; col--){
                if(color == 'b'){
                    addPieceToBoard(col,row,color);
                    color = 'r';
                }
                else if(color == 'r'){
                    addPieceToBoard(col,row,color);
                    color = 'b';
                }
            }
        }
    }

    public void initGameInterfaceBoard(){
        char color = '0';
        for(int row = 1; row < 7; row++){
            for(int col = 7; col > 0; col--){
                addPieceToBoard(col,row,color);
            }
        }
        column1Button.setEnabled(true);
        column2Button.setEnabled(true);
        column3Button.setEnabled(true);
        column4Button.setEnabled(true);
        column5Button.setEnabled(true);
        column6Button.setEnabled(true);
        column7Button.setEnabled(true);
    }
      
    JFrame winFrame = new playerWinsLoses(true);
    JFrame lossFrame = new playerWinsLoses(false);

    //call this if the player wins
    public void displayPlayerWins(){
        //JFrame winFrame = new playerWinsLoses(true);
        winFrame.setVisible(true);
        column1Button.setEnabled(false);
        column2Button.setEnabled(false);
        column3Button.setEnabled(false);
        column4Button.setEnabled(false);
        column5Button.setEnabled(false);
        column6Button.setEnabled(false);
        column7Button.setEnabled(false);
    }

    //call this if the player loses
    public void displayPlayerLoses(){
        //JFrame lossFrame = new playerWinsLoses(false);
        lossFrame.setVisible(true);
        column1Button.setEnabled(false);
        column2Button.setEnabled(false);
        column3Button.setEnabled(false);
        column4Button.setEnabled(false);
        column5Button.setEnabled(false);
        column6Button.setEnabled(false);
        column7Button.setEnabled(false);
    }

    public gameInterface(String title){
        super(title);

        loadImages();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(gameInterface);
        this.pack();
        this.setLocationRelativeTo(null);



        exitToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO request to go back to main menu
                // should be done by model

                //open main menu
                JFrame frame = new mainMenu("FORCE CONNECTOR");
                frame.setVisible(true);

                lossFrame.setVisible(false);
                winFrame.setVisible(false);

                //close game interface
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO request to go back to select difficulty menu
                // should be done by model

                //open select difficulty menu
                JFrame frame = new selectDifficultyMenu("FORCE CONNECTOR");
                frame.setVisible(true);

                lossFrame.setVisible(false);
                winFrame.setVisible(false);

                //close game interface
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();

            }
        });

        //*****
        //Placing pieces for user uses a button above a column
        //The model must look at the column to determine if the placement is valid
        //model then calls displayPlacedGamePiece(int col, int row, char color)
        //to display the proper icon of the placed piece
        //*****
        column1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {gamemanager.onColumnSelect(0);}
        });
        column2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamemanager.onColumnSelect(1);
            }
        });
        column3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamemanager.onColumnSelect(2);
            }
        });
        column4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamemanager.onColumnSelect(3);
            }
        });
        column5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamemanager.onColumnSelect(4);
            }
        });
        column6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamemanager.onColumnSelect(5);
            }
        });
        column7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamemanager.onColumnSelect(6);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        gameBoardPanel = new JPanel(){
            @Override public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(background, 0, 0, 600, 514, null);

            }
        };
    }

}
