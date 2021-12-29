
/**
 * class PlayerAgent is a subclass of Agent.
 * This class represent an Agent that is controlled by an AI player.
 * 
 * @author Mohamed Elsawy
 * @version 1.0
 */
public class AIAgent extends Agent{

    // constructor sets the agentChar variable of the current player
    public AIAgent(char agentChar){
        super(agentChar);
    }

    public void nextTurn(TicTacToeBoard board){
        System.out.println("It is AI " + toString() + "\'s turn.");
        // store the lowest value of all possible moves, best move is has the least value.
        int minMoves = 100000;
        // initialize bestMoveRow and bestMoveColumn, will be the "best" possible move row and column
        int bestMoveRow = -1;
        int bestMoveColumn = -1;
        // iterate over all the tiles on the board and call search on each possible move (empty tile)
        for(int row = 0; row < board.size(); row++){
            for(int col = 0; col < board.size(); col++){
                if(board.isEmpty(row, col)){
                    int move = search(board, row, col, 0);
                    // if move value less then minMoves and >=  0, 
                    // then update the minMoves variable with move value and set bestMoveRow to current row and bestMoveColumn to current Column 
                    if(move < minMoves && move >= 0){
                        minMoves = move;
                        bestMoveRow = row;
                        bestMoveColumn = col;
                    }
                }
            }
        }
        
        // set best possible move 
        board.setTile(bestMoveRow, bestMoveColumn, getPlayerChar());
    }

    private int search(TicTacToeBoard clone, int row, int col, int depth){
        // create clone of the current TicTacToe board
        // create "board" object to clone of "clone" parameter.
        TicTacToeBoard board = new TicTacToeBoard(clone.size());
        // loop through each tile and set tiles to clone TicTacToe board
        for(int r = 0; r < board.size(); r++){
            for(int c = 0; c < board.size(); c++){
                board.setTile(r, c, clone.getTile(r, c));
            }
        }

        // If the move is invalid (the space is not empty), search will return a value of -1.
        if(!board.isEmpty(row, col)){
            return -1;
        }
        
        // set tile in required row and column
        board.setTile(row, col, getPlayerChar());
        
        // print row, col and depth
        //System.out.println("\n row: " + row + ", col: " + col + ", depth: " + depth );
        // print the board
        //System.out.println(board.toString());

        // if the board will be in a "draw" state (the board is already full), return a value of 10000 to end the search.
        if(board.isTied()){
            return 10000;
        }

        // if Agent has won (checking with the gameOver method), return the current depth of the search.
        if(board.gameOver()){
            return depth;
        }

        // iterate over all the tiles on the board and call search on each next possible move(empty tile) and increase the depth by 1
        for(int r = 0; r < board.size(); r++){
            for(int c = 0; c < board.size(); c++){
                if(board.isEmpty(r, c)){
                    return search(board, r, c, depth + 1);
                }
            }
        }

        // this is unreachable statement
        System.out.println("unreachable statement");
        return -1;
    }
}
