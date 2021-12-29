import java.util.Scanner;

/**
 * class PlayerAgent is a subclass of Agent. 
 * This class represent an Agent that is controlled by a human player.
 * 
 * @author Mohamed Elsawy
 * @version 1.0
 */
public class PlayerAgent extends Agent{

    // constructor sets the agentChar variable of the current player
    public PlayerAgent(char agentChar){
        super(agentChar);
    }

    // ask for next move to make
    public void nextTurn(TicTacToeBoard board){
        boolean isValid = false;

        // Wait for input from the user. 
        while(!isValid){
            System.out.println("It is " + toString() + "\'s turn. Enter the Row and Col:");
            Scanner scan = new Scanner(System.in);
            int row = scan.nextInt();
            int col = scan.nextInt();   

            // Error checking here: 
            if(row >= board.size() || col >= board.size()){
                System.out.println("Out of bounds. the selected tile must be on the board");
                continue;
            }
            
            if(!board.isEmpty(row, col)){
                System.out.println("Illegal move. Space filled");
                continue;
            }

            isValid = true;
            // Set new tile
            board.setTile(row, col, getPlayerChar());
        }
    }
}
