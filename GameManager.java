import java.util.Random;
import java.util.Scanner;


/**
 * class GameManager is main class for TicTacToe pwered by AI Game
 * class GameManager Controls the overall flow of the game
 * This includes input, checking games states
 * and initialization of the board itself. 
 * 
 * @author Mohamed Elsawy
 * @version 1.0
 */

public class GameManager{
    
    // Agents
    public static PlayerAgent agentX;
    public static AIAgent agentO;

    // The board object itself. Holds game state. 
    private TicTacToeBoard board = new TicTacToeBoard();
    private Agent currentAgent;

    public static void main(String[] args){

        // Create the Game Manager object itself. 
        GameManager man = new GameManager();

        // start up game
        man.initGame();

        // Game loop (until game is over). 
        while(!man.isGameOver()){
            man.nextTurn(); 
        }

        // Quit. 
        System.out.println("Thanks for playing");
        System.exit(0);
    }

    // Initialize Game
    private void initGame(){
        initBoard();
        initPlayers();
        
        // Print out the board. 
        System.out.println(board.toString());
        System.out.println(currentAgent.toString() + " Goes first");

    }
    
    // initialize Board
    private void initBoard(){
        // Get Board size
        int size = 0;
        boolean isValid = false;

        // Wait for input from the user. 
        while(!isValid){
            System.out.println("Enter the board size (default 3):");
            Scanner scan = new Scanner(System.in);
            size = scan.nextInt();

            // Check for valid inputs. 
            if(size <= 100 && size > 1){
                isValid = true;
            }
        }

        // Create the board itself. 
        board = new TicTacToeBoard(size);
    }
    
    // initialize Players
    private void initPlayers(){
        // initialize the Agent objects
        agentX = new PlayerAgent('X');
        agentO = new AIAgent('O');
        

        // Create random number object to select first players turn. 
        Random rand = new Random();
        int turn = rand.nextInt(2);

        // Set current players turn. 
        if( turn == 0){
            currentAgent = agentX;  
        }else{
            currentAgent = agentO;
        }
    }

    private void nextTurn(){
        // get player move
        currentAgent.nextTurn(board);
        
        System.out.println(board.toString());
        // if game over, last player to move won, otherwise switch players. 
        if(board.gameOver()){
            playerWon(currentAgent);
        }else{
            if(board.isTied()){
                System.out.println("Game ends in a draw!");
                System.exit(0);
            }
            nextPlayer();
        }

    }

    private void nextPlayer(){
        if(currentAgent == agentX)
            currentAgent = agentO;
        else
            currentAgent = agentX;
    }

    private boolean isGameOver(){
        board.testGameOver();
        return board.gameOver();
    }

    private void playerWon(Agent currentAgent){
        System.out.println("Player " + currentAgent.getPlayerChar() + " won the game!");
        System.exit(0);
    }
}
