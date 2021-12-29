
/**
 * Agent class represent a single player.
 * 
 * @author Mohamed Elsawy
 * @version 1.0
 */
public class Agent {
    // variable represents the current "team" the Agent is on and will be either an 'X' or an 'O' letter
    private char agentChar;
    
    // constructor sets the agentChar variable of the current Agent 
    public Agent(char agentChar){
        this.agentChar = agentChar;
    }
    
    // Returns the agentChar variable from the current Agent 
    public char getPlayerChar(){
        return agentChar;
    }
    
    // ask for next move to make
    public void nextTurn(TicTacToeBoard board){
        System.out.println("It is " + toString() + "\'s turn.");
        // looped through each available space in the board until I found one that was empty,
        // then set the empty space to the char value ('X' or 'O') of the Agent the current nextTurn method belongs to.
        for(int row = 0; row < board.size(); row++){
            for(int col = 0; col < board.size(); col++){
                if(board.isEmpty(row, col)){
                    // Set new tile
                    board.setTile(row, col, agentChar);
                    return;
                }
            }
        }
    }
    
    // The method will return a short message stating which Agent it is, "Agent  X" or "Agent  O". 
    public  String  toString(){
        return "Agent " + agentChar;
    }
}
