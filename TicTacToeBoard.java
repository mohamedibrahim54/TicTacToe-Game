/**
 * class TicTacToeBoard:
 *  - initialize Game Board
 *  - Check Game over
 * 
 * @author Mohamed Elsawy
 * @version 1.0
 */

public class TicTacToeBoard{
	
    private char[][] board = null;

    // Basic game. 
    public TicTacToeBoard(){
        board = new char[3][3];
        initBoard();
    }

    public TicTacToeBoard(int size){
        board = new char[size][size];
        initBoard();
    }

    public TicTacToeBoard(char[][] array){
        board = array;
    }

    // Set all entries in the board array to '.'
    // This will signify an empty tile. 
    private void initBoard(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                board[r][c] = '.';
            }
        }
    }

    public boolean isEmpty(int row, int col){
        return (board[row][col] == '.');
    }

    public char getTile(int row, int col){
        return board[row][col];
    }

    public void setTile(int row, int col, char player){
        if((row >= 0 && row < board.length) && (col >= 0 && col < board[row].length)){
            board[row][col] = player;
        }else{
            System.out.println("Error, invalid location entered:" + row + " " + col);
        }
    }

    // return the size of the board (one side).
    public int size(){
        return board.length;
    }

    // method will return true if every space on the board is either an 'X' or an 'O' and false if there is one or more open space
    public boolean isTied(){
        for(int row = 0; row < size(); row++){
            for(int col = 0; col < size(); col++){
                if(isEmpty(row, col)){
                    return false;
                }
            }
        }
        return true;
    }

    // Is the game over?
    public boolean gameOver(){
        return checkRows() || checkCols() || checkDiagonal();
    }

    public void testGameOver(){
        boolean rows = checkRows();
        boolean cols = checkCols();
        boolean diag = checkDiagonal();

        System.out.println("Rows: " + rows + "  Cols: " + cols + " diag: " + diag);

    }

    private boolean checkRows(){
        // check each row. 
        for(int r = 0; r < board.length; r++){
            char first = board[r][0];
            boolean won = first != '.';
            for(int c = 1; c< board[r].length; c++){
                if(first != board[r][c]){
                    won = false;
                }
            }
            if(won){
                return won;
            }
        }
        return false;
    }

    private boolean checkCols(){
        // check each row. 

        for(int c = 0; c < board[0].length; c++){
            char first = board[0][c];
            boolean won = first != '.';
            for(int r = 1; r < board.length; r++){
                if(first != board[r][c]){
                    won = false;
                }
            }
            if(won){
                return won;
            }
        }
        return false;
    }

    private boolean checkDiagonal(){
        // top left to bottom right
        char first = board[0][0];
        boolean won = first != '.';

        // check top left to bottom right path. 
        for(int i = 0;i < board.length; i++){
            if(first != board[i][i]){
                won = false;
            }
        }

        // dont' need to check if we already won. 
        if(!won){
            // bottom left
            first = board[board.length-1][0];
            won = first != '.';

            //If any don't match, return false
            for(int i = 0; i < board.length; i++){
                if(first != board[board.length - (i+1)][i]){
                    won = false;
                }
            }	
        }

        return won;
    }

    public String toString(){
        String output = "Current Board:";
        for(int r = 0; r < board.length; r++){
            output += "\n";
            for(int c = 0; c < board[r].length; c++){
                output += "[" + board[r][c] + "]";
            }
        }
        return output + "\n";
    }


}