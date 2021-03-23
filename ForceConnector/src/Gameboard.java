import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

class GameBoard{

    private static GameBoard instance = null;
    public static GameBoard get() {
        if (instance == null) {
            instance = new GameBoard();
        }
        return instance;
    }

    public char [][] board;
    public int row;
    public int aiRow;
    public int aiColumn;
    public int playerColumn;
    public int randomColumn;
    public char aiColor;
    public char playerColor;
    public int playerRow;
    public char winner;
    private boolean isThereWinner;
    private char gameDifficulty;


    public GameBoard(){
        playerColor = 'r';
        aiColor = 'b';
        isThereWinner = false;
        gameDifficulty = 'e';
    }
    //if there is a winning move, return true,
    //else return false
    public boolean isWinningMove(){
            int HEIGHT = 6;
            int WIDTH = 7;

            for (int r = 0; r < HEIGHT; r++) { // iterate rows, bottom to top
                for (int c = 0; c < WIDTH; c++) { // iterate columns, left to right
                    int player = board[r][c];
                    if (player == '0')
                        continue; // don't check empty slots

                    if (c + 3 < WIDTH &&
                            player == board[r][c+1] && // look right
                            player == board[r][c+2] &&
                            player == board[r][c+3])
                        return true;
                    if (r + 3 < HEIGHT) {
                        if (player == board[r+1][c] && // look up
                                player == board[r+2][c] &&
                                player == board[r+3][c])
                            return true;
                        if (c + 3 < WIDTH &&
                                player == board[r+1][c+1] && // look up & right
                                player == board[r+2][c+2] &&
                                player == board[r+3][c+3])
                            return true;
                        if (c - 3 >= 0 &&
                                player == board[r+1][c-1] && // look up & left
                                player == board[r+2][c-2] &&
                                player == board[r+3][c-3])
                            return true;
                    }
                }
            }
            return false; // no winner found

    }

    public void initEmptyBoard(){
        board = new char[][]{
                {'0', '0', '0', '0', '0' , '0','0'},
                {'0', '0', '0', '0', '0' , '0','0'},
                {'0', '0', '0', '0', '0' , '0','0'},
                {'0', '0', '0', '0', '0' , '0','0'},
                {'0', '0', '0', '0', '0' , '0','0'},
                {'0', '0', '0', '0', '0' , '0','0'}
        };
        isThereWinner = false;
        if(gameDifficulty == 'h'){
            try {
                aiRandomMove();
            } catch (Exception ex) {

            }
        }
    }

    private void printBackendBoard(){
        for(int i=0; i<6;i++){
            System.out.println(board[i]);
        }
        System.out.println("");
    }

    public void setPlayerColorBasedOnDifficulty(String difficulty){
        if (difficulty.equals("hard")){
            aiColor = 'b';
            playerColor = 'r';
        }
        else if (difficulty.equals("easy")){
            aiColor = 'r';
            playerColor = 'b';
        }else{
            //error handle
        }
    }

    //'e' for easy, 'h' for hard
    public void setDifficulty(char diffficulty){
        gameDifficulty = diffficulty;
    }

    //check if the move the player just played is a valid move
    public boolean validColumn(int column){

        //if the column has 6 pieces, then is is not a validMove
        return ((column >= 0) && (column <= 5));


    }

    public boolean validRow(int row){
        return row >= 0 && row <= 6;
    }

    public void addPlayerPieceToBoard(int column){
        int i;
        for (i = 5; i >= 0; i--) {
            if (board[i][column] == '0') {
                board[i][column] = playerColor;
                playerRow = i;
                playerColumn = column;
                break;
            }
        }
        //display the move in the ui
        gameInterface.get().addPieceToBoard(column + 1, playerRow + 1, playerColor);

        //for debugging
        printBackendBoard();

        //check if that move is a winning move
        if (isWinningMove()) {
            winner = playerColor;
            System.out.println("Player Wins");
            gameInterface.get().displayPlayerWins();
            isThereWinner = true;
        }
        if(!isThereWinner) {
            try {
                aiRandomMove();
            } catch (Exception ex) {

            }
        }
    }




    public void aiRandomMove() throws InterruptedException {
        int row = 5;
        randomColumn = ThreadLocalRandom.current().nextInt(0, 7);
        
        //TimeUnit.SECONDS.sleep(1);                          //Pauses 1 second before AI move is made.
        boolean aiPlacedPiece = false;
        int j = randomColumn;
        while(!aiPlacedPiece){
            for (int i = 5; i >= 0; i--) {
                if (board[i][j] == '0') {
                    board[i][j] = aiColor;
                    aiRow = i;
                    aiColumn = j;
                    aiPlacedPiece = true;
                    break;
                }
            }
        }
        gameInterface.get().addPieceToBoard(aiColumn + 1, aiRow + 1, aiColor);

        //for debugging
        printBackendBoard();

        //check if that move is a winning move
        if (isWinningMove()){
            winner = aiColor;
            System.out.println("AI wins");
            isThereWinner = true;
            gameInterface.get().displayPlayerLoses();
        }

    }




    public int getAIRow(){
        return aiRow;
    }

    public int getAiColumn(){
        return aiColumn;
    }
    public char getAiColor(){
        return aiColor;
    }
    public char getPlayerColor(){
        return playerColor;
    }
    public int getPlayerRow(){ return playerRow; }
    public int getPlayerColumn() {return playerColumn; }
    public char getWinner(){
        return winner;
    }

}
