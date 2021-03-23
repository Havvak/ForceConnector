public class Player {

    char myColor; ///set in constructor
    boolean turnComplete;
    int winCount;
    boolean win;
    public Player(char color) {

        this.myColor = color;

    }

    public void setColor(char color) {

        this.myColor = color;

    }

    public char getColor() {
        return myColor;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getWinCount() {
        return winCount;
    }


    public void setTurnComplete(boolean turnComplete) {
        this.turnComplete = turnComplete;
    }

    public boolean getTurnComplete() {

        return turnComplete;
    }

    public void setWin(boolean win){
        this.win= win;

    }

    public boolean getWin(){
        return win;
    }


}